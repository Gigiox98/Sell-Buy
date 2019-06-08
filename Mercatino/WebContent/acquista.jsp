<%@ page import="java.util.*,Model.*" language="java"
	contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<html lang="en">
<head>
<title>Acquista Ordine</title>
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
		UtenteDAO userDAO = new UtenteDAO();
		Utente y = userDAO.doRetriveByKey((String) session.getAttribute("username"));
		String code = request.getParameter("productToBuy");
		
		
		Carrello cart = (Carrello) session.getAttribute("carrello");
		ProdottoQuantita x = cart.get(code);
		Prodotto p = x.getProdotto();
		
		String j = p.getImmagine();
	%>
	<div class="container-fluid fixed-top">
		<div class="btn-group btn-group-justified" style="margin-left: 0%;">
			<a class="btn btn-success" href="Starter">Home</a> <a
				class="btn btn-success active" href="vendi.jsp">Vendi</a> <a
				class="btn btn-success" href="Storico.jsp">Storico</a> <a
				class="btn btn-success" href="Logout">Log-out</a> <a
				class="btn btn-success" href="#">About-us</a>
		</div>
			<h1 class= "header" align="CENTER">Acquisto  <%=p.getNome()%></h1>
			<div class="col-sm-8">
				<div class="panel panel-primary">
					<div class="panel-heading">Verifica Dati Prodotto</div>
					<div class="panel-body">
						<div class="col-sm-2">
							<img src="data:image/jpg;base64,<%=j%>" class="img-responsive"
								style="max-width: 100%; height: 30%;" alt="Image">
						</div>
						<div class="col-sm-7">
							<span class="my_span">Codice Prodotto: <%=p.getCodice()%></span><br>
							<span class="my_span">Nome Prodotto : <%=p.getNome()%></span><br>
							<span class="my_span">Quantità : <%=x.getQuantita()%></span> <br>
							<span class="my_span">Prezzo Acquisto: <%=x.getPrezzo()%> &euro;</span> <br> 
							<span class="my_span">Prezzo Unitario: <%=p.getPrezzo()%> &euro; </span> <br>
							<span class="my_span">Venditore: <%=p.getCod_venditore()%></span><br>
							<span class="my_span">Zona di Partenza: <%=p.getLocalità()%></span>
						
						</div>
					</div>
					<div class="panel-footer">
						<form action="Acquista" method="post">
						
							<input type ="hidden" name = "product" value = "<%=p.getCodice()%>">
							<label style="position: relative; left: 10px; top: 10px;">Indirizzo di Destinazione:</label>
							<input style="position: relative; left: 10px; top: 10px; width: 22%"type="text" name="indirizzo"
							value = "<%= y.getVia() + " " + y.getN_civico() + " " + y.getCittà()%>">
							
							<label style="position: relative; left: 10px; top: 10px;">Codice carta di credito:</label>
							<input style="position: relative; left: 10px; top: 10px;" type="text" name="pagamento">
						
							
							<label style="position: relative; left: 10px; top: 10px;">Inserisci codice di sconto:</label>
							<input style="position: relative; left: 10px; top: 10px; width: 22%"type="text" name="sconto"
							value = "">
							<button type="submit" class="btn btn-success btn-md"
								style="position: relative; left: 10px; top: 10px; margin-left: 15px;">
								<span  class="glyphicon glyphicon glyphicon-ok"></span>
								Acquista Ordine
							</button>
						</form>
					</div>
				</div>
			</div>
		</div>
	
</body>
</html>


