package org.niu.leaves.jsp.servlet.servlet;

import org.niu.leaves.jsp.servlet.model.LeaveApplicationHistory;
import org.niu.leaves.jsp.servlet.service.LeaveApplicationService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PaginationLeaveHistory extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LeaveApplicationService leaveApplicationService = new LeaveApplicationService();
        List<String> errorList = new ArrayList<>();
        int rowsPerPage = 2;
        try {
            int start = 0;
            if (request.getParameter("id") != null) {
                start = Integer.parseInt(request.getParameter("id"));
            } else {
                start = 1;
            }
            HttpSession session = request.getSession();
            int userId = (int) session.getAttribute("userId");
            String leaveType = (String) session.getAttribute("leaveType");
            String fromDate = (String) session.getAttribute("fromDate");
            String toDate = (String) session.getAttribute("toDate");
            int end = start + rowsPerPage;
            List<LeaveApplicationHistory> leaveApplicationHistoryList = leaveApplicationService.queryApplicationHistory(userId, leaveType, fromDate, toDate, start, end);
            int totalRecord = leaveApplicationService.queryTotalRecords(userId, leaveType, fromDate, toDate);
            int pagesNumber = totalRecord / 2 + totalRecord % 2;
            request.setAttribute("pagesNumber", pagesNumber);
            request.setAttribute("leaveApplicationHistoryList", leaveApplicationHistoryList);
            RequestDispatcher rd = request.getRequestDispatcher("/leaveHistory.jsp");
            rd.forward(request, response);
        } catch (SQLException ex) {
            errorList.add(ex.toString());
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LeaveApplicationService leaveApplicationService = new LeaveApplicationService();
        List<String> errorList = new ArrayList<>();
        int rowsPerPage = 2;
        try {
            int start = 0;
            String sr = request.getParameter("pageNumber");
            if (request.getParameter("id") != null) {
                start = Integer.parseInt(request.getParameter("id"));
            } else {
                start = 1;
            }
            HttpSession session = request.getSession();
            int userId = (int) session.getAttribute("userId");
            String leaveType = (String) session.getAttribute("leaveType");
            String fromDate = (String) session.getAttribute("fromDate");
            String toDate = (String) session.getAttribute("toDate");
            int end = start + rowsPerPage;
            List<LeaveApplicationHistory> leaveApplicationHistoryList = leaveApplicationService.queryApplicationHistory(userId, leaveType, fromDate, toDate, start, end);
            int totalRecord = leaveApplicationService.queryTotalRecords(userId, leaveType, fromDate, toDate);
            int pagesNumber = totalRecord / 2 + totalRecord % 2;
            request.setAttribute("pagesNumber", pagesNumber);
            request.setAttribute("leaveApplicationHistoryList", leaveApplicationHistoryList);
        } catch (SQLException ex) {
            errorList.add(ex.toString());
        }
    }
}
