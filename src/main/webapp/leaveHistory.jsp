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

            <form action="searchLeaveHistory.do" method="post" class="table-bordered">
                <div align="center">
                    <div class="form-group">
                        <label for="fromId">Name: </label> <input type="text"
                                                                  value="${userWithDepartmentInfo.getUserName()}"
                                                                  disabled/>
                    </div>
                </div>
                <div class="col-md-10 col-md-offset-2 col-sm-10 col-sm-offset-2">
                    <div>
                        <div class="form-group col-md-6">
                            <label for="fromId" class="col-sm-4 col-md-4 style="text-align: right">From: </label>
                            <div class="col-md-3 col-sm-3">
                                <input id="fromId" type="date" name="userFromDate" required/>
                            </div>
                        </div>
                        <div class="form-group col-md-6">
                            <label for="toId" class="col-sm-4 col-md-4 style="text-align: right">To: </label>
                            <div class="col-md-3 col-sm-3">
                                <input id="toId" type="date" name="userToDate" required/>
                            </div>
                        </div>
                    </div>
                    <div>
                        <div class="form-group col-md-6">
                            <label for="staffId" class="col-sm-4 col-md-4 style="text-align: right">Leave
                                Type:</label>
                            <div class="col-md-3 col-sm-3">
                                <select name="leaveType" id="staffId">
                                    <c:forEach items="${leaveTypesList}" var="entry">
                                        <option value="${entry.getId()}">
                                                ${entry.getLeaveType()}
                                        </option>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>
                        <div class="form-group col-md-6">
                            <label for="leaveTypeId" class="col-sm-4 col-md-4 style="text-align: right">Staff
                                Name:</label>
                            <div class="col-md-3 col-sm-3">
                                <select name="username" id="leaveTypeId">
                                    <c:forEach items="${userList}" var="entry">
                                        <option value="${entry.getUserId()}">
                                                ${entry.getUserName()}
                                        </option>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>
                    </div>
                </div>

                <div align="center">
                    <button class="btn btn-primary" type="submit">Submit</button>
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
        Copyright @www.uc.cn.com
    </div>
</div>
<script src="js/jquery-2.0.3.min.js"></script>
<script src="js/bootstrap.min.js"></script>
</body>
</html>
