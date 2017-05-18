package leaveManagementAutomationFramework.Pages;

import leaveManagementAutomationFramework.Navigation.AllNavigation;
import leaveManagementAutomationFramework.Selenium.Driver;
import leaveManagementAutomationFramework.Workflows.LeaveApplicationCreator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class YourDecisionPage {

    public static void goTo() {
        AllNavigation.YourDecision.select();
    }

    public static void searchStatus(String pending) {
        Select dropdown = new Select(Driver.Instance.findElement(By.id("statusId")));
        dropdown.selectByVisibleText(pending);
        Driver.Instance.findElement(By.xpath("//button[contains(text(),'Search')]")).click();
    }

    public static void chooseThatOneApplied() {
        int pages = findPagesInTotal();
        String chosenLeavetype = LeaveApplicationCreator.chosenLeavetype;
        String chosenFrom = LeaveApplicationCreator.chosenFrom;
        String chosenTo = LeaveApplicationCreator.chosenTo;
        String chosenDays = LeaveApplicationCreator.chosenDays;

        for (int i = 1; i <= pages; i++) {
            String href = "approveRejectWithdrawn.do?page=" + i + "&selectedStatus=Pending";
            String link = "a[href='" + href + "']";
            Driver.Instance.findElement(By.cssSelector(link)).click();

            WebElement baseTable = Driver.Instance.findElement(By.tagName("table"));

            List<WebElement> trCollection = baseTable.findElements(By.xpath("//tr"));

            for (int j = 1; j < trCollection.size(); j++) {
                String xpath = "//tr[" + j + "]";
                WebElement tr = baseTable.findElement(By.xpath(xpath));
                List<WebElement> tdCollection = tr.findElements(By.xpath("//td"));
                String leaveType = tdCollection.get(4).getText();
                String from = tdCollection.get(6).getText();
                String to = tdCollection.get(8).getText();
                String days = tdCollection.get(10).getText();
                if (leaveType.contains(chosenLeavetype) && from.contains(chosenFrom) && to.contains(chosenTo) && Double.parseDouble(days)==Double.parseDouble(chosenDays))
                    break;
            }
        }
    }

    private static int findPagesInTotal() {
        List<WebElement> allElements = Driver.Instance.findElements(By.cssSelector(".pagination>li"));
        int pageNumber = allElements.size();
        int pages;
        if (pageNumber > 2) {
            pages = allElements.size() - 2;
        } else {
            pages = 1;
        }
        return pages;
    }

    public static void approve() {
    }

    public static void confirm() {
    }

    public static Boolean approvedSuccess() {
        return true;
    }
}
