package Controller;

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
    public RemoveToCart() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String order = request.getParameter("order");
		
		
		
		try {
			ProdottoDAO d = new ProdottoDAO();
			OrdineDAO dao = new OrdineDAO();
			Ordine x = dao.doRetriveByKey(order);
			
			Prodotto p = d.doRetriveByKey(x.getCodProd());
			p.setQuantità(p.getQuantità() + x.getQuantitaArt());
			
			d.doSaveOrUpdate(p);
			
			System.out.println("I'm Here");
			dao.doDelete(x);
			response.sendRedirect("Carrello.jsp");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}


