package Servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Random;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.Prodotto;
import Model.ProdottoDAO;
import Model.Sconto;
import Model.ScontoDAO;
import Model.Utente;
import Model.UtenteDAO;

/**
 * Servlet implementation class CreaSconto
 */
@WebServlet("/CreaSconto")
public class CreaSconto extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreaSconto() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    
    protected String generaCodice() {
		String codice = "";
		String alpha = "123456789@%&/£$?ABCDEFGHILMNOPQRSTUVZ";

		for (int i = 0; i < 12; i++) {
			Random r = new Random();
			int j = r.nextInt(37);
			codice = codice + alpha.charAt(j);
		}
		return codice;
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String prodotto = request.getParameter("prodotto");
		String user = request.getParameter("user");
		UtenteDAO u=new UtenteDAO();
		Utente utente;
		
		try 
		{
			utente = u.doRetriveByKey(user);
			ProdottoDAO pDAO = new ProdottoDAO();
			ScontoDAO sDAO = new ScontoDAO();
			Sconto s;
			Prodotto p = pDAO.doRetriveByKey(prodotto);
			String codice = generaCodice();
			int ammontare = (int) ((10*p.getPrezzo())/100);
			boolean usato = false;
			s = new Sconto(codice, ammontare, usato);
			sDAO.doSaveOrUpdate(s);
			
			// Creazione di una mail session
		    Properties props = new Properties();
		    props.put("mail.smtp.port", "2525");
		    Session session = Session.getDefaultInstance(props,null);

		    // Creazione del messaggio da inviare
		    MimeMessage message = new MimeMessage(session);
		    message.setSubject("Buono sconto cliente");
		    message.setText("Complimenti "+utente.getUsername()+" hai vinto un buono sconto da poter usufruire su qualsiasi"
		    		+ "articolo di Sell&Buy "
		    		+ "Codice promozionale: "+codice);

		    // Aggiunta degli indirizzi del mittente e del destinatario
		    InternetAddress fromAddress = new InternetAddress("info@SellBuy.com");
		    InternetAddress toAddress = new InternetAddress(utente.getEmail());
		    message.setFrom(fromAddress);
		    message.setRecipient(Message.RecipientType.TO, toAddress);

		    // Invio del messaggio
		    Transport.send(message);
		    
			response.sendRedirect("ProdottiMoltoVenduti");
			
		} 
		
		catch (SQLException | MessagingException e) 
		{
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