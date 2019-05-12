package Model;

public class Ordine {
	private String codice;
	private String indirizzoSped;
	private String stato;
	private int quantitaArt;
	private double prezzoAcquisto;
	private String paganento;
	private String acquirente;
	private String codProd;
	private String data;

	public Ordine(String codice, String indirizzoSped, String stato, int quantitaArt, double prezzoAcquisto,
			String paganento, String acquirente, String codProd, String data) {
		super();
		this.codice = codice;
		this.indirizzoSped = indirizzoSped;
		this.stato = stato;
		this.quantitaArt = quantitaArt;
		this.prezzoAcquisto = prezzoAcquisto;
		this.paganento = paganento;
		this.acquirente = acquirente;
		this.codProd = codProd;
		this.data = data;
	}

	public String getCodice() {
		return codice;
	}

	public void setCodice(String codice) {
		this.codice = codice;
	}

	public String getIndirizzoSped() {
		return indirizzoSped;
	}

	public void setIndirizzoSped(String indirizzoSped) {
		this.indirizzoSped = indirizzoSped;
	}

	public String getStato() {
		return stato;
	}

	public void setStato(String stato) {
		this.stato = stato;
	}

	public int getQuantitaArt() {
		return quantitaArt;
	}

	public String getData() {
		return data;
	}

	public void setQuantitaArt(int quantitaArt) {
		this.quantitaArt = quantitaArt;
	}

	public double getPrezzoAcquisto() {
		return prezzoAcquisto;
	}

	public void setPrezzoAcquisto(double prezzoAcquisto) {
		this.prezzoAcquisto = prezzoAcquisto;
	}

	public String getPaganento() {
		return paganento;
	}

	public void setPaganento(String paganento) {
		this.paganento = paganento;
	}

	public String getAcquirente() {
		return acquirente;
	}

	public void setAcquirente(String acquirente) {
		this.acquirente = acquirente;
	}

	public String getCodProd() {
		return codProd;
	}

	public void setCodProd(String codProd) {
		this.codProd = codProd;
	}

	public void setData(String data) {
		this.data = data;
	}

}