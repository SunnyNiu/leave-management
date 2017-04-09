<%--
  Created by IntelliJ IDEA.
  User: Sunny
  Date: 8/02/2017
  Time: 9:55 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<ul>
    <c:forEach items="${errorList}" var="error">
        <li text-align: left>${error}</li>
    </c:forEach>
</ul>
