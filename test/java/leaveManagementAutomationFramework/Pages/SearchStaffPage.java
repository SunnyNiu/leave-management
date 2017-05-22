package leaveManagementAutomationFramework.Pages;

import leaveManagementAutomationFramework.Navigation.AllNavigation;
import leaveManagementAutomationFramework.Selenium.Driver;
import org.openqa.selenium.By;

public class SearchStaffPage {

    public static void goTo() {
        AllNavigation.SearchUpdateStaffPage.select();
    }

    public static SearchStaffPageCommand search(String firstName, String lastName) {

        if (!isSearchStaffPage()) {
            SearchStaffPage.goTo();
        }
        return new SearchStaffPageCommand(firstName, lastName);
    }

    public static boolean notEmptyForSearch() {
        try {
            Driver.Instance.findElement(By.id("changeBtnId")).isDisplayed();
            return false;
        } catch (Exception ex) {
            return true;
        }
    }

    public static boolean isSearchStaffPage() {
        try {
            Driver.Instance.findElement(By.id("searchStaffTitle"));
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

}
