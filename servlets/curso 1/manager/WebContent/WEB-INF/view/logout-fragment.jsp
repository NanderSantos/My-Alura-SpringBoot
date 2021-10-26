<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%><!DOCTYPE html>

<c:url value="/entry?action=Logout" var="linkLogout" />

<html>
<head>
	<meta charset="UTF-8">
	<title>Login</title>
</head>
<body>
	<a href="${ linkLogout }">Logout</a>
	<br />
	<br />
</body>