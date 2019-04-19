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
import javax.servlet.http.HttpSession;

import Model.Utente;
import Model.UtenteDAO;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() 
    {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String login=request.getParameter("username");
		String password=request.getParameter("password");
		UtenteDAO o=new UtenteDAO();
		try 
		{
			ArrayList<Utente> user=o.doRetriveByCond("username like '"+login+"' and password like '"+password+"';");
			if(user.size()==0)
			{
				 request.setAttribute("esito","negativo");
				 RequestDispatcher view=request.getRequestDispatcher("login.jsp");
				 view.forward(request, response);
			}
			
			else
			{
				request.setAttribute("esito","positivo");
				HttpSession session=request.getSession();
				synchronized(session)
				{
					session.setMaxInactiveInterval(6*60);
					session.setAttribute("username", login);
					response.sendRedirect("HomePage.jsp");
				}
			}
				
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doGet(request, response);
	}

}
