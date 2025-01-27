<%@ page import="java.util.*,Model.*" language="java"
	contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<html lang="en">
<head>
<title>Dettagli</title>
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

.my_span {
	font-family: helvetica;	
	margin-left: 10px;
	font-size: 18px;
	color: #337ab7;
}
</style>
</head>
<body>
	<%
		String username = (String) session.getAttribute("username");
		
		
		Prodotto p = (Prodotto) request.getAttribute("prodotto");
		
		int q_limit = (int) request.getAttribute("quantit�_limite");
		String j = p.getImmagine();
	
		UtenteDAO du = new UtenteDAO();
		Utente venditore = du.doRetriveByKey(p.getCod_venditore());
		RecensioneDAO dr = new RecensioneDAO();
		ArrayList <Recensione> recensioni = dr.doRetriveByCond("codice_p = '" + p.getCodice()+"'");
	%>
	<div class="container-fluid fixed-top">
		<div class="btn-group btn-group-justified" style="margin-left: 0%;">
			<a class="btn btn-success" href="Starter">Home</a>
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

				<div class="collapse navbar-collapse" id="myNavbar"
					style="margin: 0%;">

					<ul class="nav navbar-nav" style="">
						<%
							if (username != null) {
						%>


						<li class="navbar-brand" style="color: rgb(242, 238, 0);">
							Benvenuto <%=username%>
						</li>
						<li><a href="Carrello.jsp" class="navbar-item"
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
				</div>
				
				<% %>
			</nav>
		</div>




		<br> <br>
		<div class="container">
			<h1 class="header">
				Prodotto
				<%=p.getCodice()%></h1>
			<div class="row">


				<div class="col-sm-12">
					<div class="panel panel-primary">
						<div class="panel-heading"><%=p.getNome()%></div>
						<div class="panel-body">
							<div class="col-sm-4">
								<img src="data:image/jpg;base64,<%=j%>" class="img-responsive"
									style="width: 100%; height: 40%;" alt="Image">
							</div>
							<div class="col-sm-8">
								<span class="my_span">Categoria: <%=p.getCod_categoria()%></span><br>
								<span class="my_span">Descrizione: <%=p.getDescrizione()%></span><br>
								<span class="my_span">Prezzo: <%=p.getPrezzo()%> &euro;
								</span><br> <span class="my_span">Localit�: <%=p.getLocalit�()%></span><br>
								<span class="my_span">Stato Prodotto: <%=p.getStato()%></span><br>
								<span class="my_span">Data Inserimento: <%=p.getData_ins()%></span><br>
								<span class="my_span">Venditore: <%=venditore.getUsername()%></span><br>
								<br>
								<br>
								<br>
								<br>
								<%
									if (username != null) {
								%>
								<form action="InserisciRecensione.jsp" method="post" style ="display: inline">
									<input type="hidden" name="code" value="<%=p.getCodice()%>">
									<input type="hidden" name="name" value="<%=p.getNome()%>">
									
									<button class="btn btn-primary">
										<span class="glyphicon glyphicon-pencil"></span>Recensione
									</button>
								</form>
								
								<%

									} 
								%>
									<%
										if (q_limit > 0) {
									%>
									<form action="AddToCart" method="get" style ="display: inline">
										<input type="hidden" name="code" value="<%=p.getCodice()%>">
										<span class="my_span">Quantit�:</span> <input type="number"
											name="quantita" min="1" max="<%=q_limit%>" step="1">
										<button class="btn btn-primary">
											<span class="glyphicon glyphicon-shopping-cart"></span>Aggiungi
											al carrello
										</button>
									</form>
									<%
										} else {
									%>
									<span class="my_span">Prodotto non disponibile</span>
								<%} %>
							</div>
						</div>

					</div>
				</div>
			</div>
			
			<%if(recensioni != null){%>
			
			<h1 class="header">Recensioni Prodotto</h1>
			
			<% for (Recensione rec: recensioni){ %>
				<div class="row">
					<div class="col-sm-12">
					<div class="panel panel-primary">
						<div class="panel-body">
								<span class="my_span">Username: <%=rec.getUtente()%></span><br>
								<span class="my_span">Commento: <%=rec.getText()%></span>
								<br> <span class="my_span">Voto: <%=rec.getVoto()%></span><br>
								
							</div>
						</div>

					</div>
				</div>
			<%} %>
			<%}%>
		</div>


		<footer class="container-fluid text-center">
			<p>Footer Text</p>
		</footer>
</body>
</html>