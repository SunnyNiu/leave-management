package org.niu.leaves.jsp.servlet.dao;

import java.sql.SQLException;

/**
 * Created by Sunny on 10/04/2017.
 */
public class MockLoginDao implements LoginDao {

    public String getPassword(String login) throws SQLException {
        if(login.equals("SunnyN")){
            return "Sun123";
        }else if(login.equals("John")){
            return "Joh123";
        }else{
            throw new SQLException("Password not found");
        }
    }
}
