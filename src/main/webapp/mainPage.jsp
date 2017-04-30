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

            <div class="col-md-12">
                <div class="col-md-6 col-lg-6 col-md-offset-4 col-lg-offset-4">
                    <table class="table table-bordered table-responsive">
                        <tbody>
                        <tr>
                            <th style="text-align: right">
                                Name:
                            </th>
                            <td>
                                ${userWithDepartmentInfo.getUserName()}
                            </td>
                        </tr>
                        <tr>
                            <th style="text-align: right">
                                Title:
                            </th>
                            <td>
                                ${userWithDepartmentInfo.getTitle()}
                            </td>
                        </tr>

                        <tr>
                            <th style="text-align: right">
                                Birthday Date:
                            </th>
                            <td>
                                ${userWithDepartmentInfo.getBirthday()}

                            </td>
                        </tr>

                        <tr>
                            <th style="text-align: right">
                                Join Date:
                            </th>
                            <td>
                                ${userWithDepartmentInfo.getJoinDate()}
                            </td>
                        </tr>

                        <tr>
                            <th style="text-align: right">
                                Department:
                            </th>
                            <td>
                                ${userWithDepartmentInfo.getDepartmentName()}
                            </td>
                        </tr>

                        <tr>
                            <th style="text-align: right">
                                Manager:
                            </th>
                            <td>
                                ${userWithDepartmentInfo.getManagerName()}
                            </td>
                        </tr>
                        </tbody>
                    </table>
                </div>
                <div class="col-md-2 col-lg-2"></div>
            </div>
            <div class="col-md-6 col-lg-6 col-md-offset-4 col-lg-offset-4">
                <form id="formBorder" action="upload.do" method="post" enctype="multipart/form-data">
                    <fieldset>
                        <div class="form-group">
                            <img height="200" width="200"
                                 src="http://localhost:8092/${userWithDepartmentInfo.getUserName()}profile.jpg">
                        </div>
                        <div class="form-group">
                            <div class="col-md-4">
                                <input id="mainPageUploadFile" class="btn btn-primary" type="file" name="photo"/>
                            </div>
                            <div class="col-md-4 col-md-offset-4">
                                <input class="btn btn-primary"
                                       type="submit"/>
                            </div>

                        </div>
                    </fieldset>


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
