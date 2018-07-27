<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.mimosSpring.mimos.model.UtenteEntity"%>
<%@ page import="com.mimosSpring.mimos.model.SpecialitaEntity"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<meta charset="ISO-8859-1">
<title>Nuovo Appuntamento</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
</head>
<body>
<div class="col-md-8 col-md-offset-4">
	<div class="container center-block col-sm-6">
		<h1>Dati della Visita</h1>
		<form action="/paziente/aggiungi/visita" method="post">
		<p>
			Dottore: <input  type=text  class="form-control form-control-lg" value="${dottore.nome} ${dottore.cognome}" disabled>
					 <input type="hidden" name="idDottoreView" value="${dottore.idUtente}">
		</p>
		<p>
		    Specialita: <input  type=text  class="form-control form-control-lg" value="<c:forEach items="${dottore.specialita}" var="var">${var.nomeSpecialita}  </c:forEach>" disabled>
		</p>
		<p>
			Data: <input  type=date name="dataVisita" class="form-control form-control-lg" required>
		</p>
		<p>
			Descrizione: 
			<textarea class="form-control form-control-lg" name="descrizione"></textarea>
		</p>
		<button type="submit" class="btn btn-lg btn-primary btn-block submit-button">Aggiungi</button>
		</form>
		<a class="btn btn-lg btn-warning btn-block submit-button " href="/paziente/visita">Indietro</a>
	</div>
</div>
</body>
</html>
