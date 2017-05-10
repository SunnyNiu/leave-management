package leaveManagementTests;

import leaveManagementAutomationFramework.CreateNewStaff;
import org.junit.Assert;
import org.junit.Test;

public class CreateNewStaffTest extends LeaveManagementTest{

    @Test
    public void Can_Create_A_New_Staff() throws InterruptedException {
        CreateNewStaff.GoTo();
        CreateNewStaff.CreateStaff("Mr","Snow123")
                .WithDepartmentTitle("CUSTOMER SERVICE","HELPDESK")
                .WithJoinDateBirthDate("2015-01-01","2015-01-01")
                .WithFirstLastName("Snow","Pai")
                .WithEmail("Snow@gmail.com")
                .Create();
        String staffIsCreatedMessage = CreateNewStaff.StaffIsCreated();
        Assert.assertEquals("Create New Staff failed", "Add new member successfully!",staffIsCreatedMessage);
    }
}
