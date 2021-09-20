<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="model.Alumno" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx" crossorigin="anonymous"></script>

<title>Portal del alumno</title>
</head>
<body>
	<div class="container">
	<%@include file="comun.jsp"%>
	<div class="row">
		<div class="col-4"></div>
		<div class="col-4">
			<h1 class="text-center">Login</h1>
			<form action="alumnoLogin" method="POST" id="form1">
			  <div class="form-group">
			    <label for="exampleUsuario">Usuario: </label>
			    <input type="text" class="form-control" id="user" name="usuario">
			  </div>
			  <div class="form-group">
			    <label for="exampleContrasena">Contraseña: </label>
			    <input type="password" class="form-control" id="pass" name="password">
			  </div>
			  <c:if test = "${!empty requestScope.error}">
			  	<span class="text-danger">${requestScope.error}</span>
			  </c:if>
			  <div class="form-group">
		  		<button type="submit" class="btn btn-primary" form="form1">Enviar</button>
			  </div>
<!-- 			  <input id="option" name="option" type="hidden" value="doListarAlumnosPorTema"> -->
			</form>
			
		</div>
		<div class="col-4"></div>
	</div>
	</div>
	
</body>
</html>