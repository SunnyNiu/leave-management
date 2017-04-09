package org.niu.leaves.jsp.servlet.service;


import org.niu.leaves.jsp.servlet.ConfigurationGuice.GuiceInjector;
import org.niu.leaves.jsp.servlet.dao.LeaveApplicationDao;

import java.sql.SQLException;

public class CheckTotalDaysByFromTo {
    LeaveApplicationDao leaveApplicationDao;

    public CheckTotalDaysByFromTo() {
        leaveApplicationDao = GuiceInjector.getInstance(LeaveApplicationDao.class);
    }

    public int checkTotalDaysByFromTo(String from, String to) throws SQLException {

        try {
            return leaveApplicationDao.getTotalDays(from, to);
        } catch (SQLException ex) {
            throw new SQLException("There is something wrong with calculation of 'from' and 'to' ");
        }
    }
}
