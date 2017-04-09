package org.niu.leaves.jsp.servlet.service;

import com.google.inject.Guice;
import com.google.inject.Injector;
import org.niu.leaves.jsp.servlet.ConfigurationGuice.ConfigureModule;
import org.niu.leaves.jsp.servlet.dao.LeaveApplicationDao;
import org.niu.leaves.jsp.servlet.dao.LeaveTypeDao;
import org.niu.leaves.jsp.servlet.dao.LeaveTypeDaoImpl;
import org.niu.leaves.jsp.servlet.model.LeaveType;

import java.sql.SQLException;
import java.util.List;

public class LeaveTypeService {
    private LeaveTypeDao leaveTypeDao;

    public LeaveTypeService(){
        Injector injector = Guice.createInjector(new ConfigureModule());
        leaveTypeDao = injector.getInstance(LeaveTypeDao.class);
    }

    public List<LeaveType> getLeaveTypes() throws SQLException {
        List<LeaveType> leaveTypes = leaveTypeDao.queryLeaveTypes();
        return leaveTypes;
    }

    public boolean leaveTypeExist(int leaveTypeId) throws SQLException {
        List<LeaveType> leaveTypes = leaveTypeDao.queryLeaveTypes();
        for (LeaveType leaveTypeValue : leaveTypes) {
            if (leaveTypeValue.getId() == leaveTypeId) {
                return true;
            }
        }
        return false;
    }
}
