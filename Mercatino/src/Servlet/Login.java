package Controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.Carrello;
import Model.Prodotto;
import Model.ProdottoDAO;
import Model.ProdottoInCarrello;
import Model.ProdottoInCarrelloDAO;
import Model.ProdottoQuantita;
import Model.Utente;
import Model.UtenteDAO;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Login() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String login = request.getParameter("username");
		String password = request.getParameter("password");
		UtenteDAO o = new UtenteDAO();
		try {
			ArrayList<Utente> user = o.doRetriveByCond("username like '" + login + "' and password like '" + password + "';");
			if (user.size() == 0) {
				request.setAttribute("esito", "negativo");
				RequestDispatcher view = request.getRequestDispatcher("login.jsp");
				view.forward(request, response);
				return;
			}

			else {
				request.setAttribute("esito", "positivo");
				HttpSession session = request.getSession();
				synchronized (session) {
					session.setMaxInactiveInterval(60 * 6);
					
					session.setAttribute("username", login);

					if (user.get(0).getAdmin_flag() == 1)
						session.setAttribute("admin", true);
					else
						session.setAttribute("admin", false);

					Carrello carrello = (Carrello) session.getAttribute("carrello");
					if (carrello == null) {
						carrello = new Carrello();
						session.setAttribute("carrello", carrello);
					}
					
					ProdottoInCarrelloDAO pcDao = new ProdottoInCarrelloDAO();
					ProdottoDAO daoP = new ProdottoDAO();
					ServletContext context = request.getServletContext();
					
					/*se ci sono già prodotti nel carrello aggiorno la base dati*/
					
					if(carrello.getProdotti() != null && !(carrello.getProdotti().isEmpty())){
						Collection<ProdottoQuantita> list = carrello.getProdotti();
						for(ProdottoQuantita pC: list) {
							String code = pC.getProdotto().getCodice();
							
							ProdottoInCarrello pCart = pcDao.doRetriveByKey(code, login);
							int quantToDB;
							
							if(pCart != null) quantToDB =  pC.getQuantita() + pCart.getQuantità();
							else quantToDB = pC.getQuantita();
							pcDao.doSaveOrUpdate(new ProdottoInCarrello(code, login, quantToDB));
							
							//rimuovo la quantità limite  dal contesto se presente
							context.removeAttribute(code);
						}
						
						
					
					}
					/*carico nel carrello i prodotti della base dati*/
					

					ArrayList<ProdottoInCarrello> list = pcDao.doRetriveByCond("cod_user = '" + login + "'");

					if (list != null) {
						for (ProdottoInCarrello p : list) {
							ProdottoQuantita prodQuant = carrello.get(p.getProdotto());
							Prodotto pr = daoP.doRetriveByKey(p.getProdotto());

							if (prodQuant != null) {
								prodQuant.setQuantita(p.getQuantità());
							} else {
								carrello.put(pr, p.getQuantità());
							}
						}
					}
					response.sendRedirect("Starter");
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
