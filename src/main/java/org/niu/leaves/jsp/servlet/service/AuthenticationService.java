package org.niu.leaves.jsp.servlet.service;

import com.google.inject.Guice;
import com.google.inject.Injector;
import org.niu.leaves.jsp.servlet.ConfigurationGuice.ConfigureModule;
import org.niu.leaves.jsp.servlet.dao.DepartmentDao;
import org.niu.leaves.jsp.servlet.dao.LoginDaoImpl;
import org.niu.leaves.jsp.servlet.dao.UserDao;
import org.niu.leaves.jsp.servlet.model.UserWithDepartmentInfo;
import org.niu.leaves.jsp.servlet.utility.Messages;

import java.sql.SQLException;

public class AuthenticationService {

    private UserDao userDao;


    public AuthenticationService() {
        Injector injector = Guice.createInjector(new ConfigureModule());
        userDao = injector.getInstance(UserDao.class);
    }

    public UserWithDepartmentInfo authenticateUser(String login, String password) throws SQLException {
        if (ifUserPasswordCorrect(login, password)) {
            return userDao.getUserWithDepartmentInfo(login);
        } else {
            throw new SQLException(Messages.USER_PASSWORD_INCORRECT);
        }
    }

    public boolean ifUserPasswordCorrect(String login, String password) throws SQLException {

        String passwordFromDatabase = new LoginDaoImpl().getPassword(login);
        //user input empty username and logon
        if (login == null || login.isEmpty()) {
            throw new SQLException(Messages.USER_IS_EMPTY);
        }

        //user doesn't populate password on login page
        if (password == null || password.isEmpty()) {
            throw new SQLException(Messages.PASSWORD_IS_EMPTY);
        }

        //password that user populates on login page is different from password from database by searching username
        if (passwordFromDatabase == null || !passwordFromDatabase.equals(password)) {
            throw new SQLException(Messages.USER_OR_PASSWORD_INCORRECT);
        }
        return true;
    }
}
