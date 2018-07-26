package com.mimosSpring.mimos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mimosSpring.mimos.DAO.MisuraRepository;
import com.mimosSpring.mimos.model.MisuraEntity;
import com.mimosSpring.mimos.model.UtenteEntity;

@Service
public class MisuraService {


	private MisuraRepository misuraRepository;
	
    @Autowired
    public MisuraService(MisuraRepository misuraRepository) {
        this.misuraRepository = misuraRepository;
    }

	public List<MisuraEntity> findAllByUtente(UtenteEntity utente) {
		return this.misuraRepository.findAllByUtente(utente);
	}
	
	public MisuraEntity save(MisuraEntity misuraEntity) {
		return this.misuraRepository.save(misuraEntity);
	}

	
}
