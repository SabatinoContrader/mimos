<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div class="container">

		<h1>Lista di misure</h1>
		</br>
		<table border="1" >
			<thead>
				<!--<%
					List<ManagementCarPlaceDTO> carPlaces = (List<ManagementCarPlaceDTO>) request
							.getAttribute("managementCarPlaceDTO");
				%>-->
				<tr>
					<th>#</th>
					<th>NOME E COGNOME</th>
					<th>SPECIALITA</th>
					<th>CITTA</th>
				</tr>
			</thead>
			<tbody>
				<!--<%
					for (ManagementCarPlaceDTO carPlace : carPlaces) {
				%>
				<tr>-->

					<td>aqui el id</td>
					<td>aqui va el nombre y el apellido</td>
					<td>aqui van las especialidades</td>
					<td>aqui va la ciudad</td>
					<!-- manca pagato -->
				</tr>
				<!--<%
					}
				%>-->
			
		</table>
	</div>


</body>
</html>