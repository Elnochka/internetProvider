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
<jsp:include page="_menu.jsp"></jsp:include>


<h3>Account list</h3>

<p style="color: red;">${errorString}</p>


    <table border="1" cellpadding="5" cellspacing="1" >

    <tr>
        <th>Id</th>
        <th>Account</th>
        <th>Balance</th>
        <th>Edit</th>
        <th>Delete</th>
    </tr>
    <c:forEach items="${accountList}" var="account" >
        <tr>
            <td>${account.idAccount}</td>
            <td>${account.account}</td>
            <td>${account.balance}</td>

            <td>
                <a href="editAccount?idAccount=${account.idAccount}">Edit</a>
            </td>
            <td>
                <a href="deleteAccount?idAccount=${account.idAccount}">Delete</a>
            </td>
        </tr>

    </c:forEach>
</table>


<a href="createAccount" >Create account</a>

<jsp:include page="_footer.jsp"></jsp:include>

</body>
</html>
