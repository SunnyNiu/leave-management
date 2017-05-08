package leaveManagementAutomationFramework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Driver {
    public static WebDriver Instance;

    private WebDriver get() {
        return this.Instance;
    }

    private void set(WebDriver instance) {
        this.Instance = instance;
    }

    public static void Initialize() {
        System.setProperty("webdriver.chrome.driver","C://software//chromedriver.exe");
        Instance = new ChromeDriver();
        Instance.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    public static void Close(){
        Instance.close();
    }
}
