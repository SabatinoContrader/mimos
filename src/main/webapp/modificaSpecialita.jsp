<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.Map"%>
<%@ page import="com.mimosSpring.mimos.DTO.SpecialitaDTO"%>
<%@ page import="com.mimosSpring.mimos.model.SpecialitaEntity"%>
<!DOCTYPE html>
<html>
<head>
<title>Admin - Gestione specialita</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
	<form name="modify skills form" id="form-1"
		action="/home/modificaSpecialitaComplete" method="post">
		<div class="container">
			<h2>MODIFICA E CANCELLAZIONE SPECIALITA'</h2>
			<div class="list-group">
				<div class="form-group">
					<input type="hidden" name="sdId" value="${sdId}" /> <input
						type="hidden" name="seId" value="${seId}" /> <a href="#"
						class="list-group-item"> <label for="name">NOME:</label> <input
						type="text" class="form-control" id="name"
						placeholder="${specialitaModifica.nome}" name="nome"
						value="${specialitaModifica.nome}">
					</a> <a href="#" class="list-group-item"> <label for="ds">DESCRIZIONE:</label>
						<input type="text" class="form-control" id="ds"
						placeholder="${specialitaModifica.descrizione}" name="descrizione"
						value="${specialitaModifica.descrizione}">
					</a>
				</div>
			</div>
		</div>
		<button type="submit" class="btn btn-default"
			formaction="/home/deleteSpecialita" formmethod="post">Cancella
			Specialita</button>
		<button type="submit" class="btn btn-default">Modifica i Dati</button>
		<button type="submit" class="btn btn-default" formaction="/home/Admin"
			formmethod="post">Esci</button>
	</form>
</body>
</html>