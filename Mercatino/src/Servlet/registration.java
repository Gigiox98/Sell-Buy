package Controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.Utente;
import Model.UtenteDAO;

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
		UtenteDAO dao = new UtenteDAO();

		String nameLetters = "^[A-Za-z' ']+$";
		String usernameLetters = "^[A-Za-z0-9]+$";
		String mailFormat = "[a-zA-Z0-9._%-]+@[a-zA-Z0-9.-]+.[a-zA-Z]";
		String passwordFormat = "^[a-zA-Z0-9_*-+!?,:;.&]{6,12}$";

		short adminflag = 0;
		String username = request.getParameter("username");
		boolean check = Pattern.matches(usernameLetters, username);

		if (!check) {
			request.setAttribute("BadFormatData", "true");
			System.out.println("Errore User");
			RequestDispatcher view = request.getRequestDispatcher("registration.jsp");
			view.forward(request, response);
			return;
		}

		try {
			if (dao.doRetriveByKey(username) != null) {
				request.setAttribute("existingUser", "true");
				RequestDispatcher view = request.getRequestDispatcher("registration.jsp");
				view.forward(request, response);
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		String email = request.getParameter("email");

		check = Pattern.matches(mailFormat, email);

		if (!check) {
			request.setAttribute("BadFormatData", "true");
			System.out.println("Errore mail");
			RequestDispatcher view = request.getRequestDispatcher("registration.jsp");
			view.forward(request, response);
			return;
		}

		String nome = request.getParameter("nome");
		check = Pattern.matches(nameLetters, nome);

		if (!check) {
			request.setAttribute("BadFormatData", "true");
			System.out.println("Errore nome");
			RequestDispatcher view = request.getRequestDispatcher("registration.jsp");
			view.forward(request, response);
			return;
		}

		String cognome = request.getParameter("cognome");

		check = Pattern.matches(nameLetters, cognome);

		if (!check) {
			request.setAttribute("BadFormatData", "true");
			System.out.println("Errore cognome");
			RequestDispatcher view = request.getRequestDispatcher("registration.jsp");
			view.forward(request, response);
			return;
		}

		String password = request.getParameter("password");

		check = Pattern.matches(passwordFormat, password);

		if (!check) {
			request.setAttribute("BadFormatData", "true");
			System.out.println("Errore formato password");
			RequestDispatcher view = request.getRequestDispatcher("registration.jsp");
			view.forward(request, response);
			return;
		}

		/*Pattern pattern = Pattern.compile(password);
		Matcher matcher = pattern.matcher("[A-Z]");
		if (!matcher.find()) {
			request.setAttribute("BadFormatData", "true");
			System.out.println("Errore non presenza AZ");
			RequestDispatcher view = request.getRequestDispatcher("registration.jsp");
			view.forward(request, response);
			return;

		}

		matcher = pattern.matcher("[1-9]");
		if (!matcher.find()) {
			request.setAttribute("BadFormatData", "true");
			System.out.println("Errore non presenza 19");
			RequestDispatcher view = request.getRequestDispatcher("registration.jsp");
			view.forward(request, response);
			return;

		}

		
		matcher = pattern.matcher("[_*-+!?,:;.&]");
		if (!matcher.find()) {
			System.out.println("Errore non presenza Special Caracter");
			request.setAttribute("BadFormatData", "true");
			RequestDispatcher view = request.getRequestDispatcher("registration.jsp");
			view.forward(request, response);
			return;

		}*/

		String via = request.getParameter("via");
		if (via.isEmpty()) {
			System.out.println("Errore via");
			request.setAttribute("BadFormatData", "true");
			RequestDispatcher view = request.getRequestDispatcher("registration.jsp");
			view.forward(request, response);
			return;

		}
		
		int civico;
		try {
			civico = Integer.parseInt(request.getParameter("civico"));
		} catch (Exception e) {
			request.setAttribute("BadFormatData", "true");
			RequestDispatcher view = request.getRequestDispatcher("registration.jsp");
			view.forward(request, response);
			return;
		}

		String città = request.getParameter("citta");
		if (città.isEmpty()) {
			System.out.println("Errore città");
			request.setAttribute("BadFormatData", "true");
			RequestDispatcher view = request.getRequestDispatcher("registration.jsp");
			view.forward(request, response);
			return;

		}
		Utente x = new Utente(nome, cognome, password, via, civico, città, username, email, adminflag);

		Boolean ack = dao.doSave(x);

		response.sendRedirect("Starter");
	}
}
