package test.org.niu.leaves.jsp.servlet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Created by Sunny on 11/02/2017.
 */
public class SeleniumTest {
    public static void main(String[] arg) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","C://software//chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://www.google.com/xhtml");
        Thread.sleep(3000);
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("ChromeDriver");
        searchBox.submit();
        Thread.sleep(5000);
        driver.quit();
    }
}
