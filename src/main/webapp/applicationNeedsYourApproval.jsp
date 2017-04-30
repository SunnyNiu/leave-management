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
                <label> <strong> Approve Reject Withdraw Application</strong></label>
                <label>${messages}</label>
                <label>
                    <%@ include file="error.jsp" %>
                </label>
                <form action="approveRejectWithdrawn.do" method="post" class="setting">
                    <select name="status" id="statusId">
                        <c:forEach items="${status}" var="entry">
                            <option value="${entry}">
                                    ${entry}
                            </option>
                        </c:forEach>
                    </select>
                    <button class="btn btn-primary" type="submit" name="searchApplication">Search</button>
                    <br>
                    <div>
                        <div>
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

                                    <td hidden><input class="form-control" type="text"
                                                      value="${leaveApplicationHistory.getId()}"
                                                      disabled></td>
                                    <td hidden><input class="form-control" name="Id" type="text"
                                                      value="${leaveApplicationHistory.getId()}"
                                                      hidden></td>
                                    <td><input class="form-control" type="text"
                                               value="${leaveApplicationHistory.getUserName()}"
                                               disabled></td>

                                    <td hidden><input class="form-control" name="name" type="text"
                                                      value="${leaveApplicationHistory.getUserName()}"
                                                      hidden> </input>
                                    </td>

                                    <td><input class="form-control" type="text"
                                               value="${leaveApplicationHistory.getLeaveType()}"
                                               disabled></td>
                                    <td hidden><input class="form-control" name="leaveType" type="text"
                                                      value="${leaveApplicationHistory.getLeaveType()}"
                                                      hidden>
                                    </td>

                                    <td><input class="form-control" type="text"
                                               value="${leaveApplicationHistory.getFromDate()}"
                                               disabled></td>
                                    <td hidden><input class="form-control" name="fromDate" type="text"
                                                      value="${leaveApplicationHistory.getFromDate()}"
                                                      hidden>
                                    </td>

                                    <td><input class="form-control" type="text"
                                               value="${leaveApplicationHistory.getToDate()}" disabled>
                                    </td>
                                    <td hidden><input class="form-control" name="toDate" type="text"
                                                      value="${leaveApplicationHistory.getToDate()}" hidden>
                                    </td>

                                    <td><input class="form-control" type="text"
                                               value="${leaveApplicationHistory.getDays()}" disabled>
                                    </td>
                                    <td hidden><input class="form-control" name="days" type="text"
                                                      value="${leaveApplicationHistory.getDays()}"
                                                      hidden>
                                    </td>

                                    <td><input class="form-control" type="text"
                                               value="${leaveApplicationHistory.getStatus()}" disabled>
                                    </td>
                                    <td hidden><input class="form-control" name="HistoryStatus" type="text"
                                                      value="${leaveApplicationHistory.getStatus()}" hidden>
                                    </td>

                                    <td><input class="form-control" type="text"
                                               value="${leaveApplicationHistory.getApproverName()}"
                                               disabled>
                                    </td>
                                    <td hidden><input class="form-control" name="approver" type="text"
                                                      value="${leaveApplicationHistory.getApproverName()}"
                                                      hidden>
                                    </td>

                                    <td>
                                        <div>
                                            <div class="col-md-3">
                                            <button class="btn btn-primary" type="submit" name="approveBtn"
                                                    value=${leaveApplicationHistory.getId()}>
                                                Approve
                                            </button>
                                            </div>
                                            <div class="col-md-4">
                                            <button class="btn btn-primary" type="submit" name="rejectBtn"
                                                    value=${leaveApplicationHistory.getId()}>
                                                Reject
                                            </button>
                                            </div>
                                            <div class="col-md-4">
                                            <button class="btn btn-primary" type="submit"
                                                    name="withdrawBtn"
                                                    value=${leaveApplicationHistory.getId()}>
                                                Withdraw
                                            </button>
                                            </div>
                                            <div class="col-md-1">
                                            </div>
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