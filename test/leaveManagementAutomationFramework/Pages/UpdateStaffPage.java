package leaveManagementAutomationFramework.Pages;

import leaveManagementAutomationFramework.Selenium.Driver;
import org.openqa.selenium.By;

/**
 * Created by Sunny on 11/05/2017.
 */
public class UpdateStaffPage {
    public static void linkChangedStaff() {
        Driver.Instance.findElement(By.id("changeBtnId")).click();
    }

    public static UpdateStaffCommand UpdateStaff(String department, String title) {
        return new UpdateStaffCommand(department, title);
    }

    public static String StaffIsChange() {
        String message = Driver.Instance.findElement(By.id("message")).getText();
        return message;
    }

    public static String getFlag() {
        return Driver.Instance.findElement(By.id("flagStatus")).getAttribute("value");
    }
}
