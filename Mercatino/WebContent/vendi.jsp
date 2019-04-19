<%@ page import = "java.util.ArrayList, Model.*" language="java" contentType="text/html; charset=ISO-8859-1"
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
	<div class= "container">
	<form action="Vendi" method="post">
		<h3> Inserisci i dati per la vendita del tuo prodotto</h3>
		<div class="row">
		<label  class= "col-sm-1 " for="categoria"> Categoria: </label> 
		
		<select name = "categoria" class="col-sm-4"> 
		<%
		 	CategoriaDAO categoria=new CategoriaDAO();
			ArrayList<Categoria> list=categoria.doRetriveAll();

			for(int i = 0; i < list.size(); i++)
			{
				out.print("<option value=\""+list.get(i).getNome()+"\">"+list.get(i).getNome()+"</option>");
			}
		%>
		</select>
		
		<br /> <br />
		
		<label  class= "col-sm-1" for="nome">Nome:</label> <input class= "col-sm-4"  type="text"  class="form-control" name = "nome"> <br /> <br />
		<label	class= "col-sm-1" for="quantità">Quantità:</label>  <input class= "col-sm-4"  type="text"  class="form-control" name = "quantità"> <br /> <br />
		<label  class= "col-sm-1" for="prezzo">Prezzo:</label> <input class= "col-sm-4"  type="text" class="form-control" name ="prezzo"> <br /> <br />
		<label  class= "col-sm-1" for="descrizione">Descrizione:</label> <input class= "col-sm-4"  type="text"  class="form-control" name = "descrizione"> <br /> <br />
		<label  class= "col-sm-1"for="località">Località:</label><input class= "col-sm-4" type="text" class="form-control" name = "località"> <br /> <br />
		<label  class= "col-sm-1" for="stato">Stato:</label> <input class= "col-sm-4"  type="text"  class="form-control" name = "stato"> <br /> <br />
		<label  class= "col-sm-1"for="immagine">Immagine:</label><input class= "col-sm-4" type="file" class="form-control" name = "immagine"> <br /> <br />
		
		<input class= "btn btn-success" type = "submit" value = "Inserisci">
		</div>
	</form>
	</div>
</body>
</html>


