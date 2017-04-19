<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="style.css" type="text/css"/>
</head>
<body>
<div >
    <div id="header">
        <h1>Leave Management System</h1>
    </div>
    <div id="parent">
        <div class="left">
            <%@ include file="menus.jsp" %>
        </div>
        <div class="right" align="right">
            <div align="right">
                <header align="right">Welcome! ${userWithDepartmentInfo.getUserName()} ${today}</header>
            </div>
            <br>
            <br>
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
                    <button type="submit" name="searchApplication">Search</button>
                    <br>
                    <table width="95%" align="center" border="1px" style="table-layout:fixed;">
                        <tr>
                            <td hidden>Id</td>
                            <td><strong>Name</strong></td>
                            <td><strong>LeaveType</strong></td>
                            <td><strong>FromDate</strong></td>
                            <td><strong>ToDate</strong></td>
                            <td><strong>LeaveDays</strong></td>
                            <td><strong>Status</strong></td>
                            <td><strong>Approver</strong></td>
                            <td>A/R</td>
                        </tr>
                        <c:forEach items="${leaveApplicationHistoryList}" var="leaveApplicationHistory"
                                   varStatus="leaveHistoryStatus">
                            <tr>
                                <td hidden><input type="text" value="${leaveApplicationHistory.getId()}" disabled></td>
                                <td hidden><input name="Id" type="text" value="${leaveApplicationHistory.getId()}"
                                                  hidden></td>
                                <td><input type="text" value="${leaveApplicationHistory.getUserName()}" disabled></td>
                                <td hidden><input name="name" type="text"
                                                  value="${leaveApplicationHistory.getUserName()}" hidden> </input>
                                </td>
                                <td><input type="text" value="${leaveApplicationHistory.getLeaveType()}" disabled></td>
                                <td hidden><input name="leaveType" type="text"
                                                  value="${leaveApplicationHistory.getLeaveType()}" hidden></td>
                                <td><input type="text" value="${leaveApplicationHistory.getFromDate()}" disabled></td>
                                <td hidden><input name="fromDate" type="text"
                                                  value="${leaveApplicationHistory.getFromDate()}" hidden></td>
                                <td><input type="text" value="${leaveApplicationHistory.getToDate()}" disabled></td>
                                <td hidden><input name="toDate" type="text"
                                                  value="${leaveApplicationHistory.getToDate()}" hidden>
                                </td>
                                <td><input type="text" value="${leaveApplicationHistory.getDays()}" disabled></td>
                                <td hidden><input name="days" type="text" value="${leaveApplicationHistory.getDays()}"
                                                  hidden>
                                </td>
                                <td><input type="text" value="${leaveApplicationHistory.getStatus()}" disabled></td>
                                <td hidden><input name="HistoryStatus" type="text"
                                                  value="${leaveApplicationHistory.getStatus()}" hidden>
                                </td>
                                <td><input type="text" value="${leaveApplicationHistory.getApproverName()}" disabled>
                                </td>
                                <td hidden><input name="approver" type="text"
                                                  value="${leaveApplicationHistory.getApproverName()}" hidden></td>
                                <td width=10%>
                                    <button id="button1" type="submit" name="approveBtn"
                                            value=${leaveApplicationHistory.getId()}>
                                        Approve
                                    </button>
                                    <br>
                                    <button id="button2" type="submit" name="rejectBtn"
                                            value=${leaveApplicationHistory.getId()}>
                                        Reject
                                    </button>
                                    <br>
                                    <button id="button3" type="submit" name="withdrawBtn"
                                            value=${leaveApplicationHistory.getId()}>
                                        Withdrawn
                                    </button>
                                </td>
                            </tr>
                        </c:forEach>
                    </table>
                </form>
            </div>
        </div>
    </div>
    <div id="footer" align="center">
        Copyright © xxx.com
    </div>
</div>

</body>
</html>