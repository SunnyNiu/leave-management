package org.niu.leaves.jsp.servlet.servlet;

import org.niu.leaves.jsp.servlet.model.UserWithDepartmentInfo;
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
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class updateUser extends HttpServlet {
    PermissionService permissionService = new PermissionService();
    DepartmentService departmentService = new DepartmentService();
    TitleService titleService = new TitleService();
    UserService userService = new UserService();

    //submit "Add new member" to database
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String login = (String) session.getAttribute("login");
        if (login == null || login.isEmpty()) {
            request.getRequestDispatcher("/sessionTimeout.jsp").forward(request, response);
            return;
        }

        List<String> errorList = new ArrayList<String>();

        String searchStaffBtn = request.getParameter("searchStaffBtn");
        if (searchStaffBtn != null) {
            String firstName = request.getParameter("firsName");
            String LastName = request.getParameter("lastName");
            if (errorList.isEmpty()) {
                try {
                    UserWithDepartmentInfo userBasicInfo = userService.getUserBasicInfo(firstName, LastName);
                    request.setAttribute("userBasicInfo", userBasicInfo);
                } catch (SQLException ex) {
                    errorList.add(ex.toString());
                }
            }

            String today = new SimpleDateFormat("yyyy/MM/dd").format(new Date());
            request.setAttribute("errorList", errorList);
            request.setAttribute("today", today);
            RequestDispatcher rd = request.getRequestDispatcher("/updateOrDeleteMember.jsp");
            rd.forward(request, response);
        }
    }
}

