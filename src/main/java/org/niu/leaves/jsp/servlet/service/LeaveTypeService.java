package org.niu.leaves.jsp.servlet.service;

import org.niu.leaves.jsp.servlet.ConfigurationGuice.GuiceInjector;
import org.niu.leaves.jsp.servlet.dao.LeaveTypeDao;
import org.niu.leaves.jsp.servlet.model.LeaveType;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class LeaveTypeService {
    private LeaveTypeDao leaveTypeDao;

    public LeaveTypeService(){
        leaveTypeDao = GuiceInjector.getInstance(LeaveTypeDao.class);
    }

    public List<LeaveType> getLeaveTypes() throws SQLException,IOException {
        List<LeaveType> leaveTypes = leaveTypeDao.queryLeaveTypes();
        return leaveTypes;
    }

    public boolean leaveTypeExist(int leaveTypeId) throws SQLException,IOException {
        List<LeaveType> leaveTypes = leaveTypeDao.queryLeaveTypes();
        for (LeaveType leaveTypeValue : leaveTypes) {
            if (leaveTypeValue.getId() == leaveTypeId) {
                return true;
            }
        }
        return false;
    }
}
