package leaveManagementAutomationFramework.Pages;

import leaveManagementAutomationFramework.Selenium.Driver;
import org.openqa.selenium.By;

public class SearchStaffPageCommand {
    private String firstName;
    private String lastName;

    public SearchStaffPageCommand(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public void Search() throws InterruptedException {
        Driver.Instance.findElement(By.id("searchFirsName")).sendKeys(firstName);
        Driver.Instance.findElement(By.id("searchLastName")).sendKeys(lastName);

        Driver.wait(1000);
        Driver.Instance.findElement(By.id("searchStaffBtnId")).click();
        Driver.wait(1000);
    }

    public void getChangeStaff() throws InterruptedException{
        Driver.Instance.findElement(By.id("changeBtnId")).click();
    }
}
