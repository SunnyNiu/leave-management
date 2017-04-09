package org.niu.leaves.jsp.servlet.service;

import com.google.inject.Guice;
import com.google.inject.Injector;
import org.niu.leaves.jsp.servlet.ConfigurationGuice.ConfigureModule;
import org.niu.leaves.jsp.servlet.dao.DepartmentDao;
import org.niu.leaves.jsp.servlet.dao.TitleDao;
import org.niu.leaves.jsp.servlet.dao.TitleDaoImpl;
import org.niu.leaves.jsp.servlet.model.Title;

import java.sql.SQLException;
import java.util.List;

public class TitleService {
    private TitleDao titleDaoImpl;

    public TitleService(){
        Injector injector = Guice.createInjector(new ConfigureModule());
        titleDaoImpl = injector.getInstance(TitleDao.class);
    }

    public List<Title> getTitles() throws SQLException{
        List<Title> titleList = titleDaoImpl.queryTitles();
        return titleList;
    }

    public int getLevelId(String title) throws SQLException{
        return titleDaoImpl.getLevelIdByTitle(title);
    }
}
