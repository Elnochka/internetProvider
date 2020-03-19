<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Subscribers list</title>
</head>
<body>

<jsp:include page="_header.jsp"></jsp:include>
<jsp:include page="_menu.jsp"></jsp:include>

<h3>Subscribers list</h3>

<p style="color: red;">${errorString}</p>

<table border="1" cellpadding="5" cellspacing="1" >
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Account</th>
        <th>Blocked</th>
        <th>Edit</th>
        <th>Delete</th>
    </tr>
    <c:forEach items="${subscriberList}" var="subscriber" >
        <tr>
            <td>${subscriber.idSubscriber}</td>
            <td>${subscriber.nameSubscriber}</td>
            <td>${subscriber.accountObject.account}</td>
            <td>${subscriber.blocked}</td>

            <td>
                <a href="editSubscriber?idSubscriber=${subscriber.idSubscriber}">Edit</a>
            </td>
            <td>
                <a href="deleteSubscriber?idSubscriber=${subscriber.idSubscriber}">Delete</a>
            </td>
        </tr>
    </c:forEach>
</table>

<a href="createSubscriber" >Create Subscriber</a>

<jsp:include page="_footer.jsp"></jsp:include>

</body>
</html>
