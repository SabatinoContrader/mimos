<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>LE TUE SPECIALIZZAZIONI</title>
</head>
<%!ArrayList<String> skills;%>
<body>
	<%
		this.skills = (ArrayList<String>) request.getAttribute("skills");
	%>
	<h1>
		Salve
		<%=request.getSession().getAttribute("utente")%>
		le tue specializzazioni: 
	</h1>
	<br>
	<form action="HomeServlet" method="post" name="skillsViewform">
		<%
			for (String s : skills) {
		%>
		<h2>
			<%=s%>
		</h2>
		<%
			}
		%>
		<button type="submit" value="homeDottore" name="pulsante">Torna
			alla Dashboard Dottore</button>
		<br>
	</form>
</body>
</html>