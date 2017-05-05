package org.niu.leaves.jsp.servlet.dao;

import org.niu.leaves.jsp.servlet.model.LeaveApplicationHistory;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public interface LeaveApplicationDao {
    public void insertLeaveApplication(int userId, String dateFrom, String dateTo, Double days, String reason, String sickType, int managerId) throws SQLException, IOException;

    public List<LeaveApplicationHistory> queryLeaveHistory(int userId, String leaveType, String fromDate, String toDate, int start, int end) throws SQLException, IOException;

    public List<LeaveApplicationHistory> queryApplicationByStatus(int approverId, String status, int start, int end) throws SQLException, IOException;

    public LeaveApplicationHistory getApplicationById(int applicationId) throws SQLException, IOException;

    public void updateApplicationStatus(int applicationId, String status) throws SQLException, IOException;

    public int getTotalDays(String from, String to) throws SQLException, IOException;

    public int queryTotalRecords(int userId, String leaveType, String fromDate, String toDate) throws SQLException, IOException;

    public int queryTotalApplicationByStatus(int applicationId, String status) throws SQLException, IOException;
}
