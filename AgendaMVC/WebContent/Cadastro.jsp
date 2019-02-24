<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cadastro</title>
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
<div align="center" style="padding: 20px;">
			<img alt="" src="img/img1.png">
			<div class="row">
				<form action="UsuarioController" method="post">
					<div class="col-sm-12" style="padding: 5px;">
					<label>nome</label>
					<input type="text" name="nome">
					</div>
					<div class="col-sm-12" style="padding: 5px;">
					<label>email</label>
					<input type="text" name="email">
					</div>
					<div class="col-sm-12" style="padding: 5px;">
					<label>senha</label>
					<input type="password" name="senha">
					</div>
					<div class="col-sm-12" style="padding: 5px;">
					<input type="submit" name="acao" value="Cadastrar" class="btn btn-primary">
					</div>
					</form>
				
				<div class="col-sm-12" style="padding: 5px;">
				<a href="index.jsp">Voltar</a>
				</div>
			</div>
</div>
			
</body>
</html>