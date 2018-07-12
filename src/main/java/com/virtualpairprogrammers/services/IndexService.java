package com.virtualpairprogrammers.services;

import com.virtualpairprogrammers.dao.UtenteDAO;
import com.virtualpairprogrammers.model.Utente;

public class IndexService {

	private UtenteDAO utenteDAO;

	public IndexService() {
		this.utenteDAO = new UtenteDAO();
	}

	public boolean login(String username, String password) {
		Utente utente = utenteDAO.getByNomeUtente(username);
		if (utente == null) {
			return false;
		} else {
			if (utente.getPassword().equals(password))
				return true;
			else
				return false;
		}
	}

	public boolean register(String username, String password) {
		Utente utente = utenteDAO.getByNomeUtente(username);
		if (utente == null) {
			return false;
		} else {
			if (utente.getPassword().equals(password))
				return true;
			else
				return false;
		}
	}

}
