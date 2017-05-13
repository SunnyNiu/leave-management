package test.org.niu.leaves.jsp.servlet.dao;

import org.niu.leaves.jsp.servlet.dao.TitleDao;
import org.niu.leaves.jsp.servlet.model.Title;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sunny on 10/04/2017.
 */
public class MockTitleDao implements TitleDao {
    public List<Title> queryTitles() throws SQLException {
        List<Title> titleList = new ArrayList<>();
        Title applicationTitle = new Title();
        applicationTitle.setId(1);
        applicationTitle.setLevelId(3);
        applicationTitle.setTitle("Software tester");
        titleList.add(applicationTitle);
        Title applicationTitle1 = new Title();
        applicationTitle1.setId(2);
        applicationTitle1.setLevelId(2);
        applicationTitle1.setTitle("manager");
        titleList.add(applicationTitle1);
        Title applicationTitle3 = new Title();
        applicationTitle3.setId(3);
        applicationTitle3.setLevelId(1);
        applicationTitle3.setTitle("hr manager");
        titleList.add(applicationTitle3);
        return titleList;
    }

    public int getLevelIdByTitle(String title) throws SQLException {
        if(title.equals("hr manager")){
            return 1;
        }else if(title.equals("manager")){
            return 2;
        }else if(title.equals("Software tester")){
            return 3;
        }else{
            throw new SQLException("title is null, please check it");
        }
    }
}
