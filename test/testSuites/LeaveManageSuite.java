package testSuites;

import leaveManagementTests.SmokeTests.*;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        LoginTest.class,
        PersonalInfoTest.class,
        ApplyLeaveTest.class,
        SearchStaffTest.class,
        CreateNewStaffTest.class,
        CreateNewStaffTest.class,
        LeaveHistoryTest.class,
        UpdateMemeberTest.class,
        ChangePasswordTest.class,
        //UpdateStaffTest.class,
        //StaffApplyLeaveAndManagerApprovesIt.class
})
public class LeaveManageSuite {
}
