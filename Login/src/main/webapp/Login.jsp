<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	String u = "Luu";
	String p = "123";
	if(u.equals("Luu")&&(p.equals("123")))
	{
		response.sendRedirect("UserProfile.html");
	}
	else
		response.sendRedirect("Login.html");
%>
</body>
</html>