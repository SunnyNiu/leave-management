package leaveManagementAutomationFramework.Pages;

import leaveManagementAutomationFramework.Navigation.AllNavigation;

public class LoginPage {
    public static void GoTo(){
        AllNavigation.Login.Select();
    }

    public static LoginCommand LoginAs(String userName) {
        return new LoginCommand(userName);
    }
}

