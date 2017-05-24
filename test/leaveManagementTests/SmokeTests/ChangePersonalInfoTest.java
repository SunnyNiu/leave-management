package leaveManagementTests.SmokeTests;


import leaveManagementAutomationFramework.Navigation.AllNavigation;
import leaveManagementAutomationFramework.Pages.ChangePersonalInfoPage;
import leaveManagementTests.Utilities.LeaveManagementTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ChangePersonalInfoTest extends LeaveManagementTest {

    @Test
    public void userCanAccessChangePersonalInfoPage() throws InterruptedException {
        AllNavigation.ChangePersonalInfo.select();
        Boolean isAt = ChangePersonalInfoPage.isAt();
        Assert.assertTrue(isAt, "Failed to login");
    }
}
