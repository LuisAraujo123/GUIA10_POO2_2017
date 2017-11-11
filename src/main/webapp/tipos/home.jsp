<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Mantenimiento de Tipos</title>
</head>
<body>
	<h1>Lista de Tipos</h1>
	<h3>
	    <a href="nuevoTipo">Nuevo Tipo</a>
	</h3>
	<table border="1">	
	    <th>Código</th>
	    <th>Nombre</th>	
	    <c:forEach var="tipoTemp" items="${listTipo}">
	        <tr>
	            <td><c:out value = "${tipoTemp.codi_tipo}"/></td>
	            <td>${tipoTemp.nomb_tipo}</td>
	            <td>
		            <a href="editarTipo?codi=${tipoTemp.codi_tipo}">Editar</a>
	                <a href="eliminarTipo?codi=${tipoTemp.codi_tipo}">Eliminar</a>
                </td>
	        </tr>
	    </c:forEach>
	</table>
</body>
</html>