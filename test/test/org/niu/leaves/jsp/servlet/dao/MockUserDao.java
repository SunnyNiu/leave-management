package test.org.niu.leaves.jsp.servlet.dao;

import org.niu.leaves.jsp.servlet.dao.UserDao;
import org.niu.leaves.jsp.servlet.model.UserInfo;
import org.niu.leaves.jsp.servlet.model.UserWithDepartmentInfo;
import org.niu.leaves.jsp.servlet.utility.Messages;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sunny on 10/04/2017.
 */
public class MockUserDao implements UserDao {
    public List<Integer> queryHRManagerLevelUserIds() throws SQLException {
        List<Integer> userIds = new ArrayList<>();
        userIds.add(2);
        return userIds;
    }

    public UserWithDepartmentInfo getUserWithDepartmentInfo(String login) throws SQLException {
        UserWithDepartmentInfo userWithDepartmentInfo = new UserWithDepartmentInfo();
        userWithDepartmentInfo.setUserId(4);
        userWithDepartmentInfo.setUserFirstName("Sunny");
        userWithDepartmentInfo.setUserLastName("Niu");
        userWithDepartmentInfo.setUserName("SunnyNiu");
        userWithDepartmentInfo.setDepartmentId("001");
        userWithDepartmentInfo.setDepartmentName("IT");
        userWithDepartmentInfo.setBirthday("1987-04-01");
        userWithDepartmentInfo.setJoinDate("1987-04-01");
        userWithDepartmentInfo.setTitle("Software tester");
        userWithDepartmentInfo.setUserEmail("sunnyouchxp@gmail.com");
        userWithDepartmentInfo.setManagerUserId(1);
        userWithDepartmentInfo.setManagerName("John");
        userWithDepartmentInfo.setManagerEmail("moumouer1985@gmail.com");
        userWithDepartmentInfo.setManagerEmailPassword("#19850707ouch");
        userWithDepartmentInfo.setUserEmailPassword("#19850707ouchxp");
        userWithDepartmentInfo.setPhoneNumber("024-0417478");
        userWithDepartmentInfo.setPhysicalAddress("Auckland");

        userWithDepartmentInfo.setUserId(1);
        userWithDepartmentInfo.setUserFirstName("John");
        userWithDepartmentInfo.setUserLastName("Key");
        userWithDepartmentInfo.setUserName("JohnKey");
        userWithDepartmentInfo.setDepartmentId("001");
        userWithDepartmentInfo.setDepartmentName("IT");
        userWithDepartmentInfo.setBirthday("1987-04-01");
        userWithDepartmentInfo.setJoinDate("1987-04-01");
        userWithDepartmentInfo.setTitle("Manager");
        userWithDepartmentInfo.setUserEmail("sunnyouchxp@gmail.com");
        userWithDepartmentInfo.setManagerUserId(1);
        userWithDepartmentInfo.setManagerName("JohnKey");
        userWithDepartmentInfo.setManagerEmail("moumouer1985@gmail.com");
        userWithDepartmentInfo.setManagerEmailPassword("#19850707ouch");
        userWithDepartmentInfo.setUserEmailPassword("#19850707ouchxp");
        userWithDepartmentInfo.setPhoneNumber("024-0417478");
        userWithDepartmentInfo.setPhysicalAddress("Auckland");

        userWithDepartmentInfo.setUserId(2);
        userWithDepartmentInfo.setUserFirstName("Kong");
        userWithDepartmentInfo.setUserLastName("Niu");
        userWithDepartmentInfo.setUserName("KongNiu");
        userWithDepartmentInfo.setDepartmentId("002");
        userWithDepartmentInfo.setDepartmentName("IT");
        userWithDepartmentInfo.setBirthday("1987-04-01");
        userWithDepartmentInfo.setJoinDate("1987-04-01");
        userWithDepartmentInfo.setTitle("Hr Manager");
        userWithDepartmentInfo.setUserEmail("sunnyouchxp@gmail.com");
        userWithDepartmentInfo.setManagerUserId(2);
        userWithDepartmentInfo.setManagerName("JohnKey");
        userWithDepartmentInfo.setManagerEmail("moumouer1985@gmail.com");
        userWithDepartmentInfo.setManagerEmailPassword("#19850707ouch");
        userWithDepartmentInfo.setUserEmailPassword("#19850707ouchxp");
        userWithDepartmentInfo.setPhoneNumber("024-0417478");
        userWithDepartmentInfo.setPhysicalAddress("Auckland");
        return userWithDepartmentInfo;
    }

    public List<UserWithDepartmentInfo> getUserBasicInfo(String firstName, String lastName) throws SQLException {
        return null;
    }

    public Integer getUserId(String user) throws SQLException {
        if (user.equals("SunnyN")) {
            return 4;
        } else if (user.equals("John")) {
            return 1;
        } else {
            throw new SQLException("UserInfo Id " + Messages.SEARCHED_RESULT_FROM_DATABASE_IS_NULL);
        }
    }

    public boolean ifUserIdExist(String login) throws SQLException {
        if (login.equals("SunnyN")) {
            return true;
        } else if (login.equals("John")) {
            return true;
        } else {
            return false;
        }
    }

    public void insertUser(String login, String password, String departmentId, String title, String joinDate, String birthDate, String firstName, String lastName, String email) throws SQLException {
    }

    public void updateUserPassword(String login, String password) throws SQLException {
    }

    public List<UserInfo> queryAllUsers() throws SQLException {
        List<UserInfo> userInfoList = new ArrayList<>();
        UserInfo userInfo1 = new UserInfo();
        userInfo1.setUserId(1);
        userInfo1.setLogin("John");
        userInfo1.setPassword("Joh123");
        userInfo1.setFirstName("John");
        userInfo1.setLastName("Key");
        userInfo1.setUserName("John", "Key");
        userInfo1.setTitleId(2);
        userInfo1.setDepartmentId("001");
        userInfo1.setBirthday("2014-01-01");
        userInfo1.setJoinDate("2014-01-01");
        userInfoList.add(userInfo1);
        UserInfo userInfo2 = new UserInfo();
        userInfo2.setUserId(4);
        userInfo2.setLogin("SunnyN");
        userInfo2.setPassword("Sun123");
        userInfo2.setFirstName("Sunny");
        userInfo2.setLastName("Niu");
        userInfo2.setUserName("Sunny", "Niu");
        userInfo2.setTitleId(1);
        userInfo2.setDepartmentId("001");
        userInfo2.setBirthday("2014-01-01");
        userInfo2.setJoinDate("2014-01-01");
        userInfoList.add(userInfo2);
        UserInfo userInfo3 = new UserInfo();
        userInfo3.setUserId(2);
        userInfo3.setLogin("Kong");
        userInfo3.setPassword("Kon123");
        userInfo3.setFirstName("Kong");
        userInfo3.setLastName("Niu");
        userInfo3.setUserName("Kong", "Niu");
        userInfo3.setTitleId(3);
        userInfo3.setDepartmentId("002");
        userInfo3.setBirthday("2014-01-01");
        userInfo3.setJoinDate("2014-01-01");
        userInfoList.add(userInfo3);
        return userInfoList;
    }

    public void updateBasicInfo(String login, String firstName, String lastName, String phoneNumber, String physicalAddress) throws SQLException {
    }

    public void updateStaffInfo(int userId, int departmentId, int titleId, String email, String emailPassword, int flag) throws SQLException, IOException {
    }

    public void removeStaff(int userId) throws SQLException, IOException {
    }

    public List<UserWithDepartmentInfo> queryAllDepartments() throws SQLException, IOException {
        return null;
    }
}
