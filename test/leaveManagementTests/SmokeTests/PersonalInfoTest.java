package leaveManagementTests.SmokeTests;


import leaveManagementAutomationFramework.Navigation.AllNavigation;
import leaveManagementAutomationFramework.Pages.MainPage;
import leaveManagementTests.Utilities.LeaveManagementTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PersonalInfoTest extends LeaveManagementTest {

    @Test
    public void userCanAccessPersonalInfoPage() throws InterruptedException {
        AllNavigation.PersonalInfo.select();
        Boolean isAt = MainPage.isAt();
        Assert.assertTrue(isAt, "Failed to login");
    }
}