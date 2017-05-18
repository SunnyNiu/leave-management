package leaveManagementTests.SmokeTests;


import leaveManagementAutomationFramework.Navigation.AllNavigation;
import leaveManagementAutomationFramework.Pages.MainPage;
import org.junit.Assert;
import org.junit.Test;

public class PersonalInfoTest {

    @Test
    public void userCanAccessPersonalInfoPage() throws InterruptedException {
        AllNavigation.PersonalInfo.select();
        Boolean isAt = MainPage.isAt();
        Assert.assertTrue("Failed to login",isAt);
    }
}