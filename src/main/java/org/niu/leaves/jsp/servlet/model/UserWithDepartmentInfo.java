package org.niu.leaves.jsp.servlet.model;


public class UserWithDepartmentInfo {

    private int userId;
    private String login;
    private String userFirstName;
    private String userLastName;
    private String username;
    private String departmentId;
    private String departmentName;
    private String birthday;
    private String joinDate;
    private int titleId;
    private String title;
    private int managerUserId;
    private String managerName;
    private String userEmail;
    private String userEmailPassword;
    private String managerEmail;
    private String managerEmailPassword;
    private String phoneNumber;
    private String physicalAddress;
    private String userPassword;
    private int flag;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int value) {
        userId = value;
    }


    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getUserFirstName() {
        return userFirstName;
    }

    public void setUserFirstName(String userFirstName) {
        this.userFirstName = userFirstName;
    }

    public String getUserLastName() {
        return userLastName;
    }

    public void setUserLastName(String userLastName) {
        this.userLastName = userLastName;
    }

    public String getUserName() {
        return username;
    }

    public void setUserName(String value) {
        username = value;
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String value) {
        departmentId = value;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String value) {
        departmentName = value;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String value) {
        birthday = value;
    }

    public String getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(String value) {
        joinDate = value;
    }

    public int getTitleId() {
        return titleId;
    }

    public void setTitleId(int titleId) {
        this.titleId = titleId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String value) {
        title = value;
    }

    public int getManagerUserId() {
        return managerUserId;
    }

    public void setManagerUserId(int managerUserId) {
        this.managerUserId = managerUserId;
    }

    public String getManagerName() {
        return managerName;
    }

    public void setManagerName(String value) {
        managerName = value;
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
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPhysicalAddress() {
        return physicalAddress;
    }

    public void setPhysicalAddress(String physicalAddress) {
        this.physicalAddress = physicalAddress;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }
}
