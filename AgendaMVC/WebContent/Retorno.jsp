<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Aviso</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>	
<style type="text/css">
h1 {
	font-family: sans-serif;
	color: #FF9933;
}
h3 {
	font-family: sans-serif;
	color: #999999;
}
</style>
</head>
<body>
	<div align="center" style="padding: 20px;">
	<img alt="" src="img/img1.png">
	<h1><%= request.getAttribute("retorno") %></h1>
	<h3><%= request.getAttribute("retornoDescricao") %></h3>
	<a href="<%= request.getAttribute("link") %>">Voltar</a>
	</div>
</body>
</html>