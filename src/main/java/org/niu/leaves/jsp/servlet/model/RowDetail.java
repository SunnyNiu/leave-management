package org.niu.leaves.jsp.servlet.model;


/**
 * Created by Sunny on 18/02/2017.
 */
public class RowDetail {

    private String fromDate;
    private String toDate;
    private String totalDays;

    public String getFromDate() {
        return this.fromDate;
    }

    public void setFromDate(String fromDate) {
        this.fromDate = fromDate;
    }

    public String getToDate() {
        return this.toDate;
    }

    public void setToDate(String toDate) {
        this.toDate = toDate;
    }

    public String getTotalDays() {
        return totalDays;
    }

    public void setTotalDays(String day) {
        this.totalDays = day;
    }
}
