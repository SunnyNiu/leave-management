package leaveManagementTests.StaffApplyLeaveAndManagerApproveIt;

import Category.GoodTestCategory;
import leaveManagementAutomationFramework.Navigation.AllNavigation;
import leaveManagementAutomationFramework.Pages.ApplyLeavePage;
import leaveManagementAutomationFramework.Pages.LoginPage;
import leaveManagementAutomationFramework.Pages.YourDecisionPage;
import leaveManagementTests.Utilities.LeaveManagementTest;
import org.junit.Assert;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import static leaveManagementAutomationFramework.Workflows.LeaveApplicationCreator.createAndSubmitApplication;

public class StaffApplyLeaveAndManagerApprovesIt extends LeaveManagementTest {

    @Test
    @Category(GoodTestCategory.class)
    public void StaffApplyLeaveAndManagerApprovesIt() throws InterruptedException {
        AllNavigation.Logout.select();
        LoginPage.goTo();
        LoginPage.loginAs("SunnyN")
                .withPassword("Sun234")
                .login();

        //Submit leave Application
        ApplyLeavePage.goTo();
        createAndSubmitApplication();
        Boolean isSubmitSuccess = ApplyLeavePage.isSubmitApplication();
        Assert.assertTrue("Submit Failed",isSubmitSuccess);
        AllNavigation.Logout.select();

        //Manager approve Application
        LoginPage.goTo();
        LoginPage.loginAs("AmieeS")
                .withPassword("Ami123")
                .login();
        YourDecisionPage.goTo();
        YourDecisionPage.searchStatus("Pending");

        //Not completed
        YourDecisionPage.chooseThatOneApplied();
        YourDecisionPage.approve();
        YourDecisionPage.confirm();
        Boolean approved = YourDecisionPage.approvedSuccess();
        Assert.assertTrue(true);
        //Your decision is done Email Successfully and only waiting for your manager's approval
    }
}
