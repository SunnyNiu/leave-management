package leaveManagementTests.SmokeTests;


import leaveManagementAutomationFramework.Navigation.AllNavigation;
import leaveManagementAutomationFramework.Pages.MainPage;
import leaveManagementTests.Utilities.LeaveManagementTest;
import org.junit.Assert;
import org.junit.Test;

public class PersonalInfoTest extends LeaveManagementTest {

    @Test
    public void userCanAccessPersonalInfoPage() throws InterruptedException {
        AllNavigation.PersonalInfo.select();
        Boolean isAt = MainPage.isAt();
        Assert.assertTrue("Failed to login",isAt);
    }
}