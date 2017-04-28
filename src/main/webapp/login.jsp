<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
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
        <h3 align="center">
            This is leave management system, you can apply for leave and search your leave histories
        </h3>
        <form action="login.do" method="post" class="form-horizontal">
            <label>
                <%@ include file="error.jsp" %>
            </label>
            <div class="form-group">
                <label for="username" class="control-label col-md-4">username:</label>
                <div class="col-md-8">
                    <div class="input-group">
                        <input type="text" name="username" id="username" maxlength="15" placeholder="e.g. Your Name">
                    </div>
                </div>
            </div>
            <div class="form-group">
                <label for="password" class="control-label col-md-4">Password:</label>
                <div class="col-md-8">
                    <div class="input-group">
                        <input type="password" name="password" id="password" maxlength="15" placeholder="e.g. Password">
                    </div>
                </div>
            </div>
            </br>
            <div class="form-group">
                <div class="col-md-8 col-md-offset-4 col-lg-6">
                    <button class="btn btn-primary" type="submit">Login</button>
                </div>
            </div>
        </form>
    </section>
    <footer class="container">
        <div class="col-md-8 col-md-offset-4">
            <p>Copyright © xxx.com</p>
        </div>
    </footer>
</div>
<script src="js/jquery-2.0.3.min.js"></script>
<script src="js/bootstrap.min.js"></script>
</body>
</html>
