package org.niu.leaves.jsp.servlet.service;

import org.niu.leaves.jsp.servlet.dao.DepartmentDao;
import org.niu.leaves.jsp.servlet.ConfigurationGuice.GuiceInjector;
import org.niu.leaves.jsp.servlet.dao.UserDao;
import org.niu.leaves.jsp.servlet.model.UserWithDepartmentInfo;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class DepartmentService {
    private DepartmentDao departmentDao;
    private UserDao userDao;

    public DepartmentService() {
        departmentDao = GuiceInjector.getInstance(DepartmentDao.class);
        userDao = GuiceInjector.getInstance(UserDao.class);
    }

    public UserWithDepartmentInfo getDepartmentManagerNameById(int userId) throws SQLException,IOException {
        return departmentDao.getDepartmentManagerByUserId(userId);
    }

    public List<UserWithDepartmentInfo> queryAllDepartments() throws SQLException,IOException {
        List<UserWithDepartmentInfo> userWithDepartmentInfoList = userDao.queryAllDepartments();
        return userWithDepartmentInfoList;
    }
}
