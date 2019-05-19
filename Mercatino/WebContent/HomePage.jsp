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
	color: rgb(242, 238, 0);
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
	color: #449d44;
	background-color: rgba(255, 255, 255, 0.8);
	padding: 0.5%;
	border: 2px solid #449d44;
	border-radius: 25px;
}

.header:hover {
	color: #5cb85c;
	background-color: rgb(255, 255, 255);
	border-color: 2px solid #5cb85c;
}


   img[usemap] { 
   border: none; 
   height: auto; 
   max-width: 100%; 
   width: auto; 
   }   
 
</style>
</head>
<body>
	<%
		String username = (String) session.getAttribute("username");
		Boolean admin = (Boolean) session.getAttribute("admin");
		
		String j = "";
		
		ArrayList<Prodotto> x = (ArrayList<Prodotto>)request.getAttribute("usati");
		ArrayList<Prodotto> x1 = (ArrayList<Prodotto>)request.getAttribute("nuovi");
		String home = (String)request.getAttribute("Home");
	%>


	<div class="container-fluid">
			<img src="Immagini/HomeTop.PNG" usemap="#image-map">
		
			<map name="image-map">
				<area target="" alt="" title="" href="Starter?categoria=Auto" coords="5,3,214,3,210,10,237,28,232,40,240,49,234,59,250,73,277,85,287,85,289,98,299,110,281,140,306,154,332,168,323,190,348,221,348,232,347,261,357,275,367,294,367,284,361,307,352,342,355,355,367,368,364,385,358,413,358,435,364,449,4,444,-1,319,4,247,5,143" shape="poly">
				<area target="" alt="" title="" href="Starter?categoria=Elettronica" coords="280,4,744,1,744,24,752,27,750,43,746,64,735,82,731,89,734,111,728,132,725,154,723,174,728,189,729,208,729,227,729,245,732,261,737,272,740,290,735,304,737,321,728,334,723,346,719,355,722,367,728,379,721,395,715,411,710,422,695,441,707,450,401,449,393,425,394,388,400,370,387,350,393,328,398,301,397,267,388,251,381,221,372,205,361,198,354,186,376,154,345,137,327,135,336,101,327,97,323,71,302,65,281,56,277,46,283,25,269,27,280,4,348,7" shape="poly">
				<area target="" alt="" title="" href="Starter?categoria=Casa" coords="781,1,1049,4,1044,28,1047,46,1052,63,1050,78,1057,95,1090,112,1089,129,1086,147,1083,154,1078,170,1078,194,1057,210,1057,221,1052,240,1038,259,1041,291,1041,305,1040,316,1037,337,1044,357,1032,374,1008,445,732,448,743,426,761,380,750,354,772,315,777,288,762,264,767,220,761,177,764,138" shape="poly">
				<area target="" alt="" title="" href="Starter?categoria=Ferramenta" coords="1034,446,1241,450,1264,401,1311,386,1341,330,1379,336,1409,269,1375,233,1356,203,1353,151,1344,97,1330,68,1307,15,1302,3,1233,1,1065,3,1086,36,1087,85,1115,94,1121,137,1106,178,1114,198,1087,229,1069,260,1084,299,1075,327,1077,352,1071,370,1050,408" shape="poly">
				<area target="" alt="" title="" href="Starter" coords="1382,1,1678,1,1679,76,1676,138,1679,186,1675,197,1613,206,1580,212,1559,242,1491,264,1437,261,1417,223,1393,202,1381,132,1372,76,1357,40,1336,0" shape="poly">
				<area target="" alt="" title="" href="Starter?categoria=Altro..." coords="1276,446,1311,411,1336,407,1350,362,1400,355,1434,291,1483,282,1532,275,1563,263,1587,242,1608,226,1633,233,1676,226,1676,257,1678,315,1679,377,1679,405,1672,443,1657,450,1307,449" shape="poly">
			</map>
			
	</div>
	
	<div class="container-fluid fixed-top">
		<div class="btn-group btn-group-justified" style="margin-left: 0%;">
			<a class="btn btn-success active" href="Starter"><%=home%></a>
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

		<nav class="navbar navbar-inverse" style = "background-color: rgb(160, 213, 95)">
			<div class="container-fluid">

				<!-- BRAND -->
				<div class="navbar-header">
					<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#alignment-example" aria-expanded="false">
						<span class="sr-only">Toggle navigation</span> <span
							class="icon-bar"></span> <span class="icon-bar"></span> <span
							class="icon-bar"></span>
					</button>
					
					<%
							if (username != null) {
						%>
						<span class="navbar-brand" style= "color: white;">
							Benvenuto <%=username%></span> <%
 							} else {
 							%>
						
						<span class="navbar-brand" style= "color: white;">
							Effettua login</span>

						<%
							}
						%>
				</div>

				<!-- COLLAPSIBLE NAVBAR -->
				<div class="collapse navbar-collapse" id="alignment-example">

					<!-- Links -->
				
					<ul class="nav navbar-nav">		
						<% if (username != null) { %>				
						<li><a href="Carrello.jsp" style="color: white; font-family: Helvetica; font-size:18px;"><span class="glyphicon glyphicon-shopping-cart"></span> Carrello</a></li>
						<%} %>
						<li class="dropdown"> <a href=""  class="dropdown-toggle"
						data-toggle="dropdown" style="color:white; font-family: Helvetica; font-size:18px;"> 
						<span class="glyphicon glyphicon-align-justify"></span> Funzionalità</a>
						<ul class="dropdown-menu">
							<li><a href="FiltroRicercaAvanzata.jsp">Ricerca
									Avanzata</a></li>
							<%if(admin != null && admin){%> 
								<li><a href="GestioneUtenza" >Gestione Utenza</a></li>
								<li><a href="ProdottiMoltoVenduti">Gestione prodotti più venduti</a></li>
								<li><a href="ProdottiNonVenduti">Gestione prodotti meno venduti</a></li>
							<%} %>
						</ul>
					</li>
					</ul>
					
					<!-- Search -->
					<form action="Starter" method="get" class="navbar-form navbar-right" role="search">
						<div class="form-group">
							<input type="text" name="prodotto" placeholder="Prodotto" class="form-control">
							<input type="text" name="zona" placeholder="zona" class="form-control">
						</div>
						<button type="submit" class="btn btn-success"> <span class="glyphicon glyphicon-search"></span> Cerca</button>
					</form>

				</div>

			</div>
		</nav>
		



		<br> <br>
		<div class="container">
			<h1 class="header">prodotti usati</h1>
			<div class="row">

				<%
					for (Prodotto y : x) {
						if (y == null)
							System.out.println("null");
						else {
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
					}
					}
				%>
			</div>
		</div>



		<br> <br>

		<div class="container">
			<h1 class="header">prodotti nuovi</h1>
			<div class="row">
				<%
					for (Prodotto y : x1) {
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
							<form action="dettagli" method="get">
								<input type="hidden" name="code" value="<%=y.getCodice()%>">
								<input type="submit" class="btn btn-primary btn-md"
									value="Dettagli Prodotto">
							</form>
						</div>
					</div>
				</div>
				<%
					}
				%>
			</div>
		</div>
		<footer class="container-fluid text-center">
			<p>Footer Text</p>
		</footer>
		
		<!-- Lo Script Prende dei codici jquery da internet, in modo tale da modificare dinamicamente il mapping dell'immagine categorie -->
		<script src="https://cdnjs.cloudflare.com/ajax/libs/jQuery-rwdImageMaps/1.6/jquery.rwdImageMaps.min.js" integrity="sha256-H0jJMH37jcA7SQWWbILbmKZkAQyD6pUqbR46qtwAcDs=" crossorigin="anonymous"></script> 
		<script> 
		   $(document).ready(function(e) { 
		   $('img[usemap]').rwdImageMaps(); 
		   $('area').on('focus', function(e) { 
		   e.preventDefault(); 
		   $('.selection p').html($(this).attr('class'));       
		   }); 
		   $(document).on('click', function(e) { 
		   if ( $(e.target).closest('area').length === 0 ) { 
		     $('.selection p').html('click su una zona'); 
		   }   
		   });   
		   }); 
		</script>
</body>

</html>