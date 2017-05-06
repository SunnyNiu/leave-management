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
<div>
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
            <div align="center">
                <div align="center">
                    <label>${messages}</label>
                    <label>
                        <%@ include file="error.jsp" %>
                    </label>
                </div>

                <form action="updatePassword.do" method="post" class="form-horizontal table-bordered">
                    <div id="borderPadding">
                        <div class="form-group">
                            <label for="nameId" class="col-sm-5 col-md-5 control-label">Username:</label>
                            <div class="col-sm-4 col-md-4">
                                <label type="text" class="control-label pull-left" id="nameId">${userWithDepartmentInfo.getUserName()}</label>
                            </div>
                            <div class="col-sm-3 col-md-3"></div>
                        </div>
                        <div class="form-group">
                            <label for="oldPasswordId" class="col-sm-5 col-md-5 control-label">Old Password:</label>
                            <div class="col-sm-4 col-md-4">
                                <input type="password" class="form-control" name="oldPassword" id="oldPasswordId"
                                       maxlength="10" required/>
                            </div>
                            <div class="col-sm-3 col-md-3"></div>
                        </div>
                        <div class="form-group">
                            <label for="newPasswordId" class="col-sm-5 col-md-5 control-label">New Password:</label>
                            <div class="col-sm-4 col-md-4">
                                <input type="password" class="form-control" name="newPassword" id="newPasswordId"
                                       maxlength="10" required/>
                            </div>
                            <div class="col-sm-3 col-md-3"></div>
                        </div>
                        <div class="form-group">
                            <label for="newPasswordConfirmationId" class="col-sm-5 col-md-5 control-label">Confirm New
                                Password:</label>
                            <div class="col-sm-4 col-md-4">
                                <input type="password" name="newPasswordConfirmation" class="form-control"
                                       id="newPasswordConfirmationId" maxlength="10" required/>
                            </div>
                            <div class="col-sm-3 col-md-3"></div>
                        </div>
                        <div>
                            <div class="col-md-7 col-md-offset-2 col-sm-7 col-sm-offset-2">
                                <button class="btn btn-primary pull-right" type="submit" name="btnUpdate">Update
                                </button>
                            </div>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </section>
    <div id="footer" align="center">
        Copyright @www.uc.cn.com
    </div>
</div>
<script src="js/jquery-2.0.3.min.js"></script>
<script src="js/bootstrap.min.js"></script>
</body>
</html>
