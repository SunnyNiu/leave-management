<%--
  Created by IntelliJ IDEA.
  User: Sunny
  Date: 27/02/2017
  Time: 4:55 PM
  To change this template use File | Settings | File Templates.
--%>
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
    <div>
        <div id="parent">
            <div class="left">
                <%@ include file="menus.jsp" %>
            </div>
            <div class="right">
                <div align="right">
                    <header align="right">Welcome! ${userWithDepartmentInfo.getUserName()} ${today}</header>
                </div>
                <br>
                <br>
                <label>
                    <%@ include file="error.jsp" %>
                </label>
                <label>${messages}</label>
                <form action="addNewMember.do" method="post">
                    <div align="center">
                        <table>
                            <tr>
                                <td>Login</td> <td><input text="type" name="newLogin" id="nameId" maxlength="10"/>
                                </td>
                                <td>Password</td> <td> <input type="password" name="password" id="passwordId"
                                                                   maxlength="10"/>
                                </td>
                            </tr>
                            <tr>
                                <td>Department</td> <td> <select name="department" id="departmentId">
                                    <c:forEach items="${departmentManagerList}" var="entry">
                                        <option value="${entry.getDepartmentId()}">
                                                ${entry.getDepartmentName()}
                                        </option>
                                    </c:forEach>
                                </select></td>
                                <td>Title</td> <td><select name="title" id="titleId">
                                    <c:forEach items="${titleList}" var="entry">
                                        <option value="${entry.getId()}">
                                                ${entry.getTitle()}
                                        </option>
                                    </c:forEach></select></td>
                            </tr>
                            <tr>
                                <td>Join Date</td> <td><input type="date" pattern="dd/MM/yyyy" name="joinDate"/></td>
                                <td>Birth Date</td> <td><input type="date" pattern="dd/MM/yyyy" name="birthDate"/></td>
                            </tr>
                            <tr>
                                <td>First Name</td> <td> <input text="type" name="firstName" id="firstName"
                                                                     maxlength="10"/>
                                </td>
                                <td>Last Name</td> <td> <input type="type" name="lastName" id="lastName"
                                                                    maxlength="10"/>
                                </td>
                            </tr>
                            <tr>
                                <td>Office Email</td> <td><input type="email" name="email" maxlength="25" width="15px"></td>
                            </tr>
                        </table>
                    </div>
                    <br>
                    <div>
                        <br>
                        <br>
                        <div>
                            <button type="submit" name="addBtn">Submit</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
    <div id="footer">
        Copyright © xxx.com
    </div>
</div>
</body>
</html>