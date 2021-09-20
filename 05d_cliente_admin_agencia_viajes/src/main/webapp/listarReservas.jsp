<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
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
			<div class="col-3"></div>
			<div class="col-6">
				<table class="table table-striped">
				  <thead>
				    <tr>
				      <th scope="col">#</th>
				      <th scope="col">Nombre</th>
				      <th scope="col">Dni</th>
				      <th scope="col">Vuelo</th>
				    </tr>
				  </thead>
				  <tbody>
				  	<c:forEach var="i" items="${requestScope.reservas}" varStatus="estado">
					    <tr>
					      <th scope="row">${estado.index+1}</th>
					      <td>${i.nombre}</td>
					      <td>${i.dni}</td>
					      <td>${i.vuelo}</td>
					    </tr>
					</c:forEach>
				  </tbody>
				</table>
			</div>
			<div class="col-3"></div>
		</div>
	<a href="toBuscar">Volver a buscar</a>
	</div>
	
</body>
</html>