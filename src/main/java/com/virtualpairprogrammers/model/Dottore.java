package com.virtualpairprogrammers.model;

import java.util.ArrayList;
import java.util.Date;

public final class Dottore extends Utente {

	private String citta;
	private ArrayList<String> specializzazioni;
	
	public Dottore(int id_utente, int id_ruolo, String nome, String cognome, String codice_fiscale, Date data_nascita,
			String username, String password, String citta, ArrayList<String> specializzazioni) {
		this.setId_utente(id_utente);
		this.setId_ruolo(id_ruolo);
		this.setUsername(username);
		this.setCodice_fiscale(codice_fiscale);
		this.setCognome(cognome);
		this.setData_nascita(data_nascita);
		this.setNome(nome);
		this.setPassword(password);
	}
	
	public Dottore() {
		
	}
	public String getCitta() {
		return citta;
	}

	public void setCitta(String citta) {
		this.citta = citta;
	}

	public ArrayList<String> getSpecializzazioni() {
		return specializzazioni;
	}

	public void setSpecializzazioni(ArrayList<String> specializzazioni) {
		this.specializzazioni = specializzazioni;
	}

	public void addSpecializzazione(String specializzazione) {
		this.specializzazioni.add(specializzazione);
	}

}
