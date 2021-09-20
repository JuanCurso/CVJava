<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.9/angular.min.js"></script>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
</head>
<body>




<div class="container">
	<h1>Libros por temática</h1>

	<div ng-app="librosApp" ng-controller="librosController">
	  <div class="input-group" style="width:30%">
		<label>Temática:</label><input type="text" class="form-control" ng-model="tema">
			
	  </div>
	  <br><br>
		<button type="button" ng-click="buscarLibros();" class="btn btn-default btn-primary" style="width:20%">Consultar</button>
	 	
	<div class="container" ng-show="libros">
			
			<br>
			<table border="1" class="table table-striped table-bordered">
				<thead>
					<tr>
						<th>Título</th>
						<th>Precio</th>
						<th>Páginas</th>
						<th></th>
					</tr>
				</thead>					
						<tr ng-repeat="libro in libros">
							<td>{{libro.titulo}}</td>
							<td>{{libro.precio}}</td>
							<td>{{libro.paginas}}</td>
							<td><a href="#" ng-click="eliminar(libro.isbn)">Eliminar</a></td>
						</tr>
			</table>

		</div>
	</div>
	</div>
	<script>
		var app=angular.module("librosApp",[]);
		app.controller("librosController",function($scope,$http){
			var url1="buscar";
			var url2="eliminar";
			$scope.buscarLibros=function(){
				$http.get(url1,{params:{tema:$scope.tema}})
				.then(function(res){
					$scope.libros=res.data;
				});
			};
			$scope.eliminar=function(isbn){
				$http.get(url2,{params:{tema:$scope.tema,isbn:isbn}})
				.then(function(res){
					$scope.libros=res.data;
				});
			};
			
		});

	</script>
<a href="toMenu">Volver al menú</a>
</body>
</html>