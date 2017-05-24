package leaveManagementAutomationFramework.Pages;


import leaveManagementAutomationFramework.Selenium.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ChangePersonalInfoPage {
    public static Boolean isAt() {
        WebElement mainPageTitle = Driver.Instance.findElement(By.className("active"));
        if (mainPageTitle.getText().contains("ChangePersonalInfo")) {
            return true;
        } else
            return false;
    }
}
