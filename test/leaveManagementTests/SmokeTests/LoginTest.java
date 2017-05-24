package leaveManagementTests.SmokeTests;

import leaveManagementAutomationFramework.Pages.MainPage;
import leaveManagementTests.Utilities.LeaveManagementTest;
import org.testng.annotations.Test;
import static org.testng.AssertJUnit.assertTrue;

public class LoginTest extends LeaveManagementTest {

    @Test
    public void userCanLogin() throws InterruptedException {
        Boolean isAt = MainPage.isAt();
        assertTrue("Failed to login",isAt);
    }
}
