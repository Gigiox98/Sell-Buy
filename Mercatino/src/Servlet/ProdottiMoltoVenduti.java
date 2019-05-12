package Servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.Prodotto;
import Model.ProdottoDAO;

/**
 * Servlet implementation class ProdottiNonVenduti
 */
@WebServlet("/ProdottiMoltoVenduti")
public class ProdottiMoltoVenduti extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProdottiMoltoVenduti() 
    {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProdottoDAO p=new ProdottoDAO();
		ArrayList <Prodotto> list= new ArrayList<Prodotto>();
		try 
		{
			list=p.doRetriveByCond(" acquistato>=5");
			request.setAttribute("prodotti", list);
			RequestDispatcher view=request.getRequestDispatcher("/ProdottiPiùVenduti.jsp");
			view.forward(request, response);
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