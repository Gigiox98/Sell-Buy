<%@ page import="java.util.*,Model.*" language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<html lang="en">
<head>
<title>Registration</title>
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
	<div class="container-fluid fixed-top">
		<div class="btn-group btn-group-justified" style="margin-left: 0%;">
			<a class="btn btn-success" href="Starter">Home</a> <a
				class="btn btn-success" href="login.jsp"><span
				class="glyphicon glyphicon-log-in"></span> Login</a> <a
				class="btn btn-success active" href="Registration.html">Registazione</a> <a
				class="btn btn-success" href="#">About-us</a>
		</div>
		<div class="col-sm-5" style="background-color:white; border-radius:10px; margin:20px; border: 3px solid #337ab7">
			<%
				String BadFormatData =(String) request.getAttribute("BadFormatData");
				
				if(BadFormatData != null && BadFormatData.equals("true")){
			%> <script>  alert("Il server comunica incongruenze nei dati"); </script><%} %>
			
			<%
				String existingUser =(String) request.getAttribute("existingUser");
				
				if(existingUser != null && existingUser.equals("true")){
			%> <script>  alert("Il server comunica che lo username è già utilizzato"); </script><%} %>
			
			<h1 align="CENTER">Registrazione Utente</h1>
			<div class="container" >
				<form action="registration" method="get" onsubmit="return validateForm()"  name="regForm">
					<h3>Inserisci i dati per la registrazione</h3>
					<div class="row">
						<h4>Dati Anagrafici</h4>
						<label class="col-sm-1" for="Nome"> Nome: </label> 
						<input class="col-sm-4" type="text" class="form-control" name="nome">
						<br /> <br /> <label class="col-sm-1" for="Cognome">Cognome:</label>
						<input class="col-sm-4" type="text" class="form-control" name="cognome"> <br /> <br />
						<label class="col-sm-1" for="Username">Username:</label> 
						<input class="col-sm-4" type="text" class="form-control" name="username"> <br />
						<br /> <label class="col-sm-1" for="password">Password:</label> 
						<input class="col-sm-4" type="password" class="form-control" name="password"> 
						
						<br /> <br />
					</div>
					<div class="row">
						<h4>Dati Contatto</h4>
						<label class="col-sm-1" for="Mail">E-Mail:</label> <input
							class="col-sm-4" type="text" class="form-control" name="email">
						<br /> <br />
					</div>
					<div class="row">

						<h4>Dati Residenza</h4>

						<label class="col-sm-1" for="Via">Via:</label><input
							class="col-sm-4" type="text" class="form-control" name="via">
						<br /> <br /> <label class="col-sm-1" for="Civico">Civico:</label><input
							class="col-sm-4" type="text" class="form-control" name="civico">
						<br /> <br /> <label class="col-sm-1" for="Città">Città :</label><input
							class="col-sm-4" type="text" class="form-control" name="citta">
						<br /> <br /> <input class="btn btn-success" type="submit"
							name="Registra" value="Registra">
					</div>
				</form>
			</div>
			<script>
			function validateForm() {
				var name = document.forms["regForm"]["nome"].value;
				var cognome = document.forms["regForm"]["cognome"].value;
				var username = document.forms["regForm"]["username"].value;
				var password = document.forms["regForm"]["password"].value;
				var email = document.forms["regForm"]["email"].value;
				var via = document.forms["regForm"]["via"].value;
				var civico = document.forms["regForm"]["civico"].value;
				var città  = document.forms["regForm"]["citta"].value;
				
				var nameLetters = /^[A-Za-z" "]{1,30}$/;
				var cognomeLetters = /^[A-Za-z" "]{1,30}$/;
				var usernameLetters = /^[A-Za-z0-9]{1,30}$/;
				var passwordFormat = /^[a-zA-Z0-9\_\*\-\+\!\?\,\:\;\.\&]{6,12}$/;
				
				
				var mailFormat = /^\w+([\._%-]?\w+)*@\w+([\.-]?\w+)*(\.\w+)+$/;
								
			
				if (name == "") alert("Il campo nome non può essere vuoto");
				else if(!(name.match(nameLetters))) alert("il nome deve avere solo caratteri alfabetici o spazi e non puÃ² superare i 30 caratteri");
				
				else if (cognome == "") alert("Il campo cognome non può essere vuoto");
				else if(!(cognome.match(cognomeLetters))) alert("il cognome deve avere solo caratteri alfabetici o spazi e non puÃ² superare i 30 caratteri");
				
				else if (username == "") alert("Il campo username non può essere vuoto");
				else if(!(username.match(usernameLetters))) alert("il username deve avere solo caratteri alfanumerici e non puÃ² superare i 30 caratteri");
				
				else if (password == "") alert("Il campo password non può essere vuoto");
				else if(!(password.match(passwordFormat)))alert("il campo password deve avere solo caratteri alfanumerici e almeno un caratter speciale tra _ * -  + ! ? , : ; . tra un minimo di 6 ad un massimo di 12 caratteri");
				else if(password.search(/[A-Z]/) < 0) alert("il campo password deve contenere almeno una lettera maiuscola");
				else if(password.search(/[0-9]/) < 0) alert("il campo password deve contenere almeno un numero");
				else if(password.search(/[\_\*\-\+\!\?\,\:\;\.\&]/) < 0) alert("il campo password deve contenere almeno un carattere speciale tra _ * - + ! ? , : ; .");
				
				else if (email == "") alert("Il campo email non può essere vuoto");
				else if (!(email.match(mailFormat)))alert("l'email non rispecchia un formato standard");
				
				else if (via == "") alert("Il campo via non può essere vuoto");
				else if (civico == "") alert("Il campo civico non può essere vuoto");
				else if (citta == "") alert("Il campo citta non può essere vuoto");
				
				else {
					return true;
				}
				
				return false;
					
			}
		</script>
</body>
</html>



