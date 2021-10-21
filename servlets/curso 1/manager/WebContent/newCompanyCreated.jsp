<%
String companyName = (String) request.getAttribute("company");
System.out.println(companyName);
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Nova Empresa</title>
</head>
<body>
	Empresa <%= companyName %> cadastrada com sucesso!
</body>
</html>