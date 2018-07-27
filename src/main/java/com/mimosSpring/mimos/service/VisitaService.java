package com.mimosSpring.mimos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mimosSpring.mimos.DAO.MisuraRepository;
import com.mimosSpring.mimos.DAO.VisitaRepository;
import com.mimosSpring.mimos.model.UtenteEntity;
import com.mimosSpring.mimos.model.VisitaEntity;

@Service
public class VisitaService {
	

	private VisitaRepository visitaRepository;
	
    @Autowired
    public VisitaService(VisitaRepository visitaRepository) {
        this.visitaRepository = visitaRepository;
    }
    
    @SuppressWarnings("unchecked")
	public VisitaEntity save(VisitaEntity visitaEntity) {
	    return visitaRepository.save(visitaEntity);
	}
    	
	public List<VisitaEntity> findAllByPaziente(UtenteEntity paziente){
		return visitaRepository.findAllByPaziente(paziente);
	}
	    
	public List<VisitaEntity> findAllByPazienteAndStato(UtenteEntity paziente, int stato){
		return visitaRepository.findAllByPazienteAndStato(paziente, stato);
	}
	
	public List<VisitaEntity> findAllByDottore(UtenteEntity dottore){
		return visitaRepository.findAllByDottore(dottore);
	}
	
	public List<VisitaEntity> findAllByDottoreAndStato(UtenteEntity dottore, int stato){
		return visitaRepository.findAllByDottoreAndStato(dottore, stato);
	}

	public void delete(VisitaEntity visitaEntity) {
		visitaRepository.delete(visitaEntity);
	}
}
