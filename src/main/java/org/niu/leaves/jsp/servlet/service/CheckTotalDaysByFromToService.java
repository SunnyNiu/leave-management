package org.niu.leaves.jsp.servlet.service;


import org.niu.leaves.jsp.servlet.ConfigurationGuice.GuiceInjector;
import org.niu.leaves.jsp.servlet.dao.LeaveApplicationDao;
import org.niu.leaves.jsp.servlet.utility.Messages;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CheckTotalDaysByFromToService {
    LeaveApplicationDao leaveApplicationDao;

    public CheckTotalDaysByFromToService() {
        leaveApplicationDao = GuiceInjector.getInstance(LeaveApplicationDao.class);
    }

    public void checkTotalDaysByFromTo(Double totalDay, String from, String to) throws ParseException, SQLException {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

        try {
            Date fromDate = formatter.parse(from);
            Date toDate = formatter.parse(to);
            int difference =
                    ((int) ((toDate.getTime() / (24 * 60 * 60 * 1000))
                            - (int) (fromDate.getTime() / (24 * 60 * 60 * 1000)))) + 1;

            if (difference < 0) {
                throw new SQLException(Messages.FROM_LESS_THAN_TO);
            }

            if (difference < totalDay || difference > (totalDay + 0.5)) {
                throw new SQLException(Messages.FROM_TO_DAYS_INCORRECT);
            }
        } catch (ParseException e) {
            throw new ParseException(Messages.DATE_FORMAT_INCORRECT_MESSAGE, 0);
        }
    }
}
