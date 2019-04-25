package Servlet;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Model.Ordine;
import Model.OrdineDAO;
import Model.Prodotto;
import Model.ProdottoDAO;

/**
 * Servlet implementation class RemoveToCart
 */
@WebServlet("/RemoveToCart")
public class RemoveToCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RemoveToCart() 
    {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String order = request.getParameter("order");
		String q=request.getParameter("quantit�");
		Integer quantit�=Integer.parseInt(q);
		
		try 
		{
			ProdottoDAO d = new ProdottoDAO();
			OrdineDAO dao = new OrdineDAO();
			Ordine x = dao.doRetriveByKey(order);
			Prodotto p = d.doRetriveByKey(x.getCodProd());
			p.setQuantit�(p.getQuantit�() + quantit�);
			d.doSaveOrUpdate(p);
			if(x.getQuantitaArt()==quantit�)
			{
				dao.doDelete(x);
				response.sendRedirect("Carrello.jsp");
			}
			
			else
			{
				x.setQuantitaArt(x.getQuantitaArt()-quantit�);
				x.setPrezzoAcquisto(x.getPrezzoAcquisto()-(p.getPrezzo()*quantit�));
				dao.doSaveOrUpdate(x);
				response.sendRedirect("Carrello.jsp");
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
