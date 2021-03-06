package leaveManagementTests.CreateSearchAndUpdateAndRemoveStaff;

import Category.GoodTestCategory;
import leaveManagementAutomationFramework.Pages.SearchStaffPage;
import leaveManagementAutomationFramework.Pages.UpdateStaffPage;
import leaveManagementAutomationFramework.Selenium.Driver;
import leaveManagementAutomationFramework.Workflows.UserCreator;
import leaveManagementAutomationFramework.Workflows.UserUpdating;
import leaveManagementTests.Utilities.LeaveManagementTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.junit.experimental.categories.Category;

public class UpdateStaffTest extends LeaveManagementTest {
    //search Staff by First Name
    //search Staff by Last Name
    //search Staff by First, Last Name together
    //Can update department
    //Can update title
    //Can update email Address
    //Can update email password
    //Can update Flag

    @Test
    @Category(GoodTestCategory.class)
    public void createSearchUpdateStaff() throws InterruptedException {
        //create a new Staff
        UserCreator.createAUser();

        //Go to search
        SearchStaffPage.search(UserCreator.previousFirstName, UserCreator.previousLastName).search();
        boolean researchIsEmpty = SearchStaffPage.notEmptyForSearch();
        Assert.assertTrue(!researchIsEmpty, "search result is empty");
        Driver.wait(6000);

        //Go to update
        UpdateStaffPage.linkChangedStaff();

        //Update staff and inactive staff
        UserUpdating.updateAUser();
        String staffIsChanged = UpdateStaffPage.staffIsChange();
        Assert.assertEquals("Update Staff failed", "Update basic info successfully!", staffIsChanged);

        //Go to search to check if staff is removed
        SearchStaffPage.search(UserCreator.previousFirstName, UserCreator.previousLastName).search();
        UpdateStaffPage.linkChangedStaff();
        String staffFlag = UpdateStaffPage.getFlag();
        Assert.assertEquals("Remove staff failed", "0", staffFlag);
    }
}
