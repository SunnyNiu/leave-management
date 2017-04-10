package org.niu.leaves.jsp.servlet.dao;

import org.niu.leaves.jsp.servlet.model.UserInfo;
import org.niu.leaves.jsp.servlet.model.UserWithDepartmentInfo;
import org.niu.leaves.jsp.servlet.utility.Messages;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {

    public List<Integer> queryHRManagerLevelUserIds() throws SQLException,IOException {
        ResultSet rs = null;
        List<Integer> userIds = new ArrayList<>();
        String sql = "select u.USERID  as userId from AP_TITLE t, AP_USERS u " +
                "where t.ID = u.TITLE_ID " +
                "and t.LEVEL_ID =1 ";
        try (Connection conn = ConnectionPool.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            rs = ps.executeQuery();
            while (rs.next()) {
                userIds.add(rs.getInt("userId"));
            }
            return userIds;
        } finally {
            if (rs != null)
                rs.close();
        }
    }

    //get user's info from database
    public UserWithDepartmentInfo getUserWithDepartmentInfo(String login) throws SQLException,IOException {
        UserWithDepartmentInfo userWithDepartmentInfo = new UserWithDepartmentInfo();
        ResultSet rs = null;
        String sql = "select userId, userFirstName, userLastName,userFirstName||userLastName as userFullName, " +
                "birthday, joinDate, departmentId, levelId, title, userEmail, userEmailPassword,phoneNumber, physicalAddress," +
                "departmentName, managerUserId, firstName||lastName as managerName, managerEmail, managerEmailPassword " +
                "from " +
                "(select users.USERID as userId,users.FIRST_NAME userFirstName, " +
                "users.LAST_NAME userLastName, users.BIRTHDAY as birthday, " +
                "users.JOINED_DATE as joinDate,users.DEPARTMENT_ID as departmentId, " +
                "users.OFFICE_EMAIL as userEmail, users.EMAIL_PASSWORD as userEmailPassword, users.PHONE_NUMBER as phoneNumber, users.PHYSICAL_ADDRESS as physicalAddress," +
                "t.LEVEL_ID as levelId, t.TITLE as title, dp.DEPARTMENT_NAME as departmentName, " +
                "dp.MANAGER_USER_ID as managerUserId, manager.FIRST_NAME as firstName, manager.OFFICE_EMAIL as managerEmail, " +
                "manager.EMAIL_PASSWORD as managerEmailPassword,manager.LAST_NAME as lastName from  " +
                "AP_USERS users inner join AP_TITLE t " +
                "on users.LOGIN = ? and users.TITLE_ID = t.ID  " +
                "left join AP_DEPARTMENT dp on users.DEPARTMENT_ID = dp.ID " +
                "left join AP_USERS manager on dp.MANAGER_USER_ID = manager.USERID) ";

        try (Connection conn = ConnectionPool.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, login);
            rs = ps.executeQuery();
            if (rs.next()) {
                userWithDepartmentInfo.setUserId(rs.getInt("userId"));
                userWithDepartmentInfo.setUserFirstName(rs.getString("userFirstName"));
                userWithDepartmentInfo.setUserLastName(rs.getString("userLastName"));
                userWithDepartmentInfo.setUserName(rs.getString("userFullName"));
                userWithDepartmentInfo.setDepartmentId(rs.getString("departmentId"));
                userWithDepartmentInfo.setDepartmentName(rs.getString("departmentName"));
                userWithDepartmentInfo.setBirthday(rs.getString("birthday").substring(0, 10));
                userWithDepartmentInfo.setJoinDate(rs.getString("joinDate").substring(0, 10));
                userWithDepartmentInfo.setTitle(rs.getString("title"));
                userWithDepartmentInfo.setUserEmail(rs.getString("userEmail"));
                userWithDepartmentInfo.setManagerUserId(rs.getInt("managerUserId"));
                userWithDepartmentInfo.setManagerName(rs.getString("managerName"));
                userWithDepartmentInfo.setManagerEmail(rs.getString("managerEmail"));
                userWithDepartmentInfo.setManagerEmailPassword(rs.getString("managerEmailPassword"));
                userWithDepartmentInfo.setUserEmailPassword(rs.getString("userEmailPassword"));
                userWithDepartmentInfo.setPhoneNumber(rs.getString("phoneNumber"));
                userWithDepartmentInfo.setPhysicalAddress(rs.getString("physicalAddress"));
            }
            return userWithDepartmentInfo;
        } finally {
            if (rs != null) {
                rs.close();
            }
        }
    }

    //get userId from database by username
    public Integer getUserId(String user) throws SQLException,IOException {
        ResultSet rs = null;

        try (Connection conn = ConnectionPool.getConnection(); Statement stmt = conn.createStatement()) {
            rs = stmt.executeQuery("select userId from AP_USERS where LOGIN =" + "'" + user + "'");
            if (rs.next()) {
                int userId = rs.getInt("userId");
                return userId;
            } else
                throw new SQLException("UserInfo Id " + Messages.SEARCHED_RESULT_FROM_DATABASE_IS_NULL);
        } finally {
            if (rs != null)
                rs.close();
        }

    }

    //check user is exist in database
    public boolean ifUserIdExist(String login) throws SQLException,IOException {
        ResultSet rs = null;
        try (Connection conn = ConnectionPool.getConnection(); Statement stmt = conn.createStatement()) {
            rs = stmt.executeQuery("select userid from AP_USERS where login =" + "'" + login + "'");
            return rs.next();
        } finally {
            if (rs != null)
                rs.close();
        }
    }

    //insert user info into AP_USERS table//login, password,department,title,joinDate,birthDate,firstName,lastName
    public void insertUser(String login, String password, String departmentId, String title, String joinDate, String birthDate, String firstName, String lastName, String email) throws SQLException,IOException {
        String sql = "INSERT INTO AP_USERS (LOGIN, PASSWORD, FIRST_NAME, LAST_NAME, TITLE_ID,DEPARTMENT_ID,BIRTHDAY,JOINED_DATE, OFFICE_EMAIL) " +
                " VALUES (?,?,?,?,?,?, TO_DATE( ?,'yyyy/mm/dd'),TO_DATE(?,'yyyy/mm/dd'),?)";
        int i = 1;
        try (Connection conn = ConnectionPool.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(i++, login);
            ps.setString(i++, password);
            ps.setString(i++, firstName);
            ps.setString(i++, lastName);
            ps.setString(i++, title);
            ps.setString(i++, departmentId);
            ps.setString(i++, birthDate);
            ps.setString(i++, joinDate);
            ps.setString(i++, email);
            ps.executeUpdate();
            ps.close();
        }
    }

    //update user's password by username
    public void updateUserPassword(String login, String password) throws SQLException,IOException {
        String sql = "UPDATE AP_USERS SET PASSWORD =? WHERE LOGIN =?";
        int i = 1;
        try (Connection conn = ConnectionPool.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(i++, password);
            ps.setString(i++, login);
            ps.executeUpdate();
            ps.close();
        }
    }

    public List<UserInfo> queryAllUsers() throws SQLException,IOException {
        String sql = "select userId as userId, login as login, password as password,  " +
                "first_name as firstName, last_name as lastName, " +
                "title_id as titleId, department_id as departmentId, birthday, " +
                "joined_date as joinDate " +
                "from AP_USERS ";
        ResultSet rs = null;
        List<UserInfo> userInfoList = new ArrayList<>();
        try (Connection conn = ConnectionPool.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            rs = ps.executeQuery(sql);
            while (rs.next()) {
                UserInfo userInfo = new UserInfo();
                userInfo.setUserId(rs.getInt("userId"));
                userInfo.setLogin(rs.getString("login"));
                userInfo.setPassword(rs.getString("password"));
                userInfo.setFirstName(rs.getString("firstName"));
                userInfo.setLastName(rs.getString("lastName"));
                userInfo.setUserName(rs.getString("firstName"), rs.getString("lastName"));
                userInfo.setTitleId(rs.getInt("titleId"));
                userInfo.setDepartmentId(rs.getString("departmentId"));
                userInfo.setBirthday(rs.getString("birthday"));
                userInfo.setJoinDate(rs.getString("joinDate"));
                userInfoList.add(userInfo);
            }
            return userInfoList;
        } finally {
            if (rs != null)
                rs.close();
        }
    }

    public void updateBasicInfo(String login, String firstName, String lastName, String phoneNumber, String physicalAddress) throws SQLException,IOException {
        String sql = "UPDATE AP_USERS SET FIRST_NAME =? ,LAST_NAME =?, PHONE_NUMBER=?, PHYSICAL_ADDRESS=?  WHERE LOGIN =?";
        int i = 1;
        try (Connection conn = ConnectionPool.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(i++, firstName);
            ps.setString(i++, lastName);
            ps.setString(i++, phoneNumber);
            ps.setString(i++, physicalAddress);
            ps.setString(i++, login);
            ps.executeUpdate();
            ps.close();
        }
    }
}
