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
        <div>
            <div class="page-header">
                <div>
                    <ol class="breadcrumb right">
                        <li class="active">ChangePersonalInfo
                            Welcome! ${userWithDepartmentInfo.getUserName()} ${today}</li>
                    </ol>
                </div>
            </div>
            <label>
                <%@ include file="error.jsp" %>
            </label>
            <label>${messages}</label>
            <form action="basicInfoUpdate.do" method="post" class="form-horizontal table-bordered">
                <div id="borderPadding">
                    <div class="form-group" >
                        <label for="firstNameId"
                               class="col-sm-5 col-md-5 control-label">First
                            Name:</label>
                        <div class="col-sm-4 col-md-4">
                            <input type="type" class="form-control" name="firstName" id="firstNameId"
                                   maxlength="10" value="${userWithDepartmentInfo.getUserFirstName()}"/>
                        </div>
                        <div class="col-sm-3 col-md-3"></div>
                    </div>
                    <div class="form-group">
                        <label for="lastNameId"
                               class="col-sm-5 col-md-5 control-label">Last
                            Name:</label>
                        <div class="col-sm-4 col-md-4">
                            <input type="type" class="form-control" name="lastName" id="lastNameId"
                                   maxlength="10" value="${userWithDepartmentInfo.getUserLastName()}"/>
                        </div>
                        <div class="col-sm-3 col-md-3"></div>
                    </div>
                    <div class="form-group">
                        <label for="phoneNumberId"
                               class="col-sm-5 col-md-5 control-label">Phone
                            Number:</label>
                        <div class="col-sm-4 col-md-4">
                            <input type="type" class="form-control" name="phoneNumber" id="phoneNumberId"
                                   maxlength="15" value="${userWithDepartmentInfo.getPhoneNumber()}"/>
                        </div>
                        <div class="col-sm-3 col-md-3"></div>
                    </div>
                    <div class="form-group">
                        <label for="physicalAddressId"
                               class="col-sm-5 col-md-5 control-label">Physical
                            Address:</label>
                        <div class="col-sm-4 col-md-4">
                            <input type="type" class="form-control" name="physicalAddress"
                                   id="physicalAddressId"
                                   maxlength="30" value="${userWithDepartmentInfo.getPhysicalAddress()}"/>
                        </div>
                        <div class="col-sm-3 col-md-3"></div>
                    </div>
                    <div class="col-md-7 col-md-offset-2 col-sm-7 col-sm-offset-2">
                        <button class="btn btn-primary pull-right" type="submit" name="updateBtn">Update</button>
                    </div>
                </div>
            </form>
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
