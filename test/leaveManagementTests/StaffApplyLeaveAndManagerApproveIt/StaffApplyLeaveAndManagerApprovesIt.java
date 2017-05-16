package leaveManagementTests.StaffApplyLeaveAndManagerApproveIt;

import leaveManagementAutomationFramework.Pages.ApplyLeavePage;
import leaveManagementAutomationFramework.Pages.LoginPage;
import leaveManagementTests.Utilities.LeaveManagementTest;
import org.junit.Assert;
import org.junit.Test;

import static leaveManagementAutomationFramework.Workflows.LeaveApplicationCreator.createAndSubmitApplication;

public class StaffApplyLeaveAndManagerApprovesIt extends LeaveManagementTest {

    @Test
    public void StaffApplyLeaveAndManagerApprovesIt() throws InterruptedException {
        LoginPage.goTo();
        LoginPage.loginAs("SunnyN")
                .withPassword("Sun234")
                .login();

        //Submit leave Application
        ApplyLeavePage.goTo();
        createAndSubmitApplication();
        Boolean isSubmitSuccess = ApplyLeavePage.isSubmitApplication();
        Assert.assertTrue("Submit Failed",isSubmitSuccess);

        //Manager approve Application
    }
}
