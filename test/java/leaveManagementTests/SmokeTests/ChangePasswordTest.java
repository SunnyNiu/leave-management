package leaveManagementTests.SmokeTests;

import leaveManagementAutomationFramework.Navigation.AllNavigation;
import leaveManagementAutomationFramework.Pages.ChangePasswordPage;
import leaveManagementTests.Utilities.LeaveManagementTest;
import org.junit.Assert;
import org.junit.Test;

public class ChangePasswordTest extends LeaveManagementTest {
    @Test
    public void userCanAccessChangePasswordPage() throws InterruptedException {
        AllNavigation.ChangePassword.select();
        Boolean isAt = ChangePasswordPage.isAt();
        Assert.assertTrue("Failed to login",isAt);
    }
}
