<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page isELIgnored = "false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Success</title>
</head>
<body>
<h1>${Header}</h1>
<p>${Desc}</p>
<hr>
<h1>Welcome, ${user.userName }</h1>
<h1>Your email address is ${user.email } </h1>
<h1>Your Password is ${user.password } try to secure the password</h1>
</body>
</html>