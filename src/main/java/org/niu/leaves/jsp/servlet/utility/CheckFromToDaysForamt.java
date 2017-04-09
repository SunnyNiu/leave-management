package org.niu.leaves.jsp.servlet.utility;

import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * Created by Sunny on 31/03/2017.
 */
public class CheckFromToDaysForamt {
    public void checkDateDaysFormat(String from, String to, String totalDay) throws ParseException,NumberFormatException {
        new SimpleDateFormat("yyyy-MM-dd").parse(from);
        new SimpleDateFormat("yyyy-MM-dd").parse(to);
        Double.parseDouble(totalDay);
    }

    public void checkDateFormat(String from, String to) throws ParseException {
        new SimpleDateFormat("yyyy-MM-dd").parse(from);
        new SimpleDateFormat("yyyy-MM-dd").parse(to);
    }
}
