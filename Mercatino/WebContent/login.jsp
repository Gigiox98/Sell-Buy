<%@ page import="java.util.*" language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login minimale</title>

<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>

</head>
<body>

<% String esito= (String)request.getAttribute("esito");
   if(esito!=null)
   {
   		if(esito.equalsIgnoreCase("negativo"))
   		{
	       out.print("<h1> Username/password errati</h1>");
   		}
   }
%>
<div class="container">
<h1 align="center"> Login </h1>
	<form action="Login" method="post">
	
		<div class="form-group">
     	 <label for="username">Username:</label>
      	 <input type="text" class="form-control" name="username">
   		</div>
   		
    <div class="form-group">
      <label for="password">Password:</label>
      <input type="password" class="form-control" name="password">
    </div>
    
     <input type="submit" class="btn btn-primary" value="Accedi"/>
     
	</form>
</div>


</body>
</html>

