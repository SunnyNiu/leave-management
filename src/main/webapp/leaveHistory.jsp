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
            <div class="page-header">
                <div>
                    <ol class="breadcrumb right">
                        <li class="active">LeaveHistory Welcome! ${userWithDepartmentInfo.getUserName()} ${today}</li>
                    </ol>
                </div>
            </div>
            <label>
                <%@ include file="error.jsp" %>
            </label>

            <form action="searchLeaveHistory.do" method="post" class="form-horizontal">
                <div class="table table-bordered" id="borderPadding">
                    <div class="form-group">
                        <label for="fromId" class="col-sm-2 col-sm-offset-2 col-md-2 col-md-offset-2 control-label">Name: </label>
                        <label type="text" class="control-label">${userWithDepartmentInfo.getUserName()}</label>
                    </div>

                    <div class="form-group ">
                        <label for="fromId"
                               class="col-sm-2 col-sm-offset-2 col-md-2 col-md-offset-2 control-label">From: </label>
                        <div class="col-sm-2 col-md-2">
                            <input class="form-control" id="fromId" type="date" name="userFromDate" value="${selectedFromDate}" required>
                        </div>

                        <label for="toId" class="col-sm-2 col-md-2 control-label">To: </label>
                        <div class="col-sm-2 col-md-2">
                            <input class="form-control" id="toId" type="date" name="userToDate" value="${selectedToDate}" required/>
                        </div>
                        <div class="col-sm-2 col-md-2">
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="staffId" class="col-sm-2 col-sm-offset-2 col-md-2 col-md-offset-2 control-label">Leave
                            Type:</label>
                        <div class="col-sm-2 col-md-2">
                            <select name="leaveType" id="staffId" class="form-control">
                                <c:forEach items="${leaveTypesList}" var="entry">
                                    <option value="${entry.getId()}"
                                            <c:if test="${entry.getId() == selectedLeaveType }">selected</c:if>>
                                            ${entry.getLeaveType()}
                                    </option>
                                </c:forEach>
                            </select>
                        </div>

                        <label for="leaveTypeId" class="col-sm-2 col-md-2 control-label">Staff
                            Name:</label>
                        <div class="col-sm-2 col-md-2">
                            <select name="username" id="leaveTypeId" class="form-control">
                                <c:forEach items="${userList}" var="entry">
                                    <option value="${entry.getUserId()}"
                                        <c:if test="${entry.getUserId() == selectedUserId }">selected</c:if>>
                                            ${entry.getUserName()}
                                    </option>
                                </c:forEach>
                            </select>
                        </div>
                        <div class="col-sm-2 col-md-2">
                        </div>
                    </div>
                    <div class="col-md-8 col-md-offset-2 col-sm-8 col-sm-offset-2">
                        <button class="btn btn-primary pull-right" type="submit">Submit</button>
                    </div>
                </div>
            </form>
        </div>
        <div>
            <%@ include file="paginationLeaveHistory.jsp" %>
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
