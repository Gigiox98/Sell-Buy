package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class CategoriaDAO {

	public void doSave(Categoria cat) throws SQLException {
		try (Connection conn = ConnectionPool.getConnection()) {
			try (Statement stmt = conn.createStatement()) {
				String query = "select categoria from categoria where categoria like '" + cat.getNome() + "';";
				ResultSet rs = stmt.executeQuery(query);
				if (!rs.next()) {
					String query2 = "insert into categoria(categoria) values ('" + cat.getNome() + "');";
					stmt.executeUpdate(query2);
				}
			}

			catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public void doSaveOrUpdate(Categoria cat) throws SQLException {
		try (Connection conn = ConnectionPool.getConnection()) {
			try (Statement stmt = conn.createStatement()) {
				String query = "select categoria from categoria where categoria like '" + cat.getNome() + "';";
				ResultSet rs = stmt.executeQuery(query);
				if (!rs.next()) {
					String query2 = "insert into categoria(categoria) values ('" + cat.getNome() + "');";
					stmt.executeUpdate(query2);
				} else {
					String query3 = "update categoria set categoria = '" + cat.getNome() + "' where categoria = '"
							+ cat.getNome() + "';";
					stmt.executeUpdate(query3);

				}
			}

			catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public void doDelete(Categoria cat) throws SQLException {
		try (Connection conn = ConnectionPool.getConnection()) {
			try (Statement stmt = conn.createStatement()) {
				String query = "select categoria from categoria where codice_c like '" + cat.getNome() + "';";
				ResultSet rs = stmt.executeQuery(query);
				if (rs.next()) {
				String query2 = "delete from categoria where categoria = '" + cat.getNome() + "';";
					stmt.executeUpdate(query2);

				}
			}

			catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	public Categoria doRetriveByKey(String key) throws SQLException {
		Categoria cat;
		try (Connection conn = ConnectionPool.getConnection()) {
			try (Statement stmt = conn.createStatement()) {
				String query = "select * from categoria where categoria like '" + key + "';";
				ResultSet rs = stmt.executeQuery(query);
				if (rs.next()) {
					return new Categoria(rs.getString("categoria"));
				} else
					return null;
			}

			catch (SQLException e) {
				e.printStackTrace();
				return null;
			}
		}

	}

	public ArrayList<Categoria> doRetriveByCond(String cond) throws SQLException {
		Categoria cat;

		try (Connection conn = ConnectionPool.getConnection()) {
			ArrayList<Categoria> list = new ArrayList<>();
			try (Statement stmt = conn.createStatement()) {
				String query = "select * from categoria where" + cond + ";";
				ResultSet rs = stmt.executeQuery(query);
				while (rs.next()) {
					list.add(new Categoria(rs.getString("categoria")));
				}
				return list;
			}

			catch (SQLException e) {
				e.printStackTrace();
				return null;
			}
		}

	}

	public ArrayList<Categoria> doRetriveAll() throws SQLException {
		Categoria cat;

		try (Connection conn = ConnectionPool.getConnection()) {
			ArrayList<Categoria> list = new ArrayList<>();
			try (Statement stmt = conn.createStatement()) {
				String query = "select * from categoria;";
				ResultSet rs = stmt.executeQuery(query);
				while (rs.next()) {
					list.add(new Categoria(rs.getString("categoria")));
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
