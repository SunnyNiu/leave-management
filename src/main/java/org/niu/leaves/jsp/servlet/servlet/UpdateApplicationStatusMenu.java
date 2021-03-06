package org.niu.leaves.jsp.servlet.servlet;

import org.niu.leaves.jsp.servlet.model.ApplicationStatus;
import org.niu.leaves.jsp.servlet.model.LeaveApplicationHistory;
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

public class UpdateApplicationStatusMenu extends HttpServlet {
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
        List<ApplicationStatus> statusList = new ArrayList<>();

        for (ApplicationStatus status : ApplicationStatus.values()) {
            statusList.add(status);
        }
        request.setAttribute("status", statusList);

        String today = new SimpleDateFormat("yyyy/MM/dd").format(new Date());
        request.setAttribute("today", today);
        request.setAttribute("errorList", errorList);
        RequestDispatcher rd = request.getRequestDispatcher("/updateApplicationStatus.jsp?");
        rd.forward(request, response);
    }
}
