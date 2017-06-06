package leaveManagementAutomationFramework.Selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

public class Driver {
    public static WebDriver Instance;
    public static String baseAddress = "http://localhost:8081/";

    private WebDriver get() {
        return this.Instance;
    }

    private void set(WebDriver instance) {
        this.Instance = instance;
    }

    public static void initialize() throws MalformedURLException {
        System.setProperty("webdriver.chrome.driver", "C://software//chromedriver.exe");
        //Instance = new RemoteWebDriver(
        //        new URL("http://localhost:4444/wd/hub"),
        //        DesiredCapabilities.chrome());
        Instance = new ChromeDriver();
        Instance.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        //Instance.manage().window().maximize();
    }

    public static void wait(int timeSpan) throws InterruptedException {
        Thread.sleep(timeSpan);
    }

    public static void close() {
        Instance.close();
    }
}
