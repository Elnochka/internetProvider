
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%--<%@ taglib uri="/WEB-INF/tag/hey.tld" prefix="custom" %>--%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Main Page</title>
</head>
<body>


<jsp:include page="/WEB-INF/views/_header.jsp"></jsp:include>


<h3>Main Page</h3>
<%--<h3>--%>
    <%--<custom:hey name='people' />--%>
<%--</h3>--%>

<form method="POST" action="${pageContext.request.contextPath}/login">
    <table border="0">

        <tr>
            <td>Login</td>
            <td><input type="text" name="name" value="${element.name}" /></td>
        </tr>


        <tr>
            <td colspan = "2">
                <input type="submit" value="Login" />

            </td>
        </tr>
    </table>

</form>


<jsp:include page="/WEB-INF/views/_footer.jsp"></jsp:include>


</body>
</html>
