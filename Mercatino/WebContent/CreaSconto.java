package Controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.Prodotto;
import Model.ProdottoDAO;
import Model.Sconto;
import Model.ScontoDAO;

/**
 * Servlet implementation class CreaSconto
 */
@WebServlet("/CreaSconto")
public class CreaSconto extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreaSconto() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    
    protected String generaCodice() {
		String codice = "";
		String alpha = "123456789@%&/£$?ABCDEFGHILMNOPQRSTUVZ";

		for (int i = 0; i < 12; i++) {
			Random r = new Random();
			int j = r.nextInt(37);
			codice = codice + alpha.charAt(j);
		}
		return codice;
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String prodotto = request.getParameter("prodotto");
		String user = request.getParameter("user");
		
		ProdottoDAO pDAO = new ProdottoDAO();
		ScontoDAO sDAO = new ScontoDAO();
		Sconto s;
		
		
		try {
			Prodotto p = pDAO.doRetriveByKey(prodotto);
			String codice = generaCodice();
			int ammontare = (int) ((10*p.getPrezzo())/100);
			boolean usato = false;
			
			s = new Sconto(codice, ammontare, usato);
			sDAO.doSaveOrUpdate(s);
			response.sendRedirect("ProdottiMoltoVenduti");
			
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
