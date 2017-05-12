package leaveManagementTests.SmokeTests;

import leaveManagementAutomationFramework.Pages.CreateNewStaffPage;
import leaveManagementTests.Utilities.LeaveManagementTest;
import org.junit.Assert;
import org.junit.Test;

public class CreateNewStaffPageTest extends LeaveManagementTest {

    @Test
    public void Can_Create_A_New_Staff() throws InterruptedException {
        CreateNewStaffPage.GoTo();
        CreateNewStaffPage.CreateStaff("Mr","Snow123")
                .WithDepartmentTitle("CUSTOMER SERVICE","HELPDESK")
                .WithJoinDateBirthDate("2015-01-01","2015-01-01")
                .WithFirstLastName("Snow","Pai")
                .WithEmail("test@gmail.com")
                .Create();
        String staffIsCreatedMessage = CreateNewStaffPage.StaffIsCreated();
        Assert.assertEquals("Create New Staff failed", "Add new member successfully!",staffIsCreatedMessage);
    }
}
