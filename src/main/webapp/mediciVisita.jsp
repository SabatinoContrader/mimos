<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ page import="com.mimosSpring.mimos.model.UtenteEntity"%>
<%@ page import="com.mimosSpring.mimos.model.SpecialitaEntity"%>
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
		<h1>Visita Medica</h1>
		<br/>
		<a class="btn btn-lg btn-warning submit-button " href="/paziente/home">Indietro</a>
		<br/>
		<h2>Elenco di Medici</h2>
		<table class="table table-striped table-medium">
			<thead>
				<tr>
					<th>Nome</th>
					<th>Cognome</th>
					<th>Specialita</th>
					<th>Città</th>
					<th>Scegliere</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${dottori}" var="dottore">
				  <tr>
					<%--per chiamare l'id viene utilizzato idMisura che è l'interno di Hibernate--%>
						<td>${dottore.nome}</td>
						<td>${dottore.cognome}</td>
						<td>					
							<c:forEach items="${dottore.specialita}" var="var">
							    ${var.nomeSpecialita}
							    <br/>
							</c:forEach>
						</td>
						<td>${dottore.citta}</td>
						<td>
							   <form action="/paziente/visita" method="post">
							    	<input type="hidden" name="idDottoreView" value="${dottore.idUtente}">
							   		<input class="btn btn-lg btn-primary submit-button btn-sm" value="Avanti" type="submit"/>
							   </form>
						</td>	
					</tr>
				</c:forEach>
		</table>
	</div>
	
</body>
</html>