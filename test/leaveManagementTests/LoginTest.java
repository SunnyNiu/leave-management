package leaveManagementTests;

import leaveManagementAutomationFramework.Driver;
import leaveManagementAutomationFramework.LoginPage;
import leaveManagementAutomationFramework.MainPage;
import org.junit.*;

public class LoginTest {

    @Before
    public void Init() {
        Driver.Initialize();
    }

    @Test
    public void User_Can_Login() throws InterruptedException {
        LoginPage.GoTo();
        LoginPage.LoginAs("William")
                .WithPassword("Wil123")
                .Login();
        Boolean isAt = MainPage.IsAt();
        Assert.assertTrue("Failed to login",isAt);
    }

    @After
    public void Cleanup() {
        Driver.Close();
    }
}
