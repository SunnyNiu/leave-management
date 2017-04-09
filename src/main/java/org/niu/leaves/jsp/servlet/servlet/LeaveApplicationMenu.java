package org.niu.leaves.jsp.servlet.servlet;

import org.niu.leaves.jsp.servlet.model.*;
import org.niu.leaves.jsp.servlet.service.*;
import org.niu.leaves.jsp.servlet.utility.InitializeLeaveApplicationForm;

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

/**
 * Created by Sunny on 27/03/2017.
 */
public class LeaveApplicationMenu extends HttpServlet {
    PermissionService permissionService = new PermissionService();
    DepartmentService departmentService = new DepartmentService();
    LeaveTypeService leaveTypeService = new LeaveTypeService();
    UserService userService = new UserService();
    TitleService titleService = new TitleService();

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String login = (String) session.getAttribute("login");
        if (login == null || login.isEmpty()) {
            request.getRequestDispatcher("/sessionTimeout.jsp").forward(request, response);
            return;
        }

        List<String> errorList = new ArrayList<String>();
        UserWithDepartmentInfo userWithDepartmentInfo = (UserWithDepartmentInfo) session.getAttribute("userWithDepartmentInfo");

        //Automatically fill in user's manager and all leave types in Dropdownlist
        try {
            UserWithDepartmentInfo departmentManager = departmentService.getDepartmentManagerNameById(userWithDepartmentInfo.getUserId());
            request.setAttribute("departmentManager", departmentManager);
            List<LeaveType> leaveTypesList = leaveTypeService.getLeaveTypes();
            request.setAttribute("leaveTypesList", leaveTypesList);
            ApplicationForm applicationForm = new InitializeLeaveApplicationForm().initializeApplicationForm();
            request.setAttribute("applicationForm", applicationForm);
        } catch (SQLException ex) {
            request.getRequestDispatcher("/managerTitleOrLeaveTypeIsNull.jsp").forward(request, response);
            return;
        }

        //keep at least there is one row on application leave page
        int totalRows = 1;
        request.setAttribute("totalRows", totalRows);
        request.setAttribute("messages", "");
        request.setAttribute("errorList", errorList);
        request.setAttribute("today", new SimpleDateFormat("yyyy/MM/dd").format(new Date()));
        request.getRequestDispatcher("/applyLeave.jsp").forward(request, response);
    }
}
