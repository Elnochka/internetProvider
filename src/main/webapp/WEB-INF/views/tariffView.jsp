<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Tariff list</title>
</head>
<body>

<jsp:include page="_header.jsp"></jsp:include>
<c:if test="${sessionScope.subscriberSession.getName().equals('Administrator')}">
    <jsp:include page="_menu.jsp"></jsp:include>
</c:if>
<c:if test="${!sessionScope.subscriberSession.getName().equals('Administrator')}">
    <jsp:include page="_menuUser.jsp"></jsp:include>
</c:if>

<h3>Tariff list</h3>

<p style="color: red;">${errorString}</p>


<form method="GET" action="${pageContext.request.contextPath}/tariffs">
    <c:if test="${sessionScope.subscriberSession.getName().equals('Administrator')}">
    <table border="1" cellpadding="5" cellspacing="1" >

            <p><input name="sort" type="submit" value="Sort" />
                    <input type="radio" name="sorting" value="maxPrice" <c:if test="${'maxPrice'.equals(sortList)}">checked</c:if>/> sortMaxPrice
                    <input type="radio" name="sorting" value="minPrice" <c:if test="${'minPrice'.equals(sortList)}">checked</c:if>/> sortMinPrice
                    <input type="radio" name="sorting" value="sortAz" <c:if test="${'sortAz'.equals(sortList)}">checked</c:if>/> sortAz
                    <input type="radio" name="sorting" value="sortZa" <c:if test="${'sortZa'.equals(sortList)}">checked</c:if>/> sortZa</p>


    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Price</th>
        <th>Path file</th>
        <th>Edit</th>
        <th>Delete</th>
        <th>Download</th>
    </tr>
    <c:forEach items="${tariffList}" var="tariff" >
        <tr>
            <td>${tariff.idTariff}</td>
            <td>${tariff.nameTariff}</td>
            <td>${tariff.price}</td>
            <td>${tariff.pathFile}</td>

            <td>
                <a href="editTariff?idTariff=${tariff.idTariff}">Edit</a>
            </td>
            <td>
                <a href="deleteTariff?idTariff=${tariff.idTariff}">Delete</a>
            </td>
            <td>
                <a href="downloadFile?idTariff=${tariff.idTariff}">Download</a>
            </td>
        </tr>

    </c:forEach>
</table>
    </c:if>
    <c:if test="${!sessionScope.subscriberSession.getName().equals('Administrator')}">
    <table border="1" cellpadding="5" cellspacing="1" >

        <p><input name="sort" type="submit" value="Sort" />
            <input type="radio" name="sorting" value="maxPrice" <c:if test="${'maxPrice'.equals(sortList)}">checked</c:if>/> sortMaxPrice
            <input type="radio" name="sorting" value="minPrice" <c:if test="${'minPrice'.equals(sortList)}">checked</c:if>/> sortMinPrice
            <input type="radio" name="sorting" value="sortAz" <c:if test="${'sortAz'.equals(sortList)}">checked</c:if>/> sortAz
            <input type="radio" name="sorting" value="sortZa" <c:if test="${'sortZa'.equals(sortList)}">checked</c:if>/> sortZa</p>

        <tr>
            <th>Id</th>
            <th>Name</th>
            <th>Price</th>
            <th>Download</th>
        </tr>
        <c:forEach items="${tariffList}" var="tariff" >
            <tr>
                <td>${tariff.idTariff}</td>
                <td>${tariff.nameTariff}</td>
                <td>${tariff.price}</td>

                <td>
                    <a href="downloadFile?idTariff=${tariff.idTariff}">Download</a>
                </td>
            </tr>

        </c:forEach>
    </table>
    </c:if>
</form>

<c:if test="${sessionScope.subscriberSession.getName().equals('Administrator')}">
    <a href="createTariff" >Create tariff</a>
</c:if>

<jsp:include page="_footer.jsp"></jsp:include>

</body>
</html>
