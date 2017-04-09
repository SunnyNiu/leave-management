package org.niu.leaves.jsp.servlet.service;

import org.niu.leaves.jsp.servlet.dao.TitleDAO;
import org.niu.leaves.jsp.servlet.model.Title;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Sunny on 31/03/2017.
 */
public class TitleService {
    private TitleDAO titleDAO = new TitleDAO();

    public List<Title> getTitles() throws SQLException{
        List<Title> titleList = titleDAO.queryTitles();
        return titleList;
    }

    public int getLevelId(String title) throws SQLException{
        return titleDAO.getLevelIdByTitle(title);
    }
}
