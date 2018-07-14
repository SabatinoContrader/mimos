<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>INSERISCI NUOVA MISURAZIONE</title>
</head>
<body>
	<h1>
		Salve 
		<%=request.getSession().getAttribute("utente")%>
		modifica i dati
	</h1>
	<form action="HomeServlet" method="post" name="selfMeasurementInsertform">
		<h2>
			Nome: <input type="text" placeholder="<%=request.getParameter("nome")%>" id="pressione" name="pressione">
		</h2>
		<h2>
			Cognome: <input type="text" id="battiti" name="battiti">
		</h2>
		<h2>
			Codice fiscale:<input type="text" name="temperatura" name="temperatura">
		</h2>
		<h2>
			Data di nascita (yyyy-mm-dd):<input type="text" name="glicemia" name="glicemia">
		</h2>
		<button type="submit" value="userRegister" name="pulsante">Invia Dati</button>
		<br>
	</form>
</body>
</html>