<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="java.util.List"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ProclicksHome</title>
</head>
<body>
<h1>This is ProclicksHome Page</h1>
<%Integer id = (Integer)request.getAttribute("id"); 
String name = (String)request.getAttribute("name"); 
List<String> friends = (List<String>) request.getAttribute("friends");
%>
<h1>Id is <%=id%></h1>
<h1>Name is <%=name%></h1>
<h1>Friends names are - </h1>
	<% for (String s: friends)
	{ 
	%>
		<h1><%=s%></h1>
	<%
	} 
	%>
</body>
</html>