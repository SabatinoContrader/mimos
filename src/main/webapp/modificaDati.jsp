<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ include file="userDTOstorage.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>MODIFICA DATI</title>
</head>
<body>
	<%
		this.user = (UtenteDTO) request.getAttribute("utenteDTO");
	%>
	<h1>
		Salve
		<%=request.getSession().getAttribute("utente")%>
		modifica i dati
	</h1>
	<form action="HomeServlet" method="post"
		name="selfModDataform">
		<h2>
			Nome: <input type="text" placeholder="<%=this.user.getNome()%>"
				id="nome" name="nome">
		</h2>
		<h2>
			Cognome: <input type="text" placeholder="<%=this.user.getCognome()%>"
				id="cognome" name="cognome">
		</h2>
		<h2>
			Codice fiscale:<input type="text"
				placeholder="<%=this.user.getCodice_fiscale()%>" name="codice"
				name="codice">
		</h2>
		<h2>
			Data di nascita (yyyy-mm-dd):<input type="text"
				placeholder="<%=this.user.getData_nascita().toString()%>"
				name="data" name="data">
		</h2>
		<button type="submit" value="modificaDati" name="pulsante">Aggiorna Dati</button>
		<br>
	</form>
</body>
</html>