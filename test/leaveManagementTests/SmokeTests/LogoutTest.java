package leaveManagementTests.SmokeTests;

import leaveManagementAutomationFramework.Navigation.AllNavigation;
import leaveManagementTests.Utilities.LeaveManagementTest;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LogoutTest extends LeaveManagementTest {

    Logger log = Logger.getLogger(LogoutTest.class.getName());

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
