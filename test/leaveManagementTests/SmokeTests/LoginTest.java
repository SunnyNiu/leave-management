package leaveManagementTests.SmokeTests;

import leaveManagementAutomationFramework.Pages.MainPage;
import leaveManagementTests.Utilities.LeaveManagementTest;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;


import static org.testng.AssertJUnit.assertTrue;

public class LoginTest extends LeaveManagementTest {
    Logger log = Logger.getLogger(LoginTest.class.getName());
    @Test
    public void userCanLogin() throws InterruptedException {
        Boolean isAt = MainPage.isAt();
        assertTrue("Failed to login", isAt);
    }

}
