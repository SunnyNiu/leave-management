package leaveManagementTests.Utilities;

import leaveManagementAutomationFramework.Selenium.Driver;
import leaveManagementAutomationFramework.Pages.LoginPage;
import org.junit.After;
import org.junit.Before;

public class LeaveManagementTest {
    @Before
    public void Init() {
        Driver.Initialize();
        LoginPage.GoTo();
        LoginPage.LoginAs("William")
                .WithPassword("Wil123")
                .Login();
    }

    @After
    public void Cleanup() {
        Driver.Close();
    }
}
