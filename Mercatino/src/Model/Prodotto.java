package Model;

public class Prodotto 
{
	private String codice;
	private String nome;
	private int quantit�;
	private double prezzo;
	private String descrizione;
	private String localit�;
	private String data_ins;
	private String stato;
	private String cod_venditore;
	private String cod_categoria;
	private String immagine;  
	private int acquistato;	
	private boolean flag_sconto;
	
	public Prodotto(String codice, String nome,  int quantit�, double prezzo, String descrizione, String localit�,
			String data_ins, String stato, String cod_venditore, String cod_categoria,String immagine, int acquistato, boolean flag_sconto) {
		this.codice = codice;
		this.nome = nome;
		this.quantit� = quantit�;
		this.prezzo = prezzo;
		this.descrizione = descrizione;
		this.localit� = localit�;
		this.data_ins = data_ins;
		this.stato = stato;
		this.cod_venditore = cod_venditore;
		this.cod_categoria = cod_categoria;
		this.immagine=immagine;
		this.acquistato = acquistato;
		this.flag_sconto = flag_sconto;
	}

	public int getAcquistato() {
		return acquistato;
	}

	public void setAcquistato(int acquistato) {
		this.acquistato = acquistato;
	}

	public String getImmagine() {
		return immagine;
	}

	public void setImmagine(String immagine) {
		this.immagine = immagine;
	}
	
	

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
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
	public int getQuantit�() {
		return quantit�;
	}
	public void setQuantit�(int quantit�) {
		this.quantit� = quantit�;
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
	public String getLocalit�() {
		return localit�;
	}
	public void setLocalit�(String localit�) {
		this.localit� = localit�;
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

	public boolean isFlag_sconto() {
		return flag_sconto;
	}

	public void setFlag_sconto(boolean flag_sconto) {
		this.flag_sconto = flag_sconto;
	}
	
	
	
	
}