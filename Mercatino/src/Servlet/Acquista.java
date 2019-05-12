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
 * Servlet implementation class Acquista
 */
@WebServlet("/Acquista")
public class Acquista extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Acquista() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		OrdineDAO ordDAO = new OrdineDAO();
		try {
			
			Ordine x = ordDAO.doRetriveByKey(request.getParameter("order"));
			ProdottoDAO product=new ProdottoDAO();
			Prodotto prodotto=product.doRetriveByKey(x.getCodProd());
			prodotto.setAcquistato(prodotto.getAcquistato()+x.getQuantitaArt());
			product.doSaveOrUpdate(prodotto);
			x.setStato("acquistato");
			x.setIndirizzoSped(request.getParameter("indirizzo"));
			x.setPaganento(request.getParameter("pagamento"));
			
			ordDAO.doSaveOrUpdate(x);
			response.sendRedirect("EsitoOrdine.jsp");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
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
