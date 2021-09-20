<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List" %>
<%@ page import="model.Curso" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx" crossorigin="anonymous"></script>
<title>Formación JavaEE</title>
</head>
<body>
<div class="container">
<%@include file="comun.jsp"%>

	<div class="row">
		<div class="col-4"></div>
		<div class="col-4">
			<h1 class="text-center">Matricular en un curso</h1>
			<form action="matricularAlumno" method="POST" id="form1">
			  <div class="form-group">
			    <label for="exampleUsuario">Seleccione el curso: </label>
			    <select class="form-control" id="idCurso" name="idCurso">
			    	<c:forEach var="i" items="${requestScope.cursos}" varStatus="estado">
			      		<option value="${i.idCurso}">${i.nombre }</option>
			    	</c:forEach>
			    </select>
			  </div>
			  <div class="form-group">
		  		<button type="submit" class="btn btn-primary" form="form1">Matricular</button>
			  </div>
			</form>
			
		</div>
		<div class="col-4"></div>
	</div>
<a href="inicio">Volver al inicio</a>

</div>
</body>
</html>