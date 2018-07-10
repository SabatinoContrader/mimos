package main.model;

public class Utente {

    private int id_utente;
    private int id_ruolo;
    private String nome;
    private String cognome;
    private String user_name;
    private String password;
    private String email;

    public Utente(int id_utente,int id_ruolo, String nome, String cognome, String user_name, String password, String email) {
        this.id_utente = id_utente; 
        this.id_ruolo = id_ruolo;
        this.nome = nome;
        this.cognome= cognome; 
        this.user_name = user_name;
        this.password = password;
        this.email = email;
    }

	public int getId_utente() {
		return id_utente;
	}

	public int getId_ruolo() {
		return id_ruolo;
	}

	public void setId_ruolo(int id_ruolo) {
		this.id_ruolo = id_ruolo;
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

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}



 
}
