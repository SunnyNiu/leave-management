package org.niu.leaves.jsp.servlet.servlet;

import org.niu.leaves.jsp.servlet.model.UserWithDepartmentInfo;
import org.niu.leaves.jsp.servlet.service.DepartmentService;
import org.niu.leaves.jsp.servlet.service.PermissionService;
import org.niu.leaves.jsp.servlet.service.TitleService;
import org.niu.leaves.jsp.servlet.service.UserService;
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

/**
 * Created by Sunny on 9/04/2017.
 */
public class BasicInfoUpdate extends HttpServlet {
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

        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String phoneNumber = request.getParameter("phoneNumber");
        String physicalAddress = request.getParameter("physicalAddress");


        if (errorList.isEmpty()) {
            try {
                userService.updateBasicInfo(login, firstName, lastName, phoneNumber, physicalAddress);
                request.setAttribute("messages", Messages.UPDATE_BASIC_INFO_SUCCESS_MESSAGE);

                UserWithDepartmentInfo userWithDepartmentInfo = userService.getUserWithDepartmentInfo(login);
                session.setAttribute("userWithDepartmentInfo", userWithDepartmentInfo);
            } catch (SQLException ex) {
                errorList.add(ex.toString());
            }
        }

        request.setAttribute("today", new SimpleDateFormat("yyyy/MM/dd").format(new Date()));
        request.setAttribute("errorList", errorList);
        RequestDispatcher rd = request.getRequestDispatcher("/basicInfoUpdated.jsp");
        rd.forward(request, response);
    }
}