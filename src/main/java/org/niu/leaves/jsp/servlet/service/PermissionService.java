package org.niu.leaves.jsp.servlet.service;

import org.niu.leaves.jsp.servlet.dao.DepartmentDao;
import org.niu.leaves.jsp.servlet.ConfigurationGuice.GuiceInjector;
import org.niu.leaves.jsp.servlet.dao.UserDao;
import org.niu.leaves.jsp.servlet.dao.UserDaoImpl;
import org.niu.leaves.jsp.servlet.model.Permission;
import org.niu.leaves.jsp.servlet.model.UserWithDepartmentInfo;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class PermissionService {

    private UserDao userDao;
    private DepartmentDao departmentDao;

    public PermissionService(){
        departmentDao = GuiceInjector.getInstance(DepartmentDao.class);
        userDao = GuiceInjector.getInstance(UserDao.class);
    }

    public Permission getUserPermission(String username) throws SQLException,IOException {
        Permission p = new Permission();
        int userId = userDao.getUserId(username);
        p.setApproveRejectIsPermitted(hasApproveRejectLeavePermission(userId));
        p.setAddMemberIsPermitted(hasCreateMemberPermission(userId));
        return p;
    }

    //Those managers have permission to approve and reject leave apply
    public boolean hasApproveRejectLeavePermission(int userId) throws SQLException,IOException {
        List<UserWithDepartmentInfo> UserWithDepartmentInfoList = departmentDao.queryAllDepartments();
        for (UserWithDepartmentInfo userWithDepartmentInfo : UserWithDepartmentInfoList) {
            if (userWithDepartmentInfo.getManagerUserId() == userId) {
                return true;
            }
        }
        return false;
    }

    public static boolean hasCreateMemberPermission(int userId) throws SQLException,IOException {
        boolean hasPermission = false;
        List<Integer> userIds = new UserDaoImpl().queryHRManagerLevelUserIds();
        for (Integer hrManagerLevelId : userIds) {
            if (hrManagerLevelId == userId)
                hasPermission = true;
        }
        return hasPermission;
    }
}
