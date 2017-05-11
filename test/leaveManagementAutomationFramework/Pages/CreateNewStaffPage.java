package leaveManagementAutomationFramework.Pages;

import leaveManagementAutomationFramework.Navigation.AllNavigation;
import leaveManagementAutomationFramework.Selenium.Driver;
import org.openqa.selenium.By;

public class CreateNewStaffPage {

    public static void GoTo() {
        AllNavigation.CreateNewStaff.Select();
    }

    public static CreateNewStaffCommand CreateStaff(String login, String password) {
        return new CreateNewStaffCommand(login, password);
    }

    public static String StaffIsCreated() {
        String message = Driver.Instance.findElement(By.id("message")).getText();
        return message;
    }
}