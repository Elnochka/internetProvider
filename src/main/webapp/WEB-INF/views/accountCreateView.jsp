<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Account create</title>
    <style>
        .error {
            color: #ff0000;
            font-style: italic;
            font-weight: bold;
        }
    </style>
</head>
<body>

<h3>Account create</h3>


<form:form method="POST" action="${pageContext.request.contextPath}/createAccount" modelAttribute="accountForm">
    <table border="0">
        <tr>
            <td>Account</td>
            <td><form:input path="account" /></td>
            <td><form:errors path="account" cssClass="error" /></td>
        </tr>
        <tr>
            <td>Balance</td>
            <td><form:input path="balance" /></td>
            <td><form:errors path="balance" cssClass="error" /></td>
        </tr>

        <tr>
            <td colspan ="2">
                <input type="submit" value= "Create account" />
                <a href="${pageContext.request.contextPath}/accounts">Cancel</a>
            </td>
        </tr>
    </table>
</form:form>

<p style="color:blue;">Account: 123456</p>
<p style="color:blue;">Balance: 34.33</p>

</body>
</html>
