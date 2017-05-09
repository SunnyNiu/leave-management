<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
            <div class="page-header">
                <div>
                    <ol class="breadcrumb right">
                        <li class="active">Update or Remove Staff Information
                            Welcome! ${userWithDepartmentInfo.getUserName()} ${today}</li>
                    </ol>
                </div>
            </div>
            <div align="center">
                <label> <strong> Staff Management</strong></label>
                <br>
                <div align="center">
                    <label>${messages}</label>
                    <label>
                        <%@ include file="error.jsp" %>
                    </label>
                </div>
                <form action="updateOrRemoveMember.do" method="post">
                    <fieldset>
                        <div class="form-group form-horizontal">
                            <label for="searchFirsName" class="control-label col-md-2 col-md-offset-2">First
                                Name: </label>
                            <div class="col-md-2">
                                <input type="text" name="firsName" id="searchFirsName"/>
                            </div>
                            <label for="searchLastName" class="control-label col-md-2">Last Name: </label>
                            <div class="col-md-2">
                                <input type="text" name="lastName" id="searchLastName"/>
                            </div>
                            <div class="col-md-2">
                                <button class="btn btn-primary" type="submit" name="searchStaffBtn">Search</button>
                            </div>
                        </div>
                    </fieldset>

                    <div>
                        <div id="borderPadding">
                            <table class="table table-responsive table-striped table-bordered table-condensed">
                                <tr>
                                    <th hidden>UserId</th>
                                    <th>FirstName</th>
                                    <th>LastName</th>
                                    <th>Login</th>
                                    <th>UserPassword</th>
                                    <th>DepartmentName</th>
                                    <th>Title</th>
                                    <th>UserEmail</th>
                                    <th>Flag</th>
                                    <th>C/R</th>
                                </tr>
                                <tbody>
                                <c:if test="${userBasicInfoNeedUpdate.getLogin()!=null}">
                                    <tr>
                                        <td hidden><label class="control-label"
                                                          type="text">${userBasicInfoNeedUpdate.getUserId()}</label>
                                        </td>
                                        <td><label style="font-weight: 100" class="control-label"
                                                   type="text">${userBasicInfoNeedUpdate.getUserFirstName()}</label>
                                        </td>

                                        <td><label style="font-weight: 100" class="control-label"
                                                   type="text">${userBasicInfoNeedUpdate.getUserLastName()}</label></td>

                                        <td><label style="font-weight: 100" class="control-label"
                                                   type="text">${userBasicInfoNeedUpdate.getLogin()}</label></td>

                                        <td><label style="font-weight: 100" class="control-label"
                                                   type="text">${userBasicInfoNeedUpdate.getUserPassword()}</label>
                                        </td>

                                        <td><label style="font-weight: 100" class="control-label"
                                                   type="text">${userBasicInfoNeedUpdate.getDepartmentName()}</label>
                                        </td>

                                        <td><label style="font-weight: 100" class="control-label"
                                                   type="text">${userBasicInfoNeedUpdate.getTitle()}</label>
                                        </td>
                                        <td><label style="font-weight: 100" class="control-label"
                                                   type="text">${userBasicInfoNeedUpdate.getUserEmail()}</label>
                                        </td>
                                        <td><label style="font-weight: 100" class="control-label"
                                                   type="text">${userBasicInfoNeedUpdate.getFlag()}</label>
                                        </td>
                                        <td>
                                            <div>
                                                <div>
                                                    <button class="btn btn-primary width" type="submit"
                                                            name="changeBtn"
                                                            value=${userBasicInfoNeedUpdate.getLogin()}>
                                                        Change
                                                    </button>
                                                </div>
                                                <!--<div class="col-md-4">
                                                    <button class="btn btn-primary width" type="submit"
                                                            name="removeBtn"
                                                            value=${userBasicInfoNeedUpdate.getUserId()}>
                                                        remove
                                                    </button>
                                                </div>-->
                                            </div>
                                        </td>
                                    </tr>
                                </c:if>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </form>
                <c:if test="${changeBtn!=null}">
                    <form action="changeUser.do" method="post" class="form-horizontal">
                        <div class="table table-bordered">
                            <input hidden type="text" name="userId" value="${userBasicInfoNeedUpdate.getUserId()}">
                            <div class="form-group form-horizontal">
                                <label for="firstName"
                                       class="col-sm-2 col-sm-offset-1 col-md-2 col-md-offset-1 control-label">FirstName:</label>

                                <label name="firstName" class="col-sm-3 col-md-3 control-label"
                                       id="firstName">${userBasicInfoNeedUpdate.getUserFirstName()}</label>

                                <label for="lastName"
                                       class="col-sm-2 col-md-2 control-label">LastName:</label>

                                <label name="lastName" class="col-sm-3 col-md-3 control-label"
                                       id="lastName">${userBasicInfoNeedUpdate.getUserLastName()}</label>
                                <div class="col-sm-1 col-md-1"></div>
                            </div>
                            <div class="form-group form-horizontal">
                                <label for="departmentId"
                                       class="col-sm-2 col-sm-offset-1 col-md-2 col-md-offset-1 control-label">Department:</label>
                                <div class="col-sm-3 col-md-3">
                                    <select name="department" id="departmentId" class="form-control">
                                        <c:forEach items="${departmentManagerList}" var="entry">
                                            <option value="${entry.getDepartmentId()}"
                                                    <c:if test="${entry.getDepartmentId() == userBasicInfoNeedUpdate.getDepartmentId() }">selected</c:if>>
                                                    ${entry.getDepartmentName()}
                                            </option>
                                        </c:forEach>
                                    </select>
                                </div>

                                <label for="titleId" class="col-sm-2 col-md-2 control-label">Title:</label>
                                <div class="col-sm-3 col-md-3">
                                    <select name="title" id="titleId" class="form-control">
                                        <c:forEach items="${titleList}" var="entry">
                                            <option value="${entry.getId()}"
                                                    <c:if test="${entry.getId() == userBasicInfoNeedUpdate.getTitleId() }">selected</c:if>>
                                                    ${entry.getTitle()}
                                            </option>
                                        </c:forEach>
                                    </select>
                                </div>
                                <div class="col-sm-1 col-md-1"></div>
                            </div>
                            <div class="form-group form-horizontal">
                                <label for="email"
                                       class="col-sm-2 col-sm-offset-1 col-md-2 col-md-offset-1 control-label">Email
                                    Address:</label>
                                <div class="col-sm-3 col-md-3">
                                    <input type="email" class="form-control" name="email" id="email" maxlength="25"
                                           value="${userBasicInfoNeedUpdate.getUserEmail()}"
                                           width="15px">
                                </div>

                                <label for="emailPassword"
                                       class="col-sm-2 col-md-2 control-label">Email
                                    Password:</label>
                                <div class="col-sm-3 col-md-3">
                                    <input type="text" class="form-control" name="emailPassword" id="emailPassword"
                                           value="${userBasicInfoNeedUpdate.getUserEmailPassword()}"
                                           maxlength="10"
                                           width="15px">
                                </div>
                            </div>
                            <div class="col-sm-2 col-md-2">
                                <select name="flag" id="flag" class="form-control">
                                    <option value="1"
                                            <c:if test="${userBasicInfoNeedUpdate.getFlag()==1}"> selected="selected"</c:if>
                                    >Active
                                    </option>
                                    <option value="0"
                                            <c:if test="${userBasicInfoNeedUpdate.getFlag()==0}"> selected="selected"</c:if>
                                    >Inactive
                                    </option>
                                </select>
                            </div>
                        </div>
                        <div class="col-md-8 col-md-offset-2 col-sm-8 col-sm-offset-2">
                            <button class="btn btn-primary pull-right" type="submit" name="updateBtn"
                                    value="${userBasicInfoNeedUpdate.getUserId()}">Update
                            </button>
                        </div>
                    </form>
                </c:if>
            </div>
        </div>
    </section>
    <div id="footer" align="center">
        Copyright @www.uc.cn.com
    </div>
</div>
<script src="js/jquery-2.0.3.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/application.js"></script>
</body>
</html>