package leaveManagementAutomationFramework.Pages;

import leaveManagementAutomationFramework.Navigation.AllNavigation;
import leaveManagementAutomationFramework.Selenium.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ApplyLeavePage {
    public static void goTo() {
        AllNavigation.ApplyLeave.select();
    }

    public static CreateNewLeaveApplicationCommand createLeaveApplication(String from, String to) {
        return new CreateNewLeaveApplicationCommand(from, to);
    }

    public static boolean isSubmitApplication() {
        try {
            Driver.Instance.findElement(By.cssSelector("#body > div > form > div > div:nth-child(2) > label")).getText().contains("Submit successfully");
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    public static Boolean isAt() {
        WebElement mainPageTitle = Driver.Instance.findElement(By.className("active"));
        if (mainPageTitle.getText().contains("ApplyLeave")) {
            return true;
        } else
            return false;
    }
}
