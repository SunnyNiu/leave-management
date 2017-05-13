package leaveManagementTests.SmokeTests;

import leaveManagementAutomationFramework.Pages.MainPage;
import leaveManagementTests.Utilities.LeaveManagementTest;
import org.junit.*;

public class LoginTest extends LeaveManagementTest {

    @Test
    public void userCanLogin() throws InterruptedException {
        Boolean isAt = MainPage.isAt();
        Assert.assertTrue("Failed to login",isAt);
    }
}
