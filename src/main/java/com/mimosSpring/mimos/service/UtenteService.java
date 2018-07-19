package com.mimosSpring.mimos.service;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mimosSpring.mimos.DAO.SpecialitaRepository;
import com.mimosSpring.mimos.DAO.UtenteRepository;
import com.mimosSpring.mimos.model.SpecialitaEntity;
import com.mimosSpring.mimos.model.UtenteEntity;
import com.mimosSpring.mimos.util.HibernateUtil;

import java.util.List;

@Service
public class UtenteService {

	Session session = null;
	Transaction transaction = null;

	private UtenteRepository utenteRepository;
	private SpecialitaRepository specialitaRepository;

	@Autowired
	public UtenteService(UtenteRepository utenteRepository) {
		this.utenteRepository = utenteRepository;
		this.specialitaRepository = null;
	}

	@Autowired
	public UtenteService(UtenteRepository utenteRepository, SpecialitaRepository specialitaRepository) {
		this.utenteRepository = utenteRepository;
		this.specialitaRepository = specialitaRepository;
		this.session = HibernateUtil.getSessionFactory().openSession();
		this.transaction = session.beginTransaction();
		this.transaction.begin();
	}

	public long countAll() {
		return this.utenteRepository.count();
	}

	public UtenteEntity save(UtenteEntity utenteEntity) {
		return this.utenteRepository.save(utenteEntity);
	}

	public void delete(UtenteEntity utenteEntity) {
		this.utenteRepository.delete(utenteEntity);
	}

	public boolean deleteByIdUtente(int idUtente) {
		return this.utenteRepository.deleteByIdUtente(idUtente);
	}

	public boolean deleteByUsername(String username) {
		return this.utenteRepository.deleteByUsername(username);
	}

	public int findIdRuoloByUsername(String username) {
		return this.utenteRepository.findIdRuoloByUsername(username);
	}

	public int findIdUtenteByUsername(String username) {
		return this.utenteRepository.findIdUtenteByUsername(username);
	}

	public List<UtenteEntity> findAll() {
		return this.utenteRepository.findAll();
	}

	public UtenteEntity findByIdUtente(int idUtente) {
		return this.utenteRepository.findByIdUtente(idUtente);
	}

	public UtenteEntity findByUsername(String username) {
		return this.utenteRepository.findByUsername(username);
	}

	public List<UtenteEntity> findByCitta(String citta) {
		return this.utenteRepository.findByCitta(citta);
	}

	/*
	public boolean addSpecialita(int idSpecialita, int idUtente) {
		if (this.specialitaRepository != null) {
			SpecialitaEntity se = this.specialitaRepository.findByIdSpecialita(idSpecialita);
			UtenteEntity ue = this.findByIdUtente(idUtente);
			ue.getClass().
		}
		return false;
	}
	*/
}
