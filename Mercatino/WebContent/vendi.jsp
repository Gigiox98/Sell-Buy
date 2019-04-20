<%@ page import ="java.util.ArrayList, Model.*" language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE HTML>
<html>
<head>

<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>

<title>Sell Buy-Form Vendita</title>
</head>
<body>

	<h1 align="CENTER">Form Vendita</h1>
<form action="Vendi" method="post" enctype="multipart/form-data">
	<div class= "container">
		<h3> Inserisci i dati per la vendita del tuo prodotto</h3>
		
		<div class="form-group">
		<label for="categoria">Categoria:</label>
		<select name="categoria">
		<%
		 	CategoriaDAO categoria=new CategoriaDAO();
			ArrayList<Categoria> list=categoria.doRetriveAll();

			for(int i = 0; i < list.size(); i++)
			{
				out.print("<option value=\""+list.get(i).getNome()+"\">"+list.get(i).getNome()+"</option>");
			}
		%>
		</select>
		</div>
		<div class="form-group">
     	 <label for="nome">Nome Prodotto:</label>
      	 <input type="text" class="form-control" name="nome">
   		</div>
   		
   		<div class="form-group">
     	 <label for="prezzo">Prezzo:</label>
      	 <input type="text" class="form-control" name="prezzo">
   		</div>
   		
   		<div class="form-group">
     	 <label for="quantità">Quantità:</label>
      	 <input type="number" class="form-control" name="quantità">
   		</div>
   		
   		<div class="form-group">
     	 <label for="località">Località:</label>
      	 <input type="text" class="form-control" name="località">
   		</div>
   		
   		<div class="form-group">
		<label for="categoria">Stato:</label>
   		<select name="stato">
   			<option value="Usato">Usato</option>
   			<option value="Nuovo">Nuovo</option>
   		</select>
   		</div>
   		
   		<div class="form-group">
     	 <label for="descrizione">Descrizione:</label>
      	 <input type="text" class="form-control" name="descrizione">
   		</div>
   		
   		<div class="form-group">
     	 <label for="image">Immagine:</label>
      	 <input type="file" class="form-control" name="image">
   		</div>
   
   		<div class="form-group">
   		<input type="submit" value="Inserisci">
   		</div>
   		
	</div>
</form>
</html>


