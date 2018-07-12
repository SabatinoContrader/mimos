package com.virtualpairprogrammers.model;

import java.util.Date;

public class Dottore {
	

    private int id_utente;
    private int id_ruolo;
    private String nome;
    private String cognome;
    private String codice_fiscale;
    private Date data_nascita;
    private String username;
    private String password;
    //dati tavele dottore
    private String specialita;
    private String cita;

    public Dottore(int id_utente, int id_ruolo, String nome, String cognome, String codice_fiscale, Date data_nascita, String username, String password, String specialita, String cita) {
    this.setId_utente(id_utente);
    this.setId_ruolo(id_ruolo);
    this.setNome(nome);
    this.setCognome(cognome);
    this.setCodice_fiscale(codice_fiscale);
    this.setData_nascita(data_nascita);
    this.setUsername(username);
    this.setPassword(password);
    //dati tavele dottore
    this.setSpecialita(specialita);
    this.setCita(cita);
    }

	public Dottore() {
		// TODO Auto-generated constructor stub
	}

	public int getId_utente() {
		return id_utente;
	}

	public void setId_utente(int id_utente) {
		this.id_utente = id_utente;
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

	public String getCodice_fiscale() {
		return codice_fiscale;
	}

	public void setCodice_fiscale(String codice_fiscale) {
		this.codice_fiscale = codice_fiscale;
	}

	public Date getData_nascita() {
		return data_nascita;
	}

	public void setData_nascita(Date data_nascita) {
		this.data_nascita = data_nascita;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSpecialita() {
		return specialita;
	}

	public void setSpecialita(String specialita) {
		this.specialita = specialita;
	}

	public String getCita() {
		return cita;
	}

	public void setCita(String cita) {
		this.cita = cita;
	}

}
