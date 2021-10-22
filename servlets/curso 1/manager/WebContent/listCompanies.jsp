<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lista de Emp</title>
</head>
<body>
	Lista de Empresas <br />
	<ul>
		<c:forEach items="${ companies }" var="company">
			<fmt:formatDate value="${ company.creationDate }" pattern="dd/MM/yyyy" var="date"/>
			<li>${ company.name }, criada em ${ date }</li>
		</c:forEach>
	</ul>
</body>
</html>