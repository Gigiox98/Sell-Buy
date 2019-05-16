package Model;

public class Utente
{
	private String nome;
	private String cognome;
	private String password;
	private String via;
	private int n_civico;
	private String città;
	private String username;
	private String email;
	private short admin_flag;
	
	public Utente(String nome, String cognome, String password, String via, int n_civico, String città,
			String username, String email, short admin_flag) 
	{
		this.nome = nome;
		this.cognome = cognome;
		this.password = password;
		this.via = via;
		this.n_civico = n_civico;
		this.città = città;
		this.username = username;
		this.email = email;
		this.admin_flag = admin_flag;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getVia() {
		return via;
	}

	public void setVia(String via) {
		this.via = via;
	}

	public int getN_civico() {
		return n_civico;
	}

	public void setN_civico(int n_civico) {
		this.n_civico = n_civico;
	}

	public String getCittà() {
		return città;
	}

	public void setCittà(String città) {
		this.città = città;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public short getAdmin_flag() {
		return admin_flag;
	}

	public void setAdmin_flag(short admin_flag) {
		this.admin_flag = admin_flag;
	}
	
	
	
	
}