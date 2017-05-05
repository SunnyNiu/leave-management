<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
                        <li class="active">Update or Remove Staff Information
                            Welcome! ${userWithDepartmentInfo.getUserName()} ${today}</li>
                    </ol>
                </div>
            </div>
            <div align="center">
                <label> <strong> Staff Management</strong></label>
                <br>
                <label>${messages}</label>
                <label>
                    <%@ include file="error.jsp" %>
                </label>
                <form action="updateOrRemoveMember.do" method="post">
                    <fieldset>
                        <div class="form-group form-horizontal">
                            <label for="FirsName" class="control-label col-md-2 col-md-offset-2">First Name: </label>
                            <div class="col-md-2">
                                <input type="text" name="firsName" id="FirsName"/>
                            </div>
                            <label for="LastName" class="control-label col-md-2">Last Name: </label>
                            <div class="col-md-2">
                                <input type="text" name="lastName" id="LastName"/>
                            </div>
                            <div class="col-md-2">
                                <button class="btn btn-primary" type="submit" name="searchStaffBtn">Search</button>
                            </div>
                        </div>
                    </fieldset>

                    <div>
                        <div id="borderPadding">
                            <%@include file="paginationUpdateOrRemoveStaff.jsp" %>
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
<script src="js/application.js"></script>
</body>
</html>