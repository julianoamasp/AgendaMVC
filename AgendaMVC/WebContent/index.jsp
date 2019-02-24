<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Agenda</title>
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
	color: #3366CC;
}
</style>
</head>
<body>
<div align="center" style="padding: 20px;">
			<img alt="" src="img/img1.png">
			<div class="row">
				<form action="UsuarioController" method="post">
				<div class="col-sm-12">
				<label>email</label>
				</div>
			</div>
			<div class="row">
				<div class="col-sm-12">
					<input type="text" name="email">
				</div>
			</div>
			<div class="row">
				<div class="col-sm-12">
					<label>senha</label>
				</div>
			</div>
			<div class="row">
				<div class="col-sm-12">	
					<input type="password" name="senha">
				</div>
			</div>	
			<div class="row">
				<div class="col-sm-12" style="padding: 5px;">
					<input type="submit" name="acao" value="Entrar" class="btn btn-primary">
				</form>
				</div>
			</div>
			<div class="row">
				<div class="col-sm-12" style="padding: 5px;">				
				<a href="Cadastro.jsp">cadastrar</a>
				</div>
			</div>
</div>
</body>
</html>