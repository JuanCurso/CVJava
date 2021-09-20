<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ page import="java.util.List" %>
<%@ page import="model.Candidato" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
  <%
    	List<Candidato> candidatos= (List<Candidato>)request.getAttribute("candidatos");
    
    	if (candidatos.size() == 0) {
  %>
  		<h1>No hay registros que mostrar.</h1>
  		<%
	} else {
		  %>
		  <table class="default" border="1">

		    <tr>

		      <th>Nombre</th>

		      <th>Edad</th>

		      <th>Puesto</th>

		      <th>Email</th>

		      <th>Editar</th>

		    </tr>
		  <%
  		for (Candidato i: candidatos) {
			%>  			
			  <tr>
			
			    <td><%=i.getNombre() %></td>
			
			    <td><%=i.getEdad() %></td>
			
			    <td><%=i.getPuesto() %></td>

			    <td><%=i.getEmail() %></td>
			
			    <td><a href="eliminar?id=<%=i.getIdcandidato()%>">Eliminar</a></td>
			
			  </tr>
			<%
		}
	  }
	  		%>

</table>
<a href="toMenu">Volver al menu</a>

</body>
</html>