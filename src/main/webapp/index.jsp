<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Mi.Mo.S</title>
</head>
<body>
	<form name="login form" id="form-1" action="/login" method="post">
		<label for="input-1">Username:</label> <br> <input id="input-1"
			name="username" placeholder="nome utente" required="true" type="text" />
		<br> <label for="input-2">Password:</label> <br> <input
			id="input-2" name="password" placeholder="password" required="true"
			type="password" /> <br> 
			<input type="submit" value="Submit"	id="button-1"/>
	</form>
</body>
</html>