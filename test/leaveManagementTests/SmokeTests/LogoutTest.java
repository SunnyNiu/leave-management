package leaveManagementTests.SmokeTests;

import leaveManagementAutomationFramework.Navigation.AllNavigation;
import leaveManagementTests.Utilities.LeaveManagementTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LogoutTest extends LeaveManagementTest {

    @Test
    public void logout() {
        AllNavigation.Logout.select();
        boolean isLogout;
        try {
            AllNavigation.ApplyLeave.select();
            isLogout = false;

        } catch (Exception e) {
            isLogout = true;
        }
        Assert.assertFalse(isLogout, "Log out fail");
    }
}
