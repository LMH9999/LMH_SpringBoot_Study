<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:out value="JdbcTemplate : Hello World"/>
<br>
<c:forEach var="dto" items="${users}">
    ${dto.id} / ${dto.name}<br>
</c:forEach>
</body>
</html>
