<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Tariff create</title>
    <style>
        .error {
            color: #ff0000;
            font-style: italic;
            font-weight: bold;
        }
    </style>
</head>
<body>

<h3>Tariff create</h3>


<form:form method="POST" action="${pageContext.request.contextPath}/createTariff" modelAttribute="tariffForm">
    <table border="0">

        <tr>
            <td>Tariff name</td>
            <td><form:input path="nameTariff" /></td>
            <td><form:errors path="nameTariff" cssClass="error" /></td>
        </tr>
        <tr>
            <td>Tariff price</td>
            <td><form:input path="price" /></td>
            <td><form:errors path="price" cssClass="error" /></td>
        </tr>
        <tr>
            <td>Path file</td>
            <td><form:input path="pathFile" /></td>
            <td><form:errors path="pathFile" cssClass="error" /></td>
        </tr>

        <tr>
            <td colspan ="2">
                <input type="submit" value= "Create tariff" />
                <a href="${pageContext.request.contextPath}/tariffs">Cancel</a>
            </td>
        </tr>

    </table>
</form:form>

<p style="color:blue;">Tariff name: base</p>
<p style="color:blue;">Tariff price: 34.33</p>
<p style="color:blue;">Tariff path file: d:/tariff.txt</p>

</body>
</html>
