package leaveManagementAutomationFramework.Utilities;

import java.util.Random;

import static leaveManagementAutomationFramework.Utilities.Department.*;
import static leaveManagementAutomationFramework.Utilities.Title.*;

public class RandomCreator {

    public static String generateRandom(String[] str) {
        Random random = new Random();
        return str[random.nextInt(str.length)];
    }

    public static String[] login = new String[]{"boy", "cat", "dog", "rabbit", "baseball", "throw", "find", "scary", "code",
            "mustard"};

    public static String[] password = new String[]{"theboy", "thecat", "thedog", "therabbit", "thebaseball", "thethrow", "thefind", "thescary", "thecode",
            "themustard"};

    public static String[] department = new String[]{IT.getName(), HR.getName(), CUSTOMER_SERVICE.getName()};

    public static String[] title = new String[]{SOFTWARE_ENGINEER.getName(), MANAGER.getName(), CUSTOMER_SUPPORTER.getName(), HELPDESK.getName(), ACCOUNT.getName(), SALES.getName()};

    public static String[] joinDate = new String[]{"01-12-2010", "02-12-2010", "03-12-2010", "04-12-2010", "06-12-2010", "07-12-2010"};

    public static String[] birthDate = new String[]{"01-12-2010", "04-12-2010", "07-11-2010", "03-12-2010", "08-12-2010", "07-12-2010"};

    public static String[] firstName = new String[]{"firstTestA", "firstTestB", "firstTestC", "firstTestD", "firstTestE", "firstTestG"};

    public static String[] lastName = new String[]{"lastTestA", "lastTestB", "lastTestC", "lastTestD", "lastTestE", "lastTestG"};

    public static String[] email = new String[]{"lastTestA@gmail.com", "lastTestB@gmail.com", "lastTestC@gmail.com", "lastTestD@gmail.com", "lastTestE@gmail.com"};

    public static String[] emailPassword = new String[]{"lastTestA", "lastTestB", "lastTestC", "lastTestD", "lastTestE"};

    public static String[] leaveType = new String[]{"Annual Leave","Sick Leave","Parental leave","Bereavement leave","Other types of leave"};

    public static String[] reason = new String[]{"have a rest","have a travel","have a cold","visit parents","deal with car accident"};

    public static String[] from = new String[]{"15-05-2017"};
    //,"2017-05-16","2017-05-17"
    public static String[] to = new String[]{"15-05-2017"};
    //,"2017-05-16","2017-05-17"
    public static String[] days = new String[]{"1"};
    //,"2","3"
}
