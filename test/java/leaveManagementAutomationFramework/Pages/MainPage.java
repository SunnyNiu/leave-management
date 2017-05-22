package leaveManagementAutomationFramework.Pages;

import leaveManagementAutomationFramework.Selenium.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class MainPage {

    public static boolean isAt() {
        WebElement mainPageTitle = Driver.Instance.findElement(By.id("mainPageTitle"));
        if (mainPageTitle.getText().contains("MainPage")) {
            return true;
        } else
            return false;
    }
}
