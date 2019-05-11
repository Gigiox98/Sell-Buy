package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class UtenteDAO
{
	final String DB_URL_with_SSL = "jdbc:mysql://localhost:3306/sellbuy?useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	final String USER = "root";
	final String PASS = "pippo";
	
	public boolean doSave(Utente o) 
	{
		    try 
		    {
		      Class.forName("com.mysql.cj.jdbc.Driver");
		    } 
		    
		    catch (ClassNotFoundException e) 
		    {
		      e.printStackTrace();
		      return false;
		    }

		    try(Connection conn=DriverManager.getConnection(DB_URL_with_SSL, USER, PASS))
		    {
		      try (Statement stmt = conn.createStatement()) 
		      {
		        String query= "select username from utente where username like '"+o.getUsername()+"';";
		        ResultSet rs=stmt.executeQuery(query);
		        if(!rs.next())
		        {
		          String query2="insert into utente(username,password,nome,cognome,via,civico,città,adminflag,email) values ('"+
		          o.getUsername()+"','"+o.getPassword()+"','"+o.getNome()+"','"+o.getCognome()+"','"+o.getVia()+"','"+o.getN_civico()+"','"+o.getCittà()+"','"+o.getAdmin_flag()+"','"+o.getEmail()+"'"+");";
		          stmt.executeUpdate(query2);
		          return true;
		        }
		        
		        else
		        {
		        	return false;
		        }
		        
		      }
		    }
		    
		    catch (SQLException e) 
		    {
		      e.printStackTrace();
		      return false;
		    }
	}

	public void doSaveOrUpdate(Utente o) 
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
		        String query= "select username from utente where username like '"+o.getUsername()+"';";
		        ResultSet rs=stmt.executeQuery(query);
		        if(!rs.next())
		        {
		          String query2="insert into utente(username,password,nome,cognome,via,civico,città,adminflag,email) values ('"+
		          o.getUsername()+"','"+o.getPassword()+"','"+o.getNome()+"','"+o.getCognome()+"','"+o.getVia()+"','"+o.getN_civico()+"','"+o.getCittà()+"','"+o.getAdmin_flag()+"','"+o.getEmail()+"');";
		          stmt.executeUpdate(query2);
		        }
		        
		        else
		        {
		        	String query2="update utente set nome='"+o.getNome()+"', cognome='"
		        +o.getCognome()+"', via='"+o.getVia()+"', civico='"+o.getN_civico()+"', città='"+o.getCittà()
		        +"', adminflag="+o.getAdmin_flag()+", password='"+o.getPassword()+"', email='"+o.getEmail()+"' where username='"+o.getUsername()+"';";
		  		          stmt.executeUpdate(query2);
		        }
		        
		      }
		    }
		    
		    catch (SQLException e) 
		    {
		      e.printStackTrace();
		    }
	}

	public void doDelete(Utente o) throws SQLException 
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
		        String query= "delete from utente where username = '"+o.getUsername()+"';";
		        stmt.executeUpdate(query);
		      }
		    }
	}
	
	public Utente doRetriveByKey(String key) throws SQLException {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		}

		catch (ClassNotFoundException e) {
			e.printStackTrace();

		}

		try (Connection conn = DriverManager.getConnection(DB_URL_with_SSL, USER, PASS)) {
			try (Statement stmt = conn.createStatement()) 
			{
				String query = "select * from utente where username like'" + key + "';";
				ResultSet rs = stmt.executeQuery(query);
				if(rs.next()) 
				{
					String nome=rs.getString("nome");
					String cognome=rs.getString("cognome");
					String password=rs.getString("password");
					String via=rs.getString("via");
					String num=rs.getString("civico");
					int numero=Integer.parseInt(num);
					String città=rs.getString("città");
					String username=rs.getString("username");
					String email=rs.getString("email");
					String adminflag=rs.getString("adminflag");
					short admin=Short.parseShort(adminflag);
					return new Utente(nome,cognome,password,via,numero,città,username,email,admin);
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
	
	public ArrayList<Utente> doRetriveByCond(String cond) throws SQLException {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		}

		catch (ClassNotFoundException e) {
			e.printStackTrace();

		}

		try (Connection conn = DriverManager.getConnection(DB_URL_with_SSL, USER, PASS)) {
			try (Statement stmt = conn.createStatement()) 
			{
				String query = "select * from utente where " + cond + ";";
				ResultSet rs = stmt.executeQuery(query);
				ArrayList <Utente> list=new ArrayList<Utente>();
				while (rs.next()) 
				{
					String nome=rs.getString("nome");
					String cognome=rs.getString("cognome");
					String password=rs.getString("password");
					String via=rs.getString("via");
					String num=rs.getString("civico");
					int numero=Integer.parseInt(num);
					String città=rs.getString("città");
					String username=rs.getString("username");
					String email=rs.getString("email");
					String adminflag=rs.getString("adminflag");
					short admin=Short.parseShort(adminflag);
					list.add(new Utente(nome,cognome,password,via,numero,città,username,email,admin));
				}
				
					return list;
			}

			catch (SQLException e) {
				e.printStackTrace();
				return null;
			}
		}

	}
	
	public ArrayList<Utente> doRetriveByAll() throws SQLException {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		}

		catch (ClassNotFoundException e) {
			e.printStackTrace();

		}

		try (Connection conn = DriverManager.getConnection(DB_URL_with_SSL, USER, PASS)) {
			try (Statement stmt = conn.createStatement()) 
			{
				String query = "select * from utente";
				ResultSet rs = stmt.executeQuery(query);
				ArrayList <Utente> list=new ArrayList<Utente>();
				while (rs.next()) 
				{
					String nome=rs.getString("nome");
					String cognome=rs.getString("cognome");
					String password=rs.getString("password");
					String via=rs.getString("via");
					String num=rs.getString("civico");
					int numero=Integer.parseInt(num);
					String città=rs.getString("città");
					String username=rs.getString("username");
					String email=rs.getString("email");
					String adminflag=rs.getString("adminflag");
					short admin=Short.parseShort(adminflag);
					list.add(new Utente(nome,cognome,password,via,numero,città,username,email,admin));
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
