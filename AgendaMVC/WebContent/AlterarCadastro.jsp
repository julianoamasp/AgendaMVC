<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.util.ArrayList"%>
<%@page import="service.ContatoService"%>
<%@page import="model.Usuario"%>
<%@page import="model.Contato"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Alterar Cadastro</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>	
<style type="text/css">
label {
	font-size: 20px;
	font-family: sans-serif;
	color: #666666;
}
</style>
</head>
<body>
<%
	Usuario usuario = (Usuario) request.getSession().getAttribute("usuario");
	ContatoService contatoService = new ContatoService();
%>
<div align="center" style="padding: 20px;">
			<img alt="" src="img/img1.png">
			<div class="row">
				<form action="UsuarioController" method="post">
					<input type="text" name="id" hidden="" value="<%= usuario.getId() %>">
					<div class="col-sm-12" style="padding: 5px;">
					<label>nome</label>
					<input type="text" name="nome" value="<%= usuario.getNome() %>">
					</div>
					<div class="col-sm-12" style="padding: 5px;">
					<label>email</label>
					<input type="text" name="email" value="<%= usuario.getEmail() %>">
					</div>
					<div class="col-sm-12" style="padding: 5px;">
					<label>senha</label>
					<input type="text" name="senha" value="<%= usuario.getSenha() %>">
					</div>
					<div class="col-sm-12" style="padding: 5px;">
					<input type="submit" name="acao" value="Alterar" class="btn btn-primary">
					</div>
					</form>
				
				<div class="col-sm-12" style="padding: 5px;">
				<a href="Principal.jsp">Voltar</a>
				</div>
			</div>
</div>
</body>
</html>