<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<c:url value="/entry?action=DeleteCompany" var="linkServletDeleteCompany" />
<c:url value="/entry?action=ShowCompany" var="linkServletShowCompany" />

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Lista de Empresas</title>
	</head>
	<body>
		<c:if test="${ not empty company }">
			<fmt:formatDate value="${ date }" pattern="dd/MM/yyyy" var="formattedDate"/>
			Empresa ${ company }, criada dia ${ formattedDate }, cadastrada com sucesso!
			<br />
			<br />
		</c:if>
			Lista de Empresas
		<br />
		<ul>
			<c:forEach items="${ companies }" var="company">
				<fmt:formatDate value="${ company.creationDate }" pattern="dd/MM/yyyy" var="date"/>
				<li>
					${ company.name }, criada em ${ date }
					<a href="${ linkServletShowCompany }&id=${ company.id }">Editar</a>
					<a href="${ linkServletDeleteCompany }&id=${ company.id }">Remover</a>
				</li>
			</c:forEach>
		</ul>
	</body>
</html>