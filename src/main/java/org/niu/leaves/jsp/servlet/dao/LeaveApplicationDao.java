package org.niu.leaves.jsp.servlet.dao;

import org.niu.leaves.jsp.servlet.model.LeaveApplicationHistory;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public interface LeaveApplicationDao {
    void insertLeaveApplication(int userId, String dateFrom, String dateTo, Double days, String reason, String sickType, int managerId) throws SQLException, IOException;

    List<LeaveApplicationHistory> queryLeaveHistory(int userId, String leaveType, String fromDate, String toDate, int start, int end) throws SQLException, IOException;

    List<LeaveApplicationHistory> queryApplicationByStatus(int approverId, String status, int start, int end) throws SQLException, IOException;

    LeaveApplicationHistory getApplicationById(int applicationId) throws SQLException, IOException;

    void updateApplicationStatus(int applicationId, String status) throws SQLException, IOException;

    int getTotalDays(String from, String to) throws SQLException, IOException;

    int queryTotalRecords(int userId, String leaveType, String fromDate, String toDate) throws SQLException, IOException;

    int queryTotalApplicationByStatus(int applicationId, String status) throws SQLException, IOException;
}
