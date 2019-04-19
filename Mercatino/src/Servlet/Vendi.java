package Servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import Model.Categoria;
import Model.CategoriaDAO;

/**
 * Servlet implementation class Vendi
 */
@WebServlet("/Vendi")
public class Vendi extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Vendi() {
        super();
   
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Boolean controllo= (Boolean) request.getAttribute("controllo");
		if(controllo == null) 
		{
				
				CategoriaDAO catDao = new CategoriaDAO();
			
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
			
			
		} else {
			Part filePart = request.getPart("nomeFile");
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
