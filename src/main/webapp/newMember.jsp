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
                        <li class="active">AddNewMember Welcome! ${userWithDepartmentInfo.getUserName()} ${today}</li>
                    </ol>
                </div>
            </div>
            <label>
                <%@ include file="error.jsp" %>
            </label>
            <label>${messages}</label>
            <form action="addNewMember.do" method="post" class="table-bordered">
                <div class="table-responsive" id="borderPadding">
                    <div class="form-group">
                        <label for="nameId" class="col-sm-2 col-sm-offset-2 col-md-2 col-md-offset-2 control-label">Login:</label>
                        <div class="col-sm-3 col-md-3">
                            <input type="text" class="form-control" name="newLogin" id="nameId" maxlength="10"/>
                        </div>

                        <label for="passwordId" class="col-sm-2 col-md-2 control-label">Password:</label>
                        <div class="col-sm-3 col-md-3">
                            <input type="password" class="form-control" name="password" id="passwordId"
                                   maxlength="10"/>
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="departmentId"
                               class="col-sm-2 col-sm-offset-2 col-md-2 col-md-offset-2 control-label">Department:</label>
                        <div class="col-sm-3 col-md-3">
                            <select name="department" id="departmentId" class="form-control">
                                <c:forEach items="${departmentManagerList}" var="entry">
                                    <option value="${entry.getDepartmentId()}">
                                            ${entry.getDepartmentName()}
                                    </option>
                                </c:forEach>
                            </select>
                        </div>
                        <label for="titleId" class="col-sm-2 col-md-2 control-label">Title:</label>
                        <div class="col-sm-3 col-md-3">
                            <select name="title" id="titleId" class="form-control">
                                <c:forEach items="${titleList}" var="entry">
                                    <option value="${entry.getId()}">
                                            ${entry.getTitle()}
                                    </option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="joinDate" class="col-sm-2 col-sm-offset-2 col-md-2 col-md-offset-2 control-label">Join
                            Date:</label>
                        <div class="col-sm-3 col-md-3">
                            <input type="date" class="form-control" pattern="dd/MM/yyyy" name="joinDate"
                                   id="joinDate"/>
                        </div>
                        <label for="birthDate" class="col-sm-2 col-md-2 control-label">Birth Date:</label>
                        <div class="col-sm-3 col-md-3">
                            <input type="date" class="form-control" pattern="dd/MM/yyyy" name="birthDate"
                                   id="birthDate"/>
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="firstName" class="col-sm-2 col-sm-offset-2 col-md-2 col-md-offset-2 control-label">First
                            Name:</label>
                        <div class="col-sm-3 col-md-3">
                            <input type="text" class="form-control" name="firstName" id="firstName" maxlength="10"/>
                        </div>
                        <label for="lastName" class="col-sm-2 col-md-2 control-label">Last Name:</label>
                        <div class="col-sm-3 col-md-3">
                            <input type="text" class="form-control" name="lastName" id="lastName" maxlength="10"/>
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="email" class="col-sm-2 col-sm-offset-2 col-md-2 col-md-offset-2 control-label">Email
                            Address:</label>
                        <div class="col-sm-8 col-md-8">
                            <input type="email" class="form-control" name="email" id="email" maxlength="25"
                                   width="15px">
                        </div>
                    </div>
                </div>
                <div align="center">
                    <button class="btn btn-primary" type="submit" name="addBtn">Submit</button>
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