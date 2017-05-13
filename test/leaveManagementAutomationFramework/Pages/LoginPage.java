package leaveManagementAutomationFramework.Pages;

import leaveManagementAutomationFramework.Navigation.AllNavigation;

public class LoginPage {
    public static void goTo(){
        AllNavigation.Login.select();
    }

    public static LoginCommand loginAs(String userName) {
        return new LoginCommand(userName);
    }
}

