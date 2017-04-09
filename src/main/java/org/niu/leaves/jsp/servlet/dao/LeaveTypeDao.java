package org.niu.leaves.jsp.servlet.dao;

import org.niu.leaves.jsp.servlet.model.LeaveType;

import java.sql.SQLException;
import java.util.List;

public interface LeaveTypeDao {
    public List<LeaveType> queryLeaveTypes() throws SQLException;
}
