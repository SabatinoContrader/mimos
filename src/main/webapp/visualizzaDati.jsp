<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ include file="userDTOstorage.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>VISUALIZZA I TUOI DATI</title>
</head>
<%!int role;%>
<body>
	<%
		this.user = (UtenteDTO) request.getAttribute("utenteDTO");
	%>
	<%
		this.role = (int) Integer.parseInt(request.getSession().getAttribute("role").toString());
	%>
	<h1>
		Salve
		<%=request.getSession().getAttribute("utente")%>
		i tuoi dati
	</h1>
	<form action="HomeServlet" method="post" name="VIEWDataform">
		<h2>
			Username:
			<%=this.user.getUsername()%>
		</h2>
		<h2>
			Password:
			<%=this.user.getPassword()%>
		</h2>
		<h2>
			Nome:
			<%=this.user.getNome()%>
		</h2>
		<h2>
			Cognome:
			<%=this.user.getCognome()%>
		</h2>
		<h2>
			Codice fiscale:
			<%=this.user.getCodice_fiscale()%>
		</h2>
		<h2>
			Data di nascita (yyyy-mm-dd):
			<%=this.user.getData_nascita().toString()%>
		</h2>
		<% switch (this.role) { case(2): %>
		<button type="submit" value="homeDottore" name="pulsante">Torna
			alla Dashboard Dottore</button>
		<%break;  case(3): %>
		<button type="submit" value="homePaziente" name="pulsante">Torna
			alla Dashboard Paziente</button>
		<%break; } %>
		<br>
	</form>
</body>
</html>