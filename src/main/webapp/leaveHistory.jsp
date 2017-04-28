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
<div class="form-inline">
    <header class="container">
        <%@ include file="menus.jsp" %>
    </header>
    <section id="body" class="container">
        <div id="parent">
            <div class="page-header">
                <div>
                    <ol class="breadcrumb right">
                        <li class="active">LeaveHistory Welcome! ${userWithDepartmentInfo.getUserName()} ${today}</li>
                    </ol>
                </div>
            </div>
            <label>
                <%@ include file="error.jsp" %>
            </label>
            <div align="center">
                <tr><label>Name</label> <input text="type" value="${userWithDepartmentInfo.getUserName()}" disabled>
                </tr>
            </div>
            <br>
            <div></div>
            <form action="searchLeaveHistory.do" method="post">
                <div class="form-group">
                    <label for="fromId">From: </label>
                    <input id="fromId" type="date" name="userFromDate" required/>
                    <label for="toId">To:  </label>
                    <input id="toId" type="date" name="userToDate" required/>
                </div>
                <div class="form-group">
                    <label for="staffId">Leave Type:</label>
                    <select name="leaveType" id="staffId">
                        <c:forEach items="${leaveTypesList}" var="entry">
                            <option value="${entry.getId()}">
                                    ${entry.getLeaveType()}
                            </option>
                        </c:forEach>
                    </select>
                    <label for="leaveTypeId">Staff Name:</label>
                    <select name="username" id="leaveTypeId">
                        <c:forEach items="${userList}" var="entry">
                            <option value="${entry.getUserId()}">
                                    ${entry.getUserName()}
                            </option>
                        </c:forEach>
                    </select>
                </div>
                <br>
                <div align="center">
                    <button class="btn btn-primary" type="submit">Submit</button>
                </div>
            </form>
            <div>
            </div>

        </div>
        <div class="table-responsive">
            <table class="table table-striped">
                <tr>
                    <td>Name</td>
                    <td>LeaveType</td>
                    <td>FromDate</td>
                    <td>ToDate</td>
                    <td>LeaveDays</td>
                    <td>Status</td>
                    <td>Approver</td>
                </tr>
                <c:forEach items="${leaveApplicationHistoryList}" var="leaveApplicationHistory">
                    <tr>
                        <td><label>${leaveApplicationHistory.getUserName()}</label></td>
                        <td><label>${leaveApplicationHistory.getLeaveType()}</label></td>
                        <td><label>${leaveApplicationHistory.getFromDate()}</label></td>
                        <td><label>${leaveApplicationHistory.getToDate()}</label></td>
                        <td><label>${leaveApplicationHistory.getDays()}</label></td>
                        <td><label>${leaveApplicationHistory.getStatus()}</label></td>
                        <td><label>${leaveApplicationHistory.getApproverName()}</label></td>
                    </tr>
                </c:forEach>
            </table>
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
