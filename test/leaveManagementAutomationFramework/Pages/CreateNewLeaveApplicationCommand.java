package leaveManagementAutomationFramework.Pages;

import leaveManagementAutomationFramework.Selenium.Driver;
import org.openqa.selenium.By;

public class CreateNewLeaveApplicationCommand {

    private String leaveType;
    private String reason;
    private String approver;
    private String from;
    private String to;
    private String days;


    public CreateNewLeaveApplicationCommand(String from, String to) {
        this.from = from;
        this.to = to;
    }

    public CreateNewLeaveApplicationCommand withLeaveTypeAndDays(String previousLeaveType, String previousDays) {
        this.leaveType = previousLeaveType;
        this.days = previousDays;
        return this;
    }

    public CreateNewLeaveApplicationCommand withReasonAndApprover(String previousReason, String previousApprover) {
        this.reason = previousReason;
        this.approver = previousApprover;
        return this;
    }

    public void create() throws InterruptedException {

        Driver.Instance.findElement(By.id("leaveTypeId")).sendKeys(leaveType);
        Driver.Instance.findElement(By.id("reason")).sendKeys(reason);
        //Driver.Instance.findElement(By.id("departmentId")).sendKeys(approver);
        Driver.Instance.findElement(By.id("fromDate")).sendKeys(from);
        Driver.Instance.findElement(By.id("toDate")).sendKeys(to);
        Driver.Instance.findElement(By.id("totalDay")).sendKeys(days);
        Driver.wait(1000);
        Driver.Instance.findElement(By.id("applySubmit")).click();
    }
}
