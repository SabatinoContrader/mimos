<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ page import="com.mimosSpring.mimos.model.MisuraEntity"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>HOME PAZIENTE</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
</head>
</head>

<body>
	<div class="container">
		<h1>Benvenuto <%=request.getSession().getAttribute("username")%></h1>
		<br/>
		<a class="btn btn-lg btn-primary submit-button" href="/paziente/misura">Inserire Misura</a>
		<a class="btn btn-lg btn-primary submit-button" href="/paziente/visita">Nuova Visita Medica</a>
		<br/>
		<h2>Misure</h2>
		<table class="table table-striped table-medium">
			<thead>
				<tr>
					<th>Data</th>
					<th>Pressione</th>
					<th>Temperatura</th>
					<th>Glicemia</th>
					<th>Battiti</th>
				</tr>
			</thead>
			<tbody>

				<c:forEach items="${misure}" var="misura">
					<tr>
					<%--per chiamare l'id viene utilizzato idMisura che è l'interno di Hibernate--%>
						<td>${misura.data}</td>
						<td>${misura.pressione}</td>
						<td>${misura.temperatura}</td>
						<td>${misura.glicemia}</td>
						<td>${misura.battiti}</td>
					</tr>
				</c:forEach>
				</tr>
		</table>
	</div>
</body>
</html>