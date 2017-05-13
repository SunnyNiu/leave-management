package leaveManagementAutomationFramework.Workflows;


import leaveManagementAutomationFramework.Pages.CreateNewStaffPage;
import leaveManagementAutomationFramework.Selenium.Driver;
import leaveManagementAutomationFramework.Utilities.RandomCreator;
import org.openqa.selenium.By;

import static leaveManagementAutomationFramework.Utilities.RandomCreator.generateRandom;

public class UserCreator {

    public static void createAUser() throws InterruptedException {
        CreateNewStaffPage.goTo();
        boolean allowCreateNewStaff = true;

        while (allowCreateNewStaff) {
            previousLogin = CreateLogin();
            previousPassword = CreatePassword();
            previousDepartment = CreateDepartment();
            previousTitle = CreateTitle();
            previousJoinDate = CreateJoinDate();
            previousBirthDate = CreateBirthDate();
            previousFirstName = CreateFirstName();
            previousLastName = CreateLastName();
            previousEmail = CreateEmail();


            CreateNewStaffPage.goTo();
            CreateNewStaffPage.createStaff(previousLogin, previousPassword)
                    .WithDepartmentTitle(previousDepartment, previousTitle)
                    .WithJoinDateBirthDate(previousJoinDate, previousBirthDate)
                    .WithFirstLastName(previousFirstName, previousLastName)
                    .WithEmail(previousEmail).create();
            try {
                String s = Driver.Instance.findElement(By.cssSelector("#message+label>ul>li"))
                        .getText().toString();
                s.contains("Username is existed user in database, please add different user");
                allowCreateNewStaff = true;
            } catch (Exception ex) {
                allowCreateNewStaff = false;
            }
        }

    }

    public static void initialize() {
        previousLogin = null;
        previousPassword = null;
        previousDepartment = null;
        previousTitle = null;
        previousJoinDate = null;
        previousBirthDate = null;
        previousFirstName = null;
        previousLastName = null;
        previousEmail = null;
    }

    public static void cleanup() throws InterruptedException {
        if (getCreatedAUser())
            removeUser();
    }

    private static void removeUser() throws InterruptedException {
        UserUpdating.updateAUser();
        initialize();
    }


    public static Boolean getCreatedAUser() {
        return !previousLogin.isEmpty();
    }

    public static String previousLogin;
    public static String previousPassword;
    public static String previousDepartment;
    public static String previousTitle;
    public static String previousJoinDate;
    public static String previousBirthDate;
    public static String previousFirstName;
    public static String previousLastName;
    public static String previousEmail;

    public String getPreviousLogin() {
        return this.previousLogin;
    }

    public void setPreviousLogin(String previousLogin) {
        this.previousLogin = previousLogin;
    }

    public String getPreviousPassword() {
        return this.previousPassword;
    }

    public void setPreviousPassword(String previousPassword) {
        this.previousPassword = previousPassword;
    }

    public String getPreviousDepartment() {
        return this.previousDepartment;
    }

    public void setPreviousDepartment(String previousDepartment) {
        this.previousDepartment = previousDepartment;
    }

    public String getPreviousTitle() {
        return this.previousTitle;
    }

    public void setPreviousTitle(String previousTitle) {
        this.previousTitle = previousTitle;
    }

    public String getPreviousJoinDate() {
        return this.previousJoinDate;
    }

    public void setPreviousJoinDate(String previousJoinDate) {
        this.previousJoinDate = previousJoinDate;
    }

    public String getPreviousBirthDate() {
        return this.previousBirthDate;
    }

    public void setPreviousBirthDate(String previousBirthDate) {
        this.previousBirthDate = previousBirthDate;
    }

    public String getPreviousFirstName() {
        return this.previousFirstName;
    }

    public void setPreviousFirstName(String previousFirstName) {
        this.previousFirstName = previousFirstName;
    }

    public String getPreviousLastName() {
        return this.previousLastName;
    }

    public void setPreviousLastName(String previousLastName) {
        this.previousLastName = previousLastName;
    }

    public String getPreviousEmail() {
        return this.previousEmail;
    }

    public void setPreviousEmail(String previousEmail) {
        this.previousEmail = previousEmail;
    }

    private static String CreateLogin() {
        return generateRandom(RandomCreator.login);
    }

    private static String CreatePassword() {
        return generateRandom(RandomCreator.password);
    }

    private static String CreateDepartment() {
        return generateRandom(RandomCreator.department);
    }

    private static String CreateTitle() {
        return generateRandom(RandomCreator.title);
    }


    private static String CreateEmail() {
        return generateRandom(RandomCreator.email);
    }

    private static String CreateLastName() {
        return generateRandom(RandomCreator.lastName);
    }

    private static String CreateFirstName() {
        return generateRandom(RandomCreator.firstName);
    }

    private static String CreateBirthDate() {
        return generateRandom(RandomCreator.birthDate);
    }

    private static String CreateJoinDate() {
        return generateRandom(RandomCreator.joinDate);
    }

}
