package Model;

public class Recensione {
	private	String codice;
	private String prodotto;
	private String utente;
	private String text;
	private int voto;
	
	
	public Recensione(String codice, String prodotto, String utente, String text, int voto) {
		this.codice = codice;
		this.prodotto = prodotto;
		this.utente = utente;
		this.text = text;
		this.voto = voto;
	}


	public String getCodice() {
		return codice;
	}


	public void setCodice(String codice) {
		this.codice = codice;
	}


	public String getProdotto() {
		return prodotto;
	}


	public void setProdotto(String prodotto) {
		this.prodotto = prodotto;
	}


	public String getUtente() {
		return utente;
	}


	public void setUtente(String utente) {
		this.utente = utente;
	}


	public String getText() {
		return text;
	}


	public void setText(String text) {
		this.text = text;
	}


	public int getVoto() {
		return voto;
	}


	public void setVoto(int voto) {
		this.voto = voto;
	}
	
	
}
