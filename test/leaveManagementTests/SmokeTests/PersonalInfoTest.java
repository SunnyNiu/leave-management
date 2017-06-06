package leaveManagementTests.SmokeTests;


import leaveManagementAutomationFramework.Navigation.AllNavigation;
import leaveManagementAutomationFramework.Pages.MainPage;
import leaveManagementTests.Utilities.LeaveManagementTest;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PersonalInfoTest extends LeaveManagementTest {
    Logger log = Logger.getLogger(PersonalInfoTest.class.getName());

    @Test
    public void userCanAccessPersonalInfoPage() throws InterruptedException {
        Logger log = Logger.getLogger(LoginTest.class.getName());
        AllNavigation.PersonalInfo.select();
        Boolean isAt = MainPage.isAt();
        Assert.assertTrue(isAt, "Failed to login");
    }
}