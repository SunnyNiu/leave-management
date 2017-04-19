<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <link rel="stylesheet" href="style.css" type="text/css"/>
</head>
<body>
<div>
    <div id="header">
        <h1>Leave Management System</h1>
    </div>
    <div id="parent">
        <form action="login.do" method="post">
            <h1 align="center">Welcome!</h1>
            <div align="center">
                <label>
                    <%@ include file="error.jsp" %>
                </label>
                <fieldset>
                    <legend>Login:</legend>
                    Login:&nbsp&nbsp&nbsp&nbsp&nbsp <input type="text" name="login" id="login" maxlength="15"><br>
                    <br>
                    Password: <input type="password" name="password" id="password" maxlength="15">
                </fieldset>
            </div>
            <div class="setting" align="center" class="setting">
                <button type="submit">Login</button>
            </div>
        </form>
    </div>
    <div id="footer" align="center">
        Copyright © xxx.com
    </div>
</div>
</body>
</html>
