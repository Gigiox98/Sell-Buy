Carmine Unisa, [24.04.19 13:02]
<%@ page import="java.util.*,Model.*" language="java"
  contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<html lang="en">
<head>
<title>Dettagli</title>
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
    String j = p.getImmagine();
    
    UtenteDAO du = new UtenteDAO();
    Utente venditore = du.doRetriveByKey(p.getCod_venditore());
    
  %>
  <div class="container-fluid fixed-top">
    <div class="btn-group btn-group-justified" style="margin-left: 0%;">
      <a class="btn btn-success" href="HomePage2.jsp">Home</a>
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
            <li><a href="#" class="navbar-item"
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
      </nav>
    </div>




    <br> <br>
    <div class="container">
      <h1 class="header">Prodotto <%=p.getCodice()%></h1>
      <div class="row">
        

        <div class="col-sm-12">
          <div class="panel panel-primary">
            <div class="panel-heading"><%=p.getNome()%></div>
            <div class="panel-body">
              <div class="col-sm-4">
                <img src="data:image/jpg;base64,<%=j%>" class="img-responsive" style="width: 100%; height: 40%;" alt="Image">
              </div>
              <div class = "col-sm-8">
                <span class="my_span">Categoria: <%=p.getCod_categoria() %></span><br>
                <span class="my_span">Descrizione: <%=p.getDescrizione() %></span><br>
                <span class="my_span">Prezzo: <%=p.getPrezzo() %> &euro;</span><br>
                <span class="my_span">Località: <%=p.getLocalità() %></span><br>
                <span class="my_span">Stato Prodotto: <%=p.getStato() %></span><br>
                <span class="my_span">Data Inserimento: <%=p.getData_ins() %></span><br>
                <span  class="my_span">Venditore: <%= venditore.getUsername()%></span><br>
                <br><br><br><br>
              <%if(username!=null){ %> 
                <%if(p.getQuantità() > 0){ %> 
                  <form action="AddToCart" method="post">
                  <input type="hidden" name="code" value="<%=p.getCodice()%>">
                  <span class = "my_span">Quantità:</span>
                  <input type="number" name="quantita" min="1" max="<%= p.getQuantità() %>" step="1">
                  <button class="btn btn-primary"><span class="glyphicon glyphicon-shopping-cart"></span>Aggiungi al carrello</button>
                  </form>
                <%} else{ %>
                  <span class="my_span">Prodotto non disponibile</span>
                <%}
                
              } else {%>
                <span class="my_span">Accedi/Registrati per cominciare ad acquistare</span>
              <%}%>
              </div>
            </div>
            <div class="panel-footer">
            
            
            </div>
          </div>
        </div>
      </div>
    </div>
</div>

    <footer class="container-fluid text-center">
      <p>Footer Text</p>
    </footer>
</body>
</html>