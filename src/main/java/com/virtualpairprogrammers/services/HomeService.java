package com.virtualpairprogrammers.services;

import java.util.ArrayList;

import com.virtualpairprogrammers.dao.UtenteDAO;
import com.virtualpairprogrammers.model.Utente;

public class HomeService {

	private UtenteDAO utenteDAO;
	
	public HomeService() {
		utenteDAO = new UtenteDAO();
	}

	public <T> ArrayList<T> getAllMisurazioni(String username){
		
		return null;
	}
	
	public boolean insertMisurazione(String username) {
		
		return false;
	}
	
	public boolean insertCheckin(String username) {
		
		return false;
	}
	
	public Utente getSingleUser(String username) {
		
		return utenteDAO.getSingleUser(username);
	}
	
	public <T> boolean updateField(String username, String field, T newdata) {
		
		return utenteDAO.updateData(username, field, newdata);
	}
}
