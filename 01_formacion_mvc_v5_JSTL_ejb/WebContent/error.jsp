<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Ha ocurrido un error en la página.</h1>
<p>${requestScope.mensaje}</p>
<a href="Controller?option=toMenu">Volver al menu</a>
</body>
</html>