package com.mimosSpring.mimos.DAO;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.mimosSpring.mimos.model.UtenteEntity;

public interface UtenteRepository extends CrudRepository<UtenteEntity, Long> {
	
    long count();

    List<UtenteEntity> findAll();

    @SuppressWarnings("unchecked")
	UtenteEntity save(UtenteEntity utenteEntity);

	void delete(UtenteEntity utenteEntity);

    UtenteEntity findByIdUtente(int idUtente);
    
    UtenteEntity findByUsername(String username);
    
    int findIdUtenteByUsername(String username);

    int findIdRuoloByUsername(String username); 
    
    List<UtenteEntity> findByCitta(String citta);
    
    List<UtenteEntity> findAllByIdSpecialita(int idSpecialita);
    
    List<UtenteEntity> findAllByNomeSpecialita(String nomeSpecialita);
}
