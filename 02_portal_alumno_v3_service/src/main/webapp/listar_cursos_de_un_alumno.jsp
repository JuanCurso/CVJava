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
	<div class="col-3"></div>
	<div class="col-6">
		<c:choose>
			<c:when test="${empty requestScope.matriculas}">
				<h1 class="my-5">El alumno seleccionado no está matriculado en ningún curso.</h1>
			</c:when>
			<c:otherwise>
				<h1 class="my-5">Listado de cursos del alumno ${sessionScope.alumno.nombre}</h1>
				<form action="desmatricularAlumno" method="post" id="form1">
				<table class="table table-striped">
				  <thead>
				    <tr>
				      <th scope="col">#</th>
				      <th scope="col">Nombre</th>
				      <th scope="col">Duracion</th>
				      <th scope="col">Nota</th>
				      <th scope="col">Desmatricular</th>
				    </tr>
				  </thead>
				  <tbody>
				  	<c:forEach var="i" items="${requestScope.matriculas}" varStatus="estado">
					    <tr>
					      <th scope="row">${estado.index+1}</th>
					      <td>${i.curso.nombre}</td>
					      <td>${i.curso.duracion}</td>
					      <td>${i.nota}</td>
					      <td><input type="checkbox" name="idsCurso" value="${i.curso.idCurso}"></input></td>
					    </tr>
					</c:forEach>
				  </tbody>
				</table>
	        	<div class="form-group">
		  			<button type="submit" class="btn btn-primary" form="form1">Desmatricular</button>
			  	</div>
					
				</form>
			</c:otherwise>
		</c:choose>
	</div>
	<div class="col-3"></div>
</div>
<a href="inicio">Volver al inicio</a>

</div>
</body>
</html>