package testSuite;

import Category.BadTestCategory;
import Category.GoodTestCategory;
import leaveManagementTests.CreateSearchAndUpdateAndRemoveStaff.UpdateStaffTest;
import leaveManagementTests.StaffApplyLeaveAndManagerApproveIt.StaffApplyLeaveAndManagerApprovesIt;
import org.junit.experimental.categories.Categories;
import org.junit.experimental.categories.Categories.IncludeCategory;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Categories.class)
@IncludeCategory(GoodTestCategory.class)
@Suite.SuiteClasses({StaffApplyLeaveAndManagerApprovesIt.class,
        UpdateStaffTest.class})
@Categories.ExcludeCategory(BadTestCategory.class)
public class LeaveManagementGoodTestSuite {
}
