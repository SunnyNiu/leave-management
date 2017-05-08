package leaveManagementAutomationFramework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class MainPage {

    public static boolean IsAt() {
        WebElement mainPageTitle = Driver.Instance.findElement(By.id("mainPageTitle"));
        if (mainPageTitle.getText().contains("MainPage")) {
            return true;
        } else
            return false;
    }
}
