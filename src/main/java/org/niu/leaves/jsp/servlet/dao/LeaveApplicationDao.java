package org.niu.leaves.jsp.servlet.dao;

import org.niu.leaves.jsp.servlet.model.LeaveApplicationHistory;

import java.sql.SQLException;
import java.util.List;

public interface LeaveApplicationDao {
    public void insertLeaveApplication(int userId, String dateFrom, String dateTo, Double days, String reason, String sickType, int managerId) throws SQLException;
    public List<LeaveApplicationHistory> queryLeaveHistory(int userId, String leaveType, String fromDate, String toDate) throws SQLException;
    public List<LeaveApplicationHistory> queryApplicationByStatus(int approverId, String status) throws SQLException;
    public LeaveApplicationHistory getApplicationById(int applicationId) throws SQLException;
    public void updateApplicationStatus(int applicationId, String status) throws SQLException;
    public int getTotalDays(String from, String to) throws SQLException;
}
