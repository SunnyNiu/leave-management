package leaveManagementTests.SmokeTests;


import leaveManagementAutomationFramework.Navigation.AllNavigation;
import leaveManagementAutomationFramework.Pages.YourDecisionPage;
import leaveManagementTests.Utilities.LeaveManagementTest;
import org.junit.Assert;
import org.junit.Test;

public class YourDecisionTest extends LeaveManagementTest {

    @Test
    public void userCanAccessLeaveHistoryPage() throws InterruptedException {
        AllNavigation.YourDecision.select();
        Boolean isAt = YourDecisionPage.isAt();
        Assert.assertTrue("Failed to login",isAt);
    }
}
