package Model;

public class Sconto 
{
	private String codice;
	private int sconto;
	
	public Sconto(String codice, int sconto) 
	{
		this.codice = codice;
		this.sconto = sconto;
	}
	
	public String getCodice() 
	{
		return codice;
	}
	public void setCodice(String codice) {
		this.codice = codice;
	}
	public int getSconto() {
		return sconto;
	}
	public void setSconto(int sconto) {
		this.sconto = sconto;
	}
	
	
	
}
