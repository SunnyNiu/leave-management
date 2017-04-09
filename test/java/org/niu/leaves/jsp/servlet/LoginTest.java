package org.niu.leaves.jsp.servlet;

import org.junit.Test;
import org.niu.leaves.jsp.servlet.dao.LoginDaoImpl;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Created by Sunny on 9/02/2017.
 */
public class LoginTest {
    ArrayList<String> errorsList = new ArrayList<>();
    @Test
    public void UserPasswordBothCorrect() throws Exception {
        LoginDaoImpl loginConnection = new LoginDaoImpl();
        String pw = loginConnection.getPassword("Sunny");
        assertEquals("Username and Password is correct", "Sun123", pw);
    }
}