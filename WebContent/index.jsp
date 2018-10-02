<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Cadastrar Nomes</title>
	</head>
	<body>
		<form action="NomeCtrl" method="post">
			<table>
				<tr>
					<td>Nome:</td>
					<td><input type="text" name="nome" required=true maxlength=200 size=80></td>
				</tr>
			</table>
			<br>
			<input type="submit" value="Cadastrar">
		</form>
	
		<% if (request.getAttribute("msg") != null) { %>
			<br><br>
			<b><%=request.getAttribute("msg")%></b>
		<% } %>
	</body>
</html>