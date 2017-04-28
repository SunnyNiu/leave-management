<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Leave Management</title>
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/cerulean.bootstrap.min.css">
    <link rel="stylesheet" href="css/style.css" rel="stylesheet"/>
</head>
<body>
<div class="form-inline">
    <header class="container">
        <%@ include file="menus.jsp" %>
    </header>
    <section id="body" class="container">
        <div id="parent">
            <div class="page-header">
                <div>
                    <ol class="breadcrumb right">
                        <li class="active">ChangePassword
                            Welcome! ${userWithDepartmentInfo.getUserName()} ${today}</li>
                    </ol>
                </div>
            </div>
            <div>
                <label>
                    <%@ include file="error.jsp" %>
                </label>
                <label>${messages}</label>
                <form action="updatePassword.do" method="post">
                    <div class="table-responsive">
                        <table class="table table-striped">
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
                        <div class="setting" align="center">
                            <button class="btn btn-primary" type="submit" name="btnUpdate">Update</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </section>
    <div id="footer" align="center">
        Copyright © xxx.com
    </div>
</div>
<script src="js/jquery-2.0.3.min.js"></script>
<script src="js/bootstrap.min.js"></script>
</body>
</html>
