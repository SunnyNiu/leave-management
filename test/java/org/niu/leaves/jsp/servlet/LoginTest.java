package java.org.niu.leaves.jsp.servlet;

import org.junit.Test;

import org.niu.leaves.jsp.servlet.dao.MockLoginDao;
import org.niu.leaves.jsp.servlet.dao.MockUserDao;
import org.niu.leaves.jsp.servlet.service.UserService;
import org.niu.leaves.jsp.servlet.ConfigurationGuice.GuiceInjector;
import org.niu.leaves.jsp.servlet.dao.*;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Created by Sunny on 9/02/2017.
 */
public class LoginTest {

    UserService userService = new UserService();

    @Test
    public void Login() throws Exception {
        String username = "SunnyN";
        userService.getPasswordByLogin(username);
        ArrayList<String> errorsList = new ArrayList<>();
    }

    @Test
    public void UserPasswordBothCorrect() throws Exception {
        LoginDao loginDao = GuiceInjector.getInstance(MockLoginDao.class);
        UserDao userDao = GuiceInjector.getInstance(MockUserDao.class);
        assertEquals("Username and Password is correct", "Sun123", "");
    }
}