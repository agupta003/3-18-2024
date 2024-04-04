<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page isELIgnored = "false" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ProclicksAboutUs</title>
</head>
<body>

<%--<%
/*String name =(String) request.getAttribute("name");
Integer age =(Integer) request.getAttribute("age");*/

--%>
<h1>My Name is </h1>
<%--<%=
//name --%> ${name}<h1> and age is </h1> ${age}
<%--<%=
//age --%>

<hr>
<c:forEach var="item" items="${marks}">
<h1>${item}</h1>
</c:forEach>


</body>
</html>