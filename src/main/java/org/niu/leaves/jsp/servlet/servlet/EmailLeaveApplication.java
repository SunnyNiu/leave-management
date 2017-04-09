package org.niu.leaves.jsp.servlet.servlet;

import org.niu.leaves.jsp.servlet.model.*;
import org.niu.leaves.jsp.servlet.service.*;
import org.niu.leaves.jsp.servlet.utility.AddRowDetail;
import org.niu.leaves.jsp.servlet.utility.InitializeLeaveApplicationForm;
import org.niu.leaves.jsp.servlet.utility.Messages;

import javax.mail.MessagingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;

public class EmailLeaveApplication extends HttpServlet {
    DepartmentService departmentService = new DepartmentService();
    LeaveTypeService leaveTypeService = new LeaveTypeService();
    UserService userService = new UserService();
    LeaveApplicationService leaveApplicationService = new LeaveApplicationService();
    PermissionService permissionService = new PermissionService();

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String login = (String) session.getAttribute("login");
        if (login == null || login.isEmpty()) {
            request.getRequestDispatcher("/sessionTimeout.jsp").forward(request, response);
            return;
        }

        //keep there are managers and leaveType when jump into SickLeave page
        List<String> errorList = new ArrayList<String>();

        UserWithDepartmentInfo userWithDepartmentInfo = (UserWithDepartmentInfo)session.getAttribute("userWithDepartmentInfo");
        try {
            UserWithDepartmentInfo departmentManagerList = departmentService.getDepartmentManagerNameById(userWithDepartmentInfo.getUserId());
            request.setAttribute("departmentManagerList", departmentManagerList);

            List<LeaveType> leaveTypesList = leaveTypeService.getLeaveTypes();
            request.setAttribute("leaveTypesList", leaveTypesList);
        } catch (SQLException ex) {
            request.getRequestDispatcher("/managerTitleOrLeaveTypeIsNull.jsp").forward(request, response);
            return;
        }

        String message = "";
        //After click sending email
        ApplicationForm applicationForm = new ApplicationForm();
        String sendEmailBtn = request.getParameter("sendEmailBtn");
        if (sendEmailBtn != null) {
            //Submit applicant leave detail into database
            String userId = request.getParameter("userId");
            int userIdValue = Integer.parseInt(userId);
            String name = request.getParameter("name");
            String leaveType = request.getParameter("LeaveType");
            String manager = request.getParameter("manager");
            String managerId = request.getParameter("managerId");
            int managerIdValue = Integer.parseInt(managerId);
            String reason = request.getParameter("reason");
            String department = request.getParameter("department");
            String totalRows = request.getParameter("totalRows");
            applicationForm.setName(name);
            applicationForm.setUserId(userIdValue);
            applicationForm.setApplicationLeaveType(leaveType);
            applicationForm.setManagerId(managerIdValue);
            applicationForm.setManagerName(manager);
            applicationForm.setReason(reason);
            applicationForm.setDepartment(department);
            applicationForm.setUserEmail(userWithDepartmentInfo.getUserEmail());
            applicationForm.setUserEmailPassword(userWithDepartmentInfo.getUserEmailPassword());
            applicationForm.setManagerEmail(userWithDepartmentInfo.getManagerEmail());
            applicationForm.setManagerEmailPassword(userWithDepartmentInfo.getManagerEmailPassword());
            String leaveTypeId = request.getParameter("leaveTypeId");
            String applicationLeaveType = request.getParameter("leaveType");
            applicationForm.setApplicationLeaveType(applicationLeaveType);
            int total = Integer.parseInt(totalRows);
            ArrayList<RowDetail> rowDetailList = new ArrayList<>();
            for (int i = 0; i < total; i++) {
                String fromDate = request.getParameterValues("fromDate")[i];
                String toDate = request.getParameterValues("toDate")[i];
                String totalDays = request.getParameterValues("totalDays")[i];
                Double totalDaysValue = Double.parseDouble(totalDays);
                RowDetail rowDetail = new AddRowDetail().addRowDetail(fromDate, toDate, totalDays);
                rowDetailList.add(rowDetail);
                try {
                    leaveApplicationService.insertLeaveApplication(userIdValue, fromDate, toDate, totalDaysValue, reason, leaveTypeId, managerIdValue);
                    message = Messages.SUBMIT_SUCCESS_MESSAGE;
                } catch (SQLException ex) {
                    errorList.add(ex.toString());
                    request.setAttribute("messages", Messages.SUBMIT_FAILED_MESSAGE);
                    RequestDispatcher rd = request.getRequestDispatcher("/applyLeave.do");
                    rd.forward(request, response);
                    return;
                }
            }
            applicationForm.setLeaveList(rowDetailList);
            //Send applicant leave detail to approver by email
            try {
                EmailService mailSender = new EmailService();
                mailSender.sendEmail(applicationForm);
                message += Messages.EMAIL_SUCCESS_MESSAGE;
                request.setAttribute("messages", message);
            } catch (IOException ex) {
                errorList.add(ex.toString());
                request.setAttribute("messages", Messages.EMAIL_FAILED_MESSAGE);
            } catch (MessagingException ex) {
                errorList.add(ex.toString());
                request.setAttribute("messages", Messages.EMAIL_FAILED_MESSAGE);
            }
            //set successful message when there is not any error and sent email successfully
            request.setAttribute("messages", Messages.SUBMIT_SUCCESS_MESSAGE);
        }
         else {
            //cancel send email and jump back to askLeave page
            request.setAttribute("messages", Messages.EMAIL_CANCEL_MESSAGE);
        }

        int totalRows = 1;
        request.setAttribute("totalRows", totalRows);
        applicationForm = new InitializeLeaveApplicationForm().initializeApplicationForm();
        request.setAttribute("applicationForm", applicationForm);
        //Date display on sickLeave page when jump into that page
        String today = new SimpleDateFormat("yyyy/MM/dd").format(new Date());
        request.setAttribute("today", today);
        request.setAttribute("errorList", errorList);
        RequestDispatcher rd = request.getRequestDispatcher("/applyLeave.do");
        rd.forward(request, response);
    }
}
