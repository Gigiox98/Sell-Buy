<%@ page import="java.util.*,Model.*" language="java"
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
</style>
</head>
<body>
	<%
		String username = (String) session.getAttribute("username");
	%>

	
		<div class="container-fluid" style="">
			<img src="Immagini/HomeTop.PNG" class="img img-responsive"
				style="width: 100%; margin: none;">
		</div>

		<div class="container-fluid fixed-top">
		<div class="btn-group btn-group-justified" style="margin-left :0%;">
			<a class="btn btn-success active" href="#">Home</a>
			<%
				if (username == null) {
			%>
			<a class="btn btn-success" href="login.jsp"><span
				class="glyphicon glyphicon-log-in"></span> Login</a> <a
				class="btn btn-success" href="Registration.html">Registazione</a>

			<%
				} else {
			%>
			<a class="btn btn-success" href="vendi.jsp">Vendi</a> <a
				class="btn btn-success" href="Storico.jsp">Storico</a> <a
				class="btn btn-success" href="Logout">Log-out</a>
			<%
				}
			%>
			<a class="btn btn-success" href="#">About-us</a>
		</div>
		<div class=" text-left">
			<nav class="navbar navbar-inverse" style="margin: 0%;">


				<div class="navbar-header">


					<button type="button" class="navbar-toggle" data-toggle="collapse"
						data-target="#myNavbar">
						<span class="icon-bar"></span> <span class="icon-bar"></span> <span
							class="icon-bar"></span>
					</button>

				</div>

				<div class="collapse navbar-collapse" id="myNavbar" style ="margin: 0%;">

					<ul class="nav navbar-nav" style="">
						<%
							if (username != null) {
						%>


						<li class="navbar-brand" style="color: rgb(242, 238, 0);">
							Benvenuto <%=username%>
						</li>
						<li><a href="#" class="navbar-item"
							style="color: rgb(242, 238, 0);"> <span
								class="glyphicon glyphicon-shopping-cart"></span>
						</a></li>


						<%
							} else {
						%>

						<li class="navbar-brand" style="color: rgb(242, 238, 0);">
							Effettua login</li>

						<%
							}
						%>
					</ul>

					<span class="navbar-brand " style="color: rgb(242, 238, 0);">Filtro
						Ricerca</span> <input type="text" class="my_input" placeholder="Prodotto">
					<select class="my_select">
						<option>Zona</option>
						<option>Zona</option>
						<option>Zona</option>
						<option>Zona</option>

					</select>
					<button type="submit" class="btn btn-success btn-md"
						style="position: relative; top: 10px;">
						<span class="glyphicon glyphicon-search"></span>
					</button>

				</div>
		</div>
		</nav>

		<%
			ProdottoDAO p = new ProdottoDAO();
			Prodotto x = p.doRetriveByKey("4138789652");
			String j = x.getImmagine();
		%>
		
		<br><br>
		<div class="container">
			<h1 align="center" style="color: lightblue">USATO</h1>
			<div class="row">
				<div class="col-sm-4">
					<div class="panel panel-primary">
						<div class="panel-heading">BLACK FRIDAY DEAL</div>
						<div class="panel-body">
							<img src="data:image/jpg;base64,<%=j%>" class="img-responsive"
								style="width: 100%" alt="Image">
						</div>
						<div class="panel-footer">Buy 50 mobiles and get a gift card</div>
					</div>
				</div>
				<div class="col-sm-4">
					<div class="panel panel-danger">
						<div class="panel-heading">BLACK FRIDAY DEAL</div>
						<div class="panel-body">
							<img src="data:image/jpg;base64,<%=j%>" class="img-responsive"
								style="width: 100%" alt="Image">
						</div>
						<div class="panel-footer">Buy 50 mobiles and get a gift card</div>
					</div>
				</div>
				<div class="col-sm-4">
					<div class="panel panel-success">
						<div class="panel-heading">BLACK FRIDAY DEAL</div>
						<div class="panel-body">
							<img src="data:image/jpg;base64,<%=j%>" class="img-responsive"
								style="width: 100%" alt="Image">
						</div>
						<div class="panel-footer">Buy 50 mobiles and get a gift card</div>
					</div>
				</div>
			</div>
		</div>
		<br>

		<div class="container">
			<div class="row">
				<h1 align="center" style="color: lightblue">NUOVO</h1>
				<div class="col-sm-4">
					<div class="panel panel-primary">
						<div class="panel-heading">BLACK FRIDAY DEAL</div>
						<div class="panel-body">
							<img src="data:image/jpg;base64,<%=j%>" class="img-responsive"
								style="width: 100%" alt="Image">
						</div>
						<div class="panel-footer">Buy 50 mobiles and get a gift card</div>
					</div>
				</div>
				<div class="col-sm-4">
					<div class="panel panel-primary">
						<div class="panel-heading">BLACK FRIDAY DEAL</div>
						<div class="panel-body">
							<img src="data:image/jpg;base64,<%=j%>" class="img-responsive"
								style="width: 100%" alt="Image">
						</div>
						<div class="panel-footer">Buy 50 mobiles and get a gift card</div>
					</div>
				</div>
				<div class="col-sm-4">
					<div class="panel panel-primary">
						<div class="panel-heading">BLACK FRIDAY DEAL</div>
						<div class="panel-body">
							<img src="data:image/jpg;base64,<%=j%>" class="img-responsive"
								style="width: 100%" alt="Image">
						</div>
						<div class="panel-footer">Buy 50 mobiles and get a gift card</div>
					</div>
				</div>
			</div>
		</div>

	</div>

	<br>
	<br>


	<footer class="container-fluid text-center">
		<p>Footer Text</p>
	</footer>

</body>
</html>