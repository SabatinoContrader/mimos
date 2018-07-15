<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ include file="userDTOstorage.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>REGISTRAZIONE NUOVO PAZIENTE</title>
</head>
<%! String username = null; %>
<body>
	<%
		this.user = new UtenteDTO();
	%>
	<form action="IndexServlet" method="post" name="selfRegisterform">
		<h2>
			Username: <input type="text" id="user" name="username" <%= this.username %>>
		</h2>
		<h2>
			Password: <input type="password" id="pass" name="password">
		</h2>
		<h2>
			Nome:<input type="text" name="nome">
		</h2>
		<h2>
			Cognome:<input type="text" name="cognome">
		</h2>
		<h2>
			Codice Fiscale:<input type="text" name="codice">
		</h2>
		<h2>
			Città di residenza:<input type="text" name="citta">
		</h2>
		<h2>
			Data di Nascita (yyyy-mm-dd):<input type="datetime" name="data">
		</h2>
		<button type="submit" value="userRegister" name="pulsante">Registrati</button>
		<br>
		<script type="text/javascript">
			document.getElementById("citta").value;
		</script>
	<%	/*
		//sto tentando di mettere i valori che andranno nella request dentro un dto da inviare
		//pensavo ad un getAttribute dopo il send ma il codice java viene eseguito contestualmente
		//all'html ergo non va. provando con le EL di JSP ${param."nometag"} comunque non funziona
		//per ora passo i valori com sopra
		this.user.setCitta((String) request.getAttribute("citta"));
		this.user.setCodice_fiscale((String) request.getAttribute("codice"));
		this.user.setCognome((String) request.getAttribute("cognome"));
		this.user.setNome((String) request.getAttribute("nome"));
		this.user.setPassword((String) request.getAttribute("password"));
		this.user.setUsername(this.username);
		this.user.setData_nascita((Date) request.getAttribute("data"));
		request.setAttribute("utenteDTO", this.user);*/
	%>
	</form>
</body>
</html>