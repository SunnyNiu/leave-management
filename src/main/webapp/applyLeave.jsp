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
<div>
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
                                <li class="active">ApplyLeave
                                    Welcome! ${userWithDepartmentInfo.getUserName()} ${today}</li>
                            </ol>
                        </div>
                    </div>
                    <label>
                        <%@ include file="error.jsp" %>
                    </label>
                    <label>${messages}</label>
                    <div class="form-group table-responsive" align="center">
                        <label style="text-align: right">Leave Type:</label></td>
                        <select name="leaveType" id="leaveTypeId">
                            <c:forEach items="${leaveTypesList}" var="entry">
                                <option value="${entry.getId()}">
                                        ${entry.getLeaveType()}
                                </option>
                            </c:forEach>
                        </select>
                    </div>
                    <div class="form-group table-responsive" align="center" name="calenderDate">
                        <c:forEach items="${applicationForm.getLeaveList()}" var="leave" varStatus="rows">
                            <label style="text-align: right">From:</label> <input type="date" pattern="dd/MM/yyyy"
                                                                                  name="fromDate"/>
                            <label style="text-align: right">To:</label> <input type="date" pattern="dd/MM/yyyy"
                                                                                name="toDate"/>
                            <label style="text-align: right">Total Days:</label>
                            <input type="text" name="totalDays" maxlength="2" value="${leave.getTotalDays()}"/>
                            <button class="btn btn-primary " type="submit" name="btnRemove" value="${rows.index}">
                               Remove Row
                            </button>
                            <br>
                        </c:forEach>
                        <input type="text" hidden name="totalRows" value="${totalRows}">
                        <input type="text" hidden name="applicationForm" value="${applicationForm}">
                        <button class="btn btn-primary" type="submit" name="btnAdd">Add new row</button>
                        <br>
                        <br>
                        <div>
                            <label style="text-align: right">Reason:</label>
                            <input type="textarea" name="reason" maxlength="100">
                            <label style="text-align: right">Approver:</label>

                            <select name="departmentManager" id="departmentId">
                                <option value="${departmentManager.getManagerUserId()}">
                                    ${departmentManager.getManagerName()}
                                </option>
                            </select>
                        </div>
                    </div>
                    <div align="center">
                        <button class="btn btn-primary" type="submit" name="btnApply">Submit</button>
                    </div>

                </div>
            </form>
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