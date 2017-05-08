package leaveManagementAutomationFramework;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
    public static void GoTo(){
        Driver.Instance.get("http://localhost:8080/login.jsp");
        WebDriverWait wait = new WebDriverWait(Driver.Instance,5 );
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("loginSubmit")));
    }

    public static LoginCommand LoginAs(String userName) {
        return new LoginCommand(userName);
    }
}

