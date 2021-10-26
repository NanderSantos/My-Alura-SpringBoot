<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
 
<c:url value="/entry?action=UpdateCompany" var="linkUpdateCompany" />
 
<!DOCTYPE html> 
<html>
	<head>
		<meta charset="UTF-8">
		<title>${ company.name }</title>
	</head>
	<body>
		<c:import url="logout-fragment.jsp" />
		<form action="${ linkUpdateCompany }" method="post" >
			<fmt:formatDate value="${ company.creationDate }" pattern="dd/MM/yyyy" var="date"/>
				Nome: <input type="text" name="name" value="${ company.name }" />
				Data de Abertura: <input type="date" name="date" value="${ date }" />
				<input type="hidden" name="id" value="${ company.id }" />
			<input type="submit" />
		</form>
	</body>
</html>