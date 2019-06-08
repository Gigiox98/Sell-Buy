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

import Model.Carrello;
import Model.Prodotto;
import Model.ProdottoDAO;
import Model.ProdottoInCarrello;
import Model.ProdottoInCarrelloDAO;
import Model.ProdottoQuantita;

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
		HttpSession session = request.getSession();
		
		synchronized (session) {
			ProdottoDAO daoP = new ProdottoDAO();
			ProdottoInCarrelloDAO daoPC = new ProdottoInCarrelloDAO();
			String username = (String) session.getAttribute("username");
			Carrello carrello = (Carrello) session.getAttribute("carrello");
			if (carrello == null) {
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("Carrello.jsp");
				requestDispatcher.forward(request, response);
				return;
			}
			
			String code = request.getParameter("code");
			if (code != null) {
				System.out.println("Sto rimuovendo " +  code);
				
				String quantità = request.getParameter("quantità");
				Prodotto p = null;
				try {
					p = daoP.doRetriveByKey(code);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if (quantità != null) {
					ProdottoQuantita prodQuant = carrello.get(code);
					
					int setNum = prodQuant.getQuantita() - Integer.parseInt(quantità);
					if (setNum <= 0) {
						carrello.remove(code);
						
						if(username != null) {
							System.out.println("Inserisco nel database " + code);
							try {
								daoPC.doDelete(new ProdottoInCarrello(code, "", 0));
							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							};
						}
						
					} else {
						prodQuant = carrello.get(code);
						prodQuant.setQuantita(setNum);
						
						if(username != null) {
							System.out.println("Inserisco nel database " + code);
							try {
								daoPC.doSaveOrUpdate(new ProdottoInCarrello(code, username, setNum));
							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							};
						}
						
					}
				}
			}
			
			}
			
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("Carrello.jsp");
			requestDispatcher.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}