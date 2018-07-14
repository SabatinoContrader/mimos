package com.virtualpairprogrammers.services;
import com.virtualpairprogrammers.dao.MisuraDAO;
import com.virtualpairprogrammers.model.Misura;
import java.util.List;


public class MisuraService {

	    private MisuraDAO misuraDAO;

	    public MisuraService() {
	        this.misuraDAO = new MisuraDAO();
	    }

	    public List<Misura> getAllMisura (int id_paziente) {
	        return this.misuraDAO.getAllMisura(id_paziente);
	    }

	    public boolean insertMisura (Misura misura) {
	        return this.misuraDAO.insertMisura(misura);
	    }
	    
	    public Misura getMisura (Misura misura) {
	        return this.misuraDAO.getMisura(misura.getId_misura());
	    }
}
