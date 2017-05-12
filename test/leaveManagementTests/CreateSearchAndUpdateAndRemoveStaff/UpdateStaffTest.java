package leaveManagementTests.CreateSearchAndUpdateAndRemoveStaff;

import leaveManagementAutomationFramework.Pages.Department;
import leaveManagementAutomationFramework.Pages.SearchStaffPage;
import leaveManagementAutomationFramework.Pages.Title;
import leaveManagementAutomationFramework.Pages.UpdateStaffPage;
import leaveManagementAutomationFramework.Selenium.Driver;
import leaveManagementAutomationFramework.Workflows.UserCreator;
import leaveManagementAutomationFramework.Workflows.UserUpdating;
import leaveManagementTests.Utilities.LeaveManagementTest;
import org.junit.Assert;
import org.junit.Test;

public class UpdateStaffTest extends LeaveManagementTest {
    //Search Staff by First Name
    //Search Staff by Last Name
    //Search Staff by First, Last Name together
    //Can update Department
    //Can update Title
    //Can update Email Address
    //Can update Email Password
    //Can update Flag

    @Test
    public void Create_Search_Update() throws InterruptedException {
        //Create a new Staff
        UserCreator.CreateAUser();

        //Go to search
        SearchStaffPage.GoTo();
        SearchStaffPage.Search(UserCreator.previousFirstName, UserCreator.previousLastName).Search();
        boolean researchIsEmpty = SearchStaffPage.NotEmptyForSearch();
        Assert.assertTrue("Search result is empty",researchIsEmpty);
        Driver.wait(6000);

        //Go to update
        UpdateStaffPage.linkChangedStaff();

        //Update staff and inactive staff
        UserUpdating.UpdateAUser();
        String staffIsChanged = UpdateStaffPage.StaffIsChange();
        Assert.assertEquals("Update Staff failed", "Update basic info successfully!",staffIsChanged);

        //Go to search to check if staff is removed
        SearchStaffPage.Search(UserCreator.previousFirstName, UserCreator.previousLastName).Search();
        UpdateStaffPage.linkChangedStaff();
        String staffFlag = UpdateStaffPage.getFlag();
        Assert.assertEquals("Remove staff failed","0",staffFlag);

        Driver.wait(6000);
    }
}
