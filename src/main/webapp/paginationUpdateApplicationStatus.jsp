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
    <section id="body" class="container">
        <div align="left">
            <nav aria-label="Page navigation">
                <ul class="pagination">
                    <c:if test="${pagesNumber!=null}">
                        <li class='page-item ${pageChosen == 1 ? "disabled": ""}'>
                            <a class="page-link" id="${start}" name="pageNumber"
                                    <c:if test="${pageChosen > 1}">
                                        href="approveRejectWithdrawn.do?page=${pageChosen-1}&selectedStatus=${selectedStatus}"
                                    </c:if>
                            >Previous</a>

                        </li>
                    </c:if>
                    <c:forEach begin="1" end="${pagesNumber}" var="i" varStatus="myIndex">
                        <li class='page-item ${pageChosen == i ? "active disabled": ""}'>
                            <a class="page-link"
                               href="approveRejectWithdrawn.do?page=${i}&selectedStatus=${selectedStatus}"
                               id="${i}" name="pageNumber"
                            >${i}</a>
                        </li>
                    </c:forEach>
                    <c:if test="${pagesNumber!=null}">
                        <li class='page-item ${pageChosen == pagesNumber ? "disabled": ""}'>
                            <a class="page-link"
                                    <c:if test="${pageChosen < pagesNumber}">
                                        href="approveRejectWithdrawn.do?page=${pageChosen+1}&selectedStatus=${selectedStatus}"
                                        name="pageNumber"</c:if>>Next</a></li>
                    </c:if>
                </ul>
                <input hidden type="text" name="pagesNumber" value="${pagesNumber}"/>
                <input hidden type="text" name="selectedStatus" value="${selectedStatus}"/>
            </nav>
        </div>
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
                                      hidden/></td>
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
                            <c:if test="${selectedStatus=='Pending'}">
                                <div class="col-md-3">
                                    <button class="btn btn-primary width" type="submit"
                                            name="approveBtn"
                                            value=${leaveApplicationHistory.getId()}>
                                        Approve
                                    </button>
                                </div>
                                <div class="col-md-3">
                                    <button class="btn btn-primary width" type="submit"
                                            name="rejectBtn"
                                            value=${leaveApplicationHistory.getId()}>
                                        Reject
                                    </button>
                                </div>
                            </c:if>
                            <c:if test="${selectedStatus!='Pending'}">
                                <div class="col-md-3">
                                    <button class="btn btn-primary width" type="submit"
                                            name="withdrawBtn"
                                            value=${leaveApplicationHistory.getId()}>
                                        Withdraw
                                    </button>
                                </div>
                            </c:if>
                            <div class="col-md-3"></div>
                        </div>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </section>
</div>
<script src="js/jquery-2.0.3.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/application.js"></script>
</body>
</html>