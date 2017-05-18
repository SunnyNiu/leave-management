package org.niu.leaves.jsp.servlet.dao;

import org.niu.leaves.jsp.servlet.model.UserInfo;
import org.niu.leaves.jsp.servlet.model.UserWithDepartmentInfo;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public interface UserDao {
    List<Integer> queryHRManagerLevelUserIds() throws SQLException,IOException;
    UserWithDepartmentInfo getUserWithDepartmentInfo(String login) throws SQLException,IOException;
    List<UserWithDepartmentInfo> getUserBasicInfo(String fristName, String LastName) throws SQLException,IOException;
    Integer getUserId(String user) throws SQLException,IOException;
    boolean ifUserIdExist(String login) throws SQLException,IOException;
    void insertUser(String login, String password, String departmentId, String title, String joinDate, String birthDate, String firstName, String lastName, String email) throws SQLException,IOException;
    void updateUserPassword(String login, String password) throws SQLException,IOException;
    List<UserInfo> queryAllUsers() throws SQLException,IOException;
    void updateBasicInfo(String login, String firstName, String lastName, String phoneNumber, String physicalAddress) throws SQLException,IOException;
    void updateStaffInfo(int userId, int departmentId, int titleId, String email, String emailPassword, int flag) throws SQLException, IOException;
    void removeStaff(int userId)  throws SQLException, IOException;
    List<UserWithDepartmentInfo> queryAllDepartments() throws SQLException, IOException;
}
