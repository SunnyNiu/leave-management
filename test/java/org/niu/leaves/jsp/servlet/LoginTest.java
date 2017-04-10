package java.org.niu.leaves.jsp.servlet;

import org.junit.Test;
import org.niu.leaves.jsp.servlet.dao.LoginDaoImpl;
import org.niu.leaves.jsp.servlet.service.UserService;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Created by Sunny on 9/02/2017.
 */
public class LoginTest {
    UserService userService = new UserService();

    @Test
    public void Login() throws Exception {
       String username ="SunnyN";
       userService.getPasswordByLogin(username);
    }
}