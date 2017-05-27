package leaveManagementAutomationFramework.Utilities;


import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

public class ExcelReader {

    public static ArrayList<LoginTestData> readLogin(String sheetName, String ExcelPath) {
        try {
            FileInputStream fis = new FileInputStream(ExcelPath);

            XSSFWorkbook wb = new XSSFWorkbook(fis);

            XSSFSheet sheet = wb.getSheet(sheetName);

            ArrayList<LoginTestData> loginTestDataArrayList = new ArrayList<>();
            for (int count = 1; count <= sheet.getLastRowNum(); count++) {
                XSSFRow row = sheet.getRow(count);
                LoginTestData loginTestData = new LoginTestData();
                loginTestData.setBrowser(row.getCell(0).toString());
                loginTestData.setUsername(row.getCell(1).toString());
                loginTestData.setPassword(row.getCell(2).toString());
                loginTestDataArrayList.add(loginTestData);
            }

            fis.close();
            return loginTestDataArrayList;
        } catch (IOException e) {
            System.out.println("Test data file not found");
            return null;
        }
    }
}


