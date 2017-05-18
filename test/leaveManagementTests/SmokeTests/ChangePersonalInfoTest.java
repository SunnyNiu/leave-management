package leaveManagementTests.SmokeTests;


import leaveManagementAutomationFramework.Navigation.AllNavigation;
import leaveManagementAutomationFramework.Pages.ChangePersonalInfoPage;
import leaveManagementTests.Utilities.LeaveManagementTest;
import org.junit.Assert;
import org.junit.Test;

public class ChangePersonalInfoTest  extends LeaveManagementTest {

    @Test
    public void userCanAccessChangePersonalInfoPage() throws InterruptedException {
        AllNavigation.ChangePersonalInfo.select();
        Boolean isAt = ChangePersonalInfoPage.isAt();
        Assert.assertTrue("Failed to login",isAt);
    }
}
