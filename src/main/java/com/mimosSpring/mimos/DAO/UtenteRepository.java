package com.mimosSpring.mimos.DAO;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
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

	int deleteByUsername(String username);

	int deleteByIdUtente(int idUtente);

    UtenteEntity findByIdUtente(int idUtente);
    
    UtenteEntity findByUsername(String username);

    //giusto per conoscenza
    //le query standard devono lavorare solo con la restituzione del tipo
    //le querycome questa hanno bisogno di usare come nella classe java
    //il nome della classe e il nome degli attributi
    //quindi non pensare in SQL ma in JAVA!!!!!!!!!!
    @Query("SELECT u.idUtente FROM UtenteEntity u where u.username = :username") 
    int findIdUtenteByUsername(@Param("username") String username);
    
    //int findIdUtenteByUsername(String username);
    
    @Query("SELECT u.idRuolo FROM UtenteEntity u where u.username = :username") 
    int findIdRuoloByUsername(@Param("username") String username);
    
    //int findIdRuoloByUsername(String username); 
    
    List<UtenteEntity> findByCitta(String citta);
    
    List<UtenteEntity> findByIdRuolo(int ruolo);

	UtenteEntity findByUsernameAndPassword(String username, String password);
    
    //List<UtenteEntity> findAllByIdSpecialita(int idSpecialita);
    
    //void setByIdSpecialita(int idSpecialita);
}
