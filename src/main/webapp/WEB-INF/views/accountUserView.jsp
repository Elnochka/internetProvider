<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Account list</title>
</head>
<body>

<jsp:include page="_header.jsp"></jsp:include>
<jsp:include page="_menuUser.jsp"></jsp:include>


<h3>Account list</h3>

<p style="color: red;">${errorString}</p>

<p style="color: blue;">Subscriber: ${element.getNameSubscriber()}</p>

    <table border="1" cellpadding="5" cellspacing="1" >

    <tr>
        <th>Id</th>
        <th>Account</th>
        <th>Balance</th>
        <th>Edit</th>

    </tr>
    <c:forEach items="${accountList}" var="account" >
        <tr>
            <td>${account.idAccount}</td>
            <td>${account.account}</td>
            <td>${account.balance}</td>

            <td>
                <a href="editAccount?idAccount=${account.idAccount}">Edit</a>
            </td>

        </tr>

    </c:forEach>
</table>


<jsp:include page="_footer.jsp"></jsp:include>

</body>
</html>
