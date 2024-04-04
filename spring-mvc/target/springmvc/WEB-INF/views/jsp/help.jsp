<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page isELIgnored = "false" %> <!-- This is for enabling "&{fields name here}" -->
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  <!-- This is for for-loop -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ProclicksAboutUs</title>
</head>
<body>

<h1>My Name is </h1> ${name}<h1> and age is </h1> ${age}

<hr>

<c:forEach var="item" items="${marks}">
	<h1>${item}</h1>
</c:forEach>


</body>
</html>