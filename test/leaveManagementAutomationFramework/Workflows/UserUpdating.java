package leaveManagementAutomationFramework.Workflows;


import leaveManagementAutomationFramework.Pages.UpdateStaffPage;
import leaveManagementAutomationFramework.Utilities.RandomCreator;

import static leaveManagementAutomationFramework.Utilities.RandomCreator.*;

/**
 * Created by Sunny on 12/05/2017.
 */
public class UserUpdating {

    public static void updateAUser() throws InterruptedException {
        String department = generateRandom(RandomCreator.department);
        String title = generateRandom(RandomCreator.title);
        String email = generateRandom(RandomCreator.email);
        String emailPassword = generateRandom(RandomCreator.emailPassword);
        String flag = "inactive";

        UpdateStaffPage.updateStaff(department, title)
                .WithEmail(email, emailPassword)
                .WithFlag(flag).change();
    }
}
