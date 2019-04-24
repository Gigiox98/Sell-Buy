<%@ page import="Model.*,java.util.*" language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ricerca avanzata</title>
</head>
<body>
<div class="container">
	<form action="Filtro2" method="get">
	<div class="row">
	<h4>Stato:</h4>
	<input type="checkbox" name="usato" value="usato" checked> Usato<br>
  	<input type="checkbox" name="nuovo" value="nuovo"> Nuovo<br>
 	</div>
 	
 	<div class="row">
	<h4>Nome Prodotto</h4>
	<input type="text" name="nome"><br>
	<h4>Prezzo</h4>
  	<input type="number" name="prezzo"><br>
 	</div>
 	
 	<div class="row">
 	<h4>Categoria:</h4>
 	<select name="categoria">
 		<option value="">Nessuna Categoria</option>
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
 	
 	<div class="row">
	<h4>Localita:</h4>
	<input type="text" name="località"><br>
	</div>
 	
  	<input type="submit" value="Ricerca">
	</form>
</div>
</body>
</html>