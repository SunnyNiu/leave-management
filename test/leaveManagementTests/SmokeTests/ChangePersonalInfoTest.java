package leaveManagementTests.SmokeTests;


import leaveManagementAutomationFramework.Navigation.AllNavigation;
import leaveManagementAutomationFramework.Pages.ChangePersonalInfoPage;
import leaveManagementTests.Utilities.LeaveManagementTest;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ChangePersonalInfoTest extends LeaveManagementTest {
    Logger log = Logger.getLogger(ChangePersonalInfoTest.class.getName());
    @Test
    public void userCanAccessChangePersonalInfoPage() throws InterruptedException {
        Logger log = Logger.getLogger(LoginTest.class.getName());
        AllNavigation.ChangePersonalInfo.select();
        Boolean isAt = ChangePersonalInfoPage.isAt();
        Assert.assertTrue(isAt, "Failed to login");
    }
}
