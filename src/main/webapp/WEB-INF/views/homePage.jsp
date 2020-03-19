
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="/WEB-INF/tag/hey.tld" prefix="custom" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Home Page</title>
</head>
<body>


<jsp:include page="/WEB-INF/views/_header.jsp"></jsp:include>
<jsp:include page="/WEB-INF/views/_menu.jsp"></jsp:include>


<h3>
    Administrator page

</h3>

<p style="color: red;">${errorString}</p>


<form method="Post" action="${pageContext.request.contextPath}/blockedUser">
    <table border="0">
        <input type="submit" value="Blocked users" />

    </table>
</form>


<jsp:include page="/WEB-INF/views/_footer.jsp"></jsp:include>


</body>
</html>
