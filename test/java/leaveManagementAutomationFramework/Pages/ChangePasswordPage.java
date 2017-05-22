package leaveManagementAutomationFramework.Pages;


import leaveManagementAutomationFramework.Selenium.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ChangePasswordPage {
    public static Boolean isAt() {
        WebElement mainPageTitle = Driver.Instance.findElement(By.className("active"));
        if (mainPageTitle.getText().contains("ChangePassword")) {
            return true;
        } else
            return false;
    }
}
