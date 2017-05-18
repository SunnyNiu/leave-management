package leaveManagementAutomationFramework.Pages;

import leaveManagementAutomationFramework.Selenium.Driver;
import org.openqa.selenium.By;

public class UpdateStaffPage {
    public static void linkChangedStaff() {
        Driver.Instance.findElement(By.id("changeBtnId")).click();
    }

    public static UpdateStaffCommand updateStaff(String department, String title) {
        return new UpdateStaffCommand(department, title);
    }

    public static String staffIsChange() {
        String message = Driver.Instance.findElement(By.id("message")).getText();
        return message;
    }

    public static String getFlag() {
        return Driver.Instance.findElement(By.id("flagStatus")).getAttribute("value");
    }
}
