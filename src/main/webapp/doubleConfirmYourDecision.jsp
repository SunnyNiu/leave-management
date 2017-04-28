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
        <form action="confirmYourDecision.do" method="post">
            <div>
                <div class="page-header">
                    <div>
                        <ol class="breadcrumb right">
                            <li class="active">ConfirmYourDecision Welcome! ${userWithDepartmentInfo.getUserName()} ${today}</li>
                        </ol>
                    </div>
                </div>
                <label>
                    <%@ include file="error.jsp" %>
                </label>
            </div>
            <div class="button" align="center" class="setting">
                <button class="btn btn-primary" type="submit" name="confirmBtn" value="${leaveApplicationHistory.getId()}"> Confirm</button>
                <button class="btn btn-primary" type="submit" name="cancelBtn" value="${leaveApplicationHistory.getId()}">Cancel</button>
                <input class="btn btn-primary" hidden name="applicationStatus" value="${Status}"></input>
            </div>
        </form>
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


