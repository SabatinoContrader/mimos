package com.mimosSpring.mimos.DAO;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mimosSpring.mimos.model.UtenteEntity;

@Repository
@Transactional
public interface UtenteRepository extends CrudRepository<UtenteEntity, Long> {
	
    long count();

    List<UtenteEntity> findAll();

    @SuppressWarnings("unchecked")
	UtenteEntity save(UtenteEntity utenteEntity);

	void delete(UtenteEntity utenteEntity);

	boolean deleteByUsername(String username);

	boolean deleteByIdUtente(int idUtente);

    UtenteEntity findByIdUtente(int idUtente);
    
    UtenteEntity findByUsername(String username);
    
    int findIdUtenteByUsername(String username);

    int findIdRuoloByUsername(String username); 
    
    List<UtenteEntity> findByCitta(String citta);
    
    //List<UtenteEntity> findAllByIdSpecialita(int idSpecialita);
    
    //void setByIdSpecialita(int idSpecialita);
}
