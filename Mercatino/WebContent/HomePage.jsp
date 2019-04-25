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

body
{
	background-image:url("Immagini/sfondo.jpg");
	backgroung-repeat:no-repeat;
}

.navbar {
      margin-bottom: 50px;
      border-radius: 0;
    }
    
    /* Remove the jumbotron's default bottom margin */ 
     .jumbotron {
      margin-bottom: 0;
    }
   
    /* Add a gray background color and some padding to the footer */
    footer {
      background-color: #f2f2f2;
      padding: 25px;
    }
}
</style>
</head>
<body>

	<%
		String username = (String) session.getAttribute("username");
	%>
	
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
  <div class="row"  style="padding: 0;">
		<div class="col-sm-12" style="padding: 0;">
		<img src="Immagini/HomeTop.PNG" class="img img-responsive" style="width:100%; margin:none;">
		</div>
		</div>
	
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>                        
      </button>
      <a class="navbar-brand" href="#">Logo</a>
    </div>
    <div class="collapse navbar-collapse" id="myNavbar">
      <ul class="nav navbar-nav">
        <li><a href="HomePage.jsp">Home</a></li>
        <li><a href="About.html">About-us</a></li>
        <%
			if (username == null) {
		%>
					<li><a href="login.jsp">Login</a></li>
					<li><a href="Registration.html">Registrazione</a></li>
					<% 
						} else {
					%>
					 <li><a href="vendi.jsp">Vendi</a></li>
        			 <li><a href="storico.jsp">Storico</a></li>
					 <li><a href="Logout">Log-out</a></li>
					 </ul>
					 <ul class="nav navbar-nav navbar-right">
					  <li><a>Benvenuto <%=username%></a></li>
        			<li><a href="#"><span class="glyphicon glyphicon-user"></span> Your Account</a></li>
       				 <li><a href="#"><span class="glyphicon glyphicon-shopping-cart"></span> Cart</a></li>
       				 <li><a href="#"><span class="glyphicon glyphicon-align-justify"></span></a></li>
      				</ul>
      		<%}%> 
      	
    </div>
  </div>
</nav> 
	<%
		ProdottoDAO p=new ProdottoDAO();
		Prodotto x=p.doRetriveByKey("9562923454");
		String j=x.getImmagine();
	%>
	
	<div class="container">  
	<h1 align="center" style="color:lightblue"> USATO </h1>  
  <div class="row">
    <div class="col-sm-4">
      <div class="panel panel-primary">
        <div class="panel-heading">BLACK FRIDAY DEAL</div>
        <div class="panel-body"><img src="data:image/jpg;base64,<%=j %>" class="img-responsive" style="width:100%" alt="Image"></div>
        <div class="panel-footer">Buy 50 mobiles and get a gift card</div>
      </div>
    </div>
    <div class="col-sm-4"> 
      <div class="panel panel-danger">
        <div class="panel-heading">BLACK FRIDAY DEAL</div>
        <div class="panel-body"><img src="data:image/jpg;base64,<%=j %>" class="img-responsive" style="width:100%" alt="Image"></div>
        <div class="panel-footer">Buy 50 mobiles and get a gift card</div>
      </div>
    </div>
    <div class="col-sm-4"> 
      <div class="panel panel-success">
        <div class="panel-heading">BLACK FRIDAY DEAL</div>
        <div class="panel-body"><img src="data:image/jpg;base64,<%=j %>" class="img-responsive" style="width:100%" alt="Image"></div>
        <div class="panel-footer">Buy 50 mobiles and get a gift card</div>
      </div>
    </div>
  </div>
</div><br>

<div class="container">    
  <div class="row">
  <h1 align="center" style="color:lightblue"> NUOVO </h1>
    <div class="col-sm-4">
      <div class="panel panel-primary">
        <div class="panel-heading">BLACK FRIDAY DEAL</div>
        <div class="panel-body"><img src="data:image/jpg;base64,<%=j %>"  class="img-responsive" style="width:100%" alt="Image"></div>
        <div class="panel-footer">Buy 50 mobiles and get a gift card</div>
      </div>
    </div>
    <div class="col-sm-4"> 
      <div class="panel panel-primary">
        <div class="panel-heading">BLACK FRIDAY DEAL</div>
        <div class="panel-body"><img src="data:image/jpg;base64,<%=j %>"  class="img-responsive" style="width:100%" alt="Image"></div>
        <div class="panel-footer">Buy 50 mobiles and get a gift card</div>
      </div>
    </div>
    <div class="col-sm-4"> 
      <div class="panel panel-primary">
        <div class="panel-heading">BLACK FRIDAY DEAL</div>
        <div class="panel-body"><img src="data:image/jpg;base64,<%=j %>" class="img-responsive" style="width:100%" alt="Image"></div>
        <div class="panel-footer">Buy 50 mobiles and get a gift card</div>
      </div>
    </div>
  </div>
</div>
<br><br>

	<footer class="container-fluid text-center">
		<p>Footer Text</p>
	</footer>
</body>
</html>