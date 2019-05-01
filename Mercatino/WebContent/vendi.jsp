<%@ page import="java.util.*,Model.*" language="java"
	contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<html lang="en">
<head>
<title>Inserisci Annuncio</title>
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
		String username = (String) session.getAttribute("username");
		ProdottoDAO dao = new ProdottoDAO();
		Prodotto p = dao.doRetriveByKey(request.getParameter("ModifyProduct"));
		ArrayList<Prodotto> myProducts = dao.doRetriveByCond("codice_venditore = '" + username +"'");
	%>
	<div class="container-fluid fixed-top">
		<div class="btn-group btn-group-justified" style="margin-left: 0%;">
			<a class="btn btn-success" href="HomePage.jsp">Home</a> <a
				class="btn btn-success active" href="vendi.jsp">Vendi</a> <a
				class="btn btn-success" href="Storico.jsp">Storico</a> <a
				class="btn btn-success" href="Logout">Log-out</a> <a
				class="btn btn-success" href="#">About-us</a>
		</div>

		<%
			if (myProducts != null) {
		%>
		<br>
		<div class="row">
			<div class="col-sm-6" style="margin: 20px;">
				<div class="panel panel-primary">
					<div class="panel-heading">Prodotti Inseriti</div>
					<form action="vendi.jsp" method="get" enctype="multipart/form-data">
					<div class="panel-body">
						<%
							for (Prodotto x : myProducts) {
						%>

								<input type="radio" id="huey" name="ModifyProduct" value="<%=x.getCodice()%>"> <label><%=x.getNome()%>
								
								<%if(x.getQuantità() == 0)%> <strong style= "background-color: yellow">ESAURITO</strong>
								
								</label><br>
						<%
							}
						%>
						
						<input type="submit" class="btn btn-success"  onclick="myFunction()"
							value="Aggiorna Prodotto">

						
						
					</div>
					</form>
				</div>
			</div>


		</div>

		<%
			}
		%>
		
		<div class="col-sm-6"
			style="background-color: white; border-radius: 10px; margin: 20px; border: 3px solid #337ab7">
			<h1 align="CENTER">Form Vendita</h1>


			<form action="Vendi" method="post" enctype="multipart/form-data">
				<div class="container">
					<h3>Inserisci i dati per la vendita del tuo prodotto</h3>
					
					<%if(p==null){ %>
					<div class="row">
						<label class="col-sm-2" for="categoria">Categoria:</label> <select
							class="col-sm-4" name="categoria">
							<%
								CategoriaDAO categoria = new CategoriaDAO();
								ArrayList<Categoria> list = categoria.doRetriveAll();
								for (int i = 0; i < list.size(); i++) {
									out.print("<option value=\"" + list.get(i).getNome() + "\">" + list.get(i).getNome() + "</option>");
								}
							%>
						</select> <br> <br> 
						<label class="col-sm-2" for="nome">Nome Prodotto:</label> 
						<input class="col-sm-4" type="text" class="form-control" name="nome"> <br> <br> 
						<label class="col-sm-2" for="prezzo">Prezzo:</label> 
						<input class="col-sm-4" type="number" step="0.1" class="form-control" name="prezzo"> <br> <br> 
						<label class="col-sm-2" for="quantità">Quantità:</label> 
						<input class="col-sm-4" type="number" class="form-control" name="quantità"> <br> <br>
						<label class="col-sm-2" for="località" >Località:</label> 
						<input class="col-sm-4" type="text" class="form-control" name="località" id="Località"><br> <br> 
						<label class="col-sm-2" for="categoria">Stato:</label>
						<select class="col-sm-4" name="stato">
							<option value="Usato">Usato</option>
							<option value="Nuovo">Nuovo</option>
						</select> <br> <br> 
						<label class="col-sm-2" for="descrizione">Descrizione:</label>
						<input class="col-sm-4" type="text" class="form-control" name="descrizione"> <br> <br> 
						<label class="col-sm-2" for="image">Immagine:</label> 
						<input class="col-sm-4" type="file" class="form-control" name="image">
						<br>
					</div>
					<% } else {%>
					<div class="row">
						<input type="hidden" name="codice"value="<%=p.getCodice()%>"> 
						
						<input type="checkbox" name="elimina" value="elimina"> Elimina<br><br>
						<label class="col-sm-2" for="nome" >Nome Prodotto:</label> 
						<input class="col-sm-4" type="text" class="form-control" name="nome" value = "<%=p.getNome() %>" > <br> <br> 
						<label class="col-sm-2" for="prezzo" >Prezzo:</label> 
						<input class="col-sm-4" type="number" step="0.1" class="form-control" name="prezzo" value = "<%=p.getPrezzo() %>" > <br> <br> 
						<label class="col-sm-2" for="quantità">Quantità:</label> 
						<input class="col-sm-4" type="number" class="form-control" name="quantità"> <br> <br>
						<label class="col-sm-2" for="località"  >Località:</label> 
						<input class="col-sm-4" type="text" class="form-control" name="località" value = "<%=p.getLocalità() %>"><br> <br> 
						<label class="col-sm-2" for="descrizione">Descrizione:</label>
						<input class="col-sm-4" type="text" class="form-control" name="descrizione" value="<%=p.getDescrizione()%>"> <br> <br> 
					
					
					</div>
					<%}%>
					<input type="submit" class="btn btn-success" value="Esegui Modifica">


				</div>
			</form>

		</div>
	</div> 

</body>
</html>


