package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class OrdineDAO {
	public void doSave(Ordine ord) throws SQLException {
		try (Connection conn = ConnectionPool.getConnection()) {
			try (Statement stmt = conn.createStatement()) {
				String query = "select codice__ordine from ordine where codice_ordine like '" + ord.getCodice() + "';";
				ResultSet rs = stmt.executeQuery(query);
				if (!rs.next()) {
					String query2 = "insert into ordine(codice_ordine, indirizzo_spedizione,"
							+ "stato, quantita_articolo, prezzo_acquisto, pagamento, username_a, codice_prodotto, data) "
							+ "values ('" + ord.getCodice() + "','" + ord.getIndirizzoSped() + "','" + ord.getStato()
							+ "','" + ord.getQuantitaArt() + "','" + ord.getPrezzoAcquisto() + "','"
							+ ord.getPaganento() + "','" + ord.getAcquirente() + "','" + ord.getCodProd() + "', data = '"+ord.getData()+"');";
					stmt.executeUpdate(query2);
				}
			}

			catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public void doSaveOrUpdate(Ordine ord) throws SQLException {
		try (Connection conn = ConnectionPool.getConnection()) {
			try (Statement stmt = conn.createStatement()) {
				String query = "select codice_ordine from ordine where codice_ordine like '" + ord.getCodice() + "';";
				ResultSet rs = stmt.executeQuery(query);
				if (!rs.next()) {
					String query2 = "insert into ordine(codice_ordine, indirizzo_spedizione,"
							+ "stato, quantita_articolo, prezzo_acquisto, pagamento, username_a, codice_prodotto, data) "
							+ "values ('" + ord.getCodice() + "','" + ord.getIndirizzoSped() + "','" + ord.getStato()
							+ "','" + ord.getQuantitaArt() + "','" + ord.getPrezzoAcquisto() + "','"
							+ ord.getPaganento() + "','" + ord.getAcquirente() + "','" + ord.getCodProd() + "', data = '"+ord.getData()+"');";
					stmt.executeUpdate(query2);
				} else {
					String query3 = "update ordine set" + " indirizzo_spedizione = '" + ord.getIndirizzoSped() + "',"
							+ " stato = '" + ord.getStato() + "'," + " quantita_articolo = '" + ord.getQuantitaArt()
							+ "'," + " prezzo_acquisto = '" + ord.getPrezzoAcquisto() + "'," + " pagamento = '"
							+ ord.getPaganento() + "'," + " username_a = '" + ord.getAcquirente() + "',"
							+ " codice_prodotto = '" + ord.getCodProd() + "', data = '" + ord.getData() + "'" + " where codice_ordine = '"
							+ ord.getCodice() + "';";
					stmt.executeUpdate(query3);

				}
			}

			catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public void doDelete(Ordine ord) throws SQLException {
		try (Connection conn = ConnectionPool.getConnection()) {
			try (Statement stmt = conn.createStatement()) {
				String query = "select codice_ordine from ordine where codice_ordine like '" + ord.getCodice() + "';";
				ResultSet rs = stmt.executeQuery(query);
				if (rs.next()) {
					String query2 = "delete from ordine where codice_ordine = '" + ord.getCodice() + "';";
					stmt.executeUpdate(query2);

				}
			}

			catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	public Ordine doRetriveByKey(String key) throws SQLException {
		try (Connection conn = ConnectionPool.getConnection()) {
			try (Statement stmt = conn.createStatement()) {
				String query = "select * from ordine where codice_ordine like '" + key + "';";
				ResultSet rs = stmt.executeQuery(query);
				if (rs.next()) {
					return new Ordine(rs.getString("codice_ordine"), rs.getString("indirizzo_spedizione"),
							rs.getString("stato"), rs.getInt("quantita_articolo"), rs.getDouble("prezzo_acquisto"),
							rs.getString("pagamento"), rs.getString("username_a"), rs.getString("codice_prodotto"),
							rs.getString("data"));
				} else
					return null;
			}

			catch (SQLException e) {
				e.printStackTrace();
				return null;
			}
		}

	}

	public ArrayList<Ordine> doRetriveByCond(String cond) throws SQLException {

		try (Connection conn = ConnectionPool.getConnection()) {
			ArrayList<Ordine> list = new ArrayList<>();
			try (Statement stmt = conn.createStatement()) {
				String query = "select * from ordine where " + cond + ";";
				ResultSet rs = stmt.executeQuery(query);
				while (rs.next()) {
					list.add(new Ordine(rs.getString("codice_ordine"), rs.getString("indirizzo_spedizione"),
							rs.getString("stato"), rs.getInt("quantita_articolo"), rs.getDouble("prezzo_acquisto"),
							rs.getString("pagamento"), rs.getString("username_a"), rs.getString("codice_prodotto"),
							rs.getString("data")));
				}
				return list;
			}

			catch (SQLException e) {
				e.printStackTrace();
				return null;
			}
		}

	}

	public ArrayList<Ordine> doRetriveAll() throws SQLException {

		try (Connection conn = ConnectionPool.getConnection()) {
			ArrayList<Ordine> list = new ArrayList<>();
			try (Statement stmt = conn.createStatement()) {
				String query = "select * from ordine;";
				ResultSet rs = stmt.executeQuery(query);
				while (rs.next()) {
					list.add(new Ordine(rs.getString("codice_ordine"), rs.getString("indirizzo_spedizione"),
							rs.getString("stato"), rs.getInt("quantita_articolo"), rs.getDouble("prezzo_acquisto"),
							rs.getString("pagamento"), rs.getString("username_a"), rs.getString("codice_prodotto"),
							rs.getString("data")));
				}
				return list;
			}

			catch (SQLException e) {
				e.printStackTrace();
				return null;
			}
		}

	}

}