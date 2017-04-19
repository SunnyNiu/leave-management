<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
        <form action="applyLeave.do" method="post">
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
                <label>${messages}</label>
                <div align="center">
                    <tr><label>Name</label> <input text="type" name="username" id="nameId"
                                                   value="${userWithDepartmentInfo.getUserName()}" disabled></tr>
                    <tr><label>Leave Type</label>
                        <select name="leaveType" id="leaveTypeId">
                            <c:forEach items="${leaveTypesList}" var="entry">
                                <option value="${entry.getId()}">
                                        ${entry.getLeaveType()}
                                </option>
                            </c:forEach>
                        </select>
                    </tr>
                </div>
                <br>
                <div align="center" name="calenderDate" class="setting">
                    <c:forEach items="${applicationForm.getLeaveList()}" var="leave" varStatus="rows">
                        From: <input type="date" pattern="dd/MM/yyyy" name="fromDate"/>
                        To: <input type="date" pattern="dd/MM/yyyy" name="toDate"/>
                        Total days:
                        <input type="text" name="totalDays" maxlength="2" value="${leave.getTotalDays()}"/>
                        <button type="submit" name="btnRemove" value="${rows.index}">Remove one row</button>
                        <br>
                    </c:forEach>
                    <input type="text" hidden name="totalRows" value="${totalRows}">
                    <input type="text" hidden name="applicationForm" value="${applicationForm}">
                    <button type="submit" name="btnAdd">Add new row</button>
                    <br>
                    <div>
                        <label>Reason:</label>
                        <input type="textarea" name="reason" maxlength="100">
                        <label>Approver:</label>

                        <select name="departmentManager" id="departmentId">
                            <option value="${departmentManager.getManagerUserId()}">
                                ${departmentManager.getManagerName()}
                            </option>
                        </select>
                    </div>
                </div>
                <div>
                    <br>
                    <br>
                    <div class="setting" align="center">
                        <button type="submit" name="btnApply">Submit</button>
                    </div>
                </div>
            </div>
        </form>
    </div>
    <div id="footer" align="center">
        Copyright © xxx.com
    </div>
</div>
</body>
</html>