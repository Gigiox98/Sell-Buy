<%@ page language="java" import="java.io.*,java.util.*" import="Model.*" import="java.util.Base64" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>LOL</title>
</head>
<body>
	<%
		ProdottoDAO p=new ProdottoDAO();
		Prodotto x=p.doRetriveByKey("9553395112");
		String j=x.getImmagine();
	%>
		<img src="data:image/jpg;base64,<%=j %>">
</body>
</html>