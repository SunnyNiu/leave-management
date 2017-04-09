package org.niu.leaves.jsp.servlet.servlet;

import org.niu.leaves.jsp.servlet.service.DepartmentService;
import org.niu.leaves.jsp.servlet.service.PermissionService;
import org.niu.leaves.jsp.servlet.service.TitleService;
import org.niu.leaves.jsp.servlet.service.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * Created by Sunny on 25/01/2017.
 */

public class MainPageMenu extends HttpServlet {
    PermissionService permissionService = new PermissionService();
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

        List<String> errorList = new ArrayList<String>();
        //get user detailed info

        request.setAttribute("errorList", errorList);
        request.setAttribute("today", new SimpleDateFormat("yyyy/MM/dd").format(new Date()));
        RequestDispatcher rd = request.getRequestDispatcher("/mainPage.jsp");
        rd.forward(request, response);
    }
}
