package org.niu.leaves.jsp.servlet.dao;

import org.niu.leaves.jsp.servlet.model.Title;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public interface TitleDao {
    List<Title> queryTitles() throws SQLException,IOException;
    int getLevelIdByTitle(String title) throws SQLException,IOException;
}
