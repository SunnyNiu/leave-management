package org.niu.leaves.jsp.servlet.service;

import org.niu.leaves.jsp.servlet.dao.LeaveApplicationDAO;
import org.niu.leaves.jsp.servlet.model.LeaveApplicationHistory;

import java.sql.SQLException;
import java.util.List;

public class LeaveApplicationService {
    private LeaveApplicationDAO leaveApplicationDAO = new LeaveApplicationDAO();

    public List<LeaveApplicationHistory> queryApplicationByStatus(int approverId, String status) throws SQLException {
        return leaveApplicationDAO.queryApplicationByStatus(approverId, status);
    }

    public LeaveApplicationHistory getApplicationById(int applicationId) throws SQLException {
        return leaveApplicationDAO.getApplicationById(applicationId);
    }

    public void updateStatus(int applicationId, String status) throws SQLException {
        leaveApplicationDAO.updateApplicationStatus(applicationId, status);
    }

    public List<LeaveApplicationHistory> queryApplicationHistory(int userId, String leaveType, String fromDate, String toDate) throws SQLException {
        return leaveApplicationDAO.queryLeaveHistory(userId, leaveType, fromDate, toDate);
    }

    public void insertLeaveApplication(int userId, String fromDate, String toDate, double totalDays, String reason, String sickType, int managerId) throws SQLException{
        leaveApplicationDAO.insertLeaveApplication(userId, fromDate, toDate, totalDays, reason, sickType, managerId);
    }
}
