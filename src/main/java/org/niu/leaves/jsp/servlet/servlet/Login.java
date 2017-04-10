package org.niu.leaves.jsp.servlet.servlet;

import org.niu.leaves.jsp.servlet.model.Permission;
import org.niu.leaves.jsp.servlet.model.UserWithDepartmentInfo;
import org.niu.leaves.jsp.servlet.service.AuthenticationService;
import org.niu.leaves.jsp.servlet.service.DepartmentService;
import org.niu.leaves.jsp.servlet.service.PermissionService;
import org.niu.leaves.jsp.servlet.service.TitleService;

import javax.servlet.http.HttpServlet;
import java.io.*;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.*;
import javax.servlet.http.*;

public class Login extends HttpServlet {
    PermissionService permissionService = new PermissionService();
    TitleService titleService = new TitleService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        HttpSession session = request.getSession();
        session.setAttribute("login", login);

        //All errors is saved in errorList
        List<String> errorList = new ArrayList<>();
        try {
            //check if this user can log in this management system
            UserWithDepartmentInfo userWithDepartmentInfo = new AuthenticationService().authenticateUser(login, password);
            session.setAttribute("userWithDepartmentInfo", userWithDepartmentInfo);

            //check user's permission
            try {
                Permission p = permissionService.getUserPermission(login);
                DepartmentService departmentService = new DepartmentService();
                List<UserWithDepartmentInfo> departmentInfoList = departmentService.queryAllDepartments();
                for (UserWithDepartmentInfo departmentInfo : departmentInfoList) {
                    if (departmentInfo.getManagerUserId() == userWithDepartmentInfo.getUserId()) {
                        session.setAttribute("approveRejectIsPermitted", p.isApproveRejectIsPermitted());
                        break;
                    }
                }
                int levelId = titleService.getLevelId(userWithDepartmentInfo.getTitle());
                if (levelId == 1) {
                    session.setAttribute("addMemberIsPermitted", p.isAddMemberIsPermitted());
                }
            } catch (SQLException ex) {
                request.getRequestDispatcher("/unauthorized.jsp").forward(request, response);
                return;
            }
            //If there is not any error at all, jump onto mainPage automatically
            if (errorList.isEmpty()) {
                //ensure only the right approver can approve this leave application, add new member
                request.setAttribute("today", new SimpleDateFormat("yyyy/MM/dd").format(new Date()));
                request.getRequestDispatcher("/mainPage.jsp").forward(request, response);
            } else {
                request.setAttribute("errorList", errorList);
                request.getRequestDispatcher("/login.jsp").forward(request, response);
            }
        } catch (SQLException ex) {
            //keep stay at login page if there is any error
            if (ex.getMessage() != null && !ex.getMessage().isEmpty()) {
                errorList.add(ex.getMessage());
            }
            request.setAttribute("errorList", errorList);
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/login.jsp").forward(request, response);
    }
}
