<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Edit favour</title>
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

<h3>Edit favour</h3>

<p style="color: red;">${errorString}</p>

<c:if test="${not empty favourForm}">
    <form:form method="POST" action="${pageContext.request.contextPath}/editFavour" modelAttribute="favourForm">
        <form:input type="hidden" path="idFavour" />
        <table border="0">
            <tr>
                <td>Id
                <td style="color:red;">${favourForm.idFavour}</td>
            </tr>
            <tr>
                <td>Name</td>
                <td><form:input path="nameFavour" /></td>
                <td><form:errors path="nameFavour" cssClass="error" /></td>
            </tr>

            <tr>
                <td colspan = "2">
                    <input type="submit" value="Edit" />
                    <a href="${pageContext.request.contextPath}/favours">Cancel</a>
                </td>
            </tr>
        </table>
    </form:form>
</c:if>

<jsp:include page="_footer.jsp"></jsp:include>

</body>
</html>