package org.niu.leaves.jsp.servlet.service;

import com.google.inject.Guice;
import com.google.inject.Injector;
import org.niu.leaves.jsp.servlet.ConfigurationGuice.ConfigureModule;
import org.niu.leaves.jsp.servlet.dao.DepartmentDao;
import org.niu.leaves.jsp.servlet.dao.LeaveApplicationDao;
import org.niu.leaves.jsp.servlet.dao.LeaveApplicationDaoImpl;

import java.sql.SQLException;

public class CheckTotalDaysByFromTo {
    LeaveApplicationDao leaveApplicationDao;

    public CheckTotalDaysByFromTo() {
        Injector injector = Guice.createInjector(new ConfigureModule());
        leaveApplicationDao = injector.getInstance(LeaveApplicationDao.class);
    }

    public int checkTotalDaysByFromTo(String from, String to) throws SQLException {

        try {
            return leaveApplicationDao.getTotalDays(from, to);
        } catch (SQLException ex) {
            throw new SQLException("There is something wrong with calculation of 'from' and 'to' ");
        }
    }
}
