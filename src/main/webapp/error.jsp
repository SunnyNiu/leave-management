
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<ul>
    <c:forEach items="${errorList}" var="error">
        <li text-align: left>${error}</li>
    </c:forEach>
</ul>
