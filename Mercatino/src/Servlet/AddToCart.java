package Controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.Ordine;
import Model.OrdineDAO;
import Model.Prodotto;
import Model.ProdottoDAO;
import Model.Utente;
import Model.UtenteDAO;

@WebServlet("/AddToCart")
public class AddToCart extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddToCart() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected String generaCodice() {
		String codice = "";
		String alpha = "ABCDEFGHILMNIPQRSTUVWXYZ0123456789";

		for (int i = 0; i < 10; i++) {
			Random r = new Random();
			int j = r.nextInt(9);
			codice = codice + alpha.charAt(j);
		}
		return codice;
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		synchronized (session) {
			int number;
			String username = (String) session.getAttribute("username");
			ProdottoDAO prodottoDao = new ProdottoDAO();
			OrdineDAO daoo = new OrdineDAO();

			try {
				Integer quantità = Integer.parseInt(request.getParameter("quantita"));
				Prodotto p = prodottoDao.doRetriveByKey(request.getParameter("code"));

				if (p != null) {
					number = p.getQuantità();
					number = number - quantità;
					p.setQuantità(number);
					prodottoDao.doSaveOrUpdate(p);

					String codiceO = generaCodice();
					String indirizzoSped = "";
					String stato = "in carrello";
					
					double prezzoAcquisto = p.getPrezzo()*quantità;
					String pagamento = "";
					String acquirente = username;
					String codProd = p.getCodice();
					Ordine o = new Ordine(codiceO, indirizzoSped, stato, quantità, prezzoAcquisto, pagamento,
							acquirente, codProd);
					daoo.doSaveOrUpdate(o);
					
					response.sendRedirect("Carrello.jsp");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}