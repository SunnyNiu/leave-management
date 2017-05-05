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
    <section id="body" class="container">
        <div align="left">
            <nav aria-label="Page navigation">
                <ul class="pagination">
                    <c:if test="${pagesNumber!=null}">
                        <li class='page-item ${pageChosen == 1 ? "disabled": ""}'>
                            <a class="page-link" id="${start}" name="pageNumber"
                                    <c:if test="${pageChosen > 1}">
                                        href="updateOrRemoveMember.do?page=${pageChosen-1}&userId=${userId}"
                                    </c:if>
                            >Previous</a>

                        </li>
                    </c:if>
                    <c:forEach begin="1" end="${pagesNumber}" var="i" varStatus="myIndex">
                        <li class='page-item ${pageChosen == i ? "active disabled": ""}'>
                            <a class="page-link"
                               href="updateOrRemoveMember.do?page=${i}&userId=${userId}"
                               id="${i}" name="pageNumber"
                            >${i}</a>
                        </li>
                    </c:forEach>
                    <c:if test="${pagesNumber!=null}">
                        <li class='page-item ${pageChosen == pagesNumber ? "disabled": ""}'>
                            <a class="page-link"
                                    <c:if test="${pageChosen < pagesNumber}">
                                        href="updateOrRemoveMember.do?page=${pageChosen+1}&userId=${userId}"
                                        name="pageNumber"</c:if>>Next</a></li>
                    </c:if>
                </ul>
                <input hidden type="text" name="pagesNumber" value="${pagesNumber}"/>
                <input hidden type="text" name="selectedStatus" value="${selectedStatus}"/>
            </nav>
        </div>
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
                <th>C/R</th>
            </tr>
            <tbody>
            <c:if test="${userBasicInfo.getUserId()!=null}">
                <tr>
                    <td hidden><label class="control-label"
                                      type="text">${userBasicInfo.getUserId()}</label></td>
                    <td hidden><label class="control-label" name="Id" type="text"
                                      value="${userBasicInfo.getUserId()}"
                                      hidden/></td>
                    <td><label style="font-weight: 100" class="control-label"
                               type="text">${userBasicInfo.getUserFirstName()}</label></td>

                    <td hidden><input class="control-label" name="firstName" type="text"
                                      value="${userBasicInfo.getUserFirstName()}"
                                      hidden> </input>
                    </td>

                    <td><label style="font-weight: 100" class="control-label"
                               type="text">${userBasicInfo.getUserLastName()}</label></td>
                    <td hidden><input class="control-label" name="lastName" type="text"
                                      value="${userBasicInfo.getUserLastName()}"
                                      hidden>
                    </td>

                    <td><label style="font-weight: 100" class="control-label"
                               type="text">${userBasicInfo.getLogin()}</label></td>
                    <td hidden><input class="control-label" name="login" type="text"
                                      value="${userBasicInfo.getLogin()}"
                                      hidden>
                    </td>

                    <td><label style="font-weight: 100" class="control-label"
                               type="text">${userBasicInfo.getUserPassword()}</label>
                    </td>
                    <td hidden><input class="control-label" name="userPassword" type="text"
                                      value="${userBasicInfo.getUserPassword()}" hidden>
                    </td>

                    <td hidden><input class="control-label" name="departmentId" type="text"
                                      value="${userBasicInfo.getDepartmentId()}"
                                      hidden>
                    </td>

                    <td><label style="font-weight: 100" class="control-label"
                               type="text">${userBasicInfo.getDepartmentName()}</label>
                    </td>
                    <td hidden><input class="control-label" name="departmentName" type="text"
                                      value="${userBasicInfo.getDepartmentName()}" hidden>
                    </td>

                    <td><label style="font-weight: 100" class="control-label"
                               type="text">${userBasicInfo.getTitle()}</label>
                    </td>
                    <td hidden><input class="control-label" name="title" type="text"
                                      value="${userBasicInfo.getTitle()}"
                                      hidden>
                    </td>
                    <td><label style="font-weight: 100" class="control-label"
                               type="text">${userBasicInfo.getUserEmail()}</label>
                    </td>
                    <td hidden><input class="control-label" name="userEmail" type="text"
                                      value="${userBasicInfo.getUserEmail()}"
                                      hidden>
                    </td>
                    <td hidden><input class="control-label" name="userEmailPassword" type="text"
                                      value="${userBasicInfo.getUserEmailPassword()}"
                                      hidden>
                    </td>
                    <td>
                        <div>
                            <div class="col-md-3">
                                <button class="btn btn-primary width" type="submit"
                                        name="updateBtn"
                                        value=${userBasicInfo.getUserId()}>
                                    Change
                                </button>
                            </div>
                            <div class="col-md-3">
                                <button class="btn btn-primary width" type="submit"
                                        name="removeBtn"
                                        value=${userBasicInfo.getUserId()}>
                                    remove
                                </button>
                            </div>
                            <div class="col-md-3"></div>
                        </div>
                    </td>
                </tr>
            </c:if>
            </tbody>
        </table>
    </section>
</div>
<script src="js/jquery-2.0.3.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/application.js"></script>
</body>
</html>