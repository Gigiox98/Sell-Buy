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
import javax.servlet.http.HttpSession;

import Model.Utente;
import Model.UtenteDAO;

/**
 * Servlet implementation class GestioneUtenza
 */
@WebServlet("/GestioneUtenza")
public class GestioneUtenza extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GestioneUtenza() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UtenteDAO dao = new UtenteDAO();
		HttpSession session = request.getSession();
		
		synchronized (session) {
			String username = (String) session.getAttribute("username");
			try {
				ArrayList<Utente> users = dao.doRetriveByCond("username != '"+username+"'");
				request.setAttribute("users", users);
				RequestDispatcher view=request.getRequestDispatcher("/GestioneUtenza.jsp");
				view.forward(request, response);
				
			} catch (SQLException e) {
				response.sendError(500);
				e.printStackTrace();
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
