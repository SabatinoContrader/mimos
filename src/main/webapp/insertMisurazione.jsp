<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ include file = "userDTOstorage.jsp"  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>INSERISCI NUOVA MISURAZIONE</title>
</head>
<body>
	<% this.user = (UtenteDTO) request.getAttribute("datiDTO");
		
	%>
	<h1>
		Salve 
		<%=request.getSession().getAttribute("utente")%>
		inserisci i campi relativi alla misurazione
	</h1>
	<form action="MisuraServlet" method="post" name="selfMeasurementInsertform">
		<h2>
			Pressione: <input  type=number step=0.01 min="0" id="pressione" name="pressione">
		</h2>
		<h2>
			Battiti: <input  type=number id="battiti" min="0" name="battiti">
		</h2>
		<h2>
			Temperatura:<input  type=number step=0.01 min="0" name="temperatura">
		</h2>
		<h2>
			Glicemia:<input  type=number step=0.01 min="0" name="glicemia">
		</h2>
		<button type="submit" value="insertMisura" name="pulsante">Registrare</button>
		<br>
	</form>
	<br>
	<a href="HomeServlet?pulsante=indietroPaziente"><button  type="button">Indietro</button></a>
</body>
</html>