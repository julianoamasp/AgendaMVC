<%@ page import="javax.servlet.http.HttpSession" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
</head>
<body>

<%
	HttpSession se = request.getSession();
	se.setAttribute("usuario", null);
	se.removeAttribute("usuario");
	se.invalidate();
	response.sendRedirect("index.jsp");
	
%>

</body>
</html>