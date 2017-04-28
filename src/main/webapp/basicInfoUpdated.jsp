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
                <form action="basicInfoUpdate.do" method="post">
                    <div class="table-responsive">
                        <table class="table table-striped">
                            <tr>
                                <td>First Name</td>
                                <td><input text="type" name="firstName" id="firstNameId" maxlength="10"
                                           value="${userWithDepartmentInfo.getUserFirstName()}"/>
                                </td>
                                <td>Last Name</td>
                                <td><input text="type" name="lastName" id="lastNameId"
                                           maxlength="10" value="${userWithDepartmentInfo.getUserLastName()}"/>
                                </td>
                            </tr>
                            <tr>
                                <td>Phone Number</td>
                                <td><input text="type" name="phoneNumber" id="phoneNumberId"
                                           maxlength="15" value="${userWithDepartmentInfo.getPhoneNumber()}"/>
                                </td>
                                <td>Physical Address</td>
                                <td><input text="type" name="physicalAddress" id="physicalAddressId"
                                           maxlength="30" value="${userWithDepartmentInfo.getPhysicalAddress()}"/>
                                </td>
                            </tr>
                        </table>
                    </div>
                    <div>
                        <div class="setting" align="center">
                            <button class="btn btn-primary" type="submit" name="updateBtn">Update</button>
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
