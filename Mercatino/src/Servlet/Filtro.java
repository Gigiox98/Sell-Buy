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
 * Servlet implementation class Filtro
 */
@WebServlet("/Filtro")
public class Filtro extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Filtro() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String nome = request.getParameter("nome");
		String stato = request.getParameter("usato");
		String stato2 = request.getParameter("nuovo");
		String categoria = request.getParameter("categoria");
		Double prezzo;
		try {
			prezzo = Double.parseDouble(request.getParameter("prezzo"));
		}
		catch (Exception e){
			prezzo = null;
		}
		String localit� = request.getParameter("localit�");
		ProdottoDAO p = new ProdottoDAO();
		
		try {
			
			ArrayList<Prodotto> result = new ArrayList<Prodotto>();

			if (nome == null && categoria == null && prezzo == null && localit� == null) {
				if (stato != null && stato2 == null)
					result = p.doRetriveByCond("stato='usato'");
				else if (stato == null && stato2 != null)
					result = p.doRetriveByCond("stato='nuovo'");
				else if (stato == null || stato2 == null)
					result = p.doRetriveByCond("stato='nuovo' or stato='usato'");
				else result = null;
			} else {
				
				String query="";
				
				if(nome != null && nome != "") {
					System.out.println("nome:"+nome);
					query = query + "(nome LIKE '%"+nome+"%' OR descrizione LIKE '%"+nome+"%') ";
					
				} 
				
				
				if(categoria != null && categoria != "") {
					if(!query.equals("")) query = query + "AND ";
					query = query + "categoria = '"+ categoria + "' ";
				}
				
				if(prezzo != null) {
					System.out.println(prezzo);
					if(!query.equals("")) query = query + "AND ";
					query = query + "prezzo <= "+ prezzo + " ";
				}
				
				if(localit� != null && localit� != "") {
					if(!query.equals("")) query = query + "AND ";
					query = query + "localit� LIKE '%"+ localit� + "%' ";
				}
				
				if((stato!=null) && (stato2 != null)){
					if(!query.equals("")) query = query + "AND ";
					query = query + "(stato = 'usato' OR stato = 'nuovo')";
				} else if(stato != null){
					if(!query.equals("")) query = query + "AND ";
					query = query + "stato = 'usato'";
				} else if(stato2 != null){
					if(!query.equals("")) query = query + "AND ";
					query = query + "stato = 'nuovo'";
				}
				
				System.out.println(query);
				result = p.doRetriveByCond(query);
			}
			
			request.setAttribute("prodotti", result);
			RequestDispatcher view = request.getRequestDispatcher("Filtro.jsp");
			view.forward(request, response);
		}

		catch  (SQLException e){
			e.printStackTrace();
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}