package com.mimosSpring.mimos.DAO;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mimosSpring.mimos.model.SpecialitaEntity;

@Repository
@Transactional
public interface SpecialitaRepository extends CrudRepository<SpecialitaEntity, Long> {
	
    long count();

    List<SpecialitaEntity> findAll();

    SpecialitaEntity findByNomeSpecialita(String nomeSpecialita);

    @SuppressWarnings("unchecked")
    SpecialitaEntity save(SpecialitaEntity specialitaEntity);

	void delete(SpecialitaEntity specialitaEntity);

	void deleteByIdSpecialita(int idSpecialita);

	void deleteByNomeSpecialita(String nomeSpecialita);

	SpecialitaEntity findByIdSpecialita(int idSpecialita);
    
    int findIdSpecialitaByNomeSpecialita(String nomeSpecialita);

    int findDescrizioneSpecialitaByIdSpecialita(int idSpecialita); 
    
    //List<SpecialitaEntity> findAllByIdUtente(int idUtente);
    
    //List<SpecialitaEntity> findAllByUsername(String username);
    
}
