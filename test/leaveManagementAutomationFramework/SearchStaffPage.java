package leaveManagementAutomationFramework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class SearchStaffPage {

    public static void GoTo() {
        WebElement menuNewStaff = Driver.Instance.findElement(By.cssSelector("a[href='updateMemberMenu.do']"));
        menuNewStaff.click();
    }

    public static SearchStaffPageCommand Search(String firstName, String lastName) {
        return new SearchStaffPageCommand(firstName, lastName);
    }

    public static boolean NotEmptyForSearch() {
        return Driver.Instance.findElement(By.id("changeBtnId")).isDisplayed();
    }

    public static boolean IsSearchStaffPage() {
        //Refactor: Can I create a generalized IsAt for all pages?
        return Driver.Instance.findElement(By.id("searchStaffTitle"))
                .getText().contains("Search, Update or Remove Staff Information");
    }
}
