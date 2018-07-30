<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.Map"%>
<%@ page import="com.mimosSpring.mimos.DTO.UtenteDTO"%>
<!DOCTYPE html>
<html>
<head>
<title>Admin - Gestione utente</title>
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
	<form name="register form" id="form-1"
		action="/home/modificaUtenteComplete" method="post">
		<div class="container">
			<h2>MODIFICA E CANCELLAZIONE UTENTE</h2>
			<div class="list-group">
				<div class="form-group">
					<input type="hidden" name="udId" value="${udId}" /> <input
						type="hidden" name="ueId" value="${ueId}" /> <a href="#"
						class="list-group-item"> <label for="role">RUOLO: <c:out
								value="${utenteModifica.id_ruolo}" escapeXml="false" />
					</label> <input type="hidden" class="form-control" id="role"
						placeholder="${utenteModifica.id_ruolo}" name="idRuolo"
						value="${utenteModifica.id_ruolo}">
					</a> <a href="#" class="list-group-item"> <label for="un">USERNAME:
							<c:out value="${utenteModifica.username}" escapeXml="false" />
					</label> <input type="hidden" class="form-control" id="un"
						placeholder="${utenteModifica.username}" name="username"
						value="${utenteModifica.username}">
					</a> <a href="#" class="list-group-item"> <label for="psw">PASSWORD:</label>
						<input type="text" class="form-control" id="psw"
						placeholder="${utenteModifica.password}" name="password"
						value="${utenteModifica.password}">
					</a> <a href="#" class="list-group-item"> <label for="name">NOME:</label>
						<input type="text" class="form-control" id="name"
						placeholder="${utenteModifica.nome}" name="nome"
						value="${utenteModifica.nome}">
					</a> <a href="#" class="list-group-item"> <label for="surname">COGNOME:</label>
						<input type="text" class="form-control" id="surname"
						placeholder="${utenteModifica.cognome}" name="cognome"
						value="${utenteModifica.cognome}">
					</a> <a href="#" class="list-group-item"> <label for="cf">CODICE
							FISCALE:</label> <input type="text" class="form-control" id="cf"
						placeholder="${utenteModifica.codice_fiscale}"
						name="codiceFiscale" value="${utenteModifica.codice_fiscale}">
					</a> <a href="#" class="list-group-item"> <label for="date">DATA
							DI NASCITA:</label> <input type="datetime" class="form-control" id="date"
						placeholder="${utenteModifica.data_nascita}" name="dataNascita"
						value="${utenteModifica.data_nascita}">
					</a> <a href="#" class="list-group-item"> <label for="city">CITTA':</label>
						<input type="text" class="form-control" id="city"
						placeholder="${utenteModifica.citta}" name="citta"
						value="${utenteModifica.citta}">
					</a>
				</div>
			</div>
		</div>
		<button type="submit" class="btn btn-default"
			formaction="/home/deleteUtente" formmethod="post">Cancella
			Utente</button>
		<button type="submit" class="btn btn-default">Modifica i Dati</button>
		<button type="submit" class="btn btn-default" formaction="/home/Admin"
			formmethod="post">Esci</button>
	</form>
</body>
</html>