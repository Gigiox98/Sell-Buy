package Controller;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import Model.Prodotto;
import Model.ProdottoDAO;

/**
 * Servlet implementation class Vendi
 */
@WebServlet("/Vendi")
@MultipartConfig
public class Vendi extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Vendi() 
    {
    	super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
				String codice="";
				String alpha="123456789";
				for(int i=0; i<10; i++)
				{
					Random r=new Random();
					int j=r.nextInt(9);
					codice=codice+alpha.charAt(j);
				}
				
				HttpSession session = request.getSession();
				String user = (String) session.getAttribute("username");
				
				String nome=request.getParameter("nome");
				String pre=request.getParameter("prezzo");
				double prezzo=Double.parseDouble(pre);
				String q=request.getParameter("quantità");
				int quantità=Integer.parseInt(q);
				String località = request.getParameter("località");
				String descrizione = request.getParameter("descrizione");
				String categoria = request.getParameter("categoria");
				String pathImmagine;
				GregorianCalendar c = new GregorianCalendar();
				
				try{
					  Part uploadedFile = request.getPart("immagine"); // Retrieves <input type="file" name="uploadedFile">
					  InputStream content = uploadedFile.getInputStream();
					  
					  pathImmagine = "C:/Users/carmi/OneDrive/Desktop/TSW-workspace/Sell&Buy2/WebContent/Immagini/prodotti/"+codice+".jpg";
					  String path2 = pathImmagine.trim();
					  System.out.println(pathImmagine);
					  Files.copy(content, Paths.get(pathImmagine));
					  File file = new File(pathImmagine);
					  
					  System.out.println("File Saved Successfully");
					  String date= "" + c.get(Calendar.DAY_OF_MONTH)  + "/" + (c.get(Calendar.MONTH)+1) + "/" + c.get(Calendar.YEAR);
					  
					  Prodotto p= new Prodotto(codice,nome,quantità,prezzo,descrizione,località, date ,"Usato",path2,user, categoria);
					  ProdottoDAO dao = new ProdottoDAO();
					  
					  dao.doSave(p);
					  response.sendRedirect("HomePage.jsp");
				  }
				  catch(Exception ex){
				   ex.printStackTrace();
				  System.out.println("can't save");
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