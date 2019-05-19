<%@ page import="java.util.*,Model.*" language="java"
	contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<html lang="en">
<head>
<title>Dettagli Utente</title>
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
	margin: 3% 24%;
}
.my_container{
	margin: 0% 24%;
	padding: 0px;
	max-width: 52%;
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
		String username = request.getParameter("user");
		UtenteDAO dao = new UtenteDAO();
		Utente x = dao.doRetriveByCond("username = '"+username+"'").get(0);		
	%>
	
	
	<div class="container-fluid fixed-top">
		<div class="btn-group btn-group-justified" style="margin-left: 0%;">
			<a class="btn btn-success" href="Starter">Home</a>
			<a class="btn btn-success" href="vendi.jsp">Vendi</a> <a
				class="btn btn-success" href="Storico.jsp">Storico</a> <a
				class="btn btn-success" href="Logout">Log-out</a>
			<a class="btn btn-success" href="GestioneUtenza">Gestione Utenza</a>
		</div>
		
		<h1 class="header">Dettagli Utente</h1>
		<div class="container my_container">
			<div class="row">


				<div class="col-sm-12">
					<div class="panel panel-primary">
						<div class="panel-heading">Utente <%=x.getUsername()%></div>
						<div class="panel-body">
								<span class="my_span">Nome: <%=x.getNome()%></span><br>
								<span class="my_span">Cognome: <%=x.getCognome()%></span><br>
								<span class="my_span">Indirizzo: <%=x.getVia()%> N. <%=x.getN_civico() %> <%=x.getCittà()%>
								</span><br> 
								
								<span class="my_span">Email: <%=x.getEmail()%></span><br>
								<%if(x.getAdmin_flag() == 1){%><span class="my_span">L'utente è amministratore</span>
								<%}else{ %><span class="my_span">L'utente non è amministratore</span><%} %>
					</div>
				</div>
			</div>
		</div>
			


</body>
</html>