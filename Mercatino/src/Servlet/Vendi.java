package Servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import Model.Prodotto;
import Model.ProdottoDAO;

/**
 * Servlet implementation class Vendi
 */
@WebServlet(urlPatterns= {"/Vendi"},
initParams = 
{ 
		@WebInitParam(name = "nome", value = "", description = "nome dell'utente"), 
		@WebInitParam(name = "prezzo", value = "", description = "cognome dell'utente"), 
		@WebInitParam(name = "quantità", value = "", description = "username"), 
		@WebInitParam(name = "myloc", value = "", description = "password"),	
		@WebInitParam(name = "località", value = "", description = "nome dell'utente"), 
		@WebInitParam(name = "stato", value = "", description = "cognome dell'utente"), 
		@WebInitParam(name = "descrizione", value = "", description = "username"), 
		@WebInitParam(name = "categoria", value = "", description = "password")		
})

public class Vendi extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Vendi() 
    {
    	super();
    }

    protected String generaCodice()
    {
    	String codice="";
		String alpha="123456789";
		
		for(int i=0; i<10; i++)
		{
			Random r=new Random();
			int j=r.nextInt(9);
			codice=codice+alpha.charAt(j);
		}
		return codice;
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
				HttpSession session=request.getSession();
				String username=(String) session.getAttribute("username");
				String codice=generaCodice();
				java.util.Date today = new java.util.Date();
				String data=today.toString();
				String nome=request.getParameter("nome");
				String pre=request.getParameter("prezzo");
				System.out.println(nome+pre);
				double prezzo=Double.parseDouble(pre);
				String q=request.getParameter("quantità");
				int quantità=Integer.parseInt(q);
				String myloc = request.getParameter("immagine");
				String località = request.getParameter("località");
				String stato=request.getParameter("stato");
				String descrizione = request.getParameter("descrizione");
				String categoria= request.getParameter("categoria");
				Prodotto p=new Prodotto(codice,quantità,prezzo,descrizione,località,data,stato,username,categoria,myloc);
				ProdottoDAO pDAO=new ProdottoDAO();
				try 
				{
					int esito=pDAO.doSave(p);
					if(esito==1)
					{
						response.sendRedirect("HomePage.jsp");
					}
					else
					{
						response.sendError(500);
					}
				} 
				
				catch (SQLException e) 
				{
					e.printStackTrace();
				}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doGet(request, response);
	}

}
