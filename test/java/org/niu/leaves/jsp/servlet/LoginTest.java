package org.niu.leaves.jsp.servlet;

import org.junit.Test;
import org.niu.leaves.jsp.servlet.dao.LoginDAO;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Created by Sunny on 9/02/2017.
 */
public class LoginTest {
    ArrayList<String> errorsList = new ArrayList<>();
    @Test
    public void UserPasswordBothCorrect() throws Exception {
        LoginDAO loginConnection = new LoginDAO();
        String pw = loginConnection.getPassword("Sunny");
        assertEquals("Username and Password is correct", "Sun123", pw);
    }
}