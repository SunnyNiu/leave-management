<%--
  Created by IntelliJ IDEA.
  User: Sunny
  Date: 8/03/2017
  Time: 3:43 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <style type="text/css">@import "style.css";</style>
</head>
<body>
<div id="header">
    <h1>Leave Management System</h1>
</div>
<div style="text-align:center; vertical-align:middle" class="formdiv">
    <form action="sendEmail.do" method="post">
        <h1 align="center">Welcome!</h1>
        <div align="center">
            <label>Send Email?</label>
        </div>
        <div class="button" align="center">
            <button type="submit" name="sendEmailBtn">Okay</button>
            <button type="submit" name="cancelBtn">Cancel</button>
        </div>
        <div>
            <table align="center" border="1px">
                <tr>
                    <td>
                        <lable>UserId</lable>
                        <input type="text" name="userId" value="${applicationForm.getUserId()}" disabled>
                        <input type="text" name="userId" value="${applicationForm.getUserId()}" hidden>
                    </td>
                    <td>
                        <lable>Name</lable>
                        <input type="text" name="name" value="${applicationForm.getName()}" disabled>
                        <input type="text" name="name" value="${applicationForm.getName()}" hidden>
                    </td>
                    <td>
                        <lable>LeaveType</lable>
                        <input type="text" name="leaveType" value="${applicationForm.getApplicationLeaveType()}"
                               disabled></td>
                    <input type="text" name="leaveType" value="${applicationForm.getApplicationLeaveType()}" hidden>
                    <input type ="text" name="leaveTypeId" value="${applicationForm.getLeaveTypeId()}" hidden>
                    </td>
                </tr>
                <tr>
                    <td>
                        <lable>Reason</lable>
                        <input type="text" name="reason" value="${applicationForm.getReason()}" disabled>
                        <input type="text" name="reason" value="${applicationForm.getReason()}" hidden>
                    </td>
                    <td>
                        <lable>Manager</lable>
                        <input type="text" name="manager" value="${applicationForm.getManagerName()}" disabled>
                        <input type="text" name="manager" value="${applicationForm.getManagerName()}" hidden>
                    </td>
                    <td>
                        <lable>ManagerId</lable>
                        <input type="text" name="managerId" value="${applicationForm.getManagerId()}" disabled>
                        <input type="text" name="managerId" value="${applicationForm.getManagerId()}" hidden>
                    </td>
                </tr>
                <tr>
                    <td>
                        <lable>Department</lable>
                        <input type="text" name="department" value="${applicationForm.getDepartment()}" disabled>
                        <input type="text" name="department" value="${applicationForm.getDepartment()}" hidden>
                    </td>
                </tr>
                <tr>
                    <td><strong>StartDate</strong></td>
                    <td><strong>EndDate</strong></td>
                    <td><strong>LeaveDays</strong></td>
                </tr>
                <c:forEach items="${applicationForm.getLeaveList()}" var="applicant" varStatus="rows">
                    <tr>
                        <td><input type="text" name="fromDate" value="${applicant.getFromDate()}" disabled>
                            <input type="text" name="fromDate" value="${applicant.getFromDate()}" hidden>
                        </td>
                        <td><input type="text" name="toDate" value="${applicant.getToDate()}" disabled>
                            <input type="text" name="toDate" value="${applicant.getToDate()}" hidden>
                        </td>
                        <td><input type="text" name="totalDays" value="${applicant.getTotalDays()}" disabled>
                            <input type="text" name="totalDays" value="${applicant.getTotalDays()}" hidden>
                        </td>
                    </tr>
                </c:forEach>
                <tr hidden>
                    <td hidden>
                        <input hidden type="text" name="totalRows" value="${totalRows}">
                    </td>
                </tr>
            </table>
        </div>
    </form>
</div>
<div id="footer">
    Copyright © xxx.com
</div>
</body>
</html>

