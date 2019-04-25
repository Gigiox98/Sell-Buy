package Servlet;

import java.io.*;
import Model.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

/**
 * Servlet that prints out the Beers of the selected color</a>.
 */

@WebServlet("/registration")
public class registration extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4778185314874657652L;

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		short adminflag=0;
		Utente x = new Utente(request.getParameter("nome"), request.getParameter("cognome"),
				 request.getParameter("password"),request.getParameter("via"),
				 Integer.parseInt(request.getParameter("civico")), request.getParameter("citta"), 
				 request.getParameter("username"), request.getParameter("email"), adminflag);
		UtenteDAO dao = new UtenteDAO();
		dao.doSave(x);
		response.sendRedirect("HomePage2.jsp");
	}
}
