package leaveManagementAutomationFramework;

public class LoginCommand {
    private String userName;
    private String password;

    public LoginCommand(String userName) {
        this.userName = userName;
    }

    public LoginCommand WithPassword(String password) {
        this.password = password;
        return this;
    }

    public void Login() {
    }
}
