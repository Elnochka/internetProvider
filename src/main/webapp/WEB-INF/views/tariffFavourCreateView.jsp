<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Tariff of favours list</title>
</head>
<body>

<jsp:include page="_header.jsp"></jsp:include>
<c:if test="${sessionScope.subscriberSession.getName().equals('Administrator')}">
    <jsp:include page="_menu.jsp"></jsp:include>
</c:if>
<c:if test="${!sessionScope.subscriberSession.getName().equals('Administrator')}">
    <jsp:include page="_menuUser.jsp"></jsp:include>
</c:if>

<h3>Tariff of favours list</h3>

<p style="color: red;">${errorString}</p>

<form:form method="POST" action="${pageContext.request.contextPath}/createTariffFavour" modelAttribute="tariffFavourForm">
    <table border="0">
        <tr>
            <td><label>Subscriber </label>&nbsp;</td>
            <td><form:select path="idSubscriber">
                <c:forEach items="${subscriberList}" var="subscriberValue">
                    <form:option value="${subscriberValue.idSubscriber}">
                            ${subscriberValue.nameSubscriber}
                    </form:option>
                </c:forEach>
            </form:select>
            </td>
        </tr>
        <tr>
            <td><label>Tariff </label>&nbsp;</td>
            <td><form:select path="idTariff">
                <c:forEach items="${tariffList}" var="tariffValue">
                    <form:option value="${tariffValue.idTariff}">
                            ${tariffValue.nameTariff}
                    </form:option>
                </c:forEach>
            </form:select>
            </td>
        </tr>

        <tr>
            <td><label>Favours </label>&nbsp;</td>
            <td><form:select path="idFavour" size="3" multiple="multiple" tabindex="1">
                <c:forEach items="${favourList}" var="favourValue">
                    <form:option value="${favourValue.idFavour}">
                            ${favourValue.nameFavour}
                    </form:option>
                </c:forEach>

            </form:select>
            </td>
        </tr>


        <tr>
            <td colspan ="2">
                <c:if test="${sessionScope.subscriberSession.getName().equals('Administrator')}">
                    <input type="submit" value= "Create tariff of favour" />
                    <a href="${pageContext.request.contextPath}/tariffFavours">Cancel</a>
                </c:if>
                <c:if test="${!sessionScope.subscriberSession.getName().equals('Administrator')}">
                    <input type="submit" value= "Create tariff of favour" />
                    <a href="${pageContext.request.contextPath}/tariffFavoursUser">Cancel</a>
                </c:if>
            </td>
        </tr>
    </table>
</form:form>

<jsp:include page="_footer.jsp"></jsp:include>

</body>
</html>
