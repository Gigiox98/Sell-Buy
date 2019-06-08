<%@ page import="java.util.*,Model.*" language="java"
	contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<html lang="en">
<head>
<title>Inserisci Recensione</title>
<link rel="icon" href="Immagini/favicon.png" />
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>

<link rel="stylesheet" href="css/star.css">
<style>
body {
	background-image: url('Immagini/sfondo.jpg');
	background-repeat: none;  	background-size: 100%;

  	
	margin-left: 10%;
	margin-right: 10%;
	
}

.img_container {
	padding: 0.5%;
	margin-left: 1.2%;
	width: 97.6%;
	background-color: rgb(160, 213, 95);
}

.category_img {
	max-width: 12%;
	margin-left: 6.5%;
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

.my_text {
	color: #1A7318;
	font-family: helvetica;
	font-size: 18px;
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
	text-align: center;
	font-size: 30px;
	text-transform: capitalize;
	color: #1A7318;
	border: 2px solid #1A7318;
	
}

.header:hover {
	color: #4FE01D;
	background-color: rgb(255, 255, 255);
}

.my_panel{
	border-radius: 0;
}
 </style>
</head>

<body>
	<%
		String prodotto = request.getParameter("code");
		String name = request.getParameter("name");
		String username = (String) session.getAttribute("username");
	%>
	<div class="container-fluid fixed-top">
		<div class="btn-group btn-group-justified" style="margin-left: 0%;">
			<a class="btn btn-success" href="Starter">Home</a> <a
				class="btn btn-success" href="vendi.jsp">Vendi</a> <a
				class="btn btn-success" href="Storico.jsp">Storico</a> <a
				class="btn btn-success" href="Logout">Log-out</a> <a
				class="btn btn-success" href="#">About-us</a>
		</div>
		<div class="col-sm-12" style="background-color: rgba(128,232,77, 0.7);">

			<h2 class="header"> Recensione <%=name%></h2>
			<div class="container">

				<form action="Recensione" method="post">
					<div class="row">
						<input type="hidden" name="prodotto" value="<%=prodotto%>">
						<input type="hidden" name="username" value="<%=username%>">
						<label class="col-sm-1 my_text" for="commento">Commenta</label> <br><br>
						<textarea class = "header" style="width: 88%; height: 15%;" name="testo"></textarea>
						<br /> <br /> <br>
						<label class="col-sm-1 my_text" for="voto">Feedback:</label>
						
						<div  class="col-sm-2" id="STAR_RATING">
							<ul>
								<li id="star_1" onclick="star_vota(1)" onmouseover="star_accendi(0); star_accendi(1)"></li>
								<li id="star_2" onclick="star_vota(2)" onmouseover="star_accendi(0); star_accendi(2)"></li>
								<li id="star_3" onclick="star_vota(3)" onmouseover="star_accendi(0); star_accendi(3)"></li>
								<li id="star_4" onclick="star_vota(4)" onmouseover="star_accendi(0); star_accendi(4)"></li>
								<li id="star_5" onclick="star_vota(5)" onmouseover="star_accendi(0); star_accendi(5)"></li>
							</ul>
						</div>
						
						<label class="col-sm-3" id="voto_div"></label>
						<input type="hidden" name = "voto" id = "voto" value = "0">
						
					</div>
					<input type="submit" class="btn btn-success" value="Invia recensione" />
				</form>
			</div>
		</div>
	</div>
	
	<script type="text/javascript" src="scripts/star.js"></script>
</body>
</html>
