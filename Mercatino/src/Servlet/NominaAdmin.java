package Controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.Utente;
import Model.UtenteDAO;

/**
 * Servlet implementation class NominaAdmin
 */
@WebServlet("/NominaAdmin")
public class NominaAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NominaAdmin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("user");
		UtenteDAO dao = new UtenteDAO();
		try {
			Utente x = dao.doRetriveByCond("username = '"+username+"'").get(0);
			if(x.getAdmin_flag() == 1) x.setAdmin_flag((short)0);
			else x.setAdmin_flag((short)1);
			
			dao.doSaveOrUpdate(x);
			response.sendRedirect("GestioneUtenza");
			
		} catch (SQLException e) {
			response.sendError(500);
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
