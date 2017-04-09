package org.niu.leaves.jsp.servlet.dao;

import org.niu.leaves.jsp.servlet.model.UserWithDepartmentInfo;

import java.sql.SQLException;
import java.util.List;

public interface DepartmentDao{
    public List<UserWithDepartmentInfo> queryAllDepartments() throws SQLException;
    public UserWithDepartmentInfo getDepartmentManagerByUserId(int userId) throws SQLException;
}
