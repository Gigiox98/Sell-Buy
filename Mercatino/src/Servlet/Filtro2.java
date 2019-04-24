package Servlet;

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
@WebServlet("/Filtro2")
public class Filtro2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Filtro2() {
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
		String prezzo = request.getParameter("prezzo");
		String località = request.getParameter("località");
		ProdottoDAO p = new ProdottoDAO();
		
		try {
			
			ArrayList<Prodotto> result = new ArrayList<Prodotto>();

			if (nome == null && categoria == null && prezzo == null && località == null) {
				if (stato != null && stato2 == null)
					result = p.doRetriveByCond("stato='usato'");
				else if (stato == null && stato2 != null)
					result = p.doRetriveByCond("stato='nuovo'");
				else if (stato == null || stato2 == null)
					result = p.doRetriveByCond("stato='nuovo' or stato='usato'");
				else result = null;
			} else {
				
				String query="";
				
				if(nome != null) {
					query = query + "(nome LIKE '%"+nome+"%' OR descrizione LIKE '%"+nome+"%') ";
					
				} 
				
				
				if(categoria != null) {
					if(!query.equals("")) query = query + "AND ";
					query = query + "nome_categoria = '"+ categoria + "' ";
				}
				
				if(prezzo != null) {
					if(!query.equals("")) query = query + "AND ";
					query = query + "prezzo <= "+ prezzo + " ";
				}
				
				if(località != null) {
					if(!query.equals("")) query = query + "AND ";
					query = query + "località LIKE '%"+ località + "%' ";
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

		catch (SQLException e) {
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