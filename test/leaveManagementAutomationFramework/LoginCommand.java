package leaveManagementAutomationFramework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

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
        WebElement loginInput = Driver.Instance.findElement(By.id("username"));
        loginInput.sendKeys(userName);

        WebElement passWord = Driver.Instance.findElement(By.id("password"));
        passWord.sendKeys(password);

        WebElement loginButton = Driver.Instance.findElement(By.id("loginSubmit"));
        loginButton.click();
    }
}
