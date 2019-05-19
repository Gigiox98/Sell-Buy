package Controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.ProdottoDAO;
import Model.Recensione;
import Model.RecensioneDAO;

/**
 * Servlet implementation class InserisciRecensione
 */
@WebServlet("/Recensione")
public class InserisciRecensione extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InserisciRecensione() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    
    protected String generaCodice() {
		String codice = "";
		String alpha = "123456789ABCDE";

		for (int i = 0; i < 10; i++) {
			Random r = new Random();
			int j = r.nextInt(9);
			codice = codice + alpha.charAt(j);
		}
		return codice;
	}
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RecensioneDAO dao = new RecensioneDAO();
		ProdottoDAO pDao = new ProdottoDAO();
		String codice = generaCodice();
		
		String prodotto = request.getParameter("prodotto");
		String username = request.getParameter("username");
		String text = request.getParameter("testo");
		int voto = Integer.parseInt(request.getParameter("voto"));
		Recensione rec = new Recensione(codice, prodotto, username, text, voto);
		
		try {
			dao.doSave(rec);
			
			request.setAttribute("prodotto", pDao.doRetriveByKey(prodotto));
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/dettagli.jsp");
			dispatcher.forward(request, response);
		} catch (SQLException e) {
			response.sendRedirect("Starter");
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
