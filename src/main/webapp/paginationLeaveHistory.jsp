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
<div>
    <header class="container">
        <%@ include file="menus.jsp" %>
    </header>
    <section id="body" class="container">
        <div>
            <form>
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
                            <td><label style="font-weight: 100">${leaveApplicationHistory.getApproverName()}</label>
                            </td>
                        </tr>
                    </c:forEach>
                    <div>
                        <nav aria-label="Page navigation example">
                            <ul class="pagination">
                                <li class="page-item"><a class="page-link" href="searchLeaveHistory.do">Previous</a>
                                </li>
                                <c:forEach begin="1" end="${pagesNumber}" var="i" varStatus="myIndex">
                                    <li class="page-item"><a class="page-link" href="searchLeaveHistory.do?page=${i}"
                                                             name="pageNumber">${i}</a>
                                    </li>
                                </c:forEach>
                                <li class="page-item"><a class="page-link" href="searchLeaveHistory.do">Next</a></li>
                                <label>${page}</label>
                            </ul>
                        </nav>
                    </div>
                </table>
            </form>
        </div>
    </section>
</div>
</body>
</html>