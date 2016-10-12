<%@ taglib prefix="c" uri="http://www.springframework.org/tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
    <title>Spittr</title>
    <link rel="stylesheet"
          type="text/css"
          href="<c:url value="/resources/style.css" />" >
</head>
<body>
<h1>Welcome to Spittr</h1>
<a href="<c:url value="/spittles" />">Spittles</a> <br/>
<a href="<c:url value="/spittles/register" />">Register</a> <br/>
<a href="<c:url value="/spittles/count"/>">Count Spittles</a>
</body>
</html>