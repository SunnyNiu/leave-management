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
            <form action="applyLeave.do" method="post" class="form-horizontal">
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

                    <div class="table table-bordered" id="borderPadding">

                        <div class="form-group ">
                            <label for="leaveTypeId"
                                   class="col-sm-2  col-md-2  control-label">Leave Type: </label>
                            <div class="col-sm-2 col-md-2">
                                <select name="leaveType" id="leaveTypeId" class="form-control">
                                    <c:forEach items="${leaveTypesList}" var="entry">
                                        <option value="${entry.getId()}">
                                                ${entry.getLeaveType()}
                                        </option>
                                    </c:forEach>
                                </select>
                            </div>

                            <label for="reason" class="col-sm-1 col-md-1 control-label">Reason: </label>
                            <div class="col-sm-2 col-md-2">
                                <input class="form-control" id="reason" type="text" name="reason" maxlength="100"
                                       class="form-control" type="textarea">
                            </div>

                            <label for="departmentId" class="col-sm-1 col-md-1 control-label">Approver: </label>
                            <div class="col-sm-2 col-md-2">
                                <select name="departmentManager" id="departmentId" class="form-control">
                                    <option value="${departmentManager.getManagerUserId()}">
                                        ${departmentManager.getManagerName()}
                                    </option>
                                </select>
                            </div>
                            <div class="col-md-2">
                                <button class="btn btn-primary" type="submit" name="btnAdd">Add New Row
                                </button>
                            </div>
                        </div>


                        <c:forEach items="${applicationForm.getLeaveList()}" var="leave" varStatus="rows">
                            <div class="form-group ">

                                <label for="fromDate" style="text-align: right" class="col-sm-2 col-md-2 control-label">From:</label>
                                <div class="col-sm-2 col-md-2"><input type="date"
                                                                      pattern="dd/MM/yyyy"
                                                                      name="fromDate"
                                                                      id="fromDate" class="form-control"/>
                                </div>

                                <label for="toDate" style="text-align: right" class="col-sm-1 col-md-1 control-label">To:</label>
                                <div class="col-sm-2 col-md-2"><input type="date"
                                                                      pattern="dd/MM/yyyy"
                                                                      name="toDate"
                                                                      id="toDate" class="form-control"/>
                                </div>

                                <label for="totalDay" style="text-align: right" class="col-sm-1 col-md-1 control-label">
                                    Days:</label>
                                <div class="col-sm-2 col-md-2">
                                    <input type="text" id="totalDay" name="totalDays" maxlength="2"
                                           value="${leave.getTotalDays()}" class="form-control"/>
                                </div>

                                <div class="col-sm-2 col-md-2">
                                    <button class="btn btn-primary" type="submit" name="btnRemove"
                                            value="${rows.index}">
                                        X
                                    </button>
                                </div>
                            </div>
                        </c:forEach>
                        <input type="text" hidden name="totalRows" value="${totalRows}">
                        <input type="text" hidden name="applicationForm" value="${applicationForm}">
                        </table>

                        <div>
                            <div class="col-md-10"></div>
                            <div class="col-md-2">
                                <button class="btn btn-primary" type="submit" name="btnApply">Submit</button>
                            </div>
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