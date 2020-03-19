<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Favour create</title>
    <style>
        .error {
            color: #ff0000;
            font-style: italic;
            font-weight: bold;
        }
    </style>
</head>
<body>

<h3>Favour create</h3>


<form:form method="POST" action="${pageContext.request.contextPath}/createFavour" modelAttribute="favourForm">
    <table border="0">
        <tr>
            <td>Favour name</td>
            <td><form:input path="nameFavour" /></td>
            <td><form:errors path="nameFavour" cssClass="error" /></td>
        </tr>

        <tr>
            <td colspan ="2">
                <input type="submit" value= "Create favour" />
                <a href="${pageContext.request.contextPath}/favours">Cancel</a>
            </td>
        </tr>
    </table>
</form:form>

<p style="color:blue;">Favour name: TV</p>


</body>
</html>
