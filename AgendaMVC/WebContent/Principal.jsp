<%@page import="java.util.ArrayList"%>
<%@page import="service.ContatoService"%>
<%@page import="model.Usuario"%>
<%@page import="model.Contato"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Principal</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<!-- jQuery library -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<!-- Latest compiled JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<style type="text/css">
h1 {
	font-family: sans-serif;
	color: #66CC00;
}

input.oc {
	border: none;
}

h3, label, th, td {
	font-family: sans-serif;
	color: #666666;
	padding: 4px;
}
</style>
</head>
<body>
	<div align="center" style="padding: 20px;">
		<%
			Usuario usuario = (Usuario) request.getSession().getAttribute("usuario");
			ContatoService contatoService = new ContatoService();
			ArrayList<Contato> contatos = contatoService.listarContatos(usuario);
		%>
		<div>
			<h1>
				Olá!
				<%=usuario.getNome()%></h1>
			<a href="AlterarCadastro.jsp">Alterar</a> 
 <a href="LogOut.jsp">Sair</a>
		</div>
		<h3>Adicionar Contato</h3>
		<form action="ContatoController" method="post">
			<label>nome</label> <input type="text" name="nome"> <label>descrição</label>
			<input type="text" name="descricao"> <label>numero</label> <input
				type="text" name="telefone"> <input type="submit"
				name="acao" value="Adicionar" class="btn">
		</form>
		<h3>Contatos</h3>
		<table class="table table-hover">


			<tr>
				<th>Nome</th>
				<th>Descrição</th>
				<th>Numero</th>
				<th>Apagar/Atualizar</th>
			</tr>
			<%
				for (Contato c : contatos) {
			%>
			<tr>
				<form action="ContatoController" method="post">
					<input type="text" name="id" value="<%=c.getId()%>" hidden=""
						id="oc">
					<td><input type="text" value="<%=c.getNome()%>" name="nome"
						class="oc"></td>
					<td><input type="text" value="<%=c.getDescricao()%>"
						name="descricao" class="oc"></td>
					<td><input type="text" value="<%=c.getNumero()%>"
						name="telefone" class="oc"></td>
					<td><input type="submit" value="x" name="acao"
						class="btn btn-danger"> <input type="submit" value="v"
						name="acao" class="btn btn-warning"></td>
				</form>
			</tr>
			<%
				}
			%>
		</table>
	</div>
</body>
</html>