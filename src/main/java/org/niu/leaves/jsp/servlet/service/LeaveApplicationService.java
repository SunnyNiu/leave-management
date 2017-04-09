package org.niu.leaves.jsp.servlet.service;

import com.google.inject.Guice;
import com.google.inject.Injector;
import org.niu.leaves.jsp.servlet.ConfigurationGuice.ConfigureModule;
import org.niu.leaves.jsp.servlet.dao.DepartmentDao;
import org.niu.leaves.jsp.servlet.dao.LeaveApplicationDao;
import org.niu.leaves.jsp.servlet.dao.LeaveApplicationDaoImpl;
import org.niu.leaves.jsp.servlet.model.LeaveApplicationHistory;

import java.sql.SQLException;
import java.util.List;

public class LeaveApplicationService {
    private LeaveApplicationDao leaveApplicationDao;

    public LeaveApplicationService(){
        Injector injector = Guice.createInjector(new ConfigureModule());
        leaveApplicationDao = injector.getInstance(LeaveApplicationDao.class);
    }

    public List<LeaveApplicationHistory> queryApplicationByStatus(int approverId, String status) throws SQLException {
        return leaveApplicationDao.queryApplicationByStatus(approverId, status);
    }

    public LeaveApplicationHistory getApplicationById(int applicationId) throws SQLException {
        return leaveApplicationDao.getApplicationById(applicationId);
    }

    public void updateStatus(int applicationId, String status) throws SQLException {
        leaveApplicationDao.updateApplicationStatus(applicationId, status);
    }

    public List<LeaveApplicationHistory> queryApplicationHistory(int userId, String leaveType, String fromDate, String toDate) throws SQLException {
        return leaveApplicationDao.queryLeaveHistory(userId, leaveType, fromDate, toDate);
    }

    public void insertLeaveApplication(int userId, String fromDate, String toDate, double totalDays, String reason, String sickType, int managerId) throws SQLException{
        leaveApplicationDao.insertLeaveApplication(userId, fromDate, toDate, totalDays, reason, sickType, managerId);
    }
}
