package Model;

public class ProdottoInCarrello {
	String username;
	String prodotto;
	int quantit�;
	
	public ProdottoInCarrello(String prodotto, String username, int quantit�) {
		super();
		this.username = username;
		this.prodotto = prodotto;
		this.quantit� = quantit�;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getProdotto() {
		return prodotto;
	}

	public void setProdotto(String prodotto) {
		this.prodotto = prodotto;
	}

	public int getQuantit�() {
		return quantit�;
	}

	public void setQuantit�(int quantit�) {
		this.quantit� = quantit�;
	}
	
	

}
