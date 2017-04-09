
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <style type="text/css">@import "style.css";</style>
</head>
<body>
<div id="header">
    <h1>Leave Management System</h1>
</div>
<div style="text-align:center; vertical-align:middle" class="formdiv">
    <form action="confirmYourDecision.do" method="post">
        <h1 align="center">Welcome!</h1>
        <div align="center">
            <label>Confirm Your Decision</label>
            <label>
                <%@ include file="error.jsp" %>
            </label>
        </div>
        <div class="button" align="center">
            <button type="submit" name="confirmBtn" value="${leaveApplicationHistory.getId()}"> Confirm</button>
            <button type="submit" name="cancelBtn" value="${leaveApplicationHistory.getId()}">Cancel</button>
            <input hidden name="applicationStatus" value="${Status}"></input>
        </div>
    </form>
</div>
<div id="footer">
    Copyright © xxx.com
</div>
</body>
</html>


