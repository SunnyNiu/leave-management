package org.niu.leaves.jsp.servlet.service;

import org.niu.leaves.jsp.servlet.ConfigurationGuice.GuiceInjector;
import org.niu.leaves.jsp.servlet.dao.LeaveApplicationDao;
import org.niu.leaves.jsp.servlet.model.LeaveApplicationHistory;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class LeaveApplicationService {
    private LeaveApplicationDao leaveApplicationDao;

    public LeaveApplicationService() {
        leaveApplicationDao = GuiceInjector.getInstance(LeaveApplicationDao.class);
    }

    public List<LeaveApplicationHistory> queryApplicationByStatus(int approverId, String status, int start, int end) throws SQLException, IOException {
        return leaveApplicationDao.queryApplicationByStatus(approverId, status, start, end);
    }

    public LeaveApplicationHistory getApplicationById(int applicationId) throws SQLException, IOException {
        return leaveApplicationDao.getApplicationById(applicationId);
    }

    public void updateStatus(int applicationId, String status) throws SQLException, IOException {
        leaveApplicationDao.updateApplicationStatus(applicationId, status);
    }

    public int queryTotalApplicationByStatus(int applicationId, String status) throws SQLException, IOException {
        return leaveApplicationDao.queryTotalApplicationByStatus(applicationId, status);
    }

    public List<LeaveApplicationHistory> queryApplicationHistory(int userId, String leaveType, String fromDate, String toDate, int start, int end) throws SQLException, IOException {
        return leaveApplicationDao.queryLeaveHistory(userId, leaveType, fromDate, toDate, start, end);
    }

    public int queryTotalRecords(int userId, String leaveType, String fromDate, String toDate) throws SQLException, IOException {
        return leaveApplicationDao.queryTotalRecords(userId, leaveType, fromDate, toDate);
    }

    public void insertLeaveApplication(int userId, String fromDate, String toDate, double totalDays, String reason, String sickType, int managerId) throws SQLException, IOException {
        leaveApplicationDao.insertLeaveApplication(userId, fromDate, toDate, totalDays, reason, sickType, managerId);
    }
}
