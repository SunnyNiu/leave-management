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
                        <li class="active">NeedYourApprove
                            Welcome! ${userWithDepartmentInfo.getUserName()} ${today}</li>
                    </ol>
                </div>
            </div>
            <div align="center">
                <label> <strong> Application Management</strong></label>
                <br>
                <label>${messages}</label>
                <label>
                    <%@ include file="error.jsp" %>
                </label>
                <form action="approveRejectWithdrawn.do" method="post">
                    <fieldset>
                        <div class="form-group form-horizontal">
                            <label for="statusId" class="control-label col-md-3 col-md-offset-2">Status: </label>
                            <div class="col-md-3">
                                <select name="status" id="statusId" class="form-control">
                                    <c:forEach items="${status}" var="entry">
                                        <option value="${entry}">
                                                ${entry}
                                        </option>
                                    </c:forEach>
                                </select>
                            </div>
                            <div class="col-md-2">
                                <button class="btn btn-primary" type="submit" name="searchApplication">Search</button>
                            </div>
                            <div class="col-md-2">
                            </div>
                        </div>
                    </fieldset>

                    <div>
                        <div id="borderPadding">
                            <table class="table table-responsive table-striped table-bordered table-condensed">
                                <tr>
                                    <th hidden>Id</th>
                                    <th>Name</th>
                                    <th>LeaveType</th>
                                    <th>FromDate</th>
                                    <th>ToDate</th>
                                    <th>LeaveDays</th>
                                    <th>Status</th>
                                    <th>Approver</th>
                                    <th>A/R</th>
                                </tr>
                                <tbody>
                                <c:forEach items="${leaveApplicationHistoryList}" var="leaveApplicationHistory"
                                           varStatus="leaveHistoryStatus">
                                    <tr>

                                        <td hidden><label class="control-label"
                                                          type="text">${leaveApplicationHistory.getId()}</label></td>
                                        <td hidden><label class="control-label" name="Id" type="text"
                                                          value="${leaveApplicationHistory.getId()}"
                                                          hidden></td>
                                        <td><label style="font-weight: 100" class="control-label"
                                                   type="text">${leaveApplicationHistory.getUserName()}</label></td>

                                        <td hidden><input class="control-label" name="name" type="text"
                                                          value="${leaveApplicationHistory.getUserName()}"
                                                          hidden> </input>
                                        </td>

                                        <td><label style="font-weight: 100" class="control-label"
                                                   type="text">${leaveApplicationHistory.getLeaveType()}</label></td>
                                        <td hidden><input class="control-label" name="leaveType" type="text"
                                                          value="${leaveApplicationHistory.getLeaveType()}"
                                                          hidden>
                                        </td>

                                        <td><label style="font-weight: 100" class="control-label"
                                                   type="text">${leaveApplicationHistory.getFromDate()}</label></td>
                                        <td hidden><input class="control-label" name="fromDate" type="text"
                                                          value="${leaveApplicationHistory.getFromDate()}"
                                                          hidden>
                                        </td>

                                        <td><label style="font-weight: 100" class="control-label"
                                                   type="text">${leaveApplicationHistory.getToDate()}</label>
                                        </td>
                                        <td hidden><input class="control-label" name="toDate" type="text"
                                                          value="${leaveApplicationHistory.getToDate()}" hidden>
                                        </td>

                                        <td><label style="font-weight: 100" class="control-label"
                                                   type="text">${leaveApplicationHistory.getDays()}</label>
                                        </td>
                                        <td hidden><input class="control-label" name="days" type="text"
                                                          value="${leaveApplicationHistory.getDays()}"
                                                          hidden>
                                        </td>

                                        <td><label style="font-weight: 100" class="control-label"
                                                   type="text">${leaveApplicationHistory.getStatus()}</label>
                                        </td>
                                        <td hidden><input class="control-label" name="HistoryStatus" type="text"
                                                          value="${leaveApplicationHistory.getStatus()}" hidden>
                                        </td>

                                        <td><label style="font-weight: 100" class="control-label"
                                                   type="text">${leaveApplicationHistory.getApproverName()}</label>
                                        </td>
                                        <td hidden><input class="control-label" name="approver" type="text"
                                                          value="${leaveApplicationHistory.getApproverName()}"
                                                          hidden>
                                        </td>

                                        <td>
                                            <div>
                                                <div class="col-md-3">
                                                    <button class="btn btn-primary width" type="submit"
                                                            name="approveBtn"
                                                            value=${leaveApplicationHistory.getId()}>
                                                        Approve
                                                    </button>
                                                </div>
                                                <div class="col-md-3">
                                                    <button class="btn btn-primary width" type="submit" name="rejectBtn"
                                                            value=${leaveApplicationHistory.getId()}>
                                                        Reject
                                                    </button>
                                                </div>
                                                <div class="col-md-3">
                                                    <button class="btn btn-primary width" type="submit"
                                                            name="withdrawBtn"
                                                            value=${leaveApplicationHistory.getId()}>
                                                        Withdraw
                                                    </button>
                                                </div>
                                                <div class="col-md-3"></div>
                                            </div>
                                        </td>
                                    </tr>
                                </c:forEach>
                                </tbody>

                            </table>
                        </div>
                        </tr>
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

</body>
</html>