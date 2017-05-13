package test.org.niu.leaves.jsp.servlet;

import org.junit.Before;
import org.junit.Test;
import org.niu.leaves.jsp.servlet.ConfigurationGuice.GuiceInjector;
import org.niu.leaves.jsp.servlet.model.Title;
import org.niu.leaves.jsp.servlet.service.TitleService;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by Sunny on 11/04/2017.
 */
public class TitleServiceTest {

    @Before
    public void initializeInjector() {
        GuiceInjector.initializeInjector(new TestConfigureModule());
    }

    @Test
    public void getTitles() throws SQLException, IOException {
        TitleService titleService = new TitleService();
        List<Title> titles = titleService.getTitles();
        String title = "Software tester";
        assertEquals("title are not correct", title, titles.get(0).getTitle());
    }

    @Test
    public void getLevelIdByTitle() throws SQLException, IOException {
        int levelId = 3;
        TitleService titleService = new TitleService();
        int levelIdFromMock = titleService.getLevelId("Software tester");
        assertEquals("Level Id is not correct", levelId, levelIdFromMock);
    }
}
