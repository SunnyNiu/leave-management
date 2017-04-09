package org.niu.leaves.jsp.servlet.servlet;

import org.niu.leaves.jsp.servlet.model.*;
import org.niu.leaves.jsp.servlet.service.*;
import org.niu.leaves.jsp.servlet.utility.Messages;

import javax.mail.MessagingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sunny on 2/04/2017.
 */
public class ConfirmOrCancelYourDecision extends HttpServlet {
    PermissionService permissionService = new PermissionService();
    UserService userService = new UserService();
    LeaveApplicationService leaveApplicationService = new LeaveApplicationService();
    TitleService titleService = new TitleService();
    DepartmentService departmentService = new DepartmentService();

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        HttpSession session = request.getSession();
        String login = (String) session.getAttribute("login");
        if (login == null || login.isEmpty()) {
            request.getRequestDispatcher("/sessionTimeout.jsp").forward(request, response);
            return;
        }
        UserWithDepartmentInfo userWithDepartmentInfo = (UserWithDepartmentInfo)session.getAttribute("userWithDepartmentInfo");
        List<String> errorList = new ArrayList<String>();

        List<ApplicationStatus> statusList = new ArrayList<>();
        for (ApplicationStatus status : ApplicationStatus.values()) {
            statusList.add(status);
        }
        request.setAttribute("status", statusList);

        String confirmBtn = request.getParameter("confirmBtn");
        //String cancelBtn = request.getParameter("cancelBtn");
        String applicationStatus = request.getParameter("applicationStatus");

        if (confirmBtn != null) {
            int applicationId = Integer.parseInt(confirmBtn);
            String messages = "";
            try {
                leaveApplicationService.updateStatus(applicationId, applicationStatus);
                messages = Messages.Make_Your_Decision;
                LeaveApplicationHistory leaveApplicationHistory = leaveApplicationService.getApplicationById(applicationId);
                ApplicationForm applicationForm = new ApplicationForm();
                applicationForm.setName(leaveApplicationHistory.getUserName());
                applicationForm.setApplicationLeaveType(leaveApplicationHistory.getLeaveType());
                applicationForm.setManagerName(leaveApplicationHistory.getApproverName());
                ArrayList<RowDetail> rowDetailList = new ArrayList<>();
                RowDetail rowDetail = new RowDetail();
                rowDetail.setFromDate(leaveApplicationHistory.getFromDate());
                rowDetail.setToDate(leaveApplicationHistory.getToDate());
                rowDetail.setTotalDays(leaveApplicationHistory.getDays().toString());
                rowDetailList.add(rowDetail);
                applicationForm.setLeaveList(rowDetailList);
                applicationForm.setUserEmail(leaveApplicationHistory.getManagerEmail());
                applicationForm.setManagerEmail(leaveApplicationHistory.getUserEmail());
                applicationForm.setUserEmailPassword(leaveApplicationHistory.getManagerEmailPassword());
                applicationForm.setManagerEmailPassword(leaveApplicationHistory.getUserEmailPassword());
                applicationForm.setStatus(applicationStatus);
                EmailService mailSender = new EmailService();
                mailSender.sendEmail(applicationForm);
                messages += " " + Messages.EMAIL_SUCCESS_MESSAGE;
                request.setAttribute("messages", messages);
            } catch (SQLException ex) {
                errorList.add(ex.toString());
            } catch (IOException ex) {
                errorList.add(ex.toString());
                request.setAttribute("messages", Messages.EMAIL_FAILED_MESSAGE);
            } catch (MessagingException ex) {
                errorList.add(ex.toString());
                request.setAttribute("messages", Messages.EMAIL_FAILED_MESSAGE);
            }
            request.setAttribute("messages", messages);

        } else {
            request.setAttribute("messages", Messages.Make_Your_Decision);
        }

        try {
            List<LeaveApplicationHistory> leaveApplicationHistoryList = new LeaveApplicationService().queryApplicationByStatus(userWithDepartmentInfo.getUserId(), "Pending");
            request.setAttribute("leaveApplicationHistoryList", leaveApplicationHistoryList);
        } catch (SQLException ex) {
            errorList.add(ex.toString());
        }
        request.setAttribute("errorList", errorList);
        RequestDispatcher rd = request.getRequestDispatcher("/applicationNeedsYourApproval.jsp");
        rd.forward(request, response);
    }
}
