package Model;

public class Sconto 
{
	private String codice;
	private int ammontare;
	private boolean usato;
	
	public Sconto(String codice, int ammontare, boolean utilizzato) 
	{
		this.codice = codice;
		this.ammontare = ammontare;
		this.usato = utilizzato;
	}
	
	public String getCodice() 
	{
		return codice;
	}
	public void setCodice(String codice) {
		this.codice = codice;
	}

	public int getAmmontare() {
		return ammontare;
	}

	public void setAmmontare(int ammontare) {
		this.ammontare = ammontare;
	}

	public boolean isUsato() {
		return usato;
	}

	public void setUsato(boolean usato) {
		this.usato = usato;
	}
	
}
