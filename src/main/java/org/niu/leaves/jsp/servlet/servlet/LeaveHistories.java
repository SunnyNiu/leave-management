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

/**
 * Created by Sunny on 30/03/2017.
 */
public class LeaveHistories extends HttpServlet {
    PermissionService permissionService = new PermissionService();
    UserService userService = new UserService();
    LeaveTypeService leaveTypeService = new LeaveTypeService();
    LeaveApplicationService leaveApplicationService = new LeaveApplicationService();
    TitleService titleService = new TitleService();
    DepartmentService departmentService = new DepartmentService();

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String login = (String) session.getAttribute("login");
        if (login == null || login.isEmpty()) {
            request.getRequestDispatcher("/sessionTimeout.jsp").forward(request, response);
            return;
        }

        List<String> errorList = new ArrayList<>();
        //get user detailed info
        UserWithDepartmentInfo userWithDepartmentInfo = (UserWithDepartmentInfo)session.getAttribute("userWithDepartmentInfo");

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
        //get data from database and convey them to jsp
        if (errorList.isEmpty()) {
            try {
                List<LeaveApplicationHistory> leaveApplicationHistoryList = leaveApplicationService.queryApplicationHistory(userId, leaveType, fromDate, toDate);
                request.setAttribute("leaveApplicationHistoryList", leaveApplicationHistoryList);
            } catch (SQLException ex) {
                errorList.add(ex.toString());
            }
        }

        String today = new SimpleDateFormat("yyyy/MM/dd").format(new Date());
        request.setAttribute("errorList", errorList);
        request.setAttribute("today", today);
        RequestDispatcher rd = request.getRequestDispatcher("/leaveHistory.jsp");
        rd.forward(request, response);
    }
}
