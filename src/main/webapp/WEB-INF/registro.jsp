<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<h1 align="center">Registro de Vehículo</h1>

	<form action="vehiculoController" method="post">
		<!-- INPUT OCULTO PARA DAR VALOR A opcion -->
		<input type="hidden" name="opcion" value="crear">
		<table border="2" align="center" bgcolor="#65C0E9">
			<tr>
				<td>Placa</td>
				<td><input type="text" name="placa"></td>
			</tr>
			<tr>
				<td>Marca</td>
				<td><input type="text" name="marca"></td>
			</tr>
			<tr>
				<td>Modelo</td>
				<td><input type="text" name="modelo"></td>
			</tr>
			<tr>
				<td>Año</td>
				<td><input type="text" name="anio"></td>
			</tr>
			<tr>
				<td>Cilidraje</td>
				<td><input type="text" name="cilindraje"></td>
			</tr>
			<tr>
				<td>Consumo</td>
				<td><input type="text" name="consumo"></td>
			</tr>
		</table>
		<input type="submit" value="Registrar">
	</form>

</body>
</html>