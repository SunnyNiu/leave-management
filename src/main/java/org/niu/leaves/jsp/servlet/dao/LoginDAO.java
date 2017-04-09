package org.niu.leaves.jsp.servlet.dao;

import java.sql.*;

public class LoginDAO {

    //get password from database by username
    public String getPassword(String login) throws SQLException {
        ResultSet rs = null;
        String sql = "Select PASSWORD from AP_USERS where LOGIN = ?";
        try (Connection conn = ConnectionPool.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, login);
            rs = ps.executeQuery();
            if (rs.next()) {
                String password = rs.getString("PASSWORD");
                return password;
            } else {
                throw new SQLException("Password not found");
            }
        } finally {
            if (rs != null)
                rs.close();
        }
    }
}
