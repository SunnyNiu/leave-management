package leaveManagementAutomationFramework.Workflows;

import leaveManagementAutomationFramework.Pages.ApplyLeavePage;
import leaveManagementAutomationFramework.Selenium.Driver;
import leaveManagementAutomationFramework.Utilities.RandomCreator;
import org.openqa.selenium.By;

import static leaveManagementAutomationFramework.Utilities.RandomCreator.generateRandom;

public class LeaveApplicationCreator {

    public static void createALeaveApplication() throws InterruptedException {
        boolean allowCreateNewApplicationLeave = true;

        while (allowCreateNewApplicationLeave) {
            chosenLeavetype = createLeaveType();
            chosenReason = createReason();
            chosenApprover = createApprover();
            chosenFrom = createFrom();
            chosenTo = createTo();
            chosenDays = createDays();

            ApplyLeavePage.goTo();
            ApplyLeavePage.createLeaveApplication(chosenFrom, chosenTo)
                    .withLeaveTypeAndDays(chosenLeavetype, chosenDays)
                    .withReasonAndApprover(chosenReason, chosenApprover)
                    .create();
            try {
                Driver.Instance.findElement(By.cssSelector("form[action='sendEmail.do']")).isDisplayed();
                allowCreateNewApplicationLeave = false;
            } catch (Exception ex) {
                allowCreateNewApplicationLeave = true;
            }
        }
    }

    private static void submitApplication() {
        Driver.Instance.findElement(By.id("submitApplication")).click();
    }

    private static void cancelApplication(){
        Driver.Instance.findElement(By.id("cancelApplication")).click();
    }

    public static void createAndSubmitApplication() throws InterruptedException {
        createALeaveApplication();
        submitApplication();
    }

    public static void createAndCancelApplication() throws InterruptedException {
        createALeaveApplication();
        cancelApplication();
    }

    public static void initialize() {
        chosenLeavetype = null;
        chosenReason = null;
        chosenApprover = null;
        chosenFrom = null;
        chosenTo = null;
        chosenDays = null;
    }

    public static String chosenLeavetype;
    public static String chosenReason;
    public static String chosenApprover;
    public static String chosenFrom;
    public static String chosenTo;
    public static String chosenDays;

    private static String createLeaveType() {
        return generateRandom(RandomCreator.leaveType);
    }

    private static String createReason() {
        return generateRandom(RandomCreator.reason);
    }

    private static String createApprover() {
        return chosenApprover;
    }

    private static String createFrom() {
        return generateRandom(RandomCreator.from);
    }

    private static String createTo() {
        return generateRandom(RandomCreator.to);
    }

    private static String createDays() {
        return generateRandom(RandomCreator.days);
    }
}
