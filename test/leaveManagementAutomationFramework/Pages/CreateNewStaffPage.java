package leaveManagementAutomationFramework.Pages;

import leaveManagementAutomationFramework.Navigation.AllNavigation;
import leaveManagementAutomationFramework.Selenium.Driver;
import org.openqa.selenium.By;

public class CreateNewStaffPage {

    public static void goTo() {
        AllNavigation.CreateNewStaff.select();
    }

    public static CreateNewStaffCommand createStaff(String login, String password) {
        return new CreateNewStaffCommand(login, password);
    }

    public static String StaffIsCreated() {
        String message = Driver.Instance.findElement(By.id("message")).getText();
        return message;
    }
}