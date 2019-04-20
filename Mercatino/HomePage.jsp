<%@ page import="java.util.*" language="java"
	contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<html lang="en">
<head>
<title>Homepage</title>
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
	margin-left: 10%;
	margin-right: 10%;
	background-image: url('Immagini/sfondo.jpg');
}

a {
	color: rgb(242, 238, 0);
	font-size: 20px
}

a:hover{
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
</style>
</head>
<body>
	<%
		String username = (String) session.getAttribute("username");
	%>
	<div class="col-lg-12" style="padding: 0;">
		<img src="Immagini/HomeTop.PNG" class="img img-responsive" style="width:100%; margin:none;">
		</div>


	<div class="container-fluid text-center">
		<div class="row content">
			<div class="col-sm-2 sidenav" style="background-color:#101010;">
				<ul class="nav flex-column ">
					<li class="nav-item"><a class="nav-link active" href="#">Home</a>
					</li>
					<%
						if (username == null) {
					%>
					<li class="nav-item"><a class="nav-link" href="login.jsp"><span
							class="glyphicon glyphicon-log-in"></span> Login</a></li>
					<li class="nav-item"><a class="nav-link" href="#">Registazione</a>
					</li>
					<%
						} else {
					%>
					<li class="nav-item"><a class="nav-link" href="vendi.jsp">Vendi</a>
					</li>
					<li class="nav-item"><a class="nav-link" href="Storico.jsp">Storico</a></li>
					<li class="nav-item"><a class="nav-link" href="Logout">Log-out</a></li>
					<%
						}
					%>
					<li class="nav-item"><a class="nav-link" href="#">About-us</a></li>
				</ul>

			</div>
			<div class="col-sm-10 text-left"
				style="background-color: green; height: 100%; padding: 0%;">
				<nav class="navbar navbar-inverse" style="margin: 0%;">
					<div class="container-fluid">

						<div class="navbar-header">
							<button type="button" class="navbar-toggle"
								data-toggle="collapse" data-target="#myNavbar">
								<span class="icon-bar"></span> <span class="icon-bar"></span> <span
									class="icon-bar"></span>
							</button>
							<span class="navbar-brand" style="color: rgb(242, 238, 0);">Filtro
								Ricerca</span>
						</div>
						<div class="collapse navbar-collapse" id="myNavbar">
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
									if (username != null) {
										out.print("<p class=\"navbar-brand\" style=\"color: rgb(242, 238, 0);\"> Benvenuto " + username
												+ " </p>");
										out.print(" <ul class=\"nav navbar-nav navbar-right\"><li> <a href=\"#\" class=\"navbar-item btn btn-success btn-md\" style=\" color: rgb(242, 238, 0);position: absolute; top: 10%; right: 2%;\">"
														+ "<p class=\"  glyphicon glyphicon-shopping-cart\"></p> Shopping Cart</a></li></ul>");
									}

									else {
										out.print("<p class=\"navbar-brand\" style=\"color: rgb(242, 238, 0);\"> Effettua login </span>");
									}
								%>
						</div>
					</div>
				</nav>

			</div>
		</div>
	</div>

	<footer class="container-fluid text-center">
		<p>Footer Text</p>
	</footer>

</body>
</html>