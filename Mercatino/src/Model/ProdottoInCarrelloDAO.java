package Model;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ProdottoInCarrelloDAO {

	public int doSave(ProdottoInCarrello o) throws SQLException, IOException {

		try (Connection conn = ConnectionPool.getConnection()) {
			try (Statement stmt = conn.createStatement()) {
				int x;
				String query = "select cod_prodotto from prodotto_carrello where cod_prodotto like '" + o.getProdotto() + "';";
				ResultSet rs = stmt.executeQuery(query);
				if (!rs.next()) {
					String query2 = "insert into prodotto_carrello(cod_prodotto, cod_user, quantità) values ('" + o.getProdotto()
							+ "','" + o.getUsername() + "','" + o.getQuantità() + ");";
					x = stmt.executeUpdate(query2);
					return x;
				}
				return 0;
			}
		}
	}

	public int doSaveOrUpdate(ProdottoInCarrello o) throws SQLException {

		try (Connection conn = ConnectionPool.getConnection()) {
			try (Statement stmt = conn.createStatement()) {
				String query = "select cod_prodotto from prodotto_carrello where cod_prodotto like '" + o.getProdotto() + "';";
				ResultSet rs = stmt.executeQuery(query);

				int x;
				if (!rs.next()) {
					String query2 = "insert into prodotto_carrello(cod_prodotto, cod_user, quantità) values ('" + o.getProdotto()
							+ "','" + o.getUsername() + "','" + o.getQuantità() + "');";
					x = stmt.executeUpdate(query2);
					return x;
				}

				else {
					String query2 = "update prodotto_carrello set quantità=" + o.getQuantità() + " where cod_prodotto ='"
							+ o.getProdotto() + "' and cod_user = '" + o.getUsername() + "';";
					x = stmt.executeUpdate(query2);
					return x;
				}
			}
		}
	}

	public void doDelete(ProdottoInCarrello o) throws SQLException {

		try (Connection conn = ConnectionPool.getConnection()) {
			try (Statement stmt = conn.createStatement()) {
				String query = "delete from prodotto_carrello where cod_prodotto like '" + o.getProdotto() + "';";
				stmt.executeUpdate(query);
			}
		}
	}

	public ProdottoInCarrello doRetriveByKey(String prod, String user) throws SQLException, IOException {

		try (Connection conn = ConnectionPool.getConnection()) {
			try (Statement stmt = conn.createStatement()) {
				String query = "select * from prodotto_carrello where cod_prodotto like'" + prod + "' and cod_user like '" + user
						+ "';";
				ResultSet rs = stmt.executeQuery(query);
				if (rs.next()) {
					String prodotto = rs.getString("cod_prodotto");
					String username = rs.getString("cod_user");
					int quantità = rs.getInt("quantità");

					return new ProdottoInCarrello(prodotto, user, quantità);
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

	public ArrayList<ProdottoInCarrello> doRetriveByCond(String cond) throws SQLException {

		try (Connection conn = ConnectionPool.getConnection()) {
			try (Statement stmt = conn.createStatement()) {
				String query = "select * from prodotto_carrello where " + cond + ";";
				ResultSet rs = stmt.executeQuery(query);
				ArrayList<ProdottoInCarrello> list = new ArrayList<ProdottoInCarrello>();
				while (rs.next()) {
					String prodotto = rs.getString("cod_prodotto");
					String username = rs.getString("cod_user");
					int quantità = rs.getInt("quantità");

					list.add(new ProdottoInCarrello(prodotto, username, quantità));
				}

				return list;
			} catch (SQLException e) {
				e.printStackTrace();
				return null;
			}
		}
	}

	public ArrayList<ProdottoInCarrello> doRetriveByAll() throws SQLException {

		try (Connection conn = ConnectionPool.getConnection()) {
			try (Statement stmt = conn.createStatement()) {
				String query = "select * from prodotto_carrello";
				ResultSet rs = stmt.executeQuery(query);

				ArrayList<ProdottoInCarrello> list = new ArrayList<ProdottoInCarrello>();
				while (rs.next()) {
					String prodotto = rs.getString("cod_prodotto");
					String username = rs.getString("cod_user");
					int quantità = rs.getInt("quantità");

					list.add(new ProdottoInCarrello(prodotto, username, quantità));
				}

				return list;
			}

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

}
