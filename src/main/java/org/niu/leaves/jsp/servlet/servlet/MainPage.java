package org.niu.leaves.jsp.servlet.servlet;

import org.niu.leaves.jsp.servlet.service.DepartmentService;
import org.niu.leaves.jsp.servlet.service.PermissionService;
import org.niu.leaves.jsp.servlet.service.TitleService;
import org.niu.leaves.jsp.servlet.service.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.http.Part;

public class MainPage extends HttpServlet {
    PermissionService permissionService = new PermissionService();
    UserService userService = new UserService();
    TitleService titleService = new TitleService();
    DepartmentService departmentService = new DepartmentService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<String> errorList = new ArrayList<String>();
        HttpSession session = request.getSession();
        String login = (String) session.getAttribute("login");
        if (login == null || login.isEmpty()) {
            request.getRequestDispatcher("/sessionTimeout.jsp").forward(request, response);
            return;
        }

        //read file to InputStream
        InputStream inputStream = null;
        Part filePart = request.getPart("photo");
        if (filePart != null) {
            inputStream = filePart.getInputStream();
        }

        //write file by ByteArrayOutputStream
        ByteArrayOutputStream outStream = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int length = -1;
        while ((length = inputStream.read(buffer)) != -1) {
            outStream.write(buffer, 0, length);
        }
        outStream.close();
        inputStream.close();
        byte[] fileByte = outStream.toByteArray();

        //get file path
        String path = this.getClass().getClassLoader().getResource("/").getPath() + "../../";

        //write file to specified path
        FileOutputStream fos = new FileOutputStream(path + login + "profile.jpg");
        fos.write(fileByte);
        fos.close();

        request.setAttribute("errorList", errorList);
        request.setAttribute("today", new SimpleDateFormat("yyyy/MM/dd").format(new Date()));
        RequestDispatcher rd = request.getRequestDispatcher("/mainPage.jsp");
        rd.forward(request, response);
    }
}
