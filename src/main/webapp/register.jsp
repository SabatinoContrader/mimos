<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="IndexServlet" method="post" name="selfRegisterform">
		<h2>
			Username: <input type="text" id="user" name="username">
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
			Data di Nascita:<input type="date" name="data">
		</h2>
		<button type="submit" value="userRegister" name="pulsante">Registrati</button>
		<br>
	</form>
</body>
</html>