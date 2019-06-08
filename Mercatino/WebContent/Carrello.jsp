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
		Collection <ProdottoQuantita> carrello = null;
		Carrello cart = (Carrello) session.getAttribute("carrello");
		if(cart != null){
			 carrello = cart.getProdotti();
		}
	%>
	<div class="container-fluid fixed-top">
		<div class="btn-group btn-group-justified" style="margin-left: 0%;">
			<a class="btn btn-success" href="Starter">Home</a> <a
				class="btn btn-success" href="vendi.jsp">Vendi</a> <a
				class="btn btn-success" href="Storico.jsp">Storico</a> 
				<%if (username != null){ %><a class="btn btn-success" href="Logout">Log-out</a> 
				<%}else {%> <a class="btn btn-success" href="login.jsp">Log-in</a> <%} %>
				<a class="btn btn-success" href="#">About-us</a>
		</div>
		<br>
		
		<%if(carrello == null || carrello.isEmpty()) { %> <h1 class = "header"> Non Hai Prodotti Nel Carrello</h1>
		<%
		} else {
			for (ProdottoQuantita x: carrello){
				Prodotto p = x.getProdotto();
				String j = p.getImmagine();
		%>

		<div class="row">
			<div class="col-sm-9">
				<div class="panel panel-primary">
					<div class="panel-heading"><%=p.getNome()%></div>
					<div class="panel-body">
						<div class="col-sm-2">
							<img src="data:image/jpg;base64,<%=j%>" class="img-responsive"
								style="width: 50%; height: 15%;" alt="Image">
						</div>
						<div class="col-sm-7">
							<span class="my_span">Quantità: <%=x.getQuantita()%></span> 
							<span class="my_span">Prezzo Acquisto: <%=x.getPrezzo()%>
								&euro;
							</span> <br> <span class="my_span">Prezzo Unitario: <%=p.getPrezzo()%>
								&euro;
							</span> <span class="my_span">Venditore: <%=p.getCod_venditore()%></span>
							
							<%if(username != null){ %>
							<form action="acquista.jsp" method="post">
								<input type ="hidden" name = "productToBuy" value = "<%=p.getCodice()%>">
								<button type="submit" class="btn btn-success btn-md"
								style="position: relative; left: 10px; top: 10px;">
									<span class="glyphicon glyphicon-ok"></span> Acquista
								</button>
							</form>
							<%} else {%>
							
							<br> <span class="my_span">Effettua L'accesso per iniziare ad acquistare</span>
							<%} %>
						</div>
					</div>
					<div class="panel-footer">
						<form action="RemoveToCart" method="post">
							<input type="hidden" name = "code" value = "<%=p.getCodice() %>">
     						 <label style="position: relative; left: 10px; top: 10px;">Quantità:</label>
							<input style="position: relative; left: 10px; top: 10px;" type="number" name="quantità" value="1" min="1" max="<%= x.getQuantita() %>" step="1">
							
							<button type="submit" class="btn btn-success btn-md"
								style="position: relative; left: 10px; top: 10px;">
								<span class="glyphicon glyphicon glyphicon-remove"></span> Rimuovi dal Carrello</button>
						</form>
					</div>
				</div>
			</div>


		</div>
		<%
			}}
		%>

	</div>

</body>
</html>