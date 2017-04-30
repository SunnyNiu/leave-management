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
<div id="page">
    <header class="container">
        <div id="menu" class="navbar navbar-default navbar-fixed-top">
            <div class="navbar-header">
                <button class="btn btn-success navbar-toggle" data-toggle="collapse" data-target="#navbar-collapse">
                    <span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>
                </button>
                <div id="logo">
                    <h4>Leave Management</h4>
                </div>
            </div>
            <div class="navbar-collapse collapse">
                <ul class="nav navbar-nav navbar-right" id="navbar-collapse">
                    <li class="nav"><a href="mainPageMenu.do">Personal Info</a></li>
                    <li class="nav"><a href="leaveMenu.do">Apply Leave</a></li>
                    <li class="nav"><a href="leaveHistoryMenu.do">Leave History</a></li>
                    <c:if test="${approveRejectIsPermitted}" var="hasPermission">
                        <li class="nav"><a href="MakeYourApprovalDecision.do">Your Decision</a></li>
                    </c:if>
                    <c:if test="${addMemberIsPermitted}" var="hasPermission">
                        <li class="nav"><a href="addNewMemberMenu.do">Add New Member</a></li>
                    </c:if>
                    <li class="nav"><a href="updatePasswordMenu.do">Change Password</a></li>
                    <li class="nav"><a href="updateInfoMenu.do">Change Personal Info</a></li>
                    <li class="nav"><a href="logout.do">Logout</a></li>
                </ul>
            </div>
        </div>
    </header>
</div>
<script src="js/jquery-2.0.3.min.js"></script>
<script src="js/bootstrap.min.js"></script>
</body>
</html>
