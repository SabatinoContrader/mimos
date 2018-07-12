package com.virtualpairprogrammers.services;

import com.virtualpairprogrammers.dao.UserDAO;
import com.virtualpairprogrammers.model.User;

public class IndexService {

	private UserDAO userDAO;

	public IndexService() {
		this.userDAO = new UserDAO();
	}

	public boolean login(String username, String password) {
		User utente = userDAO.getByNomeUtente(username);
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
