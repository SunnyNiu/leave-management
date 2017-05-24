package leaveManagementTests.SmokeTests;

import leaveManagementAutomationFramework.Navigation.AllNavigation;
import leaveManagementAutomationFramework.Pages.ChangePasswordPage;
import leaveManagementTests.Utilities.LeaveManagementTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ChangePasswordTest extends LeaveManagementTest {
    @Test
    public void userCanAccessChangePasswordPage() throws InterruptedException {
        AllNavigation.ChangePassword.select();
        Boolean isAt = ChangePasswordPage.isAt();
        Assert.assertTrue(isAt, "Failed to login");
    }
}
