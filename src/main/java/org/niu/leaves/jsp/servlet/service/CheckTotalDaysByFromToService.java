package org.niu.leaves.jsp.servlet.service;


import org.niu.leaves.jsp.servlet.ConfigurationGuice.GuiceInjector;
import org.niu.leaves.jsp.servlet.dao.LeaveApplicationDao;
import org.niu.leaves.jsp.servlet.utility.Messages;

import java.io.IOException;
import java.sql.SQLException;

public class CheckTotalDaysByFromToService {
    LeaveApplicationDao leaveApplicationDao;

    public CheckTotalDaysByFromToService() {
        leaveApplicationDao = GuiceInjector.getInstance(LeaveApplicationDao.class);
    }

    public int checkTotalDaysByFromTo(String from, String to) throws SQLException, IOException {
        try {
            return leaveApplicationDao.getTotalDays(from, to);
        } catch (SQLException ex) {
            throw new SQLException(Messages.FROM_TO_DAYS_INCORRECT);
        }
    }

    public void checkFromLessThanTo(String from, String to) throws SQLException, IOException {
        if (from.compareTo(to) > 0) {
            throw new SQLException(Messages.START_SHOULD_LESS_THAN_END_MESSAGE);
        }
    }
}
