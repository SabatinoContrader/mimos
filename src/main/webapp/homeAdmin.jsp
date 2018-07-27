<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List"%>
<%@ page import="com.mimosSpring.mimos.model.UtenteEntity"%>
<%@ page import="com.mimosSpring.mimos.DTO.UtenteDTO"%>
<%@ page import="java.util.Map"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<c:import var="listaPazientiPage" url="/listaPazienti.jsp" />
<c:import var="listaDottoriPage" url="/listaDottori.jsp" />
<c:import var="listaFarmacistiPage" url="/listaFarmacisti.jsp" />
</head>
<title>MI.MO.S ADMIN DASHBOARD</title>
</head>
<body>
	<form action="/home/Admin" method="post">

		<ul class="nav nav-tabs">
			<li class="active"><a data-toggle="tab" href="#home">HOME</a></li>
			<li><a data-toggle="tab" href="#menu1">PAZIENTI</a></li>
			<li><a data-toggle="tab" href="#menu2">DOTTORI</a></li>
			<li><a data-toggle="tab" href="#menu3">FARMACISTI</a></li>
		</ul>

		<div class="tab-content">
			<div id="home" class="tab-pane fade in active">
				<h3>DASHBOARD ADMINISTRATOR</h3>
				<p>
					Salve
					<c:out value="<h4>${utente.nome} ${utente.cognome}</h4>"
						escapeXml="false"></c:out>
				</p>
			</div>
			<div id="menu1" class="tab-pane fade">
				<h3>PAZIENTI</h3>
				<p></p>
				<!-- escapeXml="false" è necessario per parsare la pagina -->
				<c:out value="${listaPazientiPage}" escapeXml="false" />
			</div>
			<div id="menu2" class="tab-pane fade">
				<h3>DOTTORI</h3>
				<c:out value="${listaDottoriPage}" escapeXml="false" />
				<p></p>
			</div>
			<div id="menu3" class="tab-pane fade">
				<h3>FARMACISTI</h3>
				<c:out value="${listaFarmacistiPage}" escapeXml="false" />
				<p></p>
			</div>
		</div>
		<input type="submit" value="Logout" id="button-1"
			formaction="/logout"
			formmethod="get" />
	</form>
</body>
</html>