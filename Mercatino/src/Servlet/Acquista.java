package Controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.Carrello;
import Model.Ordine;
import Model.OrdineDAO;
import Model.Prodotto;
import Model.ProdottoDAO;
import Model.ProdottoInCarrello;
import Model.ProdottoInCarrelloDAO;
import Model.ProdottoQuantita;
import Model.Sconto;
import Model.ScontoDAO;

/**
 * Servlet implementation class Acquista
 */
@WebServlet("/Acquista")
public class Acquista extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Acquista() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    
    protected String generaCodice() {
		String codice = "";
		String alpha = "123456789ABCDEFGHILMNOPQUSTUVWXYZ";

		for (int i = 0; i < 12; i++) {
			Random r = new Random();
			int j = r.nextInt(33);
			codice = codice + alpha.charAt(j);
		}
		return codice;
	}
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		
		String username =(String) session.getAttribute("username");
		Carrello cart = (Carrello) session.getAttribute("carrello");
		String code = request.getParameter("product");
		
		System.out.println("acquisto-->"+code);
		ProdottoQuantita x = cart.get(code);
		
		
		Prodotto p = x.getProdotto();
		
		OrdineDAO ordDAO = new OrdineDAO();
		ProdottoDAO prodDAO = new ProdottoDAO();
		ProdottoInCarrelloDAO DAOpc= new ProdottoInCarrelloDAO();
		ScontoDAO scDAO = new ScontoDAO();
		
		try {
			
			Ordine ord = new Ordine("", "", "", 0, 0, "", "", "", "");
			
			String sc = request.getParameter("sconto");
			
			
			
			
			
			
			
			
			
			ord.setCodice(generaCodice());
			ord.setQuantitaArt(x.getQuantita());
			ord.setPrezzoAcquisto(x.getPrezzo());
			ord.setAcquirente(username);
			ord.setStato("acquistato");
			ord.setCodProd(code);
			
			java.util.Date today = new java.util.Date();
			String data = today.toString();
			
			
			
			ord.setData(data);
			System.out.println("--->" + ord.getData());
			ord.setIndirizzoSped(request.getParameter("indirizzo"));
			
			ord.setPaganento(request.getParameter("pagamento"));
			
			if(sc != null && sc != "") {
				Sconto s = scDAO.doRetriveByKey(sc);
				if(s!=null && !(s.isUsato())) {
					ord.setPrezzoAcquisto(ord.getPrezzoAcquisto() - s.getAmmontare());
					s.setUsato(true);
					scDAO.doSaveOrUpdate(s);
				}
				
			}
			
			p = x.getProdotto();
			p.setQuantità(p.getQuantità() - x.getQuantita());
			ordDAO.doSaveOrUpdate(ord);
			
			p.setAcquistato(p.getAcquistato()+ord.getQuantitaArt());
			
			DAOpc.doDelete(new ProdottoInCarrello(code, username, 0));
			
			cart.remove(code);
			prodDAO.doSaveOrUpdate(p);
			response.sendRedirect("Storico.jsp");
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
