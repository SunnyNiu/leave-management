package org.niu.leaves.jsp.servlet;

import org.junit.Test;
import org.niu.leaves.jsp.servlet.ConfigurationGuice.GuiceInjector;
import org.niu.leaves.jsp.servlet.dao.*;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Created by Sunny on 9/02/2017.
 */
public class LoginTest {
    ArrayList<String> errorsList = new ArrayList<>();

    @Test
    public void UserPasswordBothCorrect() throws Exception {
        LoginDao loginDao = GuiceInjector.getInstance(MockLoginDao.class);
        UserDao userDao = GuiceInjector.getInstance(MockUserDao.class);


        assertEquals("Username and Password is correct", "Sun123", "");
    }
}