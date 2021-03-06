package leaveManagementTests.SmokeTests;


import leaveManagementAutomationFramework.Navigation.AllNavigation;
import leaveManagementAutomationFramework.Pages.UpdateStaffPage;
import leaveManagementTests.Utilities.LeaveManagementTest;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UpdateMemeberTest extends LeaveManagementTest {
    Logger log = Logger.getLogger(UpdateMemeberTest.class.getName());

    @Test
    public void userCanAccessUpdateMemberPage() throws InterruptedException {
        AllNavigation.SearchUpdateStaffPage.select();
        Boolean isAt = UpdateStaffPage.isAt();
        Assert.assertTrue(isAt, "Failed to login");
    }
}
