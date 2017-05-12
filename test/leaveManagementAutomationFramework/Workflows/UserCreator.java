package leaveManagementAutomationFramework.Workflows;


import leaveManagementAutomationFramework.Pages.CreateNewStaffPage;

import java.util.Random;

import static leaveManagementAutomationFramework.Pages.Department.CUSTOMER_SERVICE;
import static leaveManagementAutomationFramework.Pages.Department.HR;
import static leaveManagementAutomationFramework.Pages.Department.IT;
import static leaveManagementAutomationFramework.Pages.Title.*;
import static leaveManagementAutomationFramework.Pages.Title.ACCOUNT;
import static leaveManagementAutomationFramework.Pages.Title.SALES;

public class UserCreator {

    public static void CreateAUser() throws InterruptedException {
        CreateNewStaffPage.GoTo();

        previousLogin = CreateLogin();
        previousPassword = CreatePassword();
        previousDepartment = CreateDepartment();
        previousTitle = CreateTitle();
        previousJoinDate = CreateJoinDate();
        previousBirthDate = CreateBirthDate();
        previousFirstName = CreateFirstName();
        previousLastName = CreateLastName();
        previousEmail = CreateEmail();


        CreateNewStaffPage.CreateStaff(previousLogin, previousPassword)
                .WithDepartmentTitle(previousDepartment, previousTitle)
                .WithJoinDateBirthDate(previousJoinDate, previousBirthDate)
                .WithFirstLastName(previousFirstName, previousLastName)
                .WithEmail(previousEmail).Create();
    }

    private static String GenerateRandom(String[] str) {
        Random random = new Random();
        return str[random.nextInt(str.length)];
    }

    private static String CreateLogin() {
        return GenerateRandom(Login);
    }

    private static String CreatePassword() {
        return GenerateRandom(Password);
    }

    private static String CreateDepartment() {
        return GenerateRandom(Department);
    }

    private static String CreateTitle() {
        return GenerateRandom(Title);
    }


    private static String CreateEmail() {
        return GenerateRandom(Email);
    }

    private static String CreateLastName() {
        return GenerateRandom(LastName);
    }

    private static String CreateFirstName() {
        return GenerateRandom(FirstName);
    }

    private static String CreateBirthDate() {
        return GenerateRandom(BirthDate);
    }

    private static String CreateJoinDate() {
        return GenerateRandom(JoinDate);
    }


    public static void Initialize() {
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

    public static void Cleanup() {
        if (createdAUser)
            removeUser();
    }

    private static void removeUser() {
        //ListPostsPage.TrashPost(PreviousTitle);
        //Initialize();
    }

    static Boolean createdAUser;

    public Boolean getCreatedAUser() {
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

    static String[] Login = new String[]{"boy", "cat", "dog", "rabbit", "baseball", "throw", "find", "scary", "code",
            "mustard"};

    static String[] Password = new String[]{"theboy", "thecat", "thedog", "therabbit", "thebaseball", "thethrow", "thefind", "thescary", "thecode",
            "themustard"};

    static String[] Department = new String[]{IT.getName(), HR.getName(), CUSTOMER_SERVICE.getName()};

    static String[] Title = new String[]{SOFTWARE_ENGINEER.getName(), MANAGER.getName(), CUSTOMER_SUPPORTER.getName(), HELPDESK.getName(), ACCOUNT.getName(), SALES.getName()};

    static String[] JoinDate = new String[]{"01-12-2010", "02-12-2010", "03-12-2010", "04-12-2010", "06-12-2010", "07-12-2010"};

    static String[] BirthDate = new String[]{"01-12-2010", "04-12-2010", "07-11-2010", "03-12-2010", "08-12-2010", "07-12-2010"};

    static String[] FirstName = new String[]{"firstTestA", "firstTestB", "firstTestC", "firstTestD", "firstTestE", "firstTestG"};

    static String[] LastName = new String[]{"lastTestA", "lastTestB", "lastTestC", "lastTestD", "lastTestE", "lastTestG"};

    static String[] Email = new String[]{"lastTestA@gmail.com", "lastTestB@gmail.com", "lastTestC@gmail.com", "lastTestD@gmail.com", "lastTestE@gmail.com"};
}
