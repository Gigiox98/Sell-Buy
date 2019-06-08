package Model;

public class ProdottoInCarrello {
	String username;
	String prodotto;
	int quantità;
	
	public ProdottoInCarrello(String prodotto, String username, int quantità) {
		super();
		this.username = username;
		this.prodotto = prodotto;
		this.quantità = quantità;
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

	public int getQuantità() {
		return quantità;
	}

	public void setQuantità(int quantità) {
		this.quantità = quantità;
	}
	
	

}
