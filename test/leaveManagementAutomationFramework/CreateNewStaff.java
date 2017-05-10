package leaveManagementAutomationFramework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class CreateNewStaff {

    public static void GoTo() {
        WebElement menuNewStaff = Driver.Instance.findElement(By.cssSelector("a[href='addNewMemberMenu.do']"));
        menuNewStaff.click();
    }

    public static CreateNewStaffCommand CreateStaff(String login, String password) {
        return new CreateNewStaffCommand(login, password);
    }

    public static String StaffIsCreated() {
        String message = Driver.Instance.findElement(By.id("message")).getText();
        return message;
    }
}