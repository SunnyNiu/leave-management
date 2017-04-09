
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
            <div class="right" align="right">
                <div align="right">
                    <header align="right">Welcome! ${userWithDepartmentInfo.getUserName()} ${today} </header>
                    <label hidden>${login}</label>
                </div>
                <div align="center">
                    <label>
                        <%@ include file="error.jsp" %>
                    </label>
                    <div>
                        <table align="center">
                            <tr>
                                <td height="50px">&nbsp;</td>
                                <td></td>
                                <td rowspan="10">
                                    <form action="upload.do" method="post" enctype="multipart/form-data">
                                        <table align="left">
                                            <tr><input type="file" name="photo"/></tr>
                                            <br/>
                                            <tr><input type="submit"/></tr>
                                            <br/>
                                            <tr><img height="200" width="200"
                                                     src="http://localhost:8092/${userWithDepartmentInfo.getUserName()}profile.jpg">
                                            </tr>
                                        </table>
                                    </form>
                                </td>
                            </tr>
                            <tr>
                                <td align="left"><label>Name:</label></td>
                                <td><input type="text" value="${userWithDepartmentInfo.getUserName()}" disabled></td>
                                <td></td>
                            </tr>
                            <tr>
                                <td align="left"><label>Title:</label></td>
                                <td><input type="text" value="${userWithDepartmentInfo.getTitle()}" disabled></td>
                                <td></td>
                            </tr>
                            <tr>
                                <td align="left"><label>Birthday Date:</label></td>
                                <td><input type="text" value="${userWithDepartmentInfo.getBirthday()}" disabled></td>
                                <td></td>
                            </tr>
                            <tr>
                                <td align="left"><label>Join Date:</label></td>
                                <td><input type="text" value="${userWithDepartmentInfo.getJoinDate()}" disabled></td>
                                <td></td>
                            </tr>
                            <tr>
                                <td align="left"><label>Department:</label></td>
                                <td><input type="text" value="${userWithDepartmentInfo.getDepartmentName()}" disabled>
                                </td>
                                <td></td>
                            </tr>
                            <tr>
                                <td align="left"><label>Manager:</label></td>
                                <td><input type="text" value="${userWithDepartmentInfo.getManagerName()}" disabled></td>
                                <td></td>
                            </tr>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div id="footer">
        Copyright © xxx.com
    </div>
</div>
</body>
</html>
