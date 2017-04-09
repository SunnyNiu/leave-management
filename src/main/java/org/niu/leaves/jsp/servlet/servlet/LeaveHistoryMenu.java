package org.niu.leaves.jsp.servlet.servlet;

import org.niu.leaves.jsp.servlet.model.LeaveType;
import org.niu.leaves.jsp.servlet.model.UserInfo;
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

public class LeaveHistoryMenu extends HttpServlet {
    PermissionService permissionService = new PermissionService();
    UserService userService = new UserService();
    LeaveTypeService leaveTypeService = new LeaveTypeService();
    TitleService titleService = new TitleService();
    DepartmentService departmentService = new DepartmentService();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String login = (String) session.getAttribute("login");
        if (login == null || login.isEmpty()) {
            request.getRequestDispatcher("/sessionTimeout.jsp").forward(request, response);
            return;
        }
        List<String> errorList = new ArrayList<>();
        try {
            List<UserInfo> userList = userService.getAllUsers();
            request.setAttribute("userList",userList);
            List<LeaveType> leaveTypesList = leaveTypeService.getLeaveTypes();
            request.setAttribute("leaveTypesList", leaveTypesList);
        } catch (SQLException ex) {
            errorList.add(ex.toString());
        }
        String today = new SimpleDateFormat("yyyy/MM/dd").format(new Date());
        request.setAttribute("messages", "");
        request.setAttribute("errorList", errorList);
        request.setAttribute("today", today);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/leaveHistory.jsp");
        dispatcher.forward(request, response);
    }
}
