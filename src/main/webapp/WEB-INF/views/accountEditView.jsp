<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Edit account</title>
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
<c:if test="${sessionScope.subscriberSession.getName().equals('Administrator')}">
    <jsp:include page="_menu.jsp"></jsp:include>
</c:if>
<c:if test="${!sessionScope.subscriberSession.getName().equals('Administrator')}">
    <jsp:include page="_menuUser.jsp"></jsp:include>
</c:if>

<h3>Edit account</h3>

<p style="color: red;">${errorString}</p>

<c:if test="${not empty accountForm}">
    <c:if test="${sessionScope.subscriberSession.getName().equals('Administrator')}">
    <form:form method="POST" action="${pageContext.request.contextPath}/editAccount" modelAttribute="accountForm">

        <form:input type="hidden" path="idAccount" />
        <table border="0">
            <tr>
                <td>Id
                <p style="color:red;">${accountForm.idAccount}</p></td>
            </tr>
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
                <td colspan = "2">
                    <input type="submit" value="Edit" />
                    <a href="${pageContext.request.contextPath}/accounts">Cancel</a>
                </td>
            </tr>
        </table>
    </form:form>
    </c:if>
        <c:if test="${!sessionScope.subscriberSession.getName().equals('Administrator')}">
            <form method="POST" action="${pageContext.request.contextPath}/editAccountUser">
        <input type="hidden" name="idAccount" value="${accountForm.idAccount}" />
        <input type="hidden" name="account" value="${accountForm.account}" />
        <table border="0">
            <tr>
                <td>Id</td>
                <td style="color:red;">${accountForm.idAccount}</td>
            </tr>
            <tr>
                <td>Account</td>
                <td style="color:red;">${accountForm.account}</td>
            </tr>
            <tr>
                <td>Balance
                <input type="text" name="balance" value="${accountForm.balance}" />
                <p style="color: red;">${errors.balanceError}</p></td>
            </tr>

            <tr>
                <td colspan = "2">
                    <input type="submit" value="Edit" />
                    <a href="${pageContext.request.contextPath}/accountsUser">Cancel</a>
                </td>
            </tr>
        </table>
            </form>
        </c:if>

</c:if>

<jsp:include page="_footer.jsp"></jsp:include>

</body>
</html>