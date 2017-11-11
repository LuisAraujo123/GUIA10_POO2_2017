<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Mantenimiento de Tipos</title>
</head>
<body>
	<h1>Nuevo tipo</h1>
	<form:form action="guardarTipo" method="post" modelAttribute="objeTipo">
		<form:hidden path="codi_tipo"/>
		<form:input path="nomb_tipo" />
		<input type="submit" value="Guardar" />
	</form:form>
</body>
</html>