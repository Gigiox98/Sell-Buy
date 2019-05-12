<%@ page import="java.util.*,Model.*" language="java"
 contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<html lang="en">
<head>
<title>Storico</title>
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
  OrdineDAO ordDAO = new OrdineDAO();
  ProdottoDAO prodDAO = new ProdottoDAO();
  ArrayList<Ordine> storico = ordDAO.doRetriveByCond("username_a = '" + username + "' AND stato = 'Acquistato'");
  if (storico == null)
   System.out.print("null Ord Array");
  String j = "";
 %>
 <div class="container-fluid fixed-top">
  <div class="btn-group btn-group-justified" style="margin-left: 0%;">
   <a class="btn btn-success" href="HomePage.jsp">Home</a> <a
    class="btn btn-success" href="vendi.jsp">Vendi</a> <a
    class="btn btn-success active" href="Storico.jsp">Storico</a> <a
    class="btn btn-success" href="Logout">Log-out</a> <a
    class="btn btn-success" href="#">About-us</a>
  </div>
  <br>
  <%
   for (Ordine x : storico)
   {
    Prodotto p = prodDAO.doRetriveByKey(x.getCodProd());
    j = p.getImmagine();
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
        <span class="my_span">Venditore: <%=p.getCod_venditore()%></span>
        <br>
        <span class="my_span">Quantità Acquistata: <%=x.getQuantitaArt()%></span>
    
        <br>
        <span class="my_span">Prezzo Unitario: <%=p.getPrezzo() %> &euro;</span>
        <br>
         <span class="my_span">Prezzo Totale: <%=x.getPrezzoAcquisto()%> &euro;</span>
         <br>
         
        <span class="my_span">Data di acquisto <%=x.getData() %></span>
      </div>
      <div class="col-sm-3">
      
       <form action="dettagli" method="post">
			<input type="hidden" name="code" value="<%=p.getCodice()%>">
			<input type="submit" class="btn btn-primary btn-md" value="Acquista di nuovo">
		</form>
      </div>
     </div>
    </div>
   </div>
  </div>
  <%
   }
  %>

 </div>

</body>
</html>