package org.niu.leaves.jsp.servlet.model;

public class LeaveApplicationHistory {
    private int id;
    private String name;
    private String leaveType;
    private String fromDate;
    private String toDate;
    private Double days;
    private String status;
    private String approverName;
    private int managerId;
    private String userEmail;
    private String managerEmail;
    private String userEmailPassword;
    private String managerEmailPassword;

    public int getId() {
        return this.id;
    }

    public void setId(int value) {
        this.id = value;
    }

    public String getUserName() {
        return name;
    }

    public void setUserName(String value) {
        name = value;
    }

    public String getLeaveType() {
        return leaveType;
    }

    public void setLeaveType(String value) {
        leaveType = value;
    }

    public String getFromDate() {
        return fromDate;
    }

    public void setFromDate(String value) {
        fromDate = value;
    }

    public String getToDate() {
        return toDate;
    }

    public void setToate(String value) {
        toDate = value;
    }

    public Double getDays() {
        return days;
    }

    public void setDays(Double value) {
        days = value;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String value) {
        status = value;
    }

    public String getApproverName() {
        return approverName;
    }

    public void setApproverName(String value) {
        approverName = value;
    }

    public int getManagerId() {
        return managerId;
    }

    public void setManagerId(int value) {
        managerId = value;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String value) {
        userEmail = value;
    }

    public String getManagerEmail() {
        return managerEmail;
    }

    public void setManagerEmail(String value) {
        managerEmail = value;
    }

    public String getUserEmailPassword() {
        return userEmailPassword;
    }

    public void setUserEmailPassword(String userEmailPassword) {
        this.userEmailPassword = userEmailPassword;
    }

    public String getManagerEmailPassword() {
        return managerEmailPassword;
    }

    public void setManagerEmailPassword(String managerEmailPassword) {
        this.managerEmailPassword = managerEmailPassword;
    }
}
