package leaveManagementTests.SmokeTests;

import leaveManagementAutomationFramework.Pages.SearchStaffPage;
import leaveManagementTests.Utilities.LeaveManagementTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchStaffTest extends LeaveManagementTest {

    @Test
    public void adminCanSearchStaff() throws InterruptedException {
        SearchStaffPage.goTo();
        Assert.assertTrue(SearchStaffPage.isSearchStaffPage(), "Can't access to searchStaffPage");
        SearchStaffPage.search("Sunny", "Niu").search();
        boolean researchIsEmpty = SearchStaffPage.notEmptyForSearch();
        Assert.assertTrue(!researchIsEmpty, "search result is empty");
    }
}
