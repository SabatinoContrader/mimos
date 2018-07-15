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
	<form action="HomeServlet" method="post" name="selfMeasurementInsertform">
		<h2>
			Pressione: <input type="text" id="pressione" name="pressione">
		</h2>
		<h2>
			Battiti: <input type="text" id="battiti" name="battiti">
		</h2>
		<h2>
			Temperatura:<input type="text" name="temperatura" name="temperatura">
		</h2>
		<h2>
			Glicemia:<input type="text" name="glicemia" name="glicemia">
		</h2>
		<button type="submit" value="userRegister" name="pulsante">Registrati</button>
		<br>
	</form>
</body>
</html>