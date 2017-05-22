package leaveManagementTests.SmokeTests;


import leaveManagementAutomationFramework.Navigation.AllNavigation;
import leaveManagementAutomationFramework.Pages.LeaveHistoryPage;
import leaveManagementTests.Utilities.LeaveManagementTest;
import org.junit.Assert;
import org.junit.Test;

public class LeaveHistoryTest extends LeaveManagementTest {

    @Test
    public void userCanAccessLeaveHistoryPage() throws InterruptedException {
        AllNavigation.ApplyLeaveHistory.select();
        Boolean isAt = LeaveHistoryPage.isAt();
        Assert.assertTrue("Failed to login",isAt);
    }
}
