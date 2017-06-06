package leaveManagementTests.SmokeTests;

import leaveManagementAutomationFramework.Navigation.AllNavigation;
import leaveManagementAutomationFramework.Pages.ChangePasswordPage;
import leaveManagementTests.Utilities.LeaveManagementTest;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ChangePasswordTest extends LeaveManagementTest {
    Logger log = Logger.getLogger(ChangePasswordTest.class.getName());

    @Test
    public void userCanAccessChangePasswordPage() throws InterruptedException {
        Logger log = Logger.getLogger(LoginTest.class.getName());
        AllNavigation.ChangePassword.select();
        Boolean isAt = ChangePasswordPage.isAt();
        Assert.assertTrue(isAt, "Failed to login");
    }
}
