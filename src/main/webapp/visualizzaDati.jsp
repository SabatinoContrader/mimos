<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ include file="userDTOstorage.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>INSERISCI NUOVA MISURAZIONE</title>
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
			Username: <%=this.user.getUsername()%>
		</h2>
		<h2>
			Password: <%=this.user.getPassword()%>
		</h2>
		<h2>
			Nome: <%=this.user.getNome()%>
		</h2>
		<h2>
			Cognome: <%=this.user.getCognome()%>
		</h2>
		<h2>
			Codice fiscale: <%=this.user.getCodice_fiscale()%>
		</h2>
		<h2>
			Data di nascita (yyyy-mm-dd): <%=this.user.getData_nascita().toString()%>
		</h2>
		<button type="submit" value="homePaziente" name="pulsante">Torna alla Dashboard</button>
		<br>
	</form>
</body>
</html>