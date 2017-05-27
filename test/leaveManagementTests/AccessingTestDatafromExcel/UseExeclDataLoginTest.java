package leaveManagementTests.AccessingTestDatafromExcel;


import jxl.read.biff.BiffException;
import leaveManagementAutomationFramework.Navigation.AllNavigation;
import leaveManagementAutomationFramework.Pages.LoginPage;
import leaveManagementAutomationFramework.Pages.MainPage;
import leaveManagementAutomationFramework.Utilities.ExcelReader;
import leaveManagementAutomationFramework.Utilities.LoginTestData;
import leaveManagementTests.Utilities.LeaveManagementTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.ArrayList;

import static org.testng.AssertJUnit.assertTrue;

public class UseExeclDataLoginTest extends LeaveManagementTest {

    @Test
    public void loginByExcelData() throws IOException, BiffException, InterruptedException {

        ArrayList<LoginTestData> list = ExcelReader.readLogin("Sheet1", "C://Users//Sunny//leave-management//test//leaveManagementTests//ExcelFiles//LoginTestData.xlsx");
        for (int i = 0; i < list.size(); i++) {
            LoginPage.goTo();
            LoginPage.loginAs(list.get(i).getUsername())
                    .withPassword(list.get(i).getPassword())
                    .login();
            Boolean isAt = MainPage.isAt();
            assertTrue("Failed to login", isAt);
            AllNavigation.Logout.select();
        }
    }
}
