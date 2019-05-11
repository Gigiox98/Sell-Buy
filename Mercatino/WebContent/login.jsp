<%@ page import="java.util.*,Model.*" language="java"
	contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<html lang="en">
<head>
<title>Login</title>
<link rel="icon" href="Immagini/favicon.png" />
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<style>
body {
	background-image: url('Immagini/sfondo.jpg');
}

a {
	color: rgb(242, 238, 0);
	font-size: 15px
}

a:hover {
	background: grey;
}
/* Remove the navbar's default margin-bottom and rounded borders */
.navbar {
	margin-bottom: 0;
	border-radius: 0;
}

/* Set height of the grid so .sidenav can be 100% (adjust as needed) */
.row.content {
	height: 450px
}

/* Set gray background color and 100% height */
.sidenav {
	padding-top: 20px;
	background-color: #f1f1f1;
	height: 100%;
}

/* Set black background color, white text and some padding */
footer {
	background-color: #555;
	color: white;
	padding: 15px;
}

/* On small screens, set height to 'auto' for sidenav and grid */
@media screen and (max-width: 767px) {
	.sidenav {
		height: auto;
		padding: 15px;
	}
	.row.content {
		height: auto;
	}
	.nav-link:hover {
		background: red;
	}
}

.my_input {
	position: relative;
	top: 10px;
	width: 30%;
	height: 25px;
	margin: 0 auto;
	border: auto;
	border-radius: 10px;
}

.my_select {
	position: relative;
	top: 10px;
	width: 20%;
	height: 25px;
	margin: 0 auto;
	border: auto;
	border-radius: 10px;
}

.header {
	font-family: helvetica;
	font-style: italic;
	text-align: center;
	font-size: 30px;
	text-transform: capitalize;
	color: #337ab7;
	background-color: white;
	padding: 0.5%;
	border: 2px solid blue;
}
</style>
</head>
<body>
	<div class="container-fluid fixed-top" >
		<div class="btn-group btn-group-justified" style="margin-left: 0%;">
			<a class="btn btn-success" href="HomePage.jsp">Home</a> <a
				class="btn btn-success active" href="login.jsp"><span
				class="glyphicon glyphicon-log-in"></span> Login</a> <a
				class="btn btn-success" href="Registration.html">Registazione</a> <a
				class="btn btn-success" href="#">About-us</a>
		</div>
		<div class="col-sm-5" style="background-color:white; border-radius:10px; margin:20px; border: 3px solid #337ab7">
			<%
				String esito = (String) request.getAttribute("esito");
				if (esito != null) {
					if (esito.equalsIgnoreCase("negativo")) {
						out.print("<h1> Username/password errati</h1>");
					}
				}
			%>
			<h1 align="center">Login</h1>
			<div class="container">

				<form action="Login" method="post">
					<div class="row">
						<label class="col-sm-1" for="Username">Username:</label> <input
							class="col-sm-4" type="text" class="form-control" name="username">
						<br /> <br /> <label class="col-sm-1" for="password">Password:</label>
						<input class="col-sm-4" type="password" class="form-control"
							name="password"> <br /> <br />
					</div>
					
					<input type="submit" class="btn btn-success" value="Accedi" />
				</form>
			</div>
		</div>
	</div>
</body>
</html>



