<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Tariff of favour list</title>
</head>
<body>

<jsp:include page="_header.jsp"></jsp:include>
<c:if test="${sessionScope.subscriberSession.getName().equals('Administrator')}">
    <jsp:include page="_menu.jsp"></jsp:include>
</c:if>
<c:if test="${!sessionScope.subscriberSession.getName().equals('Administrator')}">
    <jsp:include page="_menuUser.jsp"></jsp:include>
</c:if>

<h3>Tariff of favour list</h3>

<p style="color: red;">${errorString}</p>

<table border="1" cellpadding="5" cellspacing="1" >
    <tr>
        <th>Id</th>
        <th>Subscriber</th>
        <th>Tariff</th>
        <th>Favour</th>
        <th>Delete</th>

    </tr>
    <c:forEach items="${tariffFavourList}" var="tariffFavour" >
        <tr>
            <td>${tariffFavour.idTariffFavour}</td>
            <td>${tariffFavour.subscriber.getNameSubscriber()}</td>
            <td>${tariffFavour.tariff.getNameTariff()}</td>
            <td>${tariffFavour.favour.getNameFavour()}</td>
            <td>
                <a href="deleteTariffFavour?idTariffFavour=${tariffFavour.idTariffFavour}">Delete</a>
            </td>

        </tr>
    </c:forEach>
</table>

<a href="createTariffFavour" >Create tariff of favours</a>

<jsp:include page="_footer.jsp"></jsp:include>

</body>
</html>
