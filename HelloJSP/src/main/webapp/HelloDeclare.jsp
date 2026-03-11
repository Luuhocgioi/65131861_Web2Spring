<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%! int x=10; int y; int z=0; %>
	<% y =200;
		z=x+y;
		out.append("ket qua la: ");
		out.append(String.valueOf(z));
	%>
	<h2>Hoặc ta có thể xuất kiểu EXPRESSION</h2>
	<hr>
	<%="Kết quả là: " %>
	<%=z %>
</body>
</html>