package Controller;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.Prodotto;
import Model.ProdottoDAO;

/**
 * Servlet implementation class Cancella_prodotto
 */
@WebServlet("/Cancella_prodotto")
public class Cancella_prodotto extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Cancella_prodotto() 
    {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String x=(String) request.getParameter("prodotto");
		ProdottoDAO p=new ProdottoDAO();
		Prodotto o;
		try 
		{
			o = p.doRetriveByKey(x);
			p.doDelete(o);
		} 
		
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
		response.sendRedirect("ProdottiNonVenduti");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doGet(request, response);
	}

}