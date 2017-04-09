package org.niu.leaves.jsp.servlet.service;

import org.niu.leaves.jsp.servlet.dao.LeaveApplicationDAO;

import java.sql.SQLException;

public class CheckTotalDaysByFromTo {
    public int checkTotalDaysByFromTo(String from, String to) throws SQLException {
        LeaveApplicationDAO leaveApplicationDAO = new LeaveApplicationDAO();
        try {
            return leaveApplicationDAO.getTotalDays(from, to);
        } catch (SQLException ex) {
            throw new SQLException("There is something wrong with calculation of 'from' and 'to' ");
        }
    }
}
