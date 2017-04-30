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

            <form action="searchLeaveHistory.do" method="post" class="form-horizontal">
                <div class="table table-bordered" id="borderPadding">
                    <div class="form-group">
                        <label for="fromId" class="col-sm-2 col-sm-offset-2 col-md-2 col-md-offset-2 control-label">Name: </label>
                        <label type="text" class="control-label">${userWithDepartmentInfo.getUserName()}</label>
                    </div>

                    <div class="form-group ">
                        <label for="fromId"
                               class="col-sm-2 col-sm-offset-2 col-md-2 col-md-offset-2 control-label">From: </label>
                        <div class="col-sm-2 col-md-2">
                            <input class="form-control" id="fromId" type="date" name="userFromDate" required/>
                        </div>

                        <label for="toId" class="col-sm-2 col-md-2 control-label">To: </label>
                        <div class="col-sm-2 col-md-2">
                            <input class="form-control" id="toId" type="date" name="userToDate" required/>
                        </div>
                        <div class="col-sm-2 col-md-2">
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="staffId" class="col-sm-2 col-sm-offset-2 col-md-2 col-md-offset-2 control-label">Leave
                            Type:</label>
                        <div class="col-sm-2 col-md-2">
                            <select name="leaveType" id="staffId" class="form-control">
                                <c:forEach items="${leaveTypesList}" var="entry">
                                    <option value="${entry.getId()}">
                                            ${entry.getLeaveType()}
                                    </option>
                                </c:forEach>
                            </select>
                        </div>

                        <label for="leaveTypeId" class="col-sm-2 col-md-2 control-label">Staff
                            Name:</label>
                        <div class="col-sm-2 col-md-2">
                            <select name="username" id="leaveTypeId" class="form-control">
                                <c:forEach items="${userList}" var="entry">
                                    <option value="${entry.getUserId()}">
                                            ${entry.getUserName()}
                                    </option>
                                </c:forEach>
                            </select>
                        </div>
                        <div class="col-sm-2 col-md-2">
                        </div>
                    </div>


                    <div class="col-md-8 col-md-offset-2 col-sm-8 col-sm-offset-2">
                        <button class="btn btn-primary pull-right" type="submit">Submit</button>
                    </div>
                </div>
            </form>
        </div>
        <div>
            <table class="table table-striped table-responsive">
                <tr>
                    <th>Name</th>
                    <th>LeaveType</th>
                    <th>FromDate</th>
                    <th>ToDate</th>
                    <th>LeaveDays</th>
                    <th>Status</th>
                    <th>Approver</th>
                </tr>
                <c:forEach items="${leaveApplicationHistoryList}" var="leaveApplicationHistory">
                    <tr>
                        <td><label style="font-weight: 100">${leaveApplicationHistory.getUserName()}</label></td>
                        <td><label style="font-weight: 100">${leaveApplicationHistory.getLeaveType()}</label></td>
                        <td><label style="font-weight: 100">${leaveApplicationHistory.getFromDate()}</label></td>
                        <td><label style="font-weight: 100">${leaveApplicationHistory.getToDate()}</label></td>
                        <td><label style="font-weight: 100">${leaveApplicationHistory.getDays()}</label></td>
                        <td><label style="font-weight: 100">${leaveApplicationHistory.getStatus()}</label></td>
                        <td><label style="font-weight: 100">${leaveApplicationHistory.getApproverName()}</label></td>
                    </tr>
                </c:forEach>
            </table>
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
