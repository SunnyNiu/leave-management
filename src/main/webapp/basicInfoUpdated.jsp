<%--
  Created by IntelliJ IDEA.
  User: Sunny
  Date: 9/04/2017
  Time: 1:24 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <style type="text/css">@import "style.css";</style>
</head>
<body>
<div style="text-align:center; vertical-align:middle" class="formdiv">
    <div id="header">
        <h1>Leave Management System</h1>
    </div>
    <div>
        <div id="parent">
            <div class="left">
                <%@ include file="menus.jsp" %>
            </div>
            <div class="right">
                <div align="right">
                    <header align="right">Welcome! ${userWithDepartmentInfo.getUserName()} ${today}</header>
                </div>
                <br>
                <br>
                <label>
                    <%@ include file="error.jsp" %>
                </label>
                <label>${messages}</label>
                <form action="basicInfoUpdate.do" method="post">
                    <div align="center">
                        <table>
                            <tr>
                                <td>First Name</td>
                                <td><input text="type" name="firstName" id="firstNameId" maxlength="10" value="${userWithDepartmentInfo.getUserFirstName()}" />
                                </td>
                                <td>Last Name</td>
                                <td><input text="type" name="lastName" id="lastNameId"
                                           maxlength="10" value="${userWithDepartmentInfo.getUserLastName()}" />
                                </td>
                            </tr>
                            <tr>
                                <td>Phone Number</td>
                                <td><input text="type" name="phoneNumber" id="phoneNumberId"
                                           maxlength="15" value="${userWithDepartmentInfo.getPhoneNumber()}" />
                                </td>
                                <td>Physical Address</td>
                                <td><input text="type" name="physicalAddress" id="physicalAddressId"
                                           maxlength="30" value="${userWithDepartmentInfo.getPhysicalAddress()}" />
                                </td>
                            </tr>
                        </table>
                        <button type="submit" name="updateBtn">Update</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
    <div id="footer">
        Copyright © xxx.com
    </div>
</div>
</body>
</html>
