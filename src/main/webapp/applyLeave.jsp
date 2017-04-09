
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <style type="text/css">@import "style.css";</style>
</head>
<body>
<div style="text-align:center; vertical-align:middle" class="formdiv">
    <div id="header">
        <h1>Leave Management System</h1>
    </div>

    <form action="applyLeave.do" method="post">
        <div id="parent">
            <div class="left">
                <%@ include file="menus.jsp" %>
            </div>
            <div class="right">
                <div align="right">
                    <header align="right">Welcome! ${user.getUserName()} ${today}</header>
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
                <div align="center" name="calenderDate">
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
                    <div>
                        <button type="submit" name="btnApply">Submit</button>
                    </div>
                </div>
            </div>
        </div>
    </form>
</div>
<div id="footer">
    Copyright © xxx.com
</div>
</body>
</html>