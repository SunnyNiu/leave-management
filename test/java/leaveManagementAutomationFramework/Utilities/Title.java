package leaveManagementAutomationFramework.Utilities;

public enum Title {
    HR_MANAGER("HR MANAGER"),
    MANAGER("MANAGER"),
    CUSTOMER_SUPPORTER("CUSTOMER SUPPORTER"),
    HELPDESK("HELPDESK"),
    ACCOUNT("ACCOUNT"),
    SALES("SALES"),
    SOFTWARE_ENGINEER("SOFTWARE ENGINEER");

    private String name;

    Title(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}
