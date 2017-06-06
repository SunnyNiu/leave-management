package leaveManagementTests.SmokeTests;


import leaveManagementAutomationFramework.Navigation.AllNavigation;
import leaveManagementAutomationFramework.Pages.LeaveHistoryPage;
import leaveManagementTests.Utilities.LeaveManagementTest;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LeaveHistoryTest extends LeaveManagementTest {
    Logger log = Logger.getLogger(LeaveHistoryTest.class.getName());

    @Test
    public void userCanAccessLeaveHistoryPage() throws InterruptedException {
        AllNavigation.ApplyLeaveHistory.select();
        Boolean isAt = LeaveHistoryPage.isAt();
        Assert.assertTrue(isAt, "Failed to login");
    }
}
