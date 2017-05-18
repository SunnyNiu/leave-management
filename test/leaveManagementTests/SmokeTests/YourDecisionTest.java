package leaveManagementTests.SmokeTests;


import leaveManagementAutomationFramework.Navigation.AllNavigation;
import leaveManagementAutomationFramework.Pages.LeaveHistoryPage;
import org.junit.Assert;
import org.junit.Test;

public class YourDecisionTest {

    @Test
    public void userCanAccessLeaveHistoryPage() throws InterruptedException {
        AllNavigation.ApplyLeaveHistory.select();
        Boolean isAt = LeaveHistoryPage.isAt();
        Assert.assertTrue("Failed to login",isAt);
    }
}
