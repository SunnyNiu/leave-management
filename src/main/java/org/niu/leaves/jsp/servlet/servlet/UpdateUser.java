package org.niu.leaves.jsp.servlet.servlet;

import org.niu.leaves.jsp.servlet.model.Title;
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

public class UpdateUser extends HttpServlet {
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
                    List<UserWithDepartmentInfo> userBasicInfoList = userService.getUserBasicInfo(firstName, LastName);
                    request.setAttribute("userBasicInfoNeedUpdate", userBasicInfoList);
                } catch (SQLException ex) {
                    errorList.add(ex.toString());
                }
            }
        }

        String changeBtn = request.getParameter("changeBtn");
        if (changeBtn != null) {
            request.setAttribute("changeBtn", changeBtn);
            String userLogin = request.getParameter("changeBtn");

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

            try {
                UserWithDepartmentInfo userBasicInfoNeedUpdate = userService.getUserWithDepartmentInfo(userLogin);
                List<UserWithDepartmentInfo> userList = new ArrayList<>();
                userList.add(userBasicInfoNeedUpdate);
                request.setAttribute("userBasicInfoNeedUpdate", userList);
            } catch (SQLException ex) {
                errorList.add(ex.toString());
            }
        }

        String updateBtn = request.getParameter("updateBtn");
        if (updateBtn != null) {
            request.setAttribute("updateBtn", updateBtn);
            int userId = Integer.parseInt(request.getParameter("userId"));
            int departmentId = Integer.parseInt(request.getParameter("department"));
            int titleId = Integer.parseInt(request.getParameter("title"));
            String userEmail = request.getParameter("email");
            String userEmailPassword = request.getParameter("emailPassword");
            int flag = Integer.parseInt(request.getParameter("flag"));

            try {
                userService.updateStaffInfo(userId, departmentId, titleId, userEmail, userEmailPassword, flag);
                request.setAttribute("message",Messages.UPDATE_BASIC_INFO_SUCCESS_MESSAGE);
            } catch (SQLException ex) {
                request.setAttribute("errorList", errorList);
            }
        }

        String today = new SimpleDateFormat("yyyy/MM/dd").format(new Date());
        request.setAttribute("errorList", errorList);
        request.setAttribute("today", today);
        RequestDispatcher rd = request.getRequestDispatcher("/updateOrDeleteMember.jsp");
        rd.forward(request, response);
        return;
    }
}

