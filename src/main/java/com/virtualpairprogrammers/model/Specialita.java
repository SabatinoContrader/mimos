package com.virtualpairprogrammers.model;

public class Specialita {

	private String nome, descrizione;
	private int id_specialita;
	
	public Specialita(String nome, String descrizione, int id_specialita) {
		this.descrizione = descrizione;
		this.nome = nome;
		this.id_specialita = id_specialita;
	}
	
	public Specialita() {
	
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getId_specialita() {
		return id_specialita;
	}

	public void setId_specialita(int id_specialita) {
		this.id_specialita = id_specialita;
	}

}
