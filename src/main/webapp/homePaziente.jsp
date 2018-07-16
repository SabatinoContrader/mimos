<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>HOME PAZIENTE</title>
</head>

<body>
	<h1>
		Benvenuto
		<%=request.getSession().getAttribute("utente")%></h1>
	<h2>------- DASHBOARD -------</h2>

	<form action="HomeServlet" method="post"
		name="visualizzamisurazioniform">
		<h3>VISUALIZZA LE MISURAZIONI</h3>
		<input type="submit" value="getAllMisurazioni" name="pulsante">
	</form>

	<form action="HomeServlet" method="post"
		name="inseriscimisurazioneform">
		<h3>INSERISCI MISURAZIONE</h3>
		<input type="submit" value="insertMisurazione" name="pulsante">
	</form>

	<form action="HomeServlet" method="post" name="richiedivisitaform">
		<h3>RICHIEDI VISITA</h3>
		<input type="submit" value="insertCheckin" name="pulsante">
	</form>

	<form action="HomeServlet" method="post" name="modificaDatiform">
		<h3>MODIFICA DATI PERSONALI</h3>
		<input type="submit" value="gomodificaDati" name="pulsante">
	</form>

	<form action="HomeServlet" method="post" name="visualizzaDatiform">
		<h3>VISUALIZZA DATI PERSONALI</h3>
		<input type="submit" value="visualizzaDati" name="pulsante">
	</form>

	<form action="HomeServlet" method="post" name="logoutform">
		<h3>LOGOUT</h3>
		<input type="submit" value="logout" name="pulsante">
	</form>

</body>

</html>