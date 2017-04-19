<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="style.css" type="text/css"/>
</head>
<body>
<div>
    <div id="header">
        <h1>Leave Management System</h1>
    </div>
    <div id="parent">
        <div class="left">
            <%@ include file="menus.jsp" %>
        </div>
        <div class="right">
            <div align="right">
                <header align="right">Welcome! ${userWithDepartmentInfo.getUserName()} ${today}</header>
            </div>
            <br>
            <br>
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
                <div align="center">
                    From: <input type="date" name="userFromDate" required/>
                    To: <input type="date" name="userToDate" required/>
                    <label>Leave Type:</label>
                    <select name="leaveType" id="staffId">
                        <c:forEach items="${leaveTypesList}" var="entry">
                            <option value="${entry.getId()}">
                                    ${entry.getLeaveType()}
                            </option>
                        </c:forEach>
                    </select>
                    <label>Staff Name:</label>
                    <select name="username" id="leaveTypeId">
                        <c:forEach items="${userList}" var="entry">
                            <option value="${entry.getUserId()}">
                                    ${entry.getUserName()}
                            </option>
                        </c:forEach>
                    </select>
                </div>
                <br>
                <div class="setting" align="center">
                    <button type="submit">Submit</button>
                </div>
            </form>
            <div>
            </div>

        </div>

    </div>
    <div>
        <table align="center" border="1px">
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
    <div id="footer" align="center">
        Copyright © xxx.com
    </div>
</div>
</body>

</body>
</html>
