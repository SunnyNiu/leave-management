package org.niu.leaves.jsp.servlet.servlet;

import org.niu.leaves.jsp.servlet.model.Title;
import org.niu.leaves.jsp.servlet.model.UserWithDepartmentInfo;
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

public class CreateUserMenu extends HttpServlet {
    PermissionService permissionService = new PermissionService();
    DepartmentService departmentService = new DepartmentService();
    TitleService titleService = new TitleService();
    UserService userService = new UserService();

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //This control menu show that only user whose levelId=1 has permission to add new member
        HttpSession session = request.getSession();
        String login = (String) session.getAttribute("login");
        if (login == null || login.isEmpty()) {
            request.getRequestDispatcher("/sessionTimeout.jsp").forward(request, response);
            return;
        }

        List<String> errorList = new ArrayList<String>();

        //Automatically fill in managerList Dropdownlist
        try {
            List<UserWithDepartmentInfo> userWithDepartmentInfoList = departmentService.queryAllDepartments();
            request.setAttribute("departmentManagerList", userWithDepartmentInfoList);

            List<Title> titleList = titleService.getTitles();
            request.setAttribute("titleList", titleList);
        } catch (SQLException ex) {
            request.getRequestDispatcher("/managerTitleOrLeaveTypeIsNull.jsp").forward(request, response);
            return;
        }

        //get now dateTime
        String today = new SimpleDateFormat("yyyy/MM/dd").format(new Date());
        request.setAttribute("today", today);
        request.setAttribute("errorList", errorList);
        RequestDispatcher rd = request.getRequestDispatcher("/newMember.jsp");
        rd.forward(request, response);
    }
}
