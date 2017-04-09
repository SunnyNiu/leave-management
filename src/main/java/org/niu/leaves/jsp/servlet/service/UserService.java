package org.niu.leaves.jsp.servlet.service;

import com.google.inject.Guice;
import com.google.inject.Injector;
import org.niu.leaves.jsp.servlet.ConfigurationGuice.ConfigureModule;
import org.niu.leaves.jsp.servlet.dao.*;
import org.niu.leaves.jsp.servlet.model.UserInfo;
import org.niu.leaves.jsp.servlet.model.UserWithDepartmentInfo;
import org.niu.leaves.jsp.servlet.utility.Messages;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

public class UserService {
    private LoginDao loginDao;
    private UserDao userDao;

    public UserService(){
        Injector injector = Guice.createInjector(new ConfigureModule());
        loginDao = injector.getInstance(LoginDao.class);
        userDao = injector.getInstance(UserDao.class);
    }

    public String getPasswordByLogin(String login) throws SQLException{
        return loginDao.getPassword(login);
    }

    public void updateUserPassword(String login, String newPassword) throws SQLException {
        userDao.updateUserPassword(login, newPassword);
    }

    public List<UserInfo> getAllUsers() throws SQLException {
        List<UserInfo> userInfo = userDao.queryAllUsers();
        return userInfo;
    }

    public UserWithDepartmentInfo getUserWithDepartmentInfo(String login) throws SQLException {
        UserWithDepartmentInfo userDepartmentTitle = userDao.getUserWithDepartmentInfo(login);
        return userDepartmentTitle;
    }

    public void addNewMember(String login, String password, String department, String title, String joinDate, String birthDate, String firstName, String lastName, String email, boolean userIsExist) throws SQLException {
        try {
            //Verify joinDate and birthDate is date format
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            formatter.parse(joinDate);
            formatter.parse(birthDate);
            if (!userIsExist) {
                userDao.insertUser(login, password, department, title, joinDate, birthDate, firstName, lastName, email);
            } else
                throw new SQLException(Messages.NOT_ALLOWED_ADD_EXISTED_MEMBER_MESSAGE);
        } catch (SQLException ex) {
            throw new SQLException(ex.toString());
        } catch (ParseException ex) {
            throw new SQLException(Messages.DATE_FORMAT_INCORRECT_MESSAGE);
        }
    }

    public boolean userExist(String login) throws SQLException {
        return userDao.ifUserIdExist(login);
    }

    public void updateBasicInfo(String login,String firstName,String lastName,String phoneNumber,String physicalAddress)throws SQLException{
        userDao.updateBasicInfo(login, firstName, lastName, phoneNumber, physicalAddress);
    }
}
