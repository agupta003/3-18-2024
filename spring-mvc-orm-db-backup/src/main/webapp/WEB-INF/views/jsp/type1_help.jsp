<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ProclicksAboutUs</title>
</head>
<body>

<%
String name =(String) request.getAttribute("name");
Integer age =(Integer) request.getAttribute("age");
%>
<h1>My Name is </h1><%=name %> <h1> and age is </h1><%=age %>
</body>
</html>