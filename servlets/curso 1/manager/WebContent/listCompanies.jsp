<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List, br.com.alura.gerenciador.model.Company"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Nova Empresa</title>
</head>
<body>
	Lista de Empresas <br />
	<ul>
	<%
		List<Company> companies = (List<Company>) request.getAttribute("companies");
		for(Company company : companies) {
	%>
			<li><%= company.toString() %></li>
	<%
		}
	%>
	</ul>
</body>
</html>