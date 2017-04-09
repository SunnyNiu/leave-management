package org.niu.leaves.jsp.servlet.dao;

import org.niu.leaves.jsp.servlet.model.LeaveType;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LeaveTypeDaoImpl implements LeaveTypeDao {

    public List<LeaveType> queryLeaveTypes() throws SQLException {
        String sql = "select ID, LEAVE_TYPE from AP_LEAVE_TYPE";
        ResultSet rs = null;
        List<LeaveType> leaveTypeList = new ArrayList<>();
        try (Connection conn = ConnectionPool.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            rs = ps.executeQuery(sql);
            while (rs.next()) {
                LeaveType leaveType = new LeaveType();
                leaveType.setId(rs.getInt("ID"));
                leaveType.setLeaveType(rs.getString("LEAVE_TYPE"));
                leaveTypeList.add(leaveType);
            }
            return leaveTypeList;
        } finally {
            if (rs != null)
                rs.close();
        }
    }
}
