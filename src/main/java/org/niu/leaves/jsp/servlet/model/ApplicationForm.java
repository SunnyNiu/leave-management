package org.niu.leaves.jsp.servlet.model;

import java.util.ArrayList;

/**
 * Created by Sunny on 28/03/2017.
 */
public class ApplicationForm {
    private int userId;
    private String name;
    private int leaveTypeId;
    private String applicationLeaveType;
    private int managerId;
    private String managerName;
    private String reason;
    private String department;
    private String userEmail;
    private String managerEmail;
    private String userEmailPassword;
    private String managerEmailPassword;
    private String status;
    private ArrayList<RowDetail> leaveList;

    public int getUserId() {
        return this.userId;
    }

    public void setUserId(int value) {
        this.userId = value;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String value) {
        this.name = value;
    }

    public int getLeaveTypeId() {
        return this.leaveTypeId;
    }

    public void setLeaveTypeId(int value) {
        this.leaveTypeId = value;
    }

    public String getApplicationLeaveType() {
        return this.applicationLeaveType;
    }

    public void setApplicationLeaveType(String value) {
        this.applicationLeaveType = value;
    }

    public int getManagerId() {
        return this.managerId;
    }

    public void setManagerId(int value) {
        this.managerId = value;
    }

    public String getManagerName() {
        return this.managerName;
    }

    public void setManagerName(String value) {
        this.managerName = value;
    }

    public String getReason() {
        return this.reason;
    }

    public void setReason(String value) {
        this.reason = value;
    }

    public String getDepartment() {
        return this.department;
    }

    public void setDepartment(String value) {
        this.department = value;
    }

    public String getUserEmail() {
        return this.userEmail;
    }

    public void setUserEmail(String value) {
        this.userEmail = value;
    }

    public String getManagerEmail() {
        return this.managerEmail;
    }

    public void setManagerEmail(String value) {
        this.managerEmail = value;
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

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ArrayList<RowDetail> getLeaveList() {
        return this.leaveList;
    }

    public void setLeaveList(ArrayList<RowDetail> value) {
        this.leaveList = value;
    }
}
