package com.virtualpairprogrammers.services;

import java.util.List;
import com.virtualpairprogrammers.dao.VisitaDAO;
import com.virtualpairprogrammers.model.Visita;

public class VisitaService {

	 
	private  VisitaDAO visitaDAO;
	 
	public VisitaService() {
		 this.visitaDAO = new VisitaDAO();
	}
	
	public boolean insertVisita(Visita visita) {
		return this.visitaDAO.insertVisita(visita);
	}
	
	public Visita getVisita(int id_visita) {
		return this.visitaDAO.getVisita(id_visita);
		
	}
	
	public boolean setVisita(Visita visita) {
		return this.visitaDAO.setVisita(visita);	
	}

	public boolean deleteVisita(Visita visita) {
		return this.visitaDAO.deleteVisita(visita);	
	} 
	
	public List<Visita> getAllVisita () {
		return this.visitaDAO.getAllVisita();	
	}
	
	public List<Visita> getAllVisitaPerDottore (int id_dottore_, int stato_){
		return this.visitaDAO.getAllVisitaPerDottore(id_dottore_,stato_);	
	} 

	public List<Visita> getAllVisitaPerPaziente (int id_paziente_, int stato_){
		return this.visitaDAO.getAllVisitaPerPaziente(id_paziente_,stato_);	
	}
}