<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List" %>
<%@ page import="models.Alumno" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

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
<div class="content">
<h1>Lista de alumnos.</h1>
<c:if test="${!empty requestScope.alumnos}">
	<table class="table table-striped">
	  <thead>
	    <tr>
	      <th scope="col">#</th>
	      <th scope="col">Nombre</th>
	      <th scope="col">Email</th>
	      <th scope="col">Cursos</th>
	    </tr>
	  </thead>
	  <tbody>
	  	<c:forEach var="i" items="${requestScope.alumnos}" varStatus="estado">
		    <tr>
		      <th scope="row">${estado.index+1}</th>
		      <td>${i.nombre}</td>
		      <td>${i.email}</td>
			  <td>
				  <c:forEach var="c" items="${i.cursos}" varStatus="estado">
			      		<small>${c.nombre}<br></small>
			      </c:forEach>
			  </td>
		    </tr>
		</c:forEach>
	  </tbody>
	</table>
</c:if>
<a href="Controller?option=toMenu">Volver al menu</a>

</div>

</body>
</html>