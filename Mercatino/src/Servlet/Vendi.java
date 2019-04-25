package Servlet;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.Random;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import org.apache.tomcat.util.codec.binary.Base64;
import Model.Prodotto;
import Model.ProdottoDAO;

/**
 * Servlet implementation class Vendi
 */

@WebServlet(urlPatterns= {"/Vendi"},
initParams = 
{ 
})

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

    protected String generaCodice()
    {
    	String codice="";
		String alpha="123456789";
		
		for(int i=0; i<10; i++)
		{
			Random r=new Random();
			int j=r.nextInt(9);
			codice=codice+alpha.charAt(j);
		}
		return codice;
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		 		Part filePart = request.getPart("image");
		 		InputStream content=filePart.getInputStream();
	        	if (filePart != null) 
	        	{
	        			  String codice=generaCodice();
	        			  String base64Image = "";
	        			  try (FileInputStream imageInFile = (FileInputStream) content) 
	        			  {
	        			    byte imageData[] = new byte[500000];
	        			    imageInFile.read(imageData);
	        			    base64Image = Base64.encodeBase64String(imageData);
	        			  } 
	        			  
	        			  catch (FileNotFoundException e) 
	        			  {
	        			    System.out.println("Image not found" + e);
	        			  } catch (IOException ioe) {
	        			    System.out.println("Exception while reading the Image " + ioe);
	        			  }
	        
				HttpSession session=request.getSession();
				String username=(String) session.getAttribute("username");
				java.util.Date today = new java.util.Date();
				String data=today.toString();
				String nome=request.getParameter("nome");
				String pre=request.getParameter("prezzo");
				double prezzo=Double.parseDouble(pre);
				String q=request.getParameter("quantità");
				int quantità=Integer.parseInt(q);
				String località = request.getParameter("località");
				String stato=request.getParameter("stato");
				String descrizione = request.getParameter("descrizione");
				String categoria= request.getParameter("categoria");
				Prodotto p=new Prodotto(nome,codice,quantità,prezzo,descrizione,località,data,stato,username,categoria,base64Image);
				ProdottoDAO pDAO=new ProdottoDAO();
	        	
				try 
				{
					int esito=pDAO.doSave(p);
					if(esito==1)
					{
						response.sendRedirect("HomePage2.jsp");
					}
					else
					{
						response.sendError(500);
					}
				} 
				
				catch (SQLException e) 
				{
					e.printStackTrace();
				}
	        }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doGet(request, response);
	}

}
