package leaveManagementAutomationFramework.Pages;

public enum Department {
    IT("IT"),
    HR("HR"),
    CUSTOMER_SERVICE("CUSTOMER SERVICE");

    private String name;

    Department(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}
