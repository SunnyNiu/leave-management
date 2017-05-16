package leaveManagementTests.SmokeTests;

import leaveManagementAutomationFramework.Pages.CreateNewStaffPage;
import leaveManagementTests.Utilities.LeaveManagementTest;
import org.junit.Assert;
import org.junit.Test;

public class CreateNewStaffPageTest extends LeaveManagementTest {

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
