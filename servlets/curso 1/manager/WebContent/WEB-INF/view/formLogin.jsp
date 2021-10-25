<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%><!DOCTYPE html>
 
 <c:url value="/entry?action=Login" var="linkNewCompany" />
 
<html>
<head>
	<meta charset="UTF-8">
	<title>Login</title>
</head>
<body>
	<form action="${ linkNewCompany }" method="post" >
		Login: <input type="text" name="login" />
		Senha: <input type="password" name="password" />
		<input type="submit" />
	</form>
</body>
