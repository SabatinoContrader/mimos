
<!DOCTYPE html>
<html>
<head>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.List"%>
<%@ page import="com.mimosSpring.mimos.model.UtenteEntity"%>
<%@ page import="java.util.Map"%>
<meta charset="ISO-8859-1">
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<title>doc</title>
</head>
<body>
	<form action="/home/Admin" method="post">
		<div class="container">
			<h2></h2>
			<p></p>
			<div class="table-responsive">
				<table class="table">
					<caption>lista pazienti sistema</caption>
					<thead>
						<tr>
							<th>USERNAME</th>
							<th>PASSWORD</th>
							<th>NOME</th>
							<th>COGNOME</th>
							<th>DATA DI NASCITA</th>
							<th>RESIDENZA</th>
							<th>MODIFICA</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${listaUtenti}" var="user">
							<c:choose>
								<c:when test="${user.idRuolo == 1}">
									<tr>
										<td>${user.username}</td>
										<td>${user.password}</td>
										<td>${user.nome}</td>
										<td>${user.cognome}</td>
										<td>${user.dataNascita}</td>
										<td>${user.citta}</td>
										<td><input type="submit" value="->>" id="button-1"
											formaction="home/modificaUtente?id_utente=${user.idUtente}" formmethod="post" /></td>
									</tr>
								</c:when>
							</c:choose>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</form>
</body>
</html>