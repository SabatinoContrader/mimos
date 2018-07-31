<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.List"%>
<%@ page import="com.mimosSpring.mimos.model.SpecialitaEntity"%>
<%@ page import="com.mimosSpring.mimos.DTO.SpecialitaDTO"%>
<%@ page import="java.util.Map"%>
<meta charset="ISO-8859-1">
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<form action="/home/Admin" method="post">
	<div class="container">
		<h2></h2>
		<p></p>
		<div class="table-responsive">
			<table class="table">
				<caption>lista pazienti sistema</caption>
				<thead>
					<tr>
						<th>NOME</th>
						<th>DESCRIZIONE</th>
						<th>MODIFICA</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${listaSpecialita}" var="skill">
						<tr>
							<td>${skill.nomeSpecialita}</td>
							<td>${skill.descrizioneSpecialita}</td>
							<td><input type="submit" value="->>" id="button-1"
								formaction="/home/modificaSpecialita?id_skill=${skill.idSpecialita}"
								formmethod="post" /></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</form>