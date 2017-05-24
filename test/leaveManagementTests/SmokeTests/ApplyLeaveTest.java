package leaveManagementTests.SmokeTests;

import leaveManagementAutomationFramework.Navigation.AllNavigation;
import leaveManagementAutomationFramework.Pages.ApplyLeavePage;
import leaveManagementTests.Utilities.LeaveManagementTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ApplyLeaveTest extends LeaveManagementTest {

    @Test
    public void userCanAccessApplyLeavePage() throws InterruptedException {
        AllNavigation.ApplyLeave.select();
        Boolean isAt = ApplyLeavePage.isAt();
        Assert.assertTrue(isAt, "Failed to login");
    }
}
