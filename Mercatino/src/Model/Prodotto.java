package Model;

public class Prodotto 
{
	private String codice;
	private int quantità;
	private double prezzo;
	private String descrizione;
	private String località;
	private String data_ins;
	private String stato;
	private String cod_venditore;
	private String cod_categoria;
	private String immagine;  
		
	
	public Prodotto(String codice, int quantità, double prezzo, String descrizione, String località,
			String data_ins, String stato, String cod_venditore, String cod_categoria,String immagine) {
		this.codice = codice;
		this.quantità = quantità;
		this.prezzo = prezzo;
		this.descrizione = descrizione;
		this.località = località;
		this.data_ins = data_ins;
		this.stato = stato;
		this.cod_venditore = cod_venditore;
		this.cod_categoria = cod_categoria;
		this.immagine=immagine;
	}

	public String getImmagine() {
		return immagine;
	}

	public void setImmagine(String immagine) {
		this.immagine = immagine;
	}

	public String getCod_venditore() {
		return cod_venditore;
	}

	public void setCod_venditore(String cod_venditore) {
		this.cod_venditore = cod_venditore;
	}

	public String getCod_categoria() {
		return cod_categoria;
	}

	public void setCod_categoria(String cod_categoria) {
		this.cod_categoria = cod_categoria;
	}

	public String getCodice() {
		return codice;
	}
	public void setCodice(String codice) {
		this.codice = codice;
	}
	public int getQuantità() {
		return quantità;
	}
	public void setQuantità(int quantità) {
		this.quantità = quantità;
	}
	public double getPrezzo() {
		return prezzo;
	}
	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}
	public String getDescrizione() {
		return descrizione;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	public String getLocalità() {
		return località;
	}
	public void setLocalità(String località) {
		this.località = località;
	}
	public String getData_ins() {
		return data_ins;
	}
	public void setData_ins(String data_ins) {
		this.data_ins = data_ins;
	}
	public String getStato() {
		return stato;
	}
	public void setStato(String stato) {
		this.stato = stato;
	}
	
	
}
