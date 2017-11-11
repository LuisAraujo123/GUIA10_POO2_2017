<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Mantenimiento de Libros</title>
</head>
<body>
	<h1>Nuevo Libro</h1>
	<form:form action="guardarLibr" method="post" modelAttribute="objeLibr">
		<form:hidden path="codiLibr"/>
		<label>Nombre: </label>
		<form:input path="nombLibr" />
		<br>
		<label>Autor: </label>
		<form:input path="autoLibr" />
		<br>
		<label>Género: </label>
		<form:input path="geneLibr" />
		<br>
		<label>Año: </label>
		<form:input path="anioLibr" />
		<br>
		<label>Estado: </label>
		<form:input path="estaLibr"/>
		<br>
		<input type="submit" value="Guardar" />
	</form:form>
</body>
</html>