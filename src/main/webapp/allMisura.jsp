<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List"%>
<%@ page import="com.virtualpairprogrammers.dto.MisuraDTO"%>
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
			
			<% List<MisuraDTO> misureDTO = (List<MisuraDTO>) request.getAttribute("misureDTO");%>
	
				<tr>
					<th>DATA</th>
					<th>PRESSIONE</th>
					<th>BATTITI</th>
					<th>TEMPERATURA</th>
					<th>GLICEMIA</th>
				</tr>
			</thead>
			<tbody>
				<% for (MisuraDTO misuraDTO : misureDTO ) {%>
				<tr>

					<td><%=misuraDTO.getData()%></td>
					<td><%=misuraDTO.getPressione()%></td>
					<td><%=misuraDTO.getBattiti()%></td>
					<td><%=misuraDTO.getTemperatura()%></td>
					<td><%=misuraDTO.getGlicemia()%></td>
					<!-- manca pagato -->
				</tr>
				
				<%	}  %>
			
		</table>
		</br>
		<a href="HomeServlet?pulsante=indietroPaziente"><button  type="button">Indietro</button></a>
	
	</div>

</body>
</html>