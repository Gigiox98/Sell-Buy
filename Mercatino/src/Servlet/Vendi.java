package Servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import Model.Categoria;
import Model.CategoriaDAO;
import Model.Prodotto;

/**
 * Servlet implementation class Vendi
 */
@WebServlet("/Vendi")
public class Vendi extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Vendi() 
    {
    	super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
				String codice="";
				String alpha="123456789";
				for(int i=0; i<10; i++)
				{
					Random r=new Random();
					int j=r.nextInt(10);
					codice=codice+alpha.charAt(j);
				}
				
				
				String nome=request.getParameter("nome");
				String pre=request.getParameter("prezzo");
				double prezzo=Double.parseDouble(pre);
				String q=request.getParameter("quantità");
				int quantità=Integer.parseInt(q);
				String image = request.getParameter("immagine");
				String località = request.getParameter("località");
				String descrizione = request.getParameter("descrizione");
				Prodotto p=new Prodotto();
				
			try 
			{
				ArrayList<Categoria> categorie = catDao.doRetriveAll();
				ServletContext context = getServletContext();
				
				context.setAttribute("categorie", categorie);
				response.sendRedirect("vendi.jsp");	
			} 
			catch (SQLException e) 
			
			{
				response.sendRedirect("HomePage.jsp");
				e.printStackTrace();
			}
			
			
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
