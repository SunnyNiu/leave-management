package org.niu.leaves.jsp.servlet.servlet;

import org.niu.leaves.jsp.servlet.service.*;
import org.niu.leaves.jsp.servlet.utility.Messages;

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

public class PasswordUpdated extends HttpServlet {
    PermissionService permissionService = new PermissionService();
    UserService userService = new UserService();
    TitleService titleService = new TitleService();
    DepartmentService departmentService = new DepartmentService();

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //This control menu show that only user whose levelId=1 has permission to add new member
        HttpSession session = request.getSession();
        String login = (String) session.getAttribute("login");
        if (login == null || login.isEmpty()) {
            request.getRequestDispatcher("/sessionTimeout.jsp").forward(request, response);
            return;
        }

        List<String> errorList = new ArrayList<String>();

        String oldPassword = request.getParameter("oldPassword");
        String newPassword = request.getParameter("newPassword");
        String newPasswordConfirmation = request.getParameter("newPasswordConfirmation");
        try {
            //get old password of this user from database
            String passwordFromDatabase = userService.getPasswordByLogin(login);

            if (!oldPassword.equals(passwordFromDatabase)) {
                throw new SQLException(Messages.OLD_PASSWORD_INCORRECT_MESSAGE);
            }
            //new password confirmation doesn't match new password
            if (!newPassword.equals(newPasswordConfirmation)) {
                throw new SQLException(Messages.NEW_PASSWORD_CONFIRMED_UNMATCHED_MESSAGE);
            }
            //Not input new password
            if (newPassword.length() == 0) {
                throw new SQLException(Messages.NEW_PASSWORD_INCORRECT_MESSAGE);
            }

            if (errorList.isEmpty()) {
                userService.updateUserPassword(login, newPassword);
                request.setAttribute("messages", Messages.UPDATE_PASSWORD_SUCCESS_MESSAGE);
            }
        } catch (SQLException ex) {
            errorList.add(ex.toString());
        }

        request.setAttribute("errorList", errorList);
        request.setAttribute("today", new SimpleDateFormat("yyyy/MM/dd").format(new Date()));
        request.setAttribute("errorList", errorList);
        RequestDispatcher rd = request.getRequestDispatcher("/passwordUpdated.jsp");
        rd.forward(request, response);
    }
}
