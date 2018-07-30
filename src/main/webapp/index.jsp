<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>Mi.Mo.S</title>
</head>
<body>
	<!--  <form name="login form" id="form-1" action="/login" method="post">
		<label for="input-1">Username:</label> <br> <input id="input-1"
			name="username" placeholder="nome utente" required="true" type="text" />
		<br> <label for="input-2">Password:</label> <br> <input
			id="input-2" name="password" placeholder="password" required="true"
			type="password" /> <br> <input type="submit" value="Submit"
			id="button-1" />
	-->
	<form name="login form" id="form-1" action="/login" method="post">
		<div class="jumbotron text-center">
			<h1>Mi.Mo.S</h1>
			<p>mirror monitoring system</p>
		</div>
		
		<div class="container">
			<div class="row">
				<div class="col-sm-4">
					<div class="form-group">
						<label for="input-1">USERNAME:</label> <input type="text"
							class="form-control" id="input-1"
							placeholder="inserisci username" required="required"
							name="username">
					</div>
					<div class="form-group">
						<label for="psw">PASSWORD:</label> <input type="password"
							class="form-control" id="psw" placeholder="inserisci password"
							required="required" name="password">
					</div>
					<!--
					<div class="checkbox">
						<label><input type="checkbox"> Remember me</label>
					</div>
					-->
					<button type="submit" class="btn btn-default">LogIn</button>
					<button type="submit" class="btn btn-default"
						formaction="/registerIndex" formmethod="post">SignUp</button>
				</div>
				<div class="col-sm-4">
					<h3>NUOVO UTENTE?</h3>
					<p>Registrati inserendo un nuovo nome utente e password</p>
					<p>Potrai completare l'iscrizione in pochi e semplici step</p>
				</div>
				<div class="col-sm-4">
					<h3>DESCRIZIONE DEL SISTEMA</h3>
					<p>Il rivoluzionario sistema intelligente di gestione...</p>
					<p>Il nostro corpo è un sistema complesso e fantastico...</p>
				</div>
			</div>
		</div>
	</form>
</body>
</html>