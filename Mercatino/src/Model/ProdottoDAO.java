package Model;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ProdottoDAO {

	public int doSave(Prodotto o) throws SQLException, IOException {
		
		try (Connection conn = ConnectionPool.getConnection()) {
			try (Statement stmt = conn.createStatement()) {
				int x;
				String query = "select cod_p from prodotto where cod_p like '" + o.getCodice() + "';";
				ResultSet rs = stmt.executeQuery(query);
				if (!rs.next()) {
					String query2 = "insert into prodotto(cod_p,nome,quantit�,prezzo,descrizione,localit�,data_inserimento,stato,codice_venditore,categoria,immagine) values ('"
							+ o.getCodice() + "','" + o.getNome() + "','" + o.getQuantit�() + "','" + o.getPrezzo()
							+ "','" + o.getDescrizione() + "','" + o.getLocalit�() + "','" + o.getData_ins() + "','"
							+ o.getStato() + "','" + o.getCod_venditore() + "','" + o.getCod_categoria() + "','"
							+ o.getImmagine() + "'" + ");";
					x = stmt.executeUpdate(query2);
					return x;
				}
				return 0;
			}
		}
	}

	public int doSaveOrUpdate(Prodotto o) throws SQLException {
		
		try (Connection conn = ConnectionPool.getConnection()) {
			try (Statement stmt = conn.createStatement()) {
				String query = "select cod_p from prodotto where cod_p like '" + o.getCodice() + "';";
				ResultSet rs = stmt.executeQuery(query);
				
				int x;
				if (!rs.next()) {
					String query2 = "insert into prodotto(cod_p,nome,quantit�,prezzo,descrizione,localit�,data_inserimento,stato,codice_venditore,categoria,immagine) values ('"
							+ o.getCodice() + "','" + o.getNome() + "','" + o.getQuantit�() + "','" + o.getPrezzo()
							+ "','" + o.getDescrizione() + "','" + o.getLocalit�() + "','" + o.getData_ins() + "','"
							+ o.getStato() + "','" + o.getCod_venditore() + "','" + o.getCod_categoria() + "','"
							+ o.getImmagine() + "'" + ");";
					x = stmt.executeUpdate(query2);
					return x;
				}

				else {
					String query2 = "update prodotto set quantit�='" + o.getQuantit�() + "', nome = '" + o.getNome()
							+ "', prezzo='" + o.getPrezzo() + "', descrizione='" + o.getDescrizione() + "', localit�='"
							+ o.getLocalit�() + "', data_inserimento='" + o.getData_ins() + "', stato='" + o.getStato()
							+ "', codice_venditore='" + o.getCod_venditore() + "' , categoria='"
							+ o.getCod_categoria() + "' , immagine='" + o.getImmagine() + "', acquistato='"
							+ o.getAcquistato()+ "', flag_sconto = "+o.isFlag_sconto()+" where cod_p='" + o.getCodice() + "';";
					x = stmt.executeUpdate(query2);
					return x;
				}
			}
		}
	}

	public void doDelete(Prodotto o) throws SQLException {
		
		try (Connection conn = ConnectionPool.getConnection()) {
			try (Statement stmt = conn.createStatement()) {
				String query = "delete from prodotto where cod_p like '" + o.getCodice() + "';";
				stmt.executeUpdate(query);
			}
		}
	}

	public Prodotto doRetriveByKey(String key) throws SQLException, IOException {


		try (Connection conn = ConnectionPool.getConnection()) {
			try (Statement stmt = conn.createStatement()) {
				String query = "select * from prodotto where cod_p like'" + key + "';";
				ResultSet rs = stmt.executeQuery(query);
				if (rs.next()) {
					String q = rs.getString("quantit�");
					String nome = rs.getString("nome");
					int quantit� = Integer.parseInt(q);
					String p = rs.getString("prezzo");
					double prezzo = Double.parseDouble(p);
					String descrizione = rs.getString("descrizione");
					String localit� = rs.getString("localit�");
					String data_ins = rs.getString("data_inserimento");
					String stato = rs.getString("stato");
					String codice_venditore = rs.getString("codice_venditore");
					String codice_categoria = rs.getString("categoria");
					String x = rs.getString("immagine");
					String acquistato = rs.getString("acquistato");
					int acq = Integer.parseInt(acquistato);
					boolean flag_sconto = rs.getBoolean("flag_sconto");
					return new Prodotto(key, nome, quantit�, prezzo, descrizione, localit�, data_ins, stato,
							codice_venditore, codice_categoria, x, acq, flag_sconto);
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
		
		try (Connection conn = ConnectionPool.getConnection()) {
			try (Statement stmt = conn.createStatement()) {
				String query = "select * from prodotto where " + cond + ";";
				ResultSet rs = stmt.executeQuery(query);
				ArrayList<Prodotto> list = new ArrayList<Prodotto>();
				while (rs.next()) {
					String codice = rs.getString("cod_p");
					String q = rs.getString("quantit�");
					String nome = rs.getString("nome");
					int quantit� = Integer.parseInt(q);
					String p = rs.getString("prezzo");
					double prezzo = Double.parseDouble(p);
					String descrizione = rs.getString("descrizione");
					String localit� = rs.getString("localit�");
					String data_ins = rs.getString("data_inserimento");
					String stato = rs.getString("stato");
					String codice_venditore = rs.getString("codice_venditore");
					String codice_categoria = rs.getString("categoria");
					String x = rs.getString("immagine");
					String acquistato = rs.getString("acquistato");
					int acq = Integer.parseInt(acquistato);
					boolean flag_sconto = rs.getBoolean("flag_sconto");
					list.add(new Prodotto(codice, nome, quantit�, prezzo, descrizione, localit�, data_ins, stato,
							codice_venditore, codice_categoria, x, acq, flag_sconto));
				}

				return list;
			} catch (SQLException e) {
				e.printStackTrace();
				return null;
			}
		}
	}

	public ArrayList<Prodotto> doRetriveByAll() throws SQLException {
		
		try (Connection conn = ConnectionPool.getConnection()) {
			try (Statement stmt = conn.createStatement()) {
				String query = "select * from prodotto";
				ResultSet rs = stmt.executeQuery(query);
				ArrayList<Prodotto> list = new ArrayList<Prodotto>();
				while (rs.next()) {
					String nome = rs.getString("nome");
					String q = rs.getString("quantit�");
					int quantit� = Integer.parseInt(q);
					String p = rs.getString("prezzo");
					double prezzo = Double.parseDouble(p);
					String descrizione = rs.getString("descrizione");
					String localit� = rs.getString("localit�");
					String data_ins = rs.getString("data_inserimento");
					String stato = rs.getString("stato");
					String codice_venditore = rs.getString("codice_venditore");
					String codice_categoria = rs.getString("categoria");
					String codice = rs.getString("cod_p");
					String immagine = rs.getString("immagine");
					String acquistato = rs.getString("acquistato");
					int acq = Integer.parseInt(acquistato);
					boolean flag_sconto = rs.getBoolean("flag_sconto");
					list.add(new Prodotto(codice, nome, quantit�, prezzo, descrizione, localit�, data_ins, stato,
							codice_venditore, codice_categoria, immagine, acq, flag_sconto));
				}

				return list;
			} catch (SQLException e) {
				e.printStackTrace();
				return null;
			}
		}
	}
}
