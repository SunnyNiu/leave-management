package leaveManagementTests.Utilities;

import leaveManagementAutomationFramework.Selenium.Driver;
import leaveManagementAutomationFramework.Pages.LoginPage;
import leaveManagementAutomationFramework.Workflows.UserCreator;
import org.junit.Before;
import org.junit.After;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;


import java.net.MalformedURLException;

public class LeaveManagementTest {
    @BeforeSuite
    public void init() throws MalformedURLException {
        Driver.initialize();

        UserCreator.initialize();

        LoginPage.goTo();
        LoginPage.loginAs("William")
                .withPassword("Wil123")
                .login();
    }

    @AfterSuite
    public void cleanup() throws InterruptedException {
        UserCreator.cleanup();
        Driver.close();
    }
}
