package Controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import Model.Ordine;
import Model.OrdineDAO;
import Model.Prodotto;
import Model.ProdottoDAO;

@WebServlet("/AddToCart")
public class AddToCart extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddToCart() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected String generaCodice() {
		String codice = "";
		String alpha = "ABCDEFGHILMNIPQRSTUVWXYZ0123456789";

		for (int i = 0; i < 10; i++) {
			Random r = new Random();
			int j = r.nextInt(9);
			codice = codice + alpha.charAt(j);
		}
		return codice;
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException 
	{
		HttpSession session = request.getSession();
		synchronized (session) 
		{
			int number;
			String username = (String) session.getAttribute("username");
			ProdottoDAO prodottoDao = new ProdottoDAO();
			try 
			{
				Prodotto p = prodottoDao.doRetriveByKey(request.getParameter("code"));
				if(p!=null)
				{
					OrdineDAO daoo = new OrdineDAO();
					ArrayList<Ordine> list_order=daoo.doRetriveByCond("codice_prodotto='"+p.getCodice()+"' and username_a='"+username+"' and stato = 'in carrello';");
					if(list_order.size()==0)
					{
						Integer quantità = Integer.parseInt(request.getParameter("quantita"));
						number = p.getQuantità();
						number = number - quantità;
						p.setQuantità(number);
						prodottoDao.doSaveOrUpdate(p);
						String codiceO = generaCodice();
						String indirizzoSped = "";
						String stato = "in carrello";
						double prezzoAcquisto = p.getPrezzo()*quantità;
						String pagamento = "";
						String acquirente = username;
						String codProd = p.getCodice();
						
						java.util.Date today = new java.util.Date();
						String data = today.toString();
						
						Ordine o = new Ordine(codiceO, indirizzoSped, stato, quantità, prezzoAcquisto, pagamento,
								acquirente, codProd, data);
						
						System.out.println(o.getData());
						daoo.doSaveOrUpdate(o);
						response.sendRedirect("Carrello.jsp");
					}
					
					else
					{
						Ordine o=list_order.get(0);
						Integer quantità = Integer.parseInt(request.getParameter("quantita"));
						number = p.getQuantità();
						number = number - quantità;
						p.setQuantità(number);
						prodottoDao.doSaveOrUpdate(p);
						String indirizzoSped = "";
						String stato = "in carrello";
						int quantità_ord=o.getQuantitaArt()+quantità;
						double prezzoAcquisto = p.getPrezzo()*quantità_ord;
						String pagamento = "";
						String acquirente = username;
						String codProd = p.getCodice();
						Ordine ord = new Ordine(o.getCodice(), indirizzoSped, stato, quantità_ord, prezzoAcquisto, pagamento,
								acquirente, codProd, o.getData());
						daoo.doSaveOrUpdate(ord);
						response.sendRedirect("Carrello.jsp");
					}
				}
			} 
			
			catch (SQLException e1) 
			{
				e1.printStackTrace();
			}
			
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException 
	{
		doGet(request,response);
	}
	
}