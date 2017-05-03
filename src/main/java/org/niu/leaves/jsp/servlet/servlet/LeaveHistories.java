package org.niu.leaves.jsp.servlet.servlet;

import org.niu.leaves.jsp.servlet.model.*;
import org.niu.leaves.jsp.servlet.service.*;
import org.niu.leaves.jsp.servlet.utility.CheckFromToDaysForamt;
import org.niu.leaves.jsp.servlet.utility.Messages;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class LeaveHistories extends HttpServlet {
    PermissionService permissionService = new PermissionService();
    UserService userService = new UserService();
    LeaveTypeService leaveTypeService = new LeaveTypeService();
    LeaveApplicationService leaveApplicationService = new LeaveApplicationService();
    TitleService titleService = new TitleService();
    DepartmentService departmentService = new DepartmentService();

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String login = (String) session.getAttribute("login");
        if (login == null || login.isEmpty()) {
            request.getRequestDispatcher("/sessionTimeout.jsp").forward(request, response);
            return;
        }
        List<String> errorList = new ArrayList<>();
        try {
            List<UserInfo> userList = userService.getAllUsers();
            request.setAttribute("userList", userList);
            List<LeaveType> leaveTypesList = leaveTypeService.getLeaveTypes();
            request.setAttribute("leaveTypesList", leaveTypesList);
        } catch (SQLException ex) {
            errorList.add(ex.toString());
        }
        LeaveApplicationService leaveApplicationService = new LeaveApplicationService();
        int rowsPerPage = 2;
        try {
            int start = 1;
            if (request.getParameter("page") != null) {
                start = Integer.parseInt(request.getParameter("page"));
                request.setAttribute("pageChosen", start);
            } else {
                start = 1;
            }
            int userId = Integer.parseInt(session.getAttribute("userId").toString());
            String leaveType = session.getAttribute("leaveType").toString();
            String fromDate = session.getAttribute("fromDate").toString();
            String toDate = session.getAttribute("toDate").toString();
            int totalRecord = leaveApplicationService.queryTotalRecords(userId, leaveType, fromDate, toDate);
            int end = start + rowsPerPage;
            if (end > totalRecord) {
                end = totalRecord;
            }
            List<LeaveApplicationHistory> leaveApplicationHistoryList = leaveApplicationService.queryApplicationHistory(userId, leaveType, fromDate, toDate, start, end);
            int pagesNumber = totalRecord / rowsPerPage + totalRecord % rowsPerPage;
            request.setAttribute("pagesNumber", pagesNumber);
            request.setAttribute("leaveApplicationHistoryList", leaveApplicationHistoryList);

            String today = new SimpleDateFormat("yyyy/MM/dd").format(new Date());
            request.setAttribute("messages", "");
            request.setAttribute("errorList", errorList);
            request.setAttribute("today", today);
            RequestDispatcher rd = request.getRequestDispatcher("/leaveHistory.jsp?page="+start);
            rd.forward(request, response);
        } catch (SQLException ex) {
            errorList.add(ex.toString());
        }
    }


    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String login = (String) session.getAttribute("login");
        if (login == null || login.isEmpty()) {
            request.getRequestDispatcher("/sessionTimeout.jsp").forward(request, response);
            return;
        }

        List<String> errorList = new ArrayList<>();
        //get user detailed info
        UserWithDepartmentInfo userWithDepartmentInfo = (UserWithDepartmentInfo) session.getAttribute("userWithDepartmentInfo");

        try {
            List<UserInfo> userList = userService.getAllUsers();
            request.setAttribute("userList", userList);
            List<LeaveType> leaveTypesList = leaveTypeService.getLeaveTypes();
            request.setAttribute("leaveTypesList", leaveTypesList);
        } catch (SQLException ex) {
            errorList.add(ex.toString());
        }

        //get fromDate, toDate and verify date format
        String fromDate = request.getParameter("userFromDate");
        String toDate = request.getParameter("userToDate");

        try {
            new CheckFromToDaysForamt().checkDateFormat(fromDate, toDate);
        } catch (ParseException e) {
            errorList.add(Messages.DATE_FORMAT_INCORRECT_MESSAGE);
        }

        //get leaveType and current there are only two types leaveType, sick and annual leave
        String leaveType = request.getParameter("leaveType");
        try {
            //Avoid someone deliberate insert not exist leaveType
            int leaveTypeId = Integer.parseInt(leaveType);
            boolean leaveTypeExist = leaveTypeService.leaveTypeExist(leaveTypeId);
            if (!leaveTypeExist) {
                request.getRequestDispatcher("/managerTitleOrLeaveTypeIsNull.jsp").forward(request, response);
                return;
            }
        } catch (SQLException e) {
            request.getRequestDispatcher("/managerTitleOrLeaveTypeIsNull.jsp").forward(request, response);
        }

        String username = request.getParameter("username");
        int userId = Integer.parseInt(username);
        session.setAttribute("userId", userId);
        session.setAttribute("leaveType", leaveType);
        session.setAttribute("fromDate", fromDate);
        session.setAttribute("toDate", toDate);
        //get data from database and convey them to jsp
        int start = 1;
        if (errorList.isEmpty()) {
            int rowsPerPage = 2;
            try {
                int end = start + rowsPerPage;
                List<LeaveApplicationHistory> leaveApplicationHistoryList = leaveApplicationService.queryApplicationHistory(userId, leaveType, fromDate, toDate, start, end);
                int totalRecord = leaveApplicationService.queryTotalRecords(userId, leaveType, fromDate, toDate);
                int pagesNumber = totalRecord / rowsPerPage + totalRecord % rowsPerPage;
                request.setAttribute("pagesNumber", pagesNumber);
                request.setAttribute("leaveApplicationHistoryList", leaveApplicationHistoryList);
            } catch (SQLException ex) {
                errorList.add(ex.toString());
            }
        }

        String today = new SimpleDateFormat("yyyy/MM/dd").format(new Date());
        request.setAttribute("errorList", errorList);
        request.setAttribute("today", today);
        StringBuffer URL = new StringBuffer();
        URL.append("/leaveHistory.jsp?page=1 & ");
        URL.append("leaveType =" + leaveType + "&");
        URL.append("userId =" + userId + "&");
        URL.append("fromDate =" + fromDate + "&");
        URL.append("toDate =" + toDate);
        //RequestDispatcher rd = request.getRequestDispatcher(URL.toString());
        RequestDispatcher rd = request.getRequestDispatcher("/leaveHistory.jsp?page="+start);
        rd.forward(request, response);
    }
}
