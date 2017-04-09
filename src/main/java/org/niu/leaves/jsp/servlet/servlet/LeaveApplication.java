package org.niu.leaves.jsp.servlet.servlet;

import org.niu.leaves.jsp.servlet.model.*;
import org.niu.leaves.jsp.servlet.service.*;
import org.niu.leaves.jsp.servlet.utility.AddRowDetail;
import org.niu.leaves.jsp.servlet.utility.CheckFromToDaysForamt;
import org.niu.leaves.jsp.servlet.utility.InitializeLeaveApplicationForm;
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

public class LeaveApplication extends HttpServlet {
    PermissionService permissionService = new PermissionService();
    DepartmentService departmentService = new DepartmentService();
    LeaveTypeService leaveTypeService = new LeaveTypeService();
    UserService userService = new UserService();
    CheckTotalDaysByFromTo checkTotalDaysByFromTo = new CheckTotalDaysByFromTo();
    TitleService titleService = new TitleService();

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String login = (String) session.getAttribute("login");
        if (login == null || login.isEmpty()) {
            request.getRequestDispatcher("/sessionTimeout.jsp").forward(request, response);
            return;
        }

        List<String> errorList = new ArrayList<String>();
        String today = new SimpleDateFormat("yyyy/MM/dd").format(new Date());
        request.setAttribute("today", today);

        UserWithDepartmentInfo userWithDepartmentInfo = (UserWithDepartmentInfo) session.getAttribute("userWithDepartmentInfo");
        UserWithDepartmentInfo departmentManager;
        try {
            departmentManager = departmentService.getDepartmentManagerNameById(userWithDepartmentInfo.getUserId());
            request.setAttribute("departmentManager", departmentManager);
            List<LeaveType> leaveTypesList = leaveTypeService.getLeaveTypes();
            request.setAttribute("leaveTypesList", leaveTypesList);
        } catch (SQLException ex) {
            request.getRequestDispatcher("/managerTitleOrLeaveTypeIsNull.jsp").forward(request, response);
            return;
        }

        //Submit application
        ApplicationForm applicationForm = new ApplicationForm();
        applicationForm.setUserId(userWithDepartmentInfo.getUserId());
        applicationForm.setName(userWithDepartmentInfo.getUserName());
        applicationForm.setReason(request.getParameter("reason"));
        String departmentName = userWithDepartmentInfo.getDepartmentName();
        applicationForm.setDepartment(departmentName);
        String managerId = request.getParameter("departmentManager");
        if (managerId != null) {
            int managerIdValue = Integer.parseInt(managerId);
            applicationForm.setManagerId(managerIdValue);
        }
        String mangerName = userWithDepartmentInfo.getManagerName();
        applicationForm.setManagerName(mangerName);

        String btnApply = request.getParameter("btnApply");
        if (btnApply != null) {
            String leaveTypeValue = request.getParameter("leaveType");
            try {
                //Avoid someone deliberate insert not exist leaveType
                applicationForm.setApplicationLeaveType(request.getParameter("leaveType"));
                int leaveTypeId = Integer.parseInt(leaveTypeValue);
                boolean leaveTypeExist = leaveTypeService.leaveTypeExist(leaveTypeId);
                if (!leaveTypeExist) {
                    request.getRequestDispatcher("/managerTitleOrLeaveTypeIsNull.jsp").forward(request, response);
                    return;
                } else {
                    applicationForm.setLeaveTypeId(leaveTypeId);
                    List<LeaveType> leaveTypes = leaveTypeService.getLeaveTypes();
                    for (LeaveType leaveType : leaveTypes) {
                        if (leaveType.getId() == leaveTypeId)
                            applicationForm.setApplicationLeaveType(leaveType.getLeaveType());
                    }
                }
            } catch (SQLException e) {
                request.getRequestDispatcher("/managerTitleOrLeaveTypeIsNull.jsp").forward(request, response);
            }

            ArrayList<RowDetail> rowDetailList = new ArrayList<>();
            String totalRows = request.getParameter("totalRows");
            int total = Integer.parseInt(totalRows);
            for (int i = 0; i < total; i++) {
                String from = request.getParameterValues("fromDate")[i];
                String to = request.getParameterValues("toDate")[i];
                String totalDay = request.getParameterValues("totalDays")[i];
                RowDetail rowDetail = new AddRowDetail().addRowDetail(from, to, totalDay);
                rowDetailList.add(rowDetail);

                try {
                    double totalDays = Double.parseDouble(totalDay);
                    new CheckFromToDaysForamt().checkDateDaysFormat(from, to, totalDay);
                    int days = checkTotalDaysByFromTo.checkTotalDaysByFromTo(from, to);

                    if ((double) days == totalDays) {
                        errorList.add("Please populate correct days");
                    }
                } catch (NumberFormatException ex) {
                    errorList.add(Messages.Days_FORMAT_INCORRECT);
                } catch (ParseException ex) {
                    errorList.add(Messages.DATE_FORMAT_INCORRECT_MESSAGE);
                } catch (SQLException ex) {
                    errorList.add(ex.toString());
                }

                if (from.compareTo(to) > 0) {
                    errorList.add(Messages.START_SHOULD_LESS_THAN_END_MESSAGE);
                }
            }
            applicationForm.setLeaveList(rowDetailList);
            request.setAttribute("totalRows", totalRows);
            if (errorList.isEmpty()) {
                applicationForm.setLeaveList(rowDetailList);
                request.setAttribute("applicationForm", applicationForm);
                RequestDispatcher rd = request.getRequestDispatcher("/emailApplicationLeave.jsp");
                rd.forward(request, response);
            } else {

                request.setAttribute("errorList", errorList);
                request.setAttribute("applicationForm", applicationForm);
                RequestDispatcher rd = request.getRequestDispatcher("/applyLeave.jsp");
                rd.forward(request, response);
            }
        }

