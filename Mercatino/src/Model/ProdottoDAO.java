package Model;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ProdottoDAO 
{
	final String DB_URL_with_SSL = "jdbc:mysql://localhost:3306/sellbuy?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	final String USER = "root";
	final String PASS = "Rompicapo98";

	public int doSave(Prodotto o) throws SQLException, IOException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		}

		catch (ClassNotFoundException e) {
			e.printStackTrace();

		}

		try (Connection conn = DriverManager.getConnection(DB_URL_with_SSL, USER, PASS)) {
			try (Statement stmt = conn.createStatement()) {
				int x;
				String query = "select cod_p from prodotto where cod_p like '" + o.getCodice() + "';";
				ResultSet rs = stmt.executeQuery(query);
				if (!rs.next()) {
					String query2 = "insert into prodotto(cod_p,nome,quantità,prezzo,descrizione,località,data_inserimento,stato,codice_venditore,nome_categoria,immagine) values ('"
							+ o.getCodice() + "','" + o.getNome() + "','" + o.getQuantità() + "','" + o.getPrezzo()
							+ "','" + o.getDescrizione() + "','" + o.getLocalità() + "','" + o.getData_ins() + "','"
							+ o.getStato() + "','" + o.getCod_venditore() + "','" + o.getCod_categoria() + "','"
							+ o.getImmagine() + "'" + ");";
					x = stmt.executeUpdate(query2);
					return x;
				}
				return 0;
			}
		}
	}

	public void doSaveOrUpdate(Prodotto o) throws SQLException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		}

		catch (ClassNotFoundException e) {
			e.printStackTrace();

		}

		try (Connection conn = DriverManager.getConnection(DB_URL_with_SSL, USER, PASS)) {
			try (Statement stmt = conn.createStatement()) {
				String query = "select cod_p from prodotto where cod_p like '" + o.getCodice() + "';";
				ResultSet rs = stmt.executeQuery(query);
				if (!rs.next()) {
					String query2 = "insert into prodotto(cod_p,nome,quantità,prezzo,descrizione,località,data_inserimento,stato,codice_venditore,nome_categoria,immagine) values ('"
							+ o.getCodice() + "','" + o.getNome() + "','" + o.getQuantità() + "','" + o.getPrezzo()
							+ "','" + o.getDescrizione() + "','" + o.getLocalità() + "','" + o.getData_ins() + "','"
							+ o.getStato() + "','" + o.getCod_venditore() + "','" + o.getCod_categoria() + "','"
							+ o.getImmagine() + "'" + ");";
					stmt.executeUpdate(query2);
				}

				else {
					String query2 = "update prodotto set quantità='" + o.getQuantità() + "', nome = '" + o.getNome()
							+ "', prezzo='" + o.getPrezzo() + "', descrizione='" + o.getDescrizione() + "', località='"
							+ o.getLocalità() + "', data_inserimento='" + o.getData_ins() + "', stato='" + o.getStato()
							+ "', codice_venditore='" + o.getCod_venditore() + "' , nome_categoria='" + o.getCod_categoria()
							+ "' , immagine='"+o.getImmagine()+"', acquistato='"+o.getAcquistato()+"' where cod_p='" + o.getCodice() + "';";
					stmt.executeUpdate(query2);
				}
			}
		}
	}

	public void doDelete(Prodotto o) throws SQLException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		}

		catch (ClassNotFoundException e) {
			e.printStackTrace();

		}

		try (Connection conn = DriverManager.getConnection(DB_URL_with_SSL, USER, PASS)) {
			try (Statement stmt = conn.createStatement()) {
				String query = "delete from prodotto where cod_p like '" + o.getCodice() + "';";
				stmt.executeUpdate(query);
			}
		}
	}

	public Prodotto doRetriveByKey(String key) throws SQLException, IOException 
	{

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		}

		catch (ClassNotFoundException e) {
			e.printStackTrace();

		}

		try (Connection conn = DriverManager.getConnection(DB_URL_with_SSL, USER, PASS)) {
			try (Statement stmt = conn.createStatement()) {
				String query = "select * from prodotto where cod_p like'" + key + "';";
				ResultSet rs = stmt.executeQuery(query);
				if (rs.next()) {
					String q = rs.getString("quantità");
					String nome = rs.getString("nome");
					int quantità = Integer.parseInt(q);
					String p = rs.getString("prezzo");
					double prezzo = Double.parseDouble(p);
					String descrizione = rs.getString("descrizione");
					String località = rs.getString("località");
					String data_ins = rs.getString("data_inserimento");
					String stato = rs.getString("stato");
					String codice_venditore = rs.getString("codice_venditore");
					String codice_categoria = rs.getString("nome_categoria");
					String x = rs.getString("immagine");
					String acquistato=rs.getString("acquistato");
					int acq=Integer.parseInt(acquistato);
					return new Prodotto(nome, key, quantità, prezzo, descrizione, località, data_ins, stato,
							codice_venditore, codice_categoria, x,acq);
				}

				else
					return null;
			}

			catch (SQLException e) {
				e.printStackTrace();
				return null;
			}
		}

	
}

	public ArrayList<Prodotto> doRetriveByCond(String cond) throws SQLException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try (Connection conn = DriverManager.getConnection(DB_URL_with_SSL, USER, PASS)) {
			try (Statement stmt = conn.createStatement()) {
				String query = "select * from prodotto where " + cond + ";";
				ResultSet rs = stmt.executeQuery(query);
				ArrayList<Prodotto> list = new ArrayList<Prodotto>();
				while (rs.next()) {
					String codice = rs.getString("cod_p");
					String q = rs.getString("quantità");
					String nome = rs.getString("nome");
					int quantità = Integer.parseInt(q);
					String p = rs.getString("prezzo");
					double prezzo = Double.parseDouble(p);
					String descrizione = rs.getString("descrizione");
					String località = rs.getString("località");
					String data_ins = rs.getString("data_inserimento");
					String stato = rs.getString("stato");
					String codice_venditore = rs.getString("codice_venditore");
					String codice_categoria = rs.getString("nome_categoria");
					String x = rs.getString("immagine");
					String acquistato=rs.getString("acquistato");
					int acq=Integer.parseInt(acquistato);
					list.add(new Prodotto(nome, codice, quantità, prezzo, descrizione, località, data_ins, stato,
							codice_venditore, codice_categoria, x,acq));
				}

				return list;
			} catch (SQLException e) {
				e.printStackTrace();
				return null;
			}
		}
	}

 public ArrayList<Prodotto> doRetriveByAll() throws SQLException
 { 
	 try 
	 {
		 Class.forName("com.mysql.cj.jdbc.Driver"); 
	 } 
	 catch (ClassNotFoundException e)
	 { 
		 e.printStackTrace(); 
	 }
	 
	 try 
	 (Connection conn =DriverManager.getConnection(DB_URL_with_SSL, USER, PASS)) 
	 { 
		 try (Statement stmt = conn.createStatement()) 
		 { 
			 String query = "select * from prodotto";
			 ResultSet rs = stmt.executeQuery(query); 
			 ArrayList <Prodotto> list=new ArrayList<Prodotto>(); 
			 while (rs.next()) 
			 { 
				 String nome=rs.getString("nome");
				 String q=rs.getString("quantità");
				 int quantità=Integer.parseInt(q); 
				 String p=rs.getString("prezzo"); 
				 double prezzo=Double.parseDouble(p); 
				 String descrizione=rs.getString("descrizione");
				 String località=rs.getString("località"); 
				 String data_ins=rs.getString("data_inserimento"); 
				 String stato=rs.getString("stato"); 
				 String codice_venditore=rs.getString("codice_venditore"); 
				 String codice_categoria=rs.getString("nome_categoria"); 
				 String codice=rs.getString("cod_p"); 
				 String immagine=rs.getString("immagine");
				 String acquistato=rs.getString("acquistato");
					int acq=Integer.parseInt(acquistato);
				 list.add(new Prodotto(nome,codice,quantità,prezzo,descrizione,località,data_ins,stato,codice_venditore,codice_categoria,immagine,acq)); 
			}
  
		return list; 
		 } 
		 catch (SQLException e) 
		 { 
			 e.printStackTrace(); return null;
		 }
	} 
}
 
}


