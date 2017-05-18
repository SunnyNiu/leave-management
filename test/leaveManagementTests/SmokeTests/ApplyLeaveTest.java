package leaveManagementTests.SmokeTests;

import leaveManagementAutomationFramework.Navigation.AllNavigation;
import leaveManagementAutomationFramework.Pages.ApplyLeavePage;
import leaveManagementTests.Utilities.LeaveManagementTest;
import org.junit.Assert;
import org.junit.Test;

public class ApplyLeaveTest extends LeaveManagementTest {

    @Test
    public void userCanAccessApplyLeavePage() throws InterruptedException {
        AllNavigation.ApplyLeave.select();
        Boolean isAt = ApplyLeavePage.isAt();
        Assert.assertTrue("Failed to login",isAt);
    }
}
