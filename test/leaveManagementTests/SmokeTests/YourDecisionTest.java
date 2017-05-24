package leaveManagementTests.SmokeTests;


import leaveManagementAutomationFramework.Navigation.AllNavigation;
import leaveManagementAutomationFramework.Pages.YourDecisionPage;
import leaveManagementTests.Utilities.LeaveManagementTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class YourDecisionTest extends LeaveManagementTest {

    @Test
    public void userCanAccessLeaveHistoryPage() throws InterruptedException {
        AllNavigation.YourDecision.select();
        Boolean isAt = YourDecisionPage.isAt();
        Assert.assertTrue(isAt, "Failed to login");
    }
}
