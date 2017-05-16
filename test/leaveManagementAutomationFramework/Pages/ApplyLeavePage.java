package leaveManagementAutomationFramework.Pages;

import leaveManagementAutomationFramework.Navigation.AllNavigation;
import leaveManagementAutomationFramework.Selenium.Driver;
import org.openqa.selenium.By;

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
}
