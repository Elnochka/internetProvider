<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Error</title>
</head>
<body>

<h3>Error Page</h3>

<%--<p style="color: red;">${errorString}</p>--%>

<h2>You enter wrong name</h2>

<c:if test="${sessionScope.subscriberSession.getName().equals('Administrator')}">
    <a href="${pageContext.request.contextPath}/homePage">Cancel</a>
</c:if>
<c:if test="${!sessionScope.subscriberSession.getName().equals('Administrator')}">
    <a href="${pageContext.request.contextPath}/userPage">Cancel</a>
</c:if>


</body>
</html>
