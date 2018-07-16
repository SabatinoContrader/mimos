package com.virtualpairprogrammers.services;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.ArrayList;

import com.virtualpairprogrammers.dao.UtenteDAO;
import com.virtualpairprogrammers.dao.DottoreDAO;
import com.virtualpairprogrammers.dao.SpecialitaDAO;
import com.virtualpairprogrammers.model.Utente;
import com.virtualpairprogrammers.model.Dottore;
import com.virtualpairprogrammers.model.Specialita;

public class HomeService {

	private UtenteDAO utenteDAO;
	private DottoreDAO dottoreDAO;
	private SpecialitaDAO specialitaDAO;
	private Utente utente;
	private Dottore dottore;
	private Specialita specialita;
	
	public HomeService() {
		this.utenteDAO = new UtenteDAO();
		this.dottoreDAO = new DottoreDAO();
		this.specialitaDAO = new SpecialitaDAO();
		this.utente = new Utente();
		this.dottore = new Dottore();
		this.specialita = new Specialita();
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

	public int getRole(String username) {
		return utenteDAO.getUserRole(username);
	}
	
	public ArrayList<String> getDoctorSkills(String username) {
		ArrayList<Dottore> dottore = new ArrayList<>();
		ArrayList<Specialita> specialita = new ArrayList<>();
		ArrayList<String> dottore_specialita = new ArrayList<>();
		int id = utenteDAO.getIdByNick(username);
		dottore = dottoreDAO.getAllSkills(id);
		specialita = specialitaDAO.getAllSkills();
		for (Specialita s : specialita) {
			for (Dottore d : dottore) {
				int id_s = s.getId_specialita();
				int id_d = d.getId_specialita();
				if (id_s == id_d) {
					dottore_specialita.add(s.getNome());
					break;
				}
			}
		}
		return dottore_specialita;
	}
	
	public Utente getSingleUser(String username) {
		
		return utenteDAO.getSingleUser(username);
	}
	
	public <T> boolean updateField(String username, String field, T newdata) {
		
		return utenteDAO.updateData(username, field, newdata);
	}
}
