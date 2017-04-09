package org.niu.leaves.jsp.servlet.dao;

import org.niu.leaves.jsp.servlet.model.Title;

import java.sql.SQLException;
import java.util.List;

public interface TitleDao {
    public List<Title> queryTitles() throws SQLException;
    public int getLevelIdByTitle(String title) throws SQLException;
}
