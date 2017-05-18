package org.niu.leaves.jsp.servlet.dao;

import org.niu.leaves.jsp.servlet.model.UserWithDepartmentInfo;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public interface DepartmentDao{
    List<UserWithDepartmentInfo> queryAllDepartments() throws SQLException,IOException;
    UserWithDepartmentInfo getDepartmentManagerByUserId(int userId) throws SQLException,IOException;
}
