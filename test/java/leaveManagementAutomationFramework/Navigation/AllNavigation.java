package leaveManagementAutomationFramework.Navigation;

import leaveManagementAutomationFramework.Selenium.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AllNavigation {

    public static class Login {
        public static void select() {
            Driver.Instance.get(Driver.baseAddress + "login.jsp");
            WebDriverWait wait = new WebDriverWait(Driver.Instance, 5);
            wait.until(ExpectedConditions.presenceOfElementLocated(By.id("loginSubmit")));
        }
    }

    public static class PersonalInfo {
        public static void select() {
            WebElement menuPersonalInfo = Driver.Instance.findElement(By.cssSelector("a[href='mainPageMenu.do']"));
            menuPersonalInfo.click();
        }
    }

    public static class ApplyLeave {
        public static void select() {
            WebElement menuApplyLeave = Driver.Instance.findElement(By.cssSelector("a[href='leaveMenu.do']"));
            menuApplyLeave.click();
        }
    }

    public static class ApplyLeaveHistory {
        public static void select() {
            WebElement menuApplyLeave = Driver.Instance.findElement(By.cssSelector("a[href='leaveHistoryMenu.do']"));
            menuApplyLeave.click();
        }
    }

    public static class YourDecision {
        public static void select() {
            WebElement menuYourDecision = Driver.Instance.findElement(By.cssSelector("a[href='MakeYourApprovalDecision.do']"));
            menuYourDecision.click();
        }
    }

    public static class CreateNewStaff {
        public static void select() {
            WebElement menuNewStaff = Driver.Instance.findElement(By.cssSelector("a[href='addNewMemberMenu.do']"));
            menuNewStaff.click();
        }
    }

    public static class SearchUpdateStaffPage {
        public static void select() {
            WebElement menuNewStaff = Driver.Instance.findElement(By.cssSelector("a[href='updateMemberMenu.do']"));
            menuNewStaff.click();
        }
    }

    public static class ChangePassword {
        public static void select() {
            WebElement menuChangePassword = Driver.Instance.findElement(By.cssSelector("a[href='updatePasswordMenu.do']"));
            menuChangePassword.click();
        }
    }


    public static class ChangePersonalInfo {
        public static void select() {
            WebElement menuChangePersonalInfo = Driver.Instance.findElement(By.cssSelector("a[href='updateInfoMenu.do']"));
            menuChangePersonalInfo.click();
        }
    }

    public static class Logout {
        public static void select() {
            try {
                WebElement menuLogout = Driver.Instance.findElement(By.cssSelector("a[href='updateInfoMenu.do']"));
                menuLogout.click();
            } catch (Exception ex) {
            }
        }
    }
}
