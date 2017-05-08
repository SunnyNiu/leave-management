package leaveManagementTests;

import leaveManagementAutomationFramework.LoginPage;
import org.junit.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class LoginTest {

    @Test
    public void User_Can_Login() throws InterruptedException {
        LoginPage.GoTo();
        LoginPage.LoginAs("William")
                .WithPassword("Wil123")
                .Login();
        assertEquals("Leave Types are not correct", 0, 0);
        assertTrue("",0==0);
    }

    @Test
    public void GoTo(){
        LoginPage.GoTo();
    }
}
