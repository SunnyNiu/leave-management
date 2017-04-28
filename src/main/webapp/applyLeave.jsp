<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
<div class="form-inline">
    <header class="container">
            <%@ include file="menus.jsp" %>
    </header>
    <section id="body" class="container">
        <div id="parent">
            <form action="applyLeave.do" method="post">
                <div>
                    <div class="page-header">
                        <div>
                            <ol class="breadcrumb right">
                                <li class="active">ApplyLeave Welcome! ${userWithDepartmentInfo.getUserName()} ${today}</li>
                            </ol>
                        </div>
                    </div>
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
                            <button class="btn btn-primary" type="submit" name="btnRemove" value="${rows.index}">Remove one row</button>
                            <br>
                        </c:forEach>
                        <input type="text" hidden name="totalRows" value="${totalRows}">
                        <input type="text" hidden name="applicationForm" value="${applicationForm}">
                        <button class="btn btn-primary" type="submit" name="btnAdd">Add new row</button>
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
                        <div class="setting" align="center">
                            <button class="btn btn-primary" type="submit" name="btnApply">Submit</button>
                        </div>
                    </div>
                </div>
            </form>
        </div>
    </section>
    <div id="footer" align="center">
        Copyright © xxx.com
    </div>
</div>
<script src="js/jquery-2.0.3.min.js"></script>
<script src="js/bootstrap.min.js"></script>
</body>
</html>