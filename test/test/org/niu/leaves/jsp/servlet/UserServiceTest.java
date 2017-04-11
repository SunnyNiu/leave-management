package test.org.niu.leaves.jsp.servlet;

import org.junit.Before;
import org.junit.Test;

import org.niu.leaves.jsp.servlet.model.UserInfo;
import org.niu.leaves.jsp.servlet.model.UserWithDepartmentInfo;
import org.niu.leaves.jsp.servlet.service.UserService;
import org.niu.leaves.jsp.servlet.ConfigurationGuice.GuiceInjector;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by Sunny on 9/02/2017.
 */
public class UserServiceTest {

    @Before
    public void initializeInjector() {
        GuiceInjector.initializeInjector(new TestConfigureModule());
    }

    @Test
    public void Login() throws SQLException, IOException {
        UserService userService = new UserService();
        String login = "SunnyN";
        String password = "Sun123";
        String passwordFromDatabase = userService.getPasswordByLogin(login);
        assertEquals("Username and Password are not correct", password, passwordFromDatabase);
    }

    @Test
    public void GetAllUsers() throws SQLException, IOException {
        String userName = "KongNiu";
        UserService userService = new UserService();
        List<UserInfo> getAllUsers = userService.getAllUsers();
        assertEquals("Not get all users", userName, getAllUsers.get(1).getUserName());
    }

    @Test
    public void getUserWithDepartmentInfo() throws SQLException, IOException {
        UserService userService = new UserService();
        String login = "SunnyN";
        UserWithDepartmentInfo userWithDepartmentInfo = userService.getUserWithDepartmentInfo(login);
        String userName = "SunnyNiu";
        assertEquals("User info is wrong", userName, userWithDepartmentInfo.getUserName());
    }

    @Test
    public void userExist() throws SQLException, IOException {
        UserService userService = new UserService();
        String login = "SunnyN";
        boolean exist = userService.userExist(login);
        assertEquals("User is not exist", true, exist);
    }
}