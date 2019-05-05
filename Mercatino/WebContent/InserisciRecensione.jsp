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
	<%
		String prodotto = request.getParameter("code");
		String username = (String) session.getAttribute("username");
	%>
	<div class="container-fluid fixed-top">
		<div class="btn-group btn-group-justified" style="margin-left: 0%;">
			<a class="btn btn-success" href="HomePage.jsp">Home</a> <a
				class="btn btn-success" href="vendi.jsp">Vendi</a> <a
				class="btn btn-success" href="Storico.jsp">Storico</a> <a
				class="btn btn-success" href="Logout">Log-out</a> <a
				class="btn btn-success" href="#">About-us</a>
		</div>
		<br>
		<div class="col-sm-5"
			style="background-color: white; border-radius: 10px; margin: 20px; border: 3px solid #337ab7">

			<h2 align="center">
				Recensione prodotto
				<%=prodotto%></h2>
			<div class="container">

				<form action="Recensione" method="post">
					<div class="row">
						<input type="hidden" name="prodotto" value="<%=prodotto%>">
						<input type="hidden" name="username" value="<%=username%>">
						<label class="col-sm-1" for="commento">Commenta:</label>
						<textarea class="col-sm-4" class="form-control" name="testo"></textarea>
						<br /> <br /> <br>
						<label class="col-sm-2" for="voto">Vota il prodotto:</label>
							<input type="radio"  name="voto" value="1" />
							<input type="radio"  name="voto" value="2" />
							<input type="radio"  name="voto" value="3" />
							<input type="radio"  name="voto" value="4" />
							<input type="radio"  name="voto" value="5" />
							
					</div>

					<input type="submit" class="btn btn-success" value="Invia recensione" />
				</form>
			</div>
		</div>
	</div>
</body>
</html>
