<%--
  Created by IntelliJ IDEA.
  User: Sunny
  Date: 25/01/2017
  Time: 5:13 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
</head>
<body>
<ul class="nav nav-tabs">
    <li><a href="mainPageMenu.do">Personal Info</a></li>
    <br>
    <li><a href="leaveMenu.do">Apply for Leave</a></li>
    <br>
    <li><a href="leaveHistoryMenu.do">Leave History</a></li>
    <br>
    <c:if test="${approveRejectIsPermitted}" var="hasPermission">
        <li><a href="MakeYourApprovalDecision.do">MakeYourApprovalDecision</a></li>
        <br>
    </c:if>
    <c:if test="${addMemberIsPermitted}" var="hasPermission">
        <li><a href="addNewMemberMenu.do">Add New Member</a></li>
        <br>
    </c:if>
    <li><a href="updatePasswordMenu.do">Change Password</a></li>
    <br>
    <li><a href="updateInfoMenu.do">Change Personal Info</a></li>
    <br>
    <li><a href="logout.do">Logout</a></li>
</ul>
</body>
</html>
