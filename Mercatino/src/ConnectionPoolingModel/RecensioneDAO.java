package Model;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class RecensioneDAO {
	

	public int doSave(Recensione o) throws SQLException, IOException {
		

		try (Connection conn = ConnectionPool.getConnection()) {
			try (Statement stmt = conn.createStatement()) {
				int x;
				String query = "select codice from recensioni where codice like '" + o.getCodice() + "';";
				ResultSet rs = stmt.executeQuery(query);
				if (!rs.next()) {
					String query2 = "insert into recensioni (codice, codice_p, utente, testo, voto) values('"
							+ o.getCodice() + "','" + o.getProdotto() + "','" + o.getUtente() + "','" + o.getText()
							+ "'," + o.getVoto() + ");";
					x = stmt.executeUpdate(query2);
					return x;
				}
				return 0;
			}
		}
	}

	public int doSaveOrUpdate(Recensione o) throws SQLException {
		

		try (Connection conn = ConnectionPool.getConnection()) {
			try (Statement stmt = conn.createStatement()) {
				int x;
				String query = "select codice from recensioni where codice like '" + o.getCodice() + "';";
				ResultSet rs = stmt.executeQuery(query);
				if (!rs.next()) {
					String query2 = "insert into recensioni (codice, codice_p, utente, testo, voto) values('"
							+ o.getCodice() + "','" + o.getProdotto() + "','" + o.getUtente() + "','" + o.getText()
							+ "'," + o.getVoto() + ");";
					x = stmt.executeUpdate(query2);
					return x;
				} else {
					String query2 = "update recensione set codice_p='" + o.getProdotto() + "', utente = '" + o.getUtente()
							+ "', testo='" + o.getText() + "', voto='" + o.getVoto() + "' where codice like '" +o.getCodice()+ "';";
					x = stmt.executeUpdate(query2);
					return x;
				}

			}
		}
	}

	public void doDelete(Recensione o) throws SQLException {
		

		try (Connection conn = ConnectionPool.getConnection()) {
			try (Statement stmt = conn.createStatement()) {
				
				String query = "delete from recensioni where codice = '" + o.getCodice() + "';";
				stmt.executeUpdate(query);
			}
		}
	}

	public Recensione doRetriveByKey(String key) throws SQLException, IOException {


		try (Connection conn = ConnectionPool.getConnection()) {
			try (Statement stmt = conn.createStatement()) {
				String query = "select * from recensioni where cod_p like'" + key + "';";
				ResultSet rs = stmt.executeQuery(query);
				if (rs.next()) {
					String codice = rs.getString("codice");
					String prodotto = rs.getString("codice_p");
					String utente = rs.getString("utente");
					String text = rs.getString("testo");
					int voto = rs.getInt("voto");
					return new Recensione(codice, prodotto, utente, text, voto);
				}

				else
					System.out.println("sono qui");
				return null;
			}

			catch (SQLException e) {
				e.printStackTrace();
				return null;
			}
		}

	}

	public ArrayList<Recensione> doRetriveByCond(String cond) throws SQLException {
		
		try (Connection conn = ConnectionPool.getConnection()) {
			try (Statement stmt = conn.createStatement()) {
				String query = "select * from recensioni where " + cond + ";";
				ResultSet rs = stmt.executeQuery(query);
				ArrayList<Recensione> list = new ArrayList<Recensione>();
				while (rs.next()) {
					String codice = rs.getString("codice");
					String prodotto = rs.getString("codice_p");
					String utente = rs.getString("utente");
					String text = rs.getString("testo");
					int voto = rs.getInt("voto");
					list.add( new Recensione(codice, prodotto, utente, text, voto));
				}

				return list;
			} catch (SQLException e) {
				e.printStackTrace();
				return null;
			}
		}
	}

	public ArrayList<Recensione> doRetriveByAll() throws SQLException {
		
		try (Connection conn = ConnectionPool.getConnection()) {

			try (Statement stmt = conn.createStatement()) {

				String query = "select * from recensioni";
				ResultSet rs = stmt.executeQuery(query);
				ArrayList<Recensione> list = new ArrayList<Recensione>();
				while (rs.next()) {
					String codice = rs.getString("codice");
					String prodotto = rs.getString("codice_p");
					String utente = rs.getString("utente");
					String text = rs.getString("testo");
					int voto = rs.getInt("voto");
					list.add( new Recensione(codice, prodotto, utente, text, voto));
				}

				return list;
			} catch (SQLException e) {
				e.printStackTrace();
				return null;
			}
		}
	}
}
