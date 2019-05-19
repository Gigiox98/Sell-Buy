package Controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.Prodotto;
import Model.ProdottoDAO;

/**
 * Servlet implementation class Starter
 */
@WebServlet("/Starter")
public class Starter extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Starter() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProdottoDAO p = new ProdottoDAO();
		try {
			ArrayList<Prodotto> x = null;
			ArrayList<Prodotto> x1 = null;
			String categoria = request.getParameter("categoria");
			String prodotto = request.getParameter("prodotto");
			String zona = request.getParameter("zona");
			String s = "Home";
			if(categoria != null && !categoria.equals("")) {
				x = p.doRetriveByCond("stato='Usato' and categoria = '"+categoria+"'");
				x1 = p.doRetriveByCond("stato='Nuovo' and categoria = '"+categoria+"'");
				s = "Torna Indietro";
			} else if(prodotto != null || zona != null) {
				String q1= "stato='Usato'", q2 = "stato='Nuovo'";
				if((prodotto!=null) && !(prodotto.equals(""))){
					q1 = q1 +  " and (nome LIKE '%"+ prodotto +"%' OR descrizione LIKE '%"+ prodotto +"%') ";
					q2 = q2 +  " and (nome LIKE '%"+ prodotto +"%' OR descrizione LIKE '%"+ prodotto +"%') ";
				}

				if((zona!=null) && !(zona.equals(""))){
					q1 = q1 +  " and località LIKE '%"+ zona + "%' ";
					q2 = q2 +  " and località LIKE '%"+ zona + "%' ";
				}
				
				x = p.doRetriveByCond(q1);
				x1 = p.doRetriveByCond(q2);
				s = "Torna Indietro";
			}
			
			else {
				x = p.doRetriveByCond("stato='Usato'");
				x1 = p.doRetriveByCond("stato='Nuovo'");
				
			}
			request.setAttribute("usati", x);
			request.setAttribute("nuovi", x1);
			request.setAttribute("Home", s);
			
			RequestDispatcher view=request.getRequestDispatcher("/HomePage.jsp");
			view.forward(request, response);
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
