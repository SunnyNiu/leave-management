package org.niu.leaves.jsp.servlet.service;

import org.niu.leaves.jsp.servlet.dao.ConnectionPool;
import org.niu.leaves.jsp.servlet.dao.DepartmentDao;
import org.niu.leaves.jsp.servlet.ConfigurationGuice.GuiceInjector;
import org.niu.leaves.jsp.servlet.model.UserWithDepartmentInfo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DepartmentService {
    private DepartmentDao departmentDao;

    public DepartmentService() {
        departmentDao = GuiceInjector.getInstance(DepartmentDao.class);
    }

    public UserWithDepartmentInfo getDepartmentManagerNameById(int userId) throws SQLException {
        return departmentDao.getDepartmentManagerByUserId(userId);
    }

    public List<UserWithDepartmentInfo> queryAllDepartments() throws SQLException {
        ResultSet rs = null;
        String sql = "select distinct dp.id as departmentId ,dp.DEPARTMENT_NAME as departmentName, " +
                "dp.MANAGER_USER_ID as managerUserId, " +
                "manager.FIRST_NAME||manager.LAST_NAME as managerName " +
                "from AP_DEPARTMENT dp " +
                "inner join AP_USERS users on dp.ID= users.DEPARTMENT_ID " +
                "left join AP_USERS manager on manager.userid = dp.MANAGER_USER_ID";
        String departmentId;
        String departmentName;
        int managerUserId;
        String managerName;
        List<UserWithDepartmentInfo> userWithDepartmentInfoList = new ArrayList<>();
        try (Connection conn = ConnectionPool.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            rs = ps.executeQuery();
            while (rs.next()) {
                UserWithDepartmentInfo departmentWithUser = new UserWithDepartmentInfo();
                departmentId = rs.getString("departmentId");
                departmentWithUser.setDepartmentId(departmentId);
                departmentName = rs.getString("departmentName");
                departmentWithUser.setDepartmentName(departmentName);
                managerUserId = rs.getInt("managerUserId");
                departmentWithUser.setManagerUserId(managerUserId);
                managerName = rs.getString("managerName");
                departmentWithUser.setManagerName(managerName);
                userWithDepartmentInfoList.add(departmentWithUser);
            }
        } finally {
            if (rs != null)
                rs.close();
        }
        return userWithDepartmentInfoList;
    }

}
