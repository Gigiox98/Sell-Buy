<%@ page import="java.util.*" language="java"
	contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>


<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<style>
body {
	background-image: url('Immagini/sfondo.jpg');
}

a {
	color: rgb(242, 238, 0);
	font-size: 20px
}
</style>
<title>HomePage</title>
</head>
<body>

	<%
		String username= (String) session.getAttribute("username");
	%>

	<div class="container" style="background-color: green;">
		<div class="row">
			<div class="col-lg-12" style="padding: 0px;">
				<img src="Immagini/HomeTop.PNG" class="img img-responsive"
					style="width: 100%">
			</div>
		</div>
		<div class="row" style="padding: 0px;">
			<div class="col-sm-3" style="height: 1000px; padding: 0px;">
				<nav class="navbar navbar-inverse"
					style="border-radius: 0; height: 1000px; border: none;">
					<ul class="nav nav-bar-inverse flex-column">
						<li class="nav-item"><a class="nav-link active"
							href="HomePage.jsp">Home</a></li>
						<%if (username== null) {%>
							<li class="nav-item"><a class="nav-link" href="login.jsp">Login</a> </li>
							<li class="nav-item"><a class="nav-link"
							href="Registration.html">Registrazione</a></li>
							
						<% } else { %>
						<li class="nav-item"><a class="nav-link" href="vendi.jsp">Vendi</a>
						</li>
						<li class="nav-item"><a class="nav-link"
							href="Storico.jsp">Storico</a></li>
						<li class="nav-item"><a class="nav-link"
							href="Logout">Log-out</a></li>
						<%}%>
							
						<li class="nav-item"
							style="position: absolute; width: 100%; top: 96.1%;"><a
							class="nav-link" href="#">About-us</a></li>
					</ul>


				</nav>
			</div>

			<div class="col-sm-9" style="height: 1000px; padding: 0px;">
				<nav class="navbar navbar-inverse"
					style="border-radius: 0; border: none;">
					<div class="container">

						<span class="navbar-brand" style="color: rgb(242, 238, 0);">Filtro
							Ricerca</span>


						<form class="navbar-form navbar-left" action="/action_page.php">
							<div class="form-group" style="display: inline;">
								<input type="text" class="form-control" placeholder="Prodotto">
								<select class="form-control">
									<option>Zona</option>
									<option>Zona</option>
									<option>Zona</option>
									<option>Zona</option>

								</select>
								<button type="submit" class="btn btn-success">
									<span class="glyphicon glyphicon-search"></span>
								</button>
							</div>
						</form>

						<%
							
							if (username!= null) 
							{ 	
								out.print("<p class=\"navbar-brand\" style=\"color: rgb(242, 238, 0);\"> Benvenuto " + username + " </p>");
								out.print("<a href=\"#\" class=\"navbar-item btn btn-success btn-md\" style=\"position: absolute; top: 10%; right: 2%;\">"+
								          "<p class=\"  glyphicon glyphicon-shopping-cart\"></p> Shopping Cart"+
								          "</a>");
							}

							else 
							{
								out.print("<p class=\"navbar-brand\" style=\"color: rgb(242, 238, 0);\"> Effettua login </span>");
							}
						%>

					</div>
				</nav>
			</div>


		</div>

	</div>
</body>
</html>