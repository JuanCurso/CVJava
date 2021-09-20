<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List" %>
<%@ page import="models.Curso" %>
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
<h1>Listado de cursos con duración menor de ${param.duracion} horas</h1>
<table class="table table-striped">
  <thead>
    <tr>
      <th scope="col">#</th>
      <th scope="col">Nombre</th>
      <th scope="col">Duracion</th>
      <th scope="col">Fecha Inicio</th>
      <th scope="col">Preguntas</th>
    </tr>
  </thead>
  <tbody>
  	<c:forEach var="i" items="${requestScope.cursos}" varStatus="estado">
	    <tr>
	      <th scope="row">${estado.index+1}</th>
	      <td>${i.nombre}</td>
	      <td>${i.duracion}</td>
	      <td><f:formatDate value="${i.fechaInicio}" pattern="dd/MM/yyyy"/></td>
	      <td><a href="Controller?option=doCursosPreguntas&idCurso=${i.idCurso}">Ver</a></td>
	    </tr>
	</c:forEach>
  </tbody>
</table>
<a href="Controller?option=toMenu">Volver al menu</a>

</div>
</body>
</html>