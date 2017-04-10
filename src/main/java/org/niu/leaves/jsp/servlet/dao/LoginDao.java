package org.niu.leaves.jsp.servlet.dao;

import java.io.IOException;
import java.sql.SQLException;

public interface LoginDao {
    public String getPassword(String login) throws SQLException,IOException;
}
