<%--
  Created by IntelliJ IDEA.
  User: Sunny
  Date: 1/03/2017
  Time: 5:10 PM
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
                <form action="updatePassword.do" method="post">
                    <div align="center">
                        <table>
                            <tr>
                                <td>Username</td>
                                <td><input disabled text="type" name="username" id="nameId"
                                           value="${userWithDepartmentInfo.getUserName()}"/></td>
                            </tr>
                            <tr>
                                <td>OldPassword</td>
                                <td><input type="password" name="oldPassword" id="oldPasswordId"
                                           maxlength="10" required/>
                            </tr>
                            <tr>
                                <td>NewPassword</td>
                                <td><input type="password" name="newPassword" id="newPasswordId"
                                           maxlength="10" required/>
                            </tr>
                            <td>ConfirmNewPassword</td>
                            <td><input type="password" name="newPasswordConfirmation" id="newPasswordConfirmationId"
                                       maxlength="10" required/>
                            </td>
                            </tr>
                        </table>
                    </div>
                    <br>
                    <div>
                        <div>
                            <button type="submit" name="btnUpdate">Update</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>

</div>
<div id="footer">
    Copyright © xxx.com
</div>
</div>
</body>

</body>
</html>
