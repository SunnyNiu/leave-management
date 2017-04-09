package org.niu.leaves.jsp.servlet.service;

import org.niu.leaves.jsp.servlet.dao.LoginDAO;
import org.niu.leaves.jsp.servlet.dao.UserDAO;
import org.niu.leaves.jsp.servlet.model.UserInfo;
import org.niu.leaves.jsp.servlet.model.UserWithDepartmentInfo;
import org.niu.leaves.jsp.servlet.utility.Messages;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

public class UserService {
    private LoginDAO loginDAO = new LoginDAO();
    private UserDAO userDAO = new UserDAO();

    public String getPasswordByLogin(String login) throws SQLException{
        return loginDAO.getPassword(login);
    }

    public void updateUserPassword(String login, String newPassword) throws SQLException {
        userDAO.updateUserPassword(login, newPassword);
    }

    public List<UserInfo> getAllUsers() throws SQLException {
        List<UserInfo> userInfo = userDAO.queryAllUsers();
        return userInfo;
    }

    public UserWithDepartmentInfo getUserWithDepartmentInfo(String login) throws SQLException {
        UserWithDepartmentInfo userDepartmentTitle = userDAO.getUserWithDepartmentInfo(login);
        return userDepartmentTitle;
    }

    public void addNewMember(String login, String password, String department, String title, String joinDate, String birthDate, String firstName, String lastName, String email, boolean userIsExist) throws SQLException {
        try {
            //Verify joinDate and birthDate is date format
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            formatter.parse(joinDate);
            formatter.parse(birthDate);
            if (!userIsExist) {
                userDAO.insertUser(login, password, department, title, joinDate, birthDate, firstName, lastName, email);
            } else
                throw new SQLException(Messages.NOT_ALLOWED_ADD_EXISTED_MEMBER_MESSAGE);
        } catch (SQLException ex) {
            throw new SQLException(ex.toString());
        } catch (ParseException ex) {
            throw new SQLException(Messages.DATE_FORMAT_INCORRECT_MESSAGE);
        }
    }

    public boolean userExist(String login) throws SQLException {
        return userDAO.ifUserIdExist(login);
    }

    public void updateBasicInfo(String login,String firstName,String lastName,String phoneNumber,String physicalAddress)throws SQLException{
        userDAO.updateBasicInfo(login, firstName, lastName, phoneNumber, physicalAddress);
    }
}
