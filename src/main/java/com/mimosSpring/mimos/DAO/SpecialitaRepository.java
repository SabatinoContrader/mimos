package com.mimosSpring.mimos.DAO;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.mimosSpring.mimos.model.SpecialitaEntity;

import com.mimosSpring.mimos.model.UtenteEntity;;

public interface SpecialitaRepository extends CrudRepository<SpecialitaEntity, Long> {
	
    long count();

    List<SpecialitaEntity> findAll();

    SpecialitaEntity findByNomeSpecialita(String nomeSpecialita);

    @SuppressWarnings("unchecked")
    SpecialitaEntity save(SpecialitaEntity specialitaEntity);

	void delete(SpecialitaEntity specialitaEntity);

	SpecialitaEntity findByIdSpecialita(int idSpecialita);
    
    int findIdSpecialitaByNomeSpecialita(String nomeSpecialita);

    int findDescrizioneSpecialitaByIdSpecialita(int idSpecialita); 
    
    //List<SpecialitaEntity> findAllByIdUtente(int idUtente);
    
    //List<SpecialitaEntity> findAllByUsername(String username);
    
}
