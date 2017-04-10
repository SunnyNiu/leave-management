package org.niu.leaves.jsp.servlet.dao;

import org.niu.leaves.jsp.servlet.model.UserWithDepartmentInfo;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public interface DepartmentDao{
    public List<UserWithDepartmentInfo> queryAllDepartments() throws SQLException,IOException;
    public UserWithDepartmentInfo getDepartmentManagerByUserId(int userId) throws SQLException,IOException;
}
