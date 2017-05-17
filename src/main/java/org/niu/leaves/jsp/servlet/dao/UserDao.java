package org.niu.leaves.jsp.servlet.dao;

import org.niu.leaves.jsp.servlet.model.UserInfo;
import org.niu.leaves.jsp.servlet.model.UserWithDepartmentInfo;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public interface UserDao {
    public List<Integer> queryHRManagerLevelUserIds() throws SQLException,IOException;
    public UserWithDepartmentInfo getUserWithDepartmentInfo(String login) throws SQLException,IOException;
    public List<UserWithDepartmentInfo> getUserBasicInfo(String fristName, String LastName) throws SQLException,IOException;
    public Integer getUserId(String user) throws SQLException,IOException;
    public boolean ifUserIdExist(String login) throws SQLException,IOException;
    public void insertUser(String login, String password, String departmentId, String title, String joinDate, String birthDate, String firstName, String lastName, String email) throws SQLException,IOException;
    public void updateUserPassword(String login, String password) throws SQLException,IOException;
    public List<UserInfo> queryAllUsers() throws SQLException,IOException;
    public void updateBasicInfo(String login, String firstName, String lastName, String phoneNumber, String physicalAddress) throws SQLException,IOException;
    public void updateStaffInfo(int userId, int departmentId, int titleId, String email, String emailPassword, int flag) throws SQLException, IOException;
    public void removeStaff(int userId)  throws SQLException, IOException;
    public List<UserWithDepartmentInfo> queryAllDepartments() throws SQLException, IOException;
}
