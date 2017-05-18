package leaveManagementTests.SmokeTests;


import leaveManagementAutomationFramework.Navigation.AllNavigation;
import leaveManagementAutomationFramework.Pages.UpdateStaffPage;
import leaveManagementTests.Utilities.LeaveManagementTest;
import org.junit.Assert;
import org.junit.Test;

public class UpdateMemeberTest extends LeaveManagementTest {

    @Test
    public void userCanAccessUpdateMemberPage() throws InterruptedException {
        AllNavigation.SearchUpdateStaffPage.select();
        Boolean isAt = UpdateStaffPage.isAt();
        Assert.assertTrue("Failed to login",isAt);
    }
}
