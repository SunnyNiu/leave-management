package leaveManagementTests.SmokeTests;

import leaveManagementAutomationFramework.Pages.CreateNewStaffPage;
import leaveManagementTests.Utilities.LeaveManagementTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateNewStaffTest extends LeaveManagementTest {

    @Test
    public void canCreateANewStaff() throws InterruptedException {
        CreateNewStaffPage.goTo();
        CreateNewStaffPage.createStaff("Mr","Snow123")
                .withDepartmentTitle("CUSTOMER SERVICE","HELPDESK")
                .withJoinDateBirthDate("2015-01-01","2015-01-01")
                .withFirstLastName("Snow","Pai")
                .withEmail("test@gmail.com")
                .create();
        String staffIsCreatedMessage = CreateNewStaffPage.StaffIsCreated();
        Assert.assertEquals("create New Staff failed", "Add new member successfully!",staffIsCreatedMessage);
    }
}
