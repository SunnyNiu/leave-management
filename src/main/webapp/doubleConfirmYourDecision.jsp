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
        <form action="confirmYourDecision.do" method="post">
            <h1 align="center">Welcome!</h1>
            <div align="center">
                <label>Confirm Your Decision</label>
                <label>
                    <%@ include file="error.jsp" %>
                </label>
            </div>
            <div class="button" align="center" class="setting">
                <button type="submit" name="confirmBtn" value="${leaveApplicationHistory.getId()}"> Confirm</button>
                <button type="submit" name="cancelBtn" value="${leaveApplicationHistory.getId()}">Cancel</button>
                <input hidden name="applicationStatus" value="${Status}"></input>
            </div>
        </form>
    </div>
    <div id="footer" align="center">
        Copyright © xxx.com
    </div>
</div>
</body>
</html>


