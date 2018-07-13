package com.virtualpairprogrammers.model;

public final class Dottore {

	private int id_utente, id_specialita;
	
	public Dottore() {

	}
	
	public Dottore(int id_utente, int id_specialita) {
		this.setId_utente(id_utente);
		this.setId_specialita(id_specialita);
	}

	public int getId_specialita() {
		return id_specialita;
	}

	public void setId_specialita(int id_specialita) {
		this.id_specialita = id_specialita;
	}

	public int getId_utente() {
		return id_utente;
	}

	public void setId_utente(int id_utente) {
		this.id_utente = id_utente;
	}

}
