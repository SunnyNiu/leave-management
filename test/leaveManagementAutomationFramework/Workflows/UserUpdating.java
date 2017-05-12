package leaveManagementAutomationFramework.Workflows;


import leaveManagementAutomationFramework.Pages.UpdateStaffPage;
import java.util.Random;
import static leaveManagementAutomationFramework.Pages.Department.*;
import static leaveManagementAutomationFramework.Pages.Title.*;

/**
 * Created by Sunny on 12/05/2017.
 */
public class UserUpdating {

    public static void UpdateAUser() throws InterruptedException {
        String department = GenerateRandom(Department);
        String title = GenerateRandom(Title);
        String email = GenerateRandom(Email);
        String emailPassword = GenerateRandom(EmailPassword);
        String flag = "inactive";

        UpdateStaffPage.UpdateStaff(department, title)
                .WithEmail(email, emailPassword)
                .WithFlag(flag).Change();
    }

    private static String GenerateRandom(String[] str) {
        Random random = new Random();
        return str[random.nextInt(str.length)];
    }

    static String[] Department = new String[]{IT.getName(), HR.getName(), CUSTOMER_SERVICE.getName()};

    static String[] Title = new String[]{SOFTWARE_ENGINEER.getName(), MANAGER.getName(), CUSTOMER_SUPPORTER.getName(), HELPDESK.getName(), ACCOUNT.getName(), SALES.getName()};

    static String[] Email = new String[]{"UlastTestA@gmail.com", "UlastTestB@gmail.com", "UlastTestC@gmail.com", "UlastTestD@gmail.com", "UlastTestE@gmail.com"};

    static String[] EmailPassword = new String[]{"test", "test1", "test2", "test3", "test4"};
}
