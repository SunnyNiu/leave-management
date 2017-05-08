package leaveManagementAutomationFramework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class LoginPage {
    public static void GoTo(){
        System.setProperty("webdriver.chrome.driver","C://software//chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://localhost:8080/login.jsp");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.quit();
    }

    public static LoginCommand LoginAs(String userName) {
        return new LoginCommand(userName);
    }
}

