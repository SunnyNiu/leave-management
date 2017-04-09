package org.niu.leaves.jsp.servlet.servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Logout extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //close session
        request.getSession(true).invalidate();
        RequestDispatcher dispatcher=getServletContext().getRequestDispatcher("/login.jsp");
        dispatcher.forward(request,response);
    }

}
