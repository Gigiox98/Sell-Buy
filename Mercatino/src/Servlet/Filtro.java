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

import Model.Prodotto;
import Model.ProdottoDAO;

/**
 * Servlet implementation class Filtro
 */
@WebServlet("/Filtro")
public class Filtro extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Filtro() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String nome=request.getParameter("nome");
		String stato=request.getParameter("usato");
		String stato2=request.getParameter("nuovo");
		String categoria=request.getParameter("categoria");
		String prezzo=request.getParameter("prezzo");
		String località=request.getParameter("località");
		ProdottoDAO p=new ProdottoDAO();
		try 
		{
			ArrayList<Prodotto> list=p.doRetriveByAll();
			ArrayList<Prodotto> result=new ArrayList<Prodotto>();
			ArrayList<Prodotto> result2=new ArrayList<Prodotto>();
			ArrayList<Prodotto> result3=new ArrayList<Prodotto>();
			ArrayList<Prodotto> result4=new ArrayList<Prodotto>();
			
			if(nome==null && stato!=null || stato2!=null && categoria==null && prezzo==null && località==null)
			{
				if(stato!=null && stato2==null)
				result4=p.doRetriveByCond("stato='usato'");
				if(stato==null && stato2!=null)
				result4=p.doRetriveByCond("stato='nuovo'");
				if(stato==null || stato2==null)
				result4=p.doRetriveByCond("stato='nuovo' or stato='usato'");
				request.setAttribute("prodotti",result4);
				RequestDispatcher view=request.getRequestDispatcher("Filtro.jsp");
				view.forward(request, response);
			}
			
			if(nome!=null || stato!=null || stato2!=null || categoria!=null || prezzo!=null || località!=null)
			{
				for(int i=0; i<list.size(); i++)
				{
					if(nome!=null)
					{
						if(list.get(i).getNome().contains(nome) || list.get(i).getDescrizione().contains(nome))
						{
							if(stato!=null && stato2!=null)
							{
								if(list.get(i).getStato()=="usato" || list.get(i).getStato()=="nuovo")
								{
									if(categoria!=null)
									{
										if(list.get(i).getCod_categoria().contains(categoria))
										{
											if(prezzo!=null)
											{
												double price=Double.parseDouble(prezzo);
												if(price<=list.get(i).getPrezzo())
												{
													if(località!=null)
													{
														if(list.get(i).getLocalità().contains(località))
														{
															result.add(list.get(i));
														}
													}
												}
											}
										}
									}
								}
							}
							else if(stato==null && stato2!=null)
							{
								if(list.get(i).getStato()=="nuovo")
								{
									if(categoria!=null)
									{
										if(list.get(i).getCod_categoria().contains(categoria))
										{
											if(prezzo!=null)
											{
												double price=Double.parseDouble(prezzo);
												if(price<=list.get(i).getPrezzo())
												{
													if(località!=null)
													{
														if(list.get(i).getLocalità().contains(località))
														{
															result.add(list.get(i));
														}
													}
												}
											}
										}
									}
								}
							}
							else if(stato!=null && stato2==null)
							{
								if(list.get(i).getStato()=="usato")
								{
									if(categoria!=null)
									{
										if(list.get(i).getCod_categoria().contains(categoria))
										{
											if(prezzo!=null)
											{
												double price=Double.parseDouble(prezzo);
												if(price<=list.get(i).getPrezzo())
												{
													if(località!=null)
													{
														if(list.get(i).getLocalità().contains(località))
														{
															result.add(list.get(i));
														}
													}
												}
											}
										}
									}
								}
							}
						}
						else if(stato==null && stato2==null)
						{
								if(categoria!=null)
								{
									if(list.get(i).getCod_categoria().contains(categoria))
									{
										if(prezzo!=null)
										{
											double price=Double.parseDouble(prezzo);
											if(price<=list.get(i).getPrezzo())
											{
												if(località!=null)
												{
													if(list.get(i).getLocalità().contains(località))
													{
														result.add(list.get(i));
													}
												}
											}
										}
									}
								}
						}
					}
				}
				
				for(int i=0; i<result.size(); i++)
				{
					if(categoria!=null)
					{
						if(result.get(i).getCod_categoria().contains(categoria))
						{
								if(stato!=null && stato2!=null)
								{
									if(result.get(i).getStato()=="usato" || result.get(i).getStato()=="nuovo")
									{
										if(result.get(i).getNome().contains(nome) || result.get(i).getDescrizione().contains(nome))
										{
											if(prezzo!=null)
											{
												double price=Double.parseDouble(prezzo);
												if(price<=result.get(i).getPrezzo())
												{
													if(località!=null)
													{
														if(result.get(i).getLocalità().contains(località))
														{
															result2.add(result.get(i));
														}
													}
												}
											}
										}
									}
								}
							else if(stato==null && stato2!=null)
							{
								if(result.get(i).getStato()=="nuovo")
								{
									if(result.get(i).getNome().contains(nome) || result.get(i).getDescrizione().contains(nome))
									{
										if(prezzo!=null)
										{
											double price=Double.parseDouble(prezzo);
											if(price<=result.get(i).getPrezzo())
											{
												if(località!=null)
												{
													if(result.get(i).getLocalità().contains(località))
													{
														result2.add(result.get(i));
													}
												}
											}
										}
									}
								}
							}
							else if(stato!=null && stato2==null)
							{
								if(result.get(i).getStato()=="usato")
								{
									if(result.get(i).getNome().contains(nome) || result.get(i).getDescrizione().contains(nome))
									{
										if(prezzo!=null)
										{
											double price=Double.parseDouble(prezzo);
											if(price<=result.get(i).getPrezzo())
											{
												if(località!=null)
												{
													if(result.get(i).getLocalità().contains(località))
													{
														result2.add(result.get(i));
													}
												}
											}
										}
									}
								}
							}
							else if(stato==null && stato2==null)
							{
								if(result.get(i).getNome().contains(nome) || result.get(i).getDescrizione().contains(nome))
								{
									if(prezzo!=null)
									{
										double price=Double.parseDouble(prezzo);
										if(price<=result.get(i).getPrezzo())
										{
											if(località!=null)
											{
												if(result.get(i).getLocalità().contains(località))
												{
													result2.add(result.get(i));
												}
											}
										}
									}
								}
							}
						}
					}
				}
				for(int i=0; i<result2.size(); i++)
				{
					if(prezzo!=null)
					{
						double price=Double.parseDouble(prezzo);
						if(price<=result2.get(i).getPrezzo())
						{
								if(stato!=null && stato2!=null)
								{
										if(result2.get(i).getStato()=="usato" || result2.get(i).getStato()=="nuovo")
										{
											if(result2.get(i).getNome().contains(nome) || result2.get(i).getDescrizione().contains(nome))
											{
												if(categoria!=null)
												{
													if(result2.get(i).getCod_categoria().contains(categoria))
													{
											
														if(località!=null)
														{
															if(result2.get(i).getLocalità().contains(località))
															{
																result3.add(result2.get(i));
															}
														}
													}
												}
											}
										}
								}
							else if(stato==null && stato2!=null)
							{
								if(result2.get(i).getStato()=="nuovo")
								{
									if(result2.get(i).getNome().contains(nome) || result2.get(i).getDescrizione().contains(nome))
									{
										if(categoria!=null)
										{
											if(result2.get(i).getCod_categoria().contains(categoria))
											{
									
												if(località!=null)
												{
													if(result2.get(i).getLocalità().contains(località))
													{
														result3.add(result2.get(i));
													}
												}
											}
										}
									}
								}
							}
							else if(stato!=null && stato2==null)
							{
								if(result2.get(i).getStato()=="usato")
								{
									if(result2.get(i).getNome().contains(nome) || result2.get(i).getDescrizione().contains(nome))
									{
										if(categoria!=null)
										{
											if(result2.get(i).getCod_categoria().contains(categoria))
											{
									
												if(località!=null)
												{
													if(result2.get(i).getLocalità().contains(località))
													{
														result3.add(result2.get(i));
													}
												}
											}
										}
									}
								}
							}
							else if(stato==null && stato2==null)
							{
								if(result2.get(i).getNome().contains(nome) || result2.get(i).getDescrizione().contains(nome))
								{
									if(categoria!=null)
									{
										if(result2.get(i).getCod_categoria().contains(categoria))
										{
								
											if(località!=null)
											{
												if(result2.get(i).getLocalità().contains(località))
												{
													result3.add(result2.get(i));
												}
											}
										}
									}
								}
							}
						}
					}
				}
				
				for(int i=0; i<result3.size(); i++)
				{
					if(località!=null)
					{
						if(result3.get(i).getLocalità().contains(località))
						{
							if(stato!=null && stato2!=null)
							{
								if(result3.get(i).getStato()=="usato" || result3.get(i).getStato()=="nuovo")
								{
									
									if(result3.get(i).getNome().contains(nome) || result3.get(i).getDescrizione().contains(nome))
									{
										if(categoria!=null)
										{
											if(result3.get(i).getCod_categoria().contains(categoria))
											{
												if(prezzo!=null)
												{
													double price=Double.parseDouble(prezzo);
													if(price<=result3.get(i).getPrezzo())
													{
															result4.add(result3.get(i));
													}
												}
											}
										}
									}
								}
							}
							else if(stato==null && stato2!=null)
							{
								if(result3.get(i).getStato()=="nuovo")
								{
									if(result3.get(i).getNome().contains(nome) || result3.get(i).getDescrizione().contains(nome))
									{
										if(categoria!=null)
										{
											if(result3.get(i).getCod_categoria().contains(categoria))
											{
												if(prezzo!=null)
												{
													double price=Double.parseDouble(prezzo);
													if(price<=result3.get(i).getPrezzo())
													{
															result4.add(result3.get(i));
													}
												}
											}
										}
									}
								}
							}
							else if(stato!=null && stato2==null)
							{
								if(result3.get(i).getStato()=="usato")
								{

									if(result3.get(i).getNome().contains(nome) || result3.get(i).getDescrizione().contains(nome))
									{
										if(categoria!=null)
										{
											if(result3.get(i).getCod_categoria().contains(categoria))
											{
												if(prezzo!=null)
												{
													double price=Double.parseDouble(prezzo);
													if(price<=result3.get(i).getPrezzo())
													{
															result4.add(result3.get(i));
													}
												}
											}
										}
									}
								}
							}
							else if(stato==null && stato2==null)
							{

								if(result3.get(i).getNome().contains(nome) || result3.get(i).getDescrizione().contains(nome))
								{
									if(categoria!=null)
									{
										if(result3.get(i).getCod_categoria().contains(categoria))
										{
											if(prezzo!=null)
											{
												double price=Double.parseDouble(prezzo);
												if(price<=result3.get(i).getPrezzo())
												{
														result4.add(result3.get(i));
												}
											}
										}
									}
								}
							}
						}
					}
				}
				
				request.setAttribute("prodotti",result4);
				RequestDispatcher view=request.getRequestDispatcher("Filtro.jsp");
				view.forward(request, response);
			}
			
			else 
			{
				request.setAttribute("prodotti",list);
				RequestDispatcher view=request.getRequestDispatcher("Filtro.jsp");
				view.forward(request, response);
			}
		} 
		
		catch (SQLException e) 
		{
			e.printStackTrace();
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
