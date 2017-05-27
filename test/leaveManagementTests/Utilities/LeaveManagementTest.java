package leaveManagementTests.Utilities;

import jxl.read.biff.BiffException;
import leaveManagementAutomationFramework.Pages.LoginPage;
import leaveManagementAutomationFramework.Selenium.Driver;
import leaveManagementAutomationFramework.Utilities.ExcelReader;
import leaveManagementAutomationFramework.Workflows.UserCreator;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;


import java.io.IOException;

public class LeaveManagementTest {
    public ExcelReader excelReaderObj;
    @BeforeSuite
    public void init() throws IOException, BiffException {
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