        //Add new row
        String btnAdd = request.getParameter("btnAdd");
        if (btnAdd != null) {
            String total = request.getParameter("totalRows");
            ArrayList<RowDetail> rowDetailList = new ArrayList<>();
            //keep at least one row on page
            if (total == null || total.isEmpty())
                total = "1";
            //Maximum rows is 5
            int totalRows = Integer.parseInt(total);
            int totalRowsAfterAdd = totalRows;
            if (totalRows < 6) {
                if (totalRows > 4)
                    totalRows = 4;
                getAllLeaveRows(totalRows, request, rowDetailList);
                RowDetail rowDetail = new AddRowDetail().addRowDetail("", "", "");
                rowDetailList.add(rowDetail);
                applicationForm.setLeaveList(rowDetailList);
                totalRowsAfterAdd = totalRows + 1;
            }
            request.setAttribute("totalRows", totalRowsAfterAdd);
            request.setAttribute("applicationForm", applicationForm);
            RequestDispatcher rd = request.getRequestDispatcher("/applyLeave.jsp");
            rd.forward(request, response);
        }

        String btnRemove = request.getParameter("btnRemove");
        if (btnRemove != null) {
            try {
                removeOneRow(request, applicationForm);
                RequestDispatcher rd = request.getRequestDispatcher("/applyLeave.jsp");
                rd.forward(request, response);
            } catch (IOException ex) {
                errorList.add(ex.toString());
            }
        }

        if ((btnAdd == null) && (btnRemove == null) && (btnApply == null)) {
            applicationForm = new InitializeLeaveApplicationForm().initializeApplicationForm();
            request.setAttribute("applicationForm", applicationForm);
            RequestDispatcher rd = request.getRequestDispatcher("/applyLeave.jsp");
            rd.forward(request, response);
        }
    }

    //get all leave rows and add to ArrayList
    public ArrayList<RowDetail> getAllLeaveRows(int totalRows, HttpServletRequest request, ArrayList<RowDetail> rowDetailList) {
        for (int i = 0; i < totalRows; i++) {
            String from = request.getParameterValues("fromDate")[i];
            String to = request.getParameterValues("toDate")[i];
            String totalDays = request.getParameterValues("totalDays")[i];
            RowDetail rowDetail = new AddRowDetail().addRowDetail(from, to, totalDays);
            rowDetailList.add(rowDetail);
        }
        return rowDetailList;
    }

    //remove one row leave application
    public void removeOneRow(HttpServletRequest request, ApplicationForm applicationFormRow) {
        String removeIndex = request.getParameter("btnRemove");
        String total = request.getParameter("totalRows");
        ArrayList<RowDetail> rowDetailList = new ArrayList<>();
        int totalRows = Integer.parseInt(total);
        int totalRowsAfterDeduct = totalRows;

        getAllLeaveRows(totalRows, request, rowDetailList);
        if (totalRows > 1) {
            rowDetailList.remove(Integer.parseInt(removeIndex));
            totalRowsAfterDeduct = totalRows - 1;
        }
        applicationFormRow.setLeaveList(rowDetailList);

        request.setAttribute("totalRows", totalRowsAfterDeduct);
        request.setAttribute("applicationForm", applicationFormRow);
    }
}
