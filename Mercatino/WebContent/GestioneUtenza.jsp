<%@ page import="java.util.*,Model.*" language="java"
	contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<html lang="en">
<head>
<title>Gestione Utenza</title>
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
	margin:0% 24%;
}

.mycontainer{
	background-color: white;
	
	margin:0% 24%;
	
	border-top: 2px solid blue;
	border-left: 2px solid blue;
	border-right: 2px solid blue;
}

.mycontainer:last-child {
	border-bottom: 2px solid blue;
} 

.myline1{
	padding: 2%;
	border-right: 2px solid blue;
	text-align: center;
}


.my_span {
	font-family: helvetica;
	margin-left: 10px;
	font-size: 18px;
	color: #337ab7;
	transition: color 0.3s;
}

.my_span:hover{
	color: #071342;
	transition: color 0.3s;
}
</style>
</head>
<body>

	<%
	ArrayList<Utente> users = (ArrayList<Utente>) request.getAttribute("users");
	%>
	<div class="container-fluid fixed-top">
		<div class="btn-group btn-group-justified" style="margin-left: 0%;">
			<a class="btn btn-success" href="Starter">Home</a> <a
				class="btn btn-success" href="vendi.jsp">Vendi</a> <a
				class="btn btn-success" href="Storico.jsp">Storico</a> <a
				class="btn btn-success" href="Logout">Log-out</a>
				
				<div class="btn-group">
    			<button type="button" class="btn btn-success dropdown-toggle" data-toggle="dropdown">
    			 <span class="glyphicon glyphicon-align-justify"></span> Funzioni Admin</button>
    			 
			    <ul class="dropdown-menu" role="menu">
			      <li><a href="#">Gestione prodotti più venduti</a></li>
			      <li><a href="#">Gestione prodotti meno venduti</a></li>
			    </ul>
 			 </div>
		</div>
		<br>
		
		<h1 class="header">Gestione Utenza</h1>
		<br><br>
		
				<%
					for (Utente x : users){
						
				%>
				<div class="row mycontainer" >
				
				<div class="col-sm-4 myline1">
			
							<span class="my_span"><%=x.getUsername()%></span>

							
					</div>
					<div class = "col-sm-8 myline2">
						<div class="btn-group" style="margin-top: 2%;">
							<a class="btn btn-success btn-md" href="dettagliUser.jsp?user=<%=x.getUsername()%>">
							<span class="glyphicon  glyphicon-list-alt"></span> Visualizza Dettagli</a>
							<%if (x.getAdmin_flag() == 0){%>	
								<a href="NominaAdmin?user=<%=x.getUsername()%>" class="btn btn-md btn-success"> <span class="glyphicon glyphicon glyphicon-user"></span> Nomina Admin</a>
							<%}else{ %>
							 <a href="NominaAdmin?user=<%=x.getUsername()%>" class="btn btn-md btn-success"> <span class="glyphicon glyphicon glyphicon-user"></span> Rimuovi Admin</a>
							<%} %>
							<a href="DropUser?user=<%=x.getUsername()%>" class="btn btn-md btn-success"> <span class="glyphicon glyphicon glyphicon-trash"></span> Elimina Utente</a>
						</div>
						
					</div>
				</div>	
				<%} %>
					
				
			</div>

</body>
</html>