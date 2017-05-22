package leaveManagementTests.SmokeTests;

import leaveManagementAutomationFramework.Navigation.AllNavigation;
import leaveManagementTests.Utilities.LeaveManagementTest;
import org.junit.Assert;
import org.junit.Test;

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
        Assert.assertFalse("Log out fail", isLogout);
    }
}
