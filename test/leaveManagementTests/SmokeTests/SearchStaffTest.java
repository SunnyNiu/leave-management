package leaveManagementTests.SmokeTests;

import leaveManagementAutomationFramework.Pages.SearchStaffPage;
import leaveManagementTests.Utilities.LeaveManagementTest;
import org.junit.Assert;
import org.junit.Test;

public class SearchStaffTest extends LeaveManagementTest {

    @Test
    public void adminCanSearchStaff() throws InterruptedException {
        SearchStaffPage.goTo();
        Assert.assertTrue("Can't access to searchStaffPage",SearchStaffPage.isSearchStaffPage());
        SearchStaffPage.search("HIG","FRI").search();
        boolean researchIsEmpty = SearchStaffPage.notEmptyForSearch();
        Assert.assertTrue("search result is empty",researchIsEmpty);
    }
}
