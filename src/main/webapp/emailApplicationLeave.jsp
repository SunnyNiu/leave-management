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
                        <button class="btn btn-primary" id="submitApplication" type="submit" name="sendEmailBtn">Okay</button>
                        <button class="btn btn-primary" id="cancelApplication" type="submit" name="cancelBtn">Cancel</button>
                    </div>
                    <form class="form-horizontal">
                        <div id="borderPadding">
                            <div class="form-group  form-control">
                                <label for="userId" class="control-label col-md-1 col-md-offset-1">UserId:</label>
                                <div class="col-md-2">
                                    <label type="text" name="userId" id="userId"
                                           class="control-label">${applicationForm.getUserId()}</label>

                                    <input type="text" name="userId" value="${applicationForm.getUserId()}" hidden>
                                </div>

                                <lable for="name" class="control-label col-md-1 col-md-offset-1" style="text-align: right">Name:</lable>
                                <div class="col-md-2">
                                    <lable type="text" name="name" id="name"
                                           class="control-label">${applicationForm.getName()}</lable>

                                    <input type="text" name="name" value="${applicationForm.getName()}" hidden>
                                </div>

                                <lable for="leaveType" class="control-label col-md-1 col-md-offset-1">LeaveType:</lable>
                                <div class="col-md-2">
                                    <lable type="text" name="leaveType" id="leaveType"
                                           class="control-label">${applicationForm.getApplicationLeaveType()}</lable>

                                    <input type="text" name="leaveType"
                                           value="${applicationForm.getApplicationLeaveType()}"
                                           hidden>
                                    <input type="text" name="leaveTypeId"
                                           value="${applicationForm.getLeaveTypeId()}"
                                           hidden>

                                </div>
                            </div>
                            <div class="form-group form-control">
                                <lable for="reason" class="control-label col-md-1 col-md-offset-1" style="text-align: right">Reason:</lable>
                                <div class="col-md-2">
                                    <lable type="text" name="reason" id="reason"
                                           class="control-label">${applicationForm.getReason()}</lable>
                                    <input type="text" name="reason" value="${applicationForm.getReason()}" hidden>
                                </div>

                                <lable for="manager" class="control-label col-md-1 col-md-offset-1">Manager:</lable>
                                <div class="col-md-2">
                                    <lable type="text" name="manager" id="manager"
                                           class="control-label">${applicationForm.getManagerName()}</lable>
                                    <input type="text" name="manager" value="${applicationForm.getManagerName()}"
                                           hidden>
                                </div>

                                <lable for="managerId" class="control-label col-md-1 col-md-offset-1">ManagerId:</lable>
                                <div class="col-md-2">
                                    <lable type="text" name="managerId" id="managerId"
                                           class="control-label">${applicationForm.getManagerId()}</lable>
                                    <input type="text" name="managerId" value="${applicationForm.getManagerId()}"
                                           hidden>
                                </div>
                            </div>
                            <div class="form-group form-control">
                                <lable for="department" class="control-label col-md-1 col-md-offset-1">Department:</lable>
                                <div class="col-md-2">
                                    <lable type="text" name="department" id="department"
                                           class="control-label">${applicationForm.getDepartment()}</lable>
                                    <input type="text" name="department" value="${applicationForm.getDepartment()}"
                                           hidden>
                                </div>
                            </div>
                            <c:forEach items="${applicationForm.getLeaveList()}" var="applicant"
                                       varStatus="rows">
                                <div class="form-group form-control">
                                    <label for="fromDate"
                                           class="control-label col-md-1 col-md-offset-1">StartDate:</label>
                                    <div class="col-md-2">
                                        <label type="text" name="fromDate" id="fromDate"
                                               class="control-label">${applicant.getFromDate()}</label>
                                        <input type="text" name="fromDate" value="${applicant.getFromDate()}"
                                               hidden>
                                    </div>
                                    <label for="toDate" class="control-label col-md-1 col-md-offset-1">EndDate:</label>
                                    <div class="col-md-2">
                                        <label name="toDate" id="toDate"
                                               class="control-label">${applicant.getToDate()}</label>
                                        <input type="text" name="toDate" value="${applicant.getToDate()}" hidden>
                                    </div>

                                    <label for="totalDays"
                                           class="control-label col-md-1 col-md-offset-1">LeaveDays:</label>
                                    <div class="col-md-2">
                                        <label type="text" name="totalDays" id="totalDays"
                                               class="control-label">${applicant.getTotalDays()}</label>
                                        <input type="text" name="totalDays" value="${applicant.getTotalDays()}"
                                               hidden>
                                    </div>

                                </div>
                            </c:forEach>
                            <tr hidden>
                                <td hidden>
                                    <input hidden type="text" name="totalRows" value="${totalRows}">
                                </td>
                            </tr>
                        </div>
                    </form>
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

