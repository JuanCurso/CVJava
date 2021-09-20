<!DOCTYPE html>
<html>
<head>
<style>
table, th, td {
	border: 1px solid GRAY;
	border-collapse: collapse;
}
a{
	color:LIGHTSLATEGRAY;
}
h1{
	color:DARKSALMON;
}
legend{
	color:INDIANRED;
}
</style>
<meta charset="ISO-8859-1">
<title>Registro de Cursos</title>
</head>
<body>
	<fieldset>
	<legend>Datos Curso</legend>
		<form action="alta" method="post">
			<label>ISBN</label><br>
			<input type="text" name="isbn" required="required"><br>
			<label >Título:</label><br>
			<input type="text" name="titulo" required="required"><br>
			<label >Autor</label><br>
			<input type="text" name="autor" required="required"><br><br>
			<label >Precio</label><br>
			<input type="text" name="precio" required="required"><br><br>
			<label >Páginas</label><br>
			<input type="text" name="paginas" required="required"><br><br>
			<label >Temática</label><br>
			<input type="text" name="tema" required="required"><br><br>
			<input type="submit" value="Guardar">
			
		</form>
	</fieldset>
	<p align="right"><a href="toMenu">Volver</a></p>
</body>
</html>