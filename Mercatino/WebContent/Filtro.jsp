<%@ page import="java.util.*,Model.*" language="java"
	contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<html lang="en">
<head>
<title>Login</title>
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
<%
ArrayList<Prodotto> prodotti = (ArrayList<Prodotto>) request.getAttribute("prodotti");
String j = "";
%>
	<div class="container-fluid fixed-top" >
		<div class="btn-group btn-group-justified" style="margin-left: 0%;">
			<a class="btn btn-success" href="HomePage2.jsp">Home</a> <a
				class="btn btn-success" href="login.jsp"><span
				class="glyphicon glyphicon-log-in"></span> Login</a> <a
				class="btn btn-success" href="Registration.html">Registazione</a> <a
				class="btn btn-success" href="#">About-us</a>
		</div>
		<div class=" text-left">
			<div class="container">
			<h1 class="header">Risultato Ricerca</h1>
			<div class="row">
				<%
					if(prodotti == null) System.out.println("NULL");
					else{
					for (Prodotto y : prodotti) {
						if (y == null)
							System.out.print("null");
						else
							j = y.getImmagine();
				%>

				<div class="col-sm-4">
					<div class="panel panel-primary">
						<div class="panel-heading"><%=y.getNome()%></div>
						<div class="panel-body">
							<img src="data:image/jpg;base64,<%=j%>" class="img-responsive"
								style="width: 100%; height: 40%;" alt="Image">
						</div>
						<div class="panel-footer">
							<form action="dettagli" method="post">
								<input type="hidden" name="code" value="<%=y.getCodice()%>">
								<input type="submit" class="btn btn-primary btn-md"
									value="Dettagli Prodotto">
							</form>
						</div>
					</div>
				</div>
				<%
					}}
				%>
			</div>
		</div>
	</div>
	</div>
</body>
</html>
