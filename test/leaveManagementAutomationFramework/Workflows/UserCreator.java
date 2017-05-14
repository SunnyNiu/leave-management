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
            previousLogin = createLogin();
            previousPassword = createPassword();
            previousDepartment = createDepartment();
            previousTitle = createTitle();
            previousJoinDate = createJoinDate();
            previousBirthDate = createBirthDate();
            previousFirstName = createFirstName();
            previousLastName = createLastName();
            previousEmail = createEmail();


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
        if (previousLogin == null) {
            return false;
        } else
            return true;
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

    private static String createLogin() {
        return generateRandom(RandomCreator.login);
    }

    private static String createPassword() {
        return generateRandom(RandomCreator.password);
    }

    private static String createDepartment() {
        return generateRandom(RandomCreator.department);
    }

    private static String createTitle() {
        return generateRandom(RandomCreator.title);
    }

    private static String createEmail() {
        return generateRandom(RandomCreator.email);
    }

    private static String createLastName() {
        return generateRandom(RandomCreator.lastName);
    }

    private static String createFirstName() {
        return generateRandom(RandomCreator.firstName);
    }

    private static String createBirthDate() {
        return generateRandom(RandomCreator.birthDate);
    }

    private static String createJoinDate() {
        return generateRandom(RandomCreator.joinDate);
    }
}
