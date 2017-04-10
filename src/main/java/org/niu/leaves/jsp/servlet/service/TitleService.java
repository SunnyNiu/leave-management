package org.niu.leaves.jsp.servlet.service;


import org.niu.leaves.jsp.servlet.ConfigurationGuice.GuiceInjector;
import org.niu.leaves.jsp.servlet.dao.TitleDao;
import org.niu.leaves.jsp.servlet.model.Title;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class TitleService {
    private TitleDao titleDao;

    public TitleService(){
        titleDao = GuiceInjector.getInstance(TitleDao.class);
    }

    public List<Title> getTitles() throws SQLException,IOException {
        List<Title> titleList = titleDao.queryTitles();
        return titleList;
    }

    public int getLevelId(String title) throws SQLException,IOException{
        return titleDao.getLevelIdByTitle(title);
    }
}
