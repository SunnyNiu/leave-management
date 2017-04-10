package org.niu.leaves.jsp.servlet.dao;

import org.niu.leaves.jsp.servlet.model.UserWithDepartmentInfo;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DepartmentDaoImpl implements DepartmentDao {

    public List<UserWithDepartmentInfo> queryAllDepartments() throws SQLException,IOException {
        ResultSet rs = null;
        String sql = "select dp.id as departmentId ,dp.DEPARTMENT_NAME as departmentName, " +
                "dp.MANAGER_USER_ID as managerUserId, " +
                "manager.FIRST_NAME||manager.LAST_NAME as managerName " +
                "from AP_DEPARTMENT dp " +
                "inner join AP_USERS users on dp.ID= users.DEPARTMENT_ID " +
                "left join AP_USERS manager on manager.userid = dp.MANAGER_USER_ID";

        List<UserWithDepartmentInfo> userWithDepartmentInfoList = new ArrayList<UserWithDepartmentInfo>();
        try (Connection conn = ConnectionPool.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            rs = ps.executeQuery();
            while (rs.next()) {
                UserWithDepartmentInfo userWithDepartmentInfo = new UserWithDepartmentInfo();
                userWithDepartmentInfo.setDepartmentId(rs.getString("departmentId"));
                userWithDepartmentInfo.setDepartmentName(rs.getString("departmentName"));
                userWithDepartmentInfo.setManagerUserId(rs.getInt("managerUserId"));
                userWithDepartmentInfo.setManagerName(rs.getString("managerName"));
                userWithDepartmentInfoList.add(userWithDepartmentInfo);
            }
            return userWithDepartmentInfoList;
        } finally {
            if (rs != null)
                rs.close();
        }
    }

    public UserWithDepartmentInfo getDepartmentManagerByUserId(int userId) throws SQLException,IOException {
        ResultSet rs = null;
        String sql = "select dp.id as departmentId ,dp.DEPARTMENT_NAME as departmentName, " +
                "dp.MANAGER_USER_ID as managerUserId, " +
                "manager.FIRST_NAME||manager.LAST_NAME as managerName " +
                "from AP_DEPARTMENT dp " +
                "inner join AP_USERS users on dp.ID= users.DEPARTMENT_ID and users.USERID = ? " +
                "left join AP_USERS manager on manager.userid = dp.MANAGER_USER_ID";

        try (Connection conn = ConnectionPool.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, userId);
            rs = ps.executeQuery();
            if (rs.next()) {
                UserWithDepartmentInfo userWithDepartmentInfo = new UserWithDepartmentInfo();
                userWithDepartmentInfo.setDepartmentId(rs.getString("departmentId"));
                userWithDepartmentInfo.setDepartmentName(rs.getString("departmentName"));
                userWithDepartmentInfo.setManagerUserId(rs.getInt("managerUserId"));
                userWithDepartmentInfo.setManagerName(rs.getString("managerName"));
                return userWithDepartmentInfo;
            } else {
                throw new SQLException("user not found");
            }
        } finally {
            if (rs != null)
                rs.close();
        }
    }
}
