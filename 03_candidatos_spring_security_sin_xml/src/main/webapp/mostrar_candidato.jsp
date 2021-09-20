<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="model.Candidato" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Información candidato</h1>
<%
	Candidato miCandidato = (Candidato)request.getAttribute("candidato");
	
	if (miCandidato==null) {
%>
		<h3>Candidato no encontrado.</h3>
<%
	} else {
		
%>
<p>Nombre: <%=miCandidato.getNombre() %></p>
<p>Edad: <%=miCandidato.getEdad() %></p>
<p>Puesto: <%=miCandidato.getPuesto() %></p>
<p>Email: <%=miCandidato.getEmail() %></p>
<%
	}
 %>
<br>

<a href="toBuscar">Volver a la búsqueda</a>
<br>
<a href="toMenu">Volver al menu</a>

</body>
</html>