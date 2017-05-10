package leaveManagementTests;

import leaveManagementAutomationFramework.CreateNewStaff;
import leaveManagementAutomationFramework.Driver;
import leaveManagementAutomationFramework.LoginPage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CreateNewStaffTest {
    @Before
    public void Init() {
        Driver.Initialize();
    }

    @Test
    public void Can_Create_A_New_Staff() throws InterruptedException {
        LoginPage.GoTo();
        LoginPage.LoginAs("William")
                .WithPassword("Wil123")
                .Login();
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

    @After
    public void Cleanup() {
        Driver.Close();
    }
}
