package Controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sun.net.httpserver.HttpContext;

import Model.Carrello;
import Model.Prodotto;
import Model.ProdottoDAO;
import Model.ProdottoInCarrello;
import Model.ProdottoInCarrelloDAO;
import Model.ProdottoQuantita;

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

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		synchronized (session) {
			ProdottoInCarrelloDAO daoPC = new ProdottoInCarrelloDAO();
			ProdottoDAO daoP = new ProdottoDAO();
			String username = (String) session.getAttribute("username");
			Carrello carrello = (Carrello) session.getAttribute("carrello");
			
			
			if (carrello == null) {
				carrello = new Carrello();
				session.setAttribute("carrello", carrello);
			}

			String code = request.getParameter("code");
			if (code != null) {
				System.out.println("Devo inserire il prodotto " + code);
				String addNumStr = request.getParameter("quantita");

				if (addNumStr != null) {
					int addNum = Integer.parseInt(addNumStr);
					Prodotto p;
					try {
						p = daoP.doRetriveByKey(code);
						ProdottoQuantita prodQuant = carrello.get(code);
						
						int quantToDB;
						if (prodQuant != null) {
							prodQuant.setQuantita(prodQuant.getQuantita() + addNum);
							quantToDB = prodQuant.getQuantita();
						} else {
							System.out.println("Sto inserendo" + code);
							carrello.put(p, addNum);
							quantToDB = addNum;
						}
						
						if(username != null) {
							System.out.println("Inserisco nel database " + code);
							daoPC.doSaveOrUpdate(new ProdottoInCarrello(code, username, quantToDB));
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

				}

				//RequestDispatcher requestDispatcher = request.getRequestDispatcher("Carrello.jsp");
				//requestDispatcher.forward(request, response);
			}
			response.sendRedirect("Carrello.jsp");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}