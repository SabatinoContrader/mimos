<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.Map"%>
<%@ page import="com.mimosSpring.mimos.DTO.UtenteDTO"%>
<!DOCTYPE html>
<html>
<head>
<title>Register</title>
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
	<form name="register form" id="form-1" action="/registerComplete"
		method="post">
		<div class="container">
			<h2>COMPLETA I CAMPI</h2>
			<div class="list-group">
				<div class="form-group">
					<c:choose>
						<c:when test="${asAdmin}">
							<a href="#" class="list-group-item"> <label for="role">RUOLO:</label>
								<input type="text" class="form-control" id="role"
								placeholder="inserisci codice ruolo" required="required"
								name="idRuolo">
							</a>
							<a href="#" class="list-group-item"> <label for="un">USERNAME:</label>
								<input type="text" class="form-control" id="un"
								placeholder="inserisci username" required="required"
								name="username">
							</a>
							<a href="#" class="list-group-item"> <label for="psw">PASSWORD:</label>
								<input type="text" class="form-control" id="psw"
								placeholder="inserisci password" required="required"
								name="password">
							</a>
						</c:when>
						<c:otherwise>
							<input type="hidden" name="udId" value="${udId}" />
							<a href="#" class="list-group-item"> <label for="un">USERNAME:</label>
								<input type="text" class="form-control" id="un"
								placeholder="${utenteIncompleto.username}" name="username"
								disabled="disabled">
							</a>
							<a href="#" class="list-group-item"> <label for="psw">PASSWORD:</label>
								<input type="text" class="form-control" id="psw"
								placeholder="${utenteIncompleto.password}" name="password"
								disabled="disabled">

							</a>
						</c:otherwise>
					</c:choose>
					<a href="#" class="list-group-item"> <label for="name">NOME:</label>
						<input type="text" class="form-control" id="name"
						placeholder="inserisci nome" required="required" name="nome">
					</a> <a href="#" class="list-group-item"> <label for="surname">COGNOME:</label>
						<input type="text" class="form-control" id="surname"
						placeholder="inserisci cognome" required="required" name="cognome">
					</a> <a href="#" class="list-group-item"> <label for="cf">CODICE
							FISCALE:</label> <input type="text" class="form-control" id="cf"
						placeholder="inserisci Codice Fiscale" required="required"
						name="codiceFiscale">
					</a> <a href="#" class="list-group-item"> <label for="date">DATA
							DI NASCITA:</label> <input type="datetime" class="form-control" id="date"
						placeholder="inserisci Data di nascita in formato AAAA-MM-GG"
						required="required" name="dataNascita">
					</a> <a href="#" class="list-group-item"> <label for="city">CITTA':</label>
						<input type="text" class="form-control" id="city"
						placeholder="inserisci città di residenza" required="required"
						name="citta">
					</a>
				</div>
			</div>
		</div>
		<c:choose>
			<c:when test="${asAdmin}">
				<button type="submit" class="btn btn-default"
					formaction="/home/registerAdmin" formmethod="post">Inserisci
					Utente</button>
			</c:when>
			<c:otherwise>
				<button type="submit" class="btn btn-default">Registrati</button>
			</c:otherwise>
		</c:choose>
	</form>
</body>
</html>