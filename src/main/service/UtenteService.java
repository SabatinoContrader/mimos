package main.service;

import main.dao.UtenteDAO;
import main.model.Utente;

import java.util.List;

public class UtenteService {

    private UtenteDAO utenteDAO;

    public UtenteService() {
        this.utenteDAO = new UtenteDAO();
    }
    
    public boolean insertUtente (Utente utente) {
        return this.utenteDAO.insertUtente(utente);
    }
    
    public boolean setUtente (Utente utente) {
        return this.utenteDAO.setUtente(utente);
    }
    
    public boolean deleteUtente (Utente utente) {
        return this.utenteDAO.deleteUtente(utente);
    }
    
    public List<Utente> getAllDottore () {
        return this.utenteDAO.getAllDottore();
    }
    
    
    public List<Utente> getAllPaziente () {
        return this.utenteDAO.getAllPaziente();
    }
}

