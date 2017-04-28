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
        <div class="right">
            <div class="page-header">
                <div>
                    <ol class="breadcrumb right">
                        <li class="active">AddNewMember Welcome! ${userWithDepartmentInfo.getUserName()} ${today}</li>
                    </ol>
                </div>
            </div>
            <label>
                <%@ include file="error.jsp" %>
            </label>
            <label>${messages}</label>
            <form action="addNewMember.do" method="post">
                <div class="table-responsive">
                    <table class="table table-striped">
                        <tr>
                            <td>Login</td>
                            <td><input text="type" name="newLogin" id="nameId" maxlength="10"/>
                            </td>
                            <td>Password</td>
                            <td><input type="password" name="password" id="passwordId"
                                       maxlength="10"/>
                            </td>
                        </tr>
                        <tr>
                            <td>Department</td>
                            <td><select name="department" id="departmentId">
                                <c:forEach items="${departmentManagerList}" var="entry">
                                    <option value="${entry.getDepartmentId()}">
                                            ${entry.getDepartmentName()}
                                    </option>
                                </c:forEach>
                            </select></td>
                            <td>Title</td>
                            <td><select name="title" id="titleId">
                                <c:forEach items="${titleList}" var="entry">
                                    <option value="${entry.getId()}">
                                            ${entry.getTitle()}
                                    </option>
                                </c:forEach></select></td>
                        </tr>
                        <tr>
                            <td>Join Date</td>
                            <td><input type="date" pattern="dd/MM/yyyy" name="joinDate"/></td>
                            <td>Birth Date</td>
                            <td><input type="date" pattern="dd/MM/yyyy" name="birthDate"/></td>
                        </tr>
                        <tr>
                            <td>First Name</td>
                            <td><input text="type" name="firstName" id="firstName"
                                       maxlength="10"/>
                            </td>
                            <td>Last Name</td>
                            <td><input type="type" name="lastName" id="lastName"
                                       maxlength="10"/>
                            </td>
                        </tr>
                        <tr>
                            <td>Office Email</td>
                            <td><input type="email" name="email" maxlength="25" width="15px"><span class="glyphicon glyphicon-envelope"></span></td>
                        </tr>
                    </table>
                </div>
                <br>
                <div>
                    <div class="setting" align="center">
                        <button class="btn btn-primary" type="submit" name="addBtn">Submit</button>
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