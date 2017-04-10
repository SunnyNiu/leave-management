package org.niu.leaves.jsp.servlet.service;

import org.niu.leaves.jsp.servlet.ConfigurationGuice.GuiceInjector;
import org.niu.leaves.jsp.servlet.dao.*;
import org.niu.leaves.jsp.servlet.model.UserInfo;
import org.niu.leaves.jsp.servlet.model.UserWithDepartmentInfo;
import org.niu.leaves.jsp.servlet.utility.Messages;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

public class UserService {
    private LoginDao loginDao;
    private UserDao userDao;

    public UserService(){
        loginDao = GuiceInjector.getInstance(LoginDao.class);
        userDao = GuiceInjector.getInstance(UserDao.class);
    }

    public String getPasswordByLogin(String login) throws SQLException,IOException {
        return loginDao.getPassword(login);
    }

    public void updateUserPassword(String login, String newPassword) throws SQLException,IOException {
        userDao.updateUserPassword(login, newPassword);
    }

    public List<UserInfo> getAllUsers() throws SQLException,IOException {
        List<UserInfo> userInfo = userDao.queryAllUsers();
        return userInfo;
    }

    public UserWithDepartmentInfo getUserWithDepartmentInfo(String login) throws SQLException,IOException {
        UserWithDepartmentInfo userDepartmentTitle = userDao.getUserWithDepartmentInfo(login);
        return userDepartmentTitle;
    }

    public void addNewMember(String login, String password, String department, String title, String joinDate, String birthDate, String firstName, String lastName, String email, boolean userIsExist) throws SQLException,IOException {
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

    public boolean userExist(String login) throws SQLException,IOException {
        return userDao.ifUserIdExist(login);
    }

    public void updateBasicInfo(String login,String firstName,String lastName,String phoneNumber,String physicalAddress)throws SQLException,IOException{
        userDao.updateBasicInfo(login, firstName, lastName, phoneNumber, physicalAddress);
    }
}
