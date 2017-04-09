package org.niu.leaves.jsp.servlet.dao;

import org.niu.leaves.jsp.servlet.model.UserInfo;
import org.niu.leaves.jsp.servlet.model.UserWithDepartmentInfo;

import java.sql.SQLException;
import java.util.List;

public interface UserDao {
    public List<Integer> queryHRManagerLevelUserIds() throws SQLException;
    public UserWithDepartmentInfo getUserWithDepartmentInfo(String login) throws SQLException;
    public Integer getUserId(String user) throws SQLException;
    public boolean ifUserIdExist(String login) throws SQLException;
    public void insertUser(String login, String password, String departmentId, String title, String joinDate, String birthDate, String firstName, String lastName, String email) throws SQLException;
    public void updateUserPassword(String login, String password) throws SQLException;
    public List<UserInfo> queryAllUsers() throws SQLException;
    public void updateBasicInfo(String login, String firstName, String lastName, String phoneNumber, String physicalAddress) throws SQLException;
}
