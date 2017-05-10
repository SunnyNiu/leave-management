package leaveManagementTests;

import leaveManagementAutomationFramework.MainPage;
import org.junit.*;

public class LoginTest extends LeaveManagementTest {

    @Test
    public void User_Can_Login() throws InterruptedException {
        Boolean isAt = MainPage.IsAt();
        Assert.assertTrue("Failed to login",isAt);
    }
}
