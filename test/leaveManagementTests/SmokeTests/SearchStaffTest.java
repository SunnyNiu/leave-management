package leaveManagementTests.SmokeTests;

import leaveManagementAutomationFramework.Pages.SearchStaffPage;
import leaveManagementTests.Utilities.LeaveManagementTest;
import org.junit.Assert;
import org.junit.Test;

public class SearchStaffTest extends LeaveManagementTest {

    @Test
    public void Admin_Can_Search_Staff() throws InterruptedException {
        SearchStaffPage.GoTo();
        Assert.assertTrue("Can't access to searchStaffPage",SearchStaffPage.IsSearchStaffPage());
        SearchStaffPage.Search("HIG","FRI").Search();
        boolean researchIsEmpty = SearchStaffPage.NotEmptyForSearch();
        Assert.assertTrue("Search result is empty",researchIsEmpty);
    }
}
