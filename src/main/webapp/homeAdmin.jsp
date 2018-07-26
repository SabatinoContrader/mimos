
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
<title>Insert title here</title>
</head>
<body>
	<form action="/Home/modificaUtente?id=${user.id_utente}" method="post">
		<div class="container">
			<h2>Table</h2>
			<p>The .table-responsive class creates a responsive table which
				will scroll horizontally on small devices (under 768px). When
				viewing on anything larger than 768px wide, there is no difference:</p>
			<div class="table-responsive">
				<table class="table">
					<caption>lista pazienti sistema</caption>
					<thead>
						<tr>
							<th>USERNAME /</th>
							<th>PASSWORD</th>
							<th>NOME</th>
							<th>COGNOME</th>
							<th>DATA DI NASCITA</th>
							<th>RESIDENZA</th>
							<th></th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${users}" var="user">
							<tr>
								<td>${user.username}</td>
								<td>${user.password}</td>
								<td>${user.nome}</td>
								<td>${user.cognome}</td>
								<td>${user.data_nascita}</td>
								<td>${user.citta}</td>
								<td><input type="submit" value="->>" id="button-1"
									formmethod="post" /></td>

							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</form>
</body>
</html>