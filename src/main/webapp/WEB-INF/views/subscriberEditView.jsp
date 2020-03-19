<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Edit subscriber</title>
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

<h3>Edit subscriber</h3>

<p style="color: red;">${errorString}</p>

<c:if test="${not empty subscriberForm}">
    <form:form method="POST" action="${pageContext.request.contextPath}/editSubscriber" modelAttribute="subscriberForm">
        <form:input type="hidden" path="idSubscriber" />
        <table border="0">
            <tr>
                <td>Id
                <td style="color:red;">${subscriberForm.idSubscriber}</td>
            </tr>
            <tr>
                <td>Subscriber name</td>
                <td><form:input path="nameSubscriber" /></td>
                <td><form:errors path="nameSubscriber" cssClass="error" /></td>
            </tr>
            <tr>
                <td>Account</td>
                <td><select name="account">
                    <c:forEach items="${listAccount}" var="accountValue">
                        <option value="${accountValue.idAccount}"
                                ${accountValue.account == subscriberForm.accountObject.account ? 'selected="selected"' : ''}>${accountValue.account}
                        </option>
                    </c:forEach>
                </select>

            </tr>
            <tr>
                <td>Blocked</td>
                <td><input type="checkbox" name="blocked" value="1"
                           <c:if test="${subscriberForm.blocked == true}">checked="checked"</c:if>/></td>

            </tr>

            <tr>
                <td colspan = "2">
                    <input type="submit" value="Edit" />
                    <a href="${pageContext.request.contextPath}/subscribers">Cancel</a>
                </td>
            </tr>
        </table>
    </form:form>
</c:if>

<jsp:include page="_footer.jsp"></jsp:include>

</body>
</html>