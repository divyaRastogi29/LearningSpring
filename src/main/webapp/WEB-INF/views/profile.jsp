<%--
  Created by IntelliJ IDEA.
  User: divya
  Date: 5/10/16
  Time: 10:28 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Profile</title>
</head>
<body>
<h1>Your Profile</h1>
    <c:out value="${spitter.username} is profile of user"/><br/>
    <c:out value="${spitter.firstName}"/><br/>
    <c:out value="${spitter.lastName}"/><br/>
</body>
</html>
