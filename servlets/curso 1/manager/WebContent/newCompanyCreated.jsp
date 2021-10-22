<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Nova Empresa</title>
	</head>
	<body>
		<c:if test="${ not empty company }">
			<fmt:formatDate value="${ date }" pattern="dd/MM/yyyy" var="formattedDate"/>
			Empresa ${ company }, criada dia ${ formattedDate }, cadastrada com sucesso!
		</c:if>
		<c:if test="${ empty company }">
			Nenhuma empresa cadastrada!
		</c:if>
	</body>
</html>