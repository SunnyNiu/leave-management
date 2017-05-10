package leaveManagementAutomationFramework;

import org.openqa.selenium.By;

public class CreateNewStaffCommand {
    private String login;
    private String password;
    private String department;
    private String title;
    private String joinDate;
    private String birthDate;
    private String firstName;
    private String lastName;
    private String email;

    public CreateNewStaffCommand(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public CreateNewStaffCommand WithDepartmentTitle(String department, String title) {
        this.department = department;
        this.title = title;
        return this;
    }

    public CreateNewStaffCommand WithJoinDateBirthDate(String joinDate, String birthDate) {
        this.joinDate = joinDate;
        this.birthDate = birthDate;
        return this;
    }

    public CreateNewStaffCommand WithFirstLastName(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        return this;
    }

    public CreateNewStaffCommand WithEmail(String email) {
        this.email = email;
        return this;
    }

    public void Create() throws InterruptedException {
        Driver.Instance.findElement(By.id("nameId")).sendKeys(login);
        Driver.Instance.findElement(By.id("passwordId")).sendKeys(password);
        Driver.Instance.findElement(By.id("departmentId")).sendKeys(department);
        Driver.Instance.findElement(By.id("titleId")).sendKeys(title);
        Driver.Instance.findElement(By.id("joinDate")).sendKeys(joinDate);
        Driver.Instance.findElement(By.id("birthDate")).sendKeys(birthDate);
        Driver.Instance.findElement(By.id("firstName")).sendKeys(firstName);
        Driver.Instance.findElement(By.id("lastName")).sendKeys(lastName);
        Driver.Instance.findElement(By.id("email")).sendKeys(email);

        Driver.wait(1000);
        Driver.Instance.findElement(By.id("addNewStaff")).click();
    }
}
