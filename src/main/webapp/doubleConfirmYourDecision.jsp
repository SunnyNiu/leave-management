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
        <form action="confirmYourDecision.do" method="post">
            <div>
                <div class="page-header">
                    <div>
                        <ol class="breadcrumb right">
                            <li class="active">ConfirmYourDecision
                                Welcome! ${userWithDepartmentInfo.getUserName()} ${today}</li>
                        </ol>
                    </div>
                </div>
            </div>
            <div class="button" align="center">
                <button class="btn btn-primary" type="submit" name="confirmBtn"
                        value="${leaveApplicationHistory.getId()}"> Confirm
                </button>
                <button class="btn btn-primary" type="submit" name="cancelBtn"
                        value="${leaveApplicationHistory.getId()}">Cancel
                </button>
                <input type="text" hidden name="applicationStatus" value="${Status}"/>
                <%
                    String pagesNumber = request.getParameter("pagesNumber");
                    request.setAttribute("pagesNumber", pagesNumber);
                    String selectedStatus = request.getParameter("selectedStatus");
                    request.setAttribute("selectedStatus", selectedStatus);
                %>
                <input type="text" name="pagesNumber" value="${pagesNumber}"/>
                <input type="text" name="selectedStatus" value="${selectedStatus}"/>
            </div>
        </form>
    </section>
    <div id="footer" align="center">
        Copyright @www.uc.cn.com
    </div>
</div>
<script src="js/jquery-2.0.3.min.js"></script>
<script src="js/bootstrap.min.js"></script>
</body>
</html>


