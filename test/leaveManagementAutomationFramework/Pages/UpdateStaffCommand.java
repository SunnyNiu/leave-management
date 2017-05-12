package leaveManagementAutomationFramework.Pages;

import leaveManagementAutomationFramework.Selenium.Driver;
import org.openqa.selenium.By;

public class UpdateStaffCommand {
    String DepartmentId;
    String Title;
    String EmailAddress;
    String EmailPassword;
    String flag;

    public UpdateStaffCommand(String dep, String title) {
        this.DepartmentId = dep;
        this.Title = title;
    }

    public UpdateStaffCommand WithEmail(String email, String emailPw) {
        this.EmailAddress = email;
        this.EmailPassword = emailPw;
        return this;
    }

    public UpdateStaffCommand WithFlag(String flag) {
        this.flag = flag;
        return this;
    }

    public void Change() throws InterruptedException {
        Driver.wait(1000);
        Driver.Instance.findElement(By.id("email")).clear();
        Driver.Instance.findElement(By.id("emailPassword")).clear();
        Driver.Instance.findElement(By.id("departmentId")).sendKeys(DepartmentId);
        Driver.Instance.findElement(By.id("titleId")).sendKeys(Title);
        Driver.Instance.findElement(By.id("email")).sendKeys(EmailAddress);
        Driver.Instance.findElement(By.id("emailPassword")).sendKeys(EmailPassword);
        Driver.Instance.findElement(By.id("flagStatus")).sendKeys(flag);
        Driver.wait(1000);
        Driver.Instance.findElement(By.id("udpateBtn")).click();
    }
}
