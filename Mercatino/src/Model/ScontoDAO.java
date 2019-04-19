package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ScontoDAO
{
	final String DB_URL_with_SSL = "jdbc:mysql://localhost:3306/sellbuy?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	final String USER = "root";
	final String PASS = "Rompicapo98";
	
	public void doSave(Sconto o) 
	{
		try 
	    {
	      Class.forName("com.mysql.cj.jdbc.Driver");
	    } 
	    
	    catch (ClassNotFoundException e) 
	    {
	      e.printStackTrace();
	      
	    }

	    try(Connection conn=DriverManager.getConnection(DB_URL_with_SSL, USER, PASS))
	    {
	      try (Statement stmt = conn.createStatement()) 
	      {
	        String query= "select codice_p from sconto where codice_p like '"+o.getCodice()+"';";
	        ResultSet rs=stmt.executeQuery(query);
	        if(!rs.next())
	        {
	          String query2="insert into sconto(codice_p,sconto) values ('"+
	          o.getCodice()+"','"+o.getSconto()+");";
	          stmt.executeUpdate(query2);
	        }
	        
	      }
	    }
	    
	    catch (SQLException e) 
	    {
	      e.printStackTrace();
	    }
	    
	}

	public void doSaveOrUpdate(Sconto o) 
	{
		try 
	    {
	      Class.forName("com.mysql.cj.jdbc.Driver");
	    } 
	    
	    catch (ClassNotFoundException e) 
	    {
	      e.printStackTrace();
	      
	    }

	    try(Connection conn=DriverManager.getConnection(DB_URL_with_SSL, USER, PASS))
	    {
	      try (Statement stmt = conn.createStatement()) 
	      {
	        String query= "select codice_p from sconto where codice_p like '"+o.getCodice()+"';";
	        ResultSet rs=stmt.executeQuery(query);
	        if(!rs.next())
	        {
	          String query2="insert into sconto(codice_p,sconto) values ('"+
	          o.getCodice()+"','"+o.getSconto()+"');";
	          stmt.executeUpdate(query2);
	        }
	        
	        else
	        {
	        	String query2="update sconto set sconto='"+o.getSconto()+"' where codice_p='"+o.getCodice()+"');";
	  		          stmt.executeUpdate(query2);
	        }
	        
	      }
	    }
	    
	    catch (SQLException e) 
	    {
	      e.printStackTrace();
	    }
	}

	public void doDelete(Sconto o) throws SQLException 
	{
		 try 
		    {
		      Class.forName("com.mysql.cj.jdbc.Driver");
		    } 
		    
		    catch (ClassNotFoundException e) 
		    {
		      e.printStackTrace();
		      
		    }

		    try(Connection conn=DriverManager.getConnection(DB_URL_with_SSL, USER, PASS))
		    {
		      try (Statement stmt = conn.createStatement()) 
		      {
		        String query= "delete from sconto where codice_p like '"+o.getCodice()+"';";
		        stmt.executeQuery(query);
		      }
		    }
	}
	
	public Sconto doRetriveByKey(String key) throws SQLException {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		}

		catch (ClassNotFoundException e) {
			e.printStackTrace();

		}

		try (Connection conn = DriverManager.getConnection(DB_URL_with_SSL, USER, PASS)) {
			try (Statement stmt = conn.createStatement()) 
			{
				String query = "select * from sconto where codice_p like'" + key + "';";
				ResultSet rs = stmt.executeQuery(query);
				if(rs.next()) 
				{
					String codice_p=rs.getString("codice_p");
					String sc=rs.getString("sconto");
					int sconto=Integer.parseInt(sc);
					return new Sconto(codice_p,sconto);
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
	
	public ArrayList<Sconto> doRetriveByCond(String cond) throws SQLException {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		}

		catch (ClassNotFoundException e) {
			e.printStackTrace();

		}

		try (Connection conn = DriverManager.getConnection(DB_URL_with_SSL, USER, PASS)) {
			try (Statement stmt = conn.createStatement()) 
			{
				String query = "select * from sconto where " + cond + ";";
				ResultSet rs = stmt.executeQuery(query);
				ArrayList <Sconto> list=new ArrayList<Sconto>();
				while (rs.next()) 
				{
					String codice=rs.getString("codice_p");
					String sc=rs.getString("sconto");
					int sconto=Integer.parseInt(sc);
					list.add(new Sconto(codice,sconto));
				}
				
					return list;
			}

			catch (SQLException e) {
				e.printStackTrace();
				return null;
			}
		}

	}
	
	public ArrayList<Sconto> doRetriveByAll() throws SQLException {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		}

		catch (ClassNotFoundException e) {
			e.printStackTrace();

		}

		try (Connection conn = DriverManager.getConnection(DB_URL_with_SSL, USER, PASS)) {
			try (Statement stmt = conn.createStatement()) 
			{
				String query = "select * from sconto";
				ResultSet rs = stmt.executeQuery(query);
				ArrayList <Sconto> list=new ArrayList<Sconto>();
				while (rs.next()) 
				{
					String codice=rs.getString("codice_p");
					String sc=rs.getString("sconto");
					int sconto=Integer.parseInt(sc);
					list.add(new Sconto(codice,sconto));
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
