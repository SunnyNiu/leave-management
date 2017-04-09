package org.niu.leaves.jsp.servlet.service;

import org.niu.leaves.jsp.servlet.dao.DepartmentDAO;
import org.niu.leaves.jsp.servlet.dao.UserDAO;
import org.niu.leaves.jsp.servlet.model.Permission;
import org.niu.leaves.jsp.servlet.model.UserWithDepartmentInfo;

import java.sql.SQLException;
import java.util.List;

public class PermissionService {

    private UserDAO userDAO = new UserDAO();
    private DepartmentDAO departmentDao = new DepartmentDAO();

    public Permission getUserPermission(String username) throws SQLException {
        Permission p = new Permission();
        int userId = userDAO.getUserId(username);
        p.setApproveRejectIsPermitted(hasApproveRejectLeavePermission(userId));
        p.setAddMemberIsPermitted(hasCreateMemberPermission(userId));
        return p;
    }

    //Those managers have permission to approve and reject leave apply
    public boolean hasApproveRejectLeavePermission(int userId) throws SQLException {
        List<UserWithDepartmentInfo> UserWithDepartmentInfoList = departmentDao.queryAllDepartments();
        for (UserWithDepartmentInfo userWithDepartmentInfo : UserWithDepartmentInfoList) {
            if (userWithDepartmentInfo.getManagerUserId() == userId) {
                return true;
            }
        }
        return false;
    }

    public static boolean hasCreateMemberPermission(int userId) throws SQLException {
        boolean hasPermission = false;
        List<Integer> userIds = new UserDAO().queryHRManagerLevelUserIds();
        for (Integer hrManagerLevelId : userIds) {
            if (hrManagerLevelId == userId)
                hasPermission = true;
        }
        return hasPermission;
    }
}
