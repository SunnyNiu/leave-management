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
        <div>
            <div class="page-header">
                <div>
                    <ol class="breadcrumb right">
                        <li class="active">MainPage Welcome! ${userWithDepartmentInfo.getUserName()} ${today}</li>
                    </ol>
                </div>
            </div>
            <div align="center">
                <label>
                    <%@ include file="error.jsp" %>
                </label>
                <div class="table-responsive">
                    <table class="table table-striped table-bordered">
                        <tr>
                            <td rowspan="10">
                                <form action="upload.do" method="post" enctype="multipart/form-data" class="setting">
                                    <table align="left" class="setting">
                                        <tr><input class="btn btn-primary" type="file" name="photo"/></tr>
                                        <br/>
                                        <tr><input class="btn btn-primary" type="submit"/></tr>
                                        <br/>
                                        <tr><img height="200" width="200"
                                                 src="http://localhost:8092/${userWithDepartmentInfo.getUserName()}profile.jpg">
                                        </tr>
                                    </table>
                                </form>
                            </td>
                        </tr>
                        <tr>
                            <td align="left"><label>Name:</label></td>
                            <td><input type="text" value="${userWithDepartmentInfo.getUserName()}" disabled></td>
                        </tr>
                        <tr>
                            <td align="left"><label>Title:</label></td>
                            <td><input type="text" value="${userWithDepartmentInfo.getTitle()}" disabled></td>
                        </tr>
                        <tr>
                            <td align="left"><label>Birthday Date:</label></td>
                            <td><input type="text" value="${userWithDepartmentInfo.getBirthday()}" disabled></td>
                        </tr>
                        <tr>
                            <td align="left"><label>Join Date:</label></td>
                            <td><input type="text" value="${userWithDepartmentInfo.getJoinDate()}" disabled></td>
                        </tr>
                        <tr>
                            <td align="left"><label>Department:</label></td>
                            <td><input type="text" value="${userWithDepartmentInfo.getDepartmentName()}" disabled>
                            </td>
                        </tr>
                        <tr>
                            <td align="left"><label>Manager:</label></td>
                            <td><input type="text" value="${userWithDepartmentInfo.getManagerName()}" disabled></td>
                        </tr>
                    </table>
                </div>
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
