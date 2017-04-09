package org.niu.leaves.jsp.servlet.dao;

import org.niu.leaves.jsp.servlet.model.Title;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TitleDaoImpl implements TitleDao {

    public List<Title> queryTitles() throws SQLException {
        ResultSet rs = null;
        List<Title> titleList = new ArrayList<>();
        String sql = "select ID, LEVEL_ID, TITLE FROM AP_TITLE";

        try (Connection conn = ConnectionPool.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            rs = ps.executeQuery();
            while (rs.next()) {
                Title applicationTitle = new Title();
                applicationTitle.setId(rs.getInt("ID"));
                applicationTitle.setLevelId(rs.getInt("LEVEL_ID"));
                applicationTitle.setTitle(rs.getString("TITLE"));
                titleList.add(applicationTitle);
            }
            return titleList;
        } finally {
            if (rs != null)
                rs.close();
        }
    }

    public int getLevelIdByTitle(String title) throws SQLException {
        String sql = "Select level_id from AP_TITLE where title =?";
        ResultSet rs = null;
        try (Connection conn = ConnectionPool.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, title);
            rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt("level_id");
            } else {
                throw new SQLException("Title is null, please check it");
            }
        } finally {
            if (rs != null)
                rs.close();
        }
    }
}
