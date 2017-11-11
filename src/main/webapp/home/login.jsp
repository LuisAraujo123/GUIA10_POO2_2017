<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
</head>
<body>
	<c:url var="loginUrl" value="/home/login" />
		<form action="${loginUrl}" method="post">
			<c:if test="${param.error != null}">
				<p>Usuario y contraseña inválido.</p>
			</c:if>
			<label for="txt_usua">Usuario: </label>
			<input type="text" id="txt_usua" name="acce_usua" placeholder="Ingrese Usuario" required>
			
			<label for="txt_pass">Password</label>
			<input type="password" id="txt_pass" name="cont_usua" placeholder="Ingrese Password" required>
			
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
			<input type="submit" value="Ingresar">
		</form>
</body>
</html>