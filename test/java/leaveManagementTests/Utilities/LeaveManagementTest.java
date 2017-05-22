package leaveManagementTests.Utilities;

import leaveManagementAutomationFramework.Selenium.Driver;
import leaveManagementAutomationFramework.Pages.LoginPage;
import leaveManagementAutomationFramework.Workflows.UserCreator;
import org.junit.After;
import org.junit.Before;

import java.net.MalformedURLException;

public class LeaveManagementTest {
    @Before
    public void init() throws MalformedURLException {
        Driver.initialize();

        UserCreator.initialize();

        LoginPage.goTo();
        LoginPage.loginAs("William")
                .withPassword("Wil123")
                .login();
    }

    @After
    public void cleanup() throws InterruptedException {
        UserCreator.cleanup();
        Driver.close();
    }
}
