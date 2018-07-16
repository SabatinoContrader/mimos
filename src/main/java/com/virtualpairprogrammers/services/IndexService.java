package com.virtualpairprogrammers.services;

import com.virtualpairprogrammers.dao.UtenteDAO;
import com.virtualpairprogrammers.model.Utente;

public class IndexService {

	private UtenteDAO utenteDAO;

	public IndexService() {
		this.utenteDAO = new UtenteDAO();
	}

	public boolean login(String username, String password) {
		return utenteDAO.verifyEntry(username, password);
	}

	public boolean register(Utente utente) {
		return utenteDAO.insertUser(utente);
	}

	public int getRole(String username) {
		return utenteDAO.getUserRole(username);
	}
	
	public int getIdByNick(String username) {
		return utenteDAO.getIdByNick(username);
	}
}

