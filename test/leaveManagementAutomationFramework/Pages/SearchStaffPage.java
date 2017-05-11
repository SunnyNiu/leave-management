package leaveManagementAutomationFramework.Pages;

import leaveManagementAutomationFramework.Navigation.AllNavigation;
import leaveManagementAutomationFramework.Selenium.Driver;
import org.openqa.selenium.By;

public class SearchStaffPage {

    public static void GoTo() {
        AllNavigation.SearchUpdateStaffPage.Select();
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
