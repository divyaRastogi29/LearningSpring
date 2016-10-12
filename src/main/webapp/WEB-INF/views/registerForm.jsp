<%--
  Created by IntelliJ IDEA.
  User: divya
  Date: 5/10/16
  Time: 8:53 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Spittr</title>
    <link rel="stylesheet" type="text/css"
          href="<c:url value="/resources/style.css" />">
</head>
<body>

<h1>Registration Form</h1>

<form method="post">
    First Name   :  <input type="text" name="firstName"/> <br/><br/>
    Last Name  :  <input type="text" name="lastName"/> <br/><br/>
    Username :  <input type="text" name="username"/> <br/><br/>
    Password :  <input type="text" name="password"/> <br/><br/>
    <input type="submit" value="Register"/>
</form>

</body>
</html>
