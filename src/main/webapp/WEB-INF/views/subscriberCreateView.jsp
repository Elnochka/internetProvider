<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Subscriber create</title>
    <style>
        .error {
            color: #ff0000;
            font-style: italic;
            font-weight: bold;
        }
    </style>
</head>
<body>

<h3>Subscriber create</h3>
<p style="color: red;">${errorString}</p>


<form:form method="POST" action="${pageContext.request.contextPath}/createSubscriber" modelAttribute="subscriberForm">
    <table border="0">
        <tr>
            <td>Subscriber name</td>
            <td><form:input path="nameSubscriber" /></td>
            <td><form:errors path="nameSubscriber" cssClass="error" /></td>
        </tr>
        <tr>
            <td>Subscriber account
            <form:select path="account">
                <c:forEach items="${listAccount}" var="accountValue">
                    <form:option value="${accountValue.idAccount}">
                            ${accountValue.account}
                    </form:option>
                </c:forEach>
            </form:select></td>


        </tr>
        <tr>
            <td>Blocked
            <form:checkbox path="blocked" value= "1" /> </td>
        </tr>

        <tr>
            <td colspan ="2">
                <input type="submit" value= "Create subscriber" />
                <a href="${pageContext.request.contextPath}/subscribers">Cancel</a>
            </td>
        </tr>
    </table>
</form:form>

<p style="color:blue;">Subscriber name: people</p>
<p style="color:blue;">Subscriber account: 321123</p>
<p style="color:blue;">Blocked: false</p>


</body>
</html>
