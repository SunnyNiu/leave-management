package org.niu.leaves.jsp.servlet.servlet;

import org.niu.leaves.jsp.servlet.model.Title;
import org.niu.leaves.jsp.servlet.model.UserWithDepartmentInfo;
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
import java.util.*;

public class CreateUser extends HttpServlet {
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

        String addBtn = request.getParameter("addBtn");
        if (addBtn != null) {
            String newLogin = request.getParameter("newLogin");
            String password = request.getParameter("password");
            String department = request.getParameter("department");
            String title = request.getParameter("title");
            String joinDate = request.getParameter("joinDate");
            String birthDate = request.getParameter("birthDate");
            String firstName = request.getParameter("firstName");
            String lastName = request.getParameter("lastName");
            String email = request.getParameter("email");
            try {
                boolean userIsExist = userService.userExist(newLogin);
                userService.addNewMember(newLogin, password, department, title, joinDate, birthDate, firstName, lastName,email, userIsExist);
                request.setAttribute("messages", Messages.ADD_MEMBER_SUCCESS_MESSAGE);
            } catch (SQLException ex) {
                errorList.add(ex.toString());
            }

            String today = new SimpleDateFormat("yyyy/MM/dd").format(new Date());
            request.setAttribute("errorList",errorList);
            request.setAttribute("today", today);
            RequestDispatcher rd = request.getRequestDispatcher("/newMember.jsp");
            rd.forward(request, response);
        }
    }
}
