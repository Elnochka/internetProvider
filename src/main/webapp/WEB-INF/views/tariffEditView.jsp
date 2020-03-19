<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Edit tariff</title>
    <style>
        .error {
            color: #ff0000;
            font-style: italic;
            font-weight: bold;
        }
    </style>
</head>
<body>

<jsp:include page="_header.jsp"></jsp:include>
<jsp:include page="_menu.jsp"></jsp:include>

<h3>Edit tariff</h3>

<p style="color: red;">${errorString}</p>

<c:if test="${not empty tariffForm}">
    <form:form method="POST" action="${pageContext.request.contextPath}/editTariff" modelAttribute="tariffForm">
        <form:input type="hidden" path="idTariff" />
        <table border="0">
            <tr>
                <td>Id
                <p style="color:red;">${tariffForm.idTariff}</p></td>
            </tr>
            <tr>
                <td>Name</td>
                <td><form:input path="nameTariff" /></td>
                <td><form:errors path="nameTariff" cssClass="error" /></td>
            </tr>
            <tr>
                <td>Price</td>
                <td><form:input path="price" /></td>
                <td><form:errors path="price" cssClass="error" /></td>
            </tr>
            <tr>
                <td>Path file</td>
                <td><form:input path="pathFile" /></td>
                <td><form:errors path="pathFile" cssClass="error" /></td>
            </tr>

            <tr>
                <td colspan = "2">
                    <input type="submit" value="Edit" />
                    <a href="${pageContext.request.contextPath}/tariffs">Cancel</a>
                </td>
            </tr>
        </table>
    </form:form>
</c:if>

<jsp:include page="_footer.jsp"></jsp:include>

</body>
</html>