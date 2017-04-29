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
            <form action="sendEmail.do" method="post">
                <div>
                    <div class="page-header">
                        <div>
                            <ol class="breadcrumb right">
                                <li class="active">EmailApplication
                                    Welcome! ${userWithDepartmentInfo.getUserName()} ${today}</li>
                            </ol>
                        </div>
                    </div>
                    <div class="button" align="center">
                        <button class="btn btn-primary" type="submit" name="sendEmailBtn">Okay</button>
                        <button class="btn btn-primary" type="submit" name="cancelBtn">Cancel</button>
                    </div>
                    <div >
                        <table class="table table-striped table-bordered table-condensed table-responsive">
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
                                    <input type="text" name="leaveType"
                                           value="${applicationForm.getApplicationLeaveType()}"
                                           disabled></td>
                                <input type="text" name="leaveType" value="${applicationForm.getApplicationLeaveType()}"
                                       hidden>
                                <input type="text" name="leaveTypeId" value="${applicationForm.getLeaveTypeId()}"
                                       hidden>
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
                                    <input type="text" name="manager" value="${applicationForm.getManagerName()}"
                                           disabled>
                                    <input type="text" name="manager" value="${applicationForm.getManagerName()}"
                                           hidden>
                                </td>
                                <td>
                                    <lable>ManagerId</lable>
                                    <input type="text" name="managerId" value="${applicationForm.getManagerId()}"
                                           disabled>
                                    <input type="text" name="managerId" value="${applicationForm.getManagerId()}"
                                           hidden>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <lable>Department</lable>
                                    <input type="text" name="department" value="${applicationForm.getDepartment()}"
                                           disabled>
                                    <input type="text" name="department" value="${applicationForm.getDepartment()}"
                                           hidden>
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
                                    <td><input type="text" name="totalDays" value="${applicant.getTotalDays()}"
                                               disabled>
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

