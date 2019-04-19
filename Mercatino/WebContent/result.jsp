<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Risultato Registrazione</h1>
	<p>
		<%
			Boolean ack = (Boolean) request.getAttribute("Controllo");
		if (ack) out.write("ok");
		else out.write("Error");

		%>
	
</body>
</html>

