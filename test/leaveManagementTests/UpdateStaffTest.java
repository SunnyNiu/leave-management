package leaveManagementTests;

import leaveManagementAutomationFramework.Pages.*;
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
        CreateNewStaffPage.GoTo();
        CreateNewStaffPage.CreateStaff("ser", "ser")
                .WithDepartmentTitle("CUSTOMER SERVICE", "HELPDESK")
                .WithJoinDateBirthDate("2017-01-01", "2015-01-01")
                .WithFirstLastName("ser", "ser")
                .WithEmail("Reason@gmail.com")
                .Create();

        //Go to search
        SearchStaffPage.GoTo();
        SearchStaffPage.Search("ser","ser").Search();
        boolean researchIsEmpty = SearchStaffPage.NotEmptyForSearch();
        Assert.assertTrue("Search result is empty",researchIsEmpty);

        //Go to update
        UpdateStaffPage.linkChangedStaff();
        UpdateStaffPage.UpdateStaff(Department.IT.getName(), Title.SOFTWARE_ENGINEER.getName())
        .WithEmail("test@gmail.com","testPassword")
        .WithFlag("0").Change();

        String staffIsChanged = UpdateStaffPage.StaffIsChange();
        Assert.assertEquals("Update Staff failed", "Update basic info successfully!",staffIsChanged);

        //Go to search to check if update correct
        SearchStaffPage.Search("ser","ser").Search();

        //Remove that created staff
    }
}
