package org.niu.leaves.jsp.servlet.servlet;

import org.niu.leaves.jsp.servlet.service.DepartmentService;
import org.niu.leaves.jsp.servlet.service.PermissionService;
import org.niu.leaves.jsp.servlet.service.TitleService;
import org.niu.leaves.jsp.servlet.service.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class updateUserMenu extends HttpServlet {
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

        //get now dateTime
        String today = new SimpleDateFormat("yyyy/MM/dd").format(new Date());
        request.setAttribute("today", today);
        RequestDispatcher rd = request.getRequestDispatcher("/updateOrDeleteMember.jsp");
        rd.forward(request, response);
    }
}