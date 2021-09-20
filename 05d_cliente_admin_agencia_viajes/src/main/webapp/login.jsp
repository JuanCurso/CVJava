<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx" crossorigin="anonymous"></script>

</head>
<body>
	<div class="container">
		<div class="text-center my-5 py-3 bg-primary text-white">
				<h1>Agencia de Viajes S.A.</h1>
		</div>
		<div class="row">
			<div class="col-4"></div>
			<div class="col-4">
				<h1 class="text-center">Login</h1>
				<form action="security_check" method="POST" id="form1">
				  <div class="form-group">
				    <label for="exampleUsuario">Usuario: </label>
				    <input type="text" class="form-control" id="j_username" name="j_username">
				  </div>
				  <div class="form-group">
				    <label for="exampleContrasena">Contraseña: </label>
				    <input type="password" class="form-control" id="j_password" name="j_password">
				  </div>
				  <div class="form-group">
			  		<button type="submit" class="btn btn-primary" form="form1">Enviar</button>
				  </div>
				</form>
				
			</div>
			<div class="col-4"></div>
		</div>
	</div>
</body>
</html>