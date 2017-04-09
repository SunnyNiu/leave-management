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
        if (searchBtn != null) {
            String status = request.getParameter("status");
            try {
                List<LeaveApplicationHistory> leaveApplicationHistoryList = leaveApplicationService.queryApplicationByStatus(userWithDepartmentInfo.getUserId(), status);
                request.setAttribute("leaveApplicationHistoryList", leaveApplicationHistoryList);
            } catch (SQLException ex) {
                errorList.add(ex.toString());
            }
            request.setAttribute("errorList", errorList);
            RequestDispatcher rd = request.getRequestDispatcher("/applicationNeedsYourApproval.jsp");
            rd.forward(request, response);
        }

        String approveBtn = request.getParameter("approveBtn");
        if (approveBtn != null) {
            int applicationId = Integer.parseInt(approveBtn);
            String status = "Approve";
            try {
                LeaveApplicationHistory leaveApplicationHistory = leaveApplicationService.getApplicationById(applicationId);
                request.setAttribute("leaveApplicationHistory", leaveApplicationHistory);
                request.setAttribute("Status", status);
                RequestDispatcher rd = request.getRequestDispatcher("/doubleConfirmYourDecision.jsp");
                rd.forward(request, response);
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
                RequestDispatcher rd = request.getRequestDispatcher("/doubleConfirmYourDecision.jsp");
                rd.forward(request, response);
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
                RequestDispatcher rd = request.getRequestDispatcher("/doubleConfirmYourDecision.jsp");
                rd.forward(request, response);
            } catch (SQLException ex) {
                errorList.add(ex.toString());
            }
        }
    }
}
