package Controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

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
 * Servlet implementation class dettagli
 */
@WebServlet("/dettagli")
public class dettagli extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public dettagli() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		synchronized (session) {	
			
		
			String codice = (String) request.getParameter("code");
			
			if(codice == null) codice = (String) request.getAttribute("code");
			Carrello cart =(Carrello) session.getAttribute("carrello");
			String username =(String) session.getAttribute("username");
			
			System.out.println(codice);
			ProdottoDAO dao = new ProdottoDAO();
			
			
			ProdottoInCarrelloDAO daoPC = new ProdottoInCarrelloDAO();
			try {
				Prodotto x = dao.doRetriveByKey(codice);
				ArrayList<ProdottoInCarrello> list = daoPC.doRetriveByCond("cod_prodotto = '" + codice+ "'");
				
				int q_limit = x.getQuantità();
				
				for(ProdottoInCarrello c: list) {
					q_limit -= c.getQuantità();
				}
				
				
				//tolgo eventuali quantità già nel carrello di sessione
				if(username == null && cart != null) {
					ProdottoQuantita t = cart.get(codice);
					if(t != null) q_limit -= t.getQuantita();
				}
				
				System.out.println(q_limit);
				request.setAttribute("prodotto",  x);
				request.setAttribute("quantità_limite",  q_limit);
				
				RequestDispatcher view = request.getRequestDispatcher("dettagli.jsp");
				view.forward(request, response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				response.sendRedirect("Starter");
			}
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
