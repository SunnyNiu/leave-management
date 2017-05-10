<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta http-equiv="refresh" content="30; url=login.jsp">
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/cerulean.bootstrap.min.css">
    <link ref="stylesheet" href="css/bootstrap-theme.css">
    <link rel="stylesheet" href="css/style.css" rel="stylesheet"/>
</head>
<body>
<div>
    <div class="page-header">
        <h1 align="center">Leave Management System</h1>
    </div>
    <section id="body" class="container">
        <form action="login.do" method="post" class="form-horizontal table-bordered">
            <div id="borderPadding">
                <div align="center">
                    <label>
                        <%@ include file="error.jsp" %>
                    </label>
                </div>
                <div class="form-group">
                    <label for="username" class="control-label col-md-4">Username:</label>
                    <div class="col-md-8">
                        <div class="input-group">
                            <!--<input type="text" name="username" id="username" maxlength="15" value="William">-->
                            <input type="text" name="username" id="username" maxlength="15">
                        </div>
                    </div>
                </div>
                <div class="form-group">
                    <label for="password" class="control-label col-md-4">Password:</label>
                    <div class="col-md-8">
                        <div class="input-group">
                            <!--<input type="password" name="password" id="password" maxlength="15" value="Wil123">-->
                            <input type="password" name="password" id="password" maxlength="15">
                        </div>
                    </div>
                </div>
                </br>
                <div>
                    <div class="col-md-4 col-md-offset-2 col-sm-4 col-sm-offset-2">
                        <button class="btn btn-primary pull-right" type="submit" id="loginSubmit">Login</button>
                    </div>
                    <div class="col-md-8"></div>
                </div>
            </div>
        </form>
    </section>
    <footer class="container">
        <div class="col-md-8 col-md-offset-4">
            <p>Copyright @www.uc.cn.com</p>
        </div>
    </footer>
</div>
<script src="js/jquery-2.0.3.min.js"></script>
<script src="js/bootstrap.min.js"></script>
</body>
</html>
