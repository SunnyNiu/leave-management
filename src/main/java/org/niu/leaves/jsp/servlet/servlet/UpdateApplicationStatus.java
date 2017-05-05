package org.niu.leaves.jsp.servlet.servlet;

import org.niu.leaves.jsp.servlet.model.*;
import org.niu.leaves.jsp.servlet.service.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UpdateApplicationStatus extends HttpServlet {
    PermissionService permissionService = new PermissionService();
    LeaveApplicationService leaveApplicationService = new LeaveApplicationService();
    UserService userService = new UserService();
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

        //Automatically fill in managerList Dropdownlist
        List<ApplicationStatus> statusList = new ArrayList<>();
        for (ApplicationStatus status : ApplicationStatus.values()) {
            statusList.add(status);
        }
        request.setAttribute("status", statusList);

        //Allow 2 records in each page
        int rowsPerPage = 2;
        try {
            int start = 1;
            int page = 1;
            if (request.getParameter("page") != null) {
                page = Integer.parseInt(request.getParameter("page"));
                request.setAttribute("pageChosen", page);
            }
            if (page > 1) {
                start = (page - 1) * rowsPerPage + 1;
            }

            String selectedStatus = request.getParameter("selectedStatus");
            request.setAttribute("selectedStatus", selectedStatus);

            UserWithDepartmentInfo userWithDepartmentInfo = (UserWithDepartmentInfo) session.getAttribute("userWithDepartmentInfo");
            int totalRecord = leaveApplicationService.queryTotalApplicationByStatus(userWithDepartmentInfo.getUserId(), selectedStatus);
            int end = page * rowsPerPage;
            if (end > totalRecord) {
                end = totalRecord;
            }
            int pagesNumber = totalRecord / rowsPerPage + totalRecord % rowsPerPage;
            request.setAttribute("pagesNumber", pagesNumber);

            List<LeaveApplicationHistory> leaveApplicationHistoryList = leaveApplicationService.queryApplicationByStatus(userWithDepartmentInfo.getUserId(), selectedStatus, start, end);
            request.setAttribute("leaveApplicationHistoryList", leaveApplicationHistoryList);

            request.setAttribute("errorList", errorList);
            String today = new SimpleDateFormat("yyyy/MM/dd").format(new Date());
            request.setAttribute("today", today);

            RequestDispatcher rd = request.getRequestDispatcher("/updateApplicationStatus.jsp?page=1&selectedStatus=" + selectedStatus + "&pagesNumber=" + pagesNumber);
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

        UserWithDepartmentInfo userWithDepartmentInfo = (UserWithDepartmentInfo) session.getAttribute("userWithDepartmentInfo");
        List<String> errorList = new ArrayList<String>();

        //Automatically fill in managerList Dropdownlist
        List<ApplicationStatus> statusList = new ArrayList<>();
        for (ApplicationStatus status : ApplicationStatus.values()) {
            statusList.add(status);
        }
        request.setAttribute("status", statusList);

        String today = new SimpleDateFormat("yyyy/MM/dd").format(new Date());
        request.setAttribute("today", today);

        String searchBtn = request.getParameter("searchApplication");
        int totalNumber = 0;
        int pagesNumber = 0;
        String selectedStatus = "Pending";

        if (searchBtn != null) {
            selectedStatus = request.getParameter("status");
            request.setAttribute("selectedStatus", selectedStatus);
            int start = 1;
            //Default search pending application
            int rowsPerPage = 2;
            int end = start + rowsPerPage - 1;

            request.setAttribute("pageChosen", 1);
            try {
                List<LeaveApplicationHistory> leaveApplicationHistoryList = leaveApplicationService.queryApplicationByStatus(userWithDepartmentInfo.getUserId(), selectedStatus, start, end);
                totalNumber = leaveApplicationService.queryTotalApplicationByStatus(userWithDepartmentInfo.getUserId(), selectedStatus);
                pagesNumber = totalNumber / rowsPerPage + totalNumber % rowsPerPage;
                request.setAttribute("pagesNumber", pagesNumber);
                request.setAttribute("leaveApplicationHistoryList", leaveApplicationHistoryList);
            } catch (SQLException ex) {
                errorList.add(ex.toString());
            }
            request.setAttribute("errorList", errorList);
            RequestDispatcher rd = request.getRequestDispatcher("/updateApplicationStatus.jsp?page=1&selectedStatus=" + selectedStatus + "&pagesNumber=" + pagesNumber);
            rd.forward(request, response);
            return;
        }

        String approveBtn = request.getParameter("approveBtn");
        if (approveBtn != null) {
            int applicationId = Integer.parseInt(approveBtn);
            String status = "Approve";
            try {
                LeaveApplicationHistory leaveApplicationHistory = leaveApplicationService.getApplicationById(applicationId);
                request.setAttribute("leaveApplicationHistory", leaveApplicationHistory);
                request.setAttribute("Status", status);
                pagesNumber = Integer.parseInt(request.getParameter("pagesNumber"));
                String searchSelectedStatus = request.getParameter("selectedStatus");
                RequestDispatcher rd = request.getRequestDispatcher("/doubleConfirmYourDecision.jsp?page=1&pagesNumber=" + pagesNumber + "&selectedStatus=" + searchSelectedStatus);
                rd.forward(request, response);
                return;
            } catch (SQLException ex) {
                errorList.add(ex.toString());
            }
        }

        String rejectBtn = request.getParameter("rejectBtn");
        if (rejectBtn != null) {
            int applicationId = Integer.parseInt(rejectBtn);
            String status = "Reject";
            try {
                LeaveApplicationHistory leaveApplicationHistory = leaveApplicationService.getApplicationById(applicationId);
                request.setAttribute("leaveApplicationHistory", leaveApplicationHistory);
                request.setAttribute("Status", status);
                pagesNumber = Integer.parseInt(request.getParameter("pagesNumber"));
                String searchSelectedStatus = request.getParameter("selectedStatus");
                //String searchSelectedStatus = request.getParameter("selectedStatus");
                RequestDispatcher rd = request.getRequestDispatcher("/doubleConfirmYourDecision.jsp?page=1&pagesNumber=" + pagesNumber + "&selectedStatus=" + searchSelectedStatus);
                rd.forward(request, response);
                return;
            } catch (SQLException ex) {
                errorList.add(ex.toString());
            }
        }

        String withdrawBtn = request.getParameter("withdrawBtn");
        if (withdrawBtn != null) {
            int applicationId = Integer.parseInt(withdrawBtn);
            String status = "Pending";
            try {
                LeaveApplicationHistory leaveApplicationHistory = leaveApplicationService.getApplicationById(applicationId);
                request.setAttribute("leaveApplicationHistory", leaveApplicationHistory);
                request.setAttribute("Status", status);
                pagesNumber = Integer.parseInt(request.getParameter("pagesNumber"));
                String searchSelectedStatus = request.getParameter("selectedStatus");
                //String searchSelectedStatus = request.getParameter("selectedStatus");
                RequestDispatcher rd = request.getRequestDispatcher("/doubleConfirmYourDecision.jsp?page=1&pagesNumber=" + pagesNumber + "&selectedStatus=" + searchSelectedStatus);
                rd.forward(request, response);
                return;
            } catch (SQLException ex) {
                errorList.add(ex.toString());
            }
        }
    }
}
