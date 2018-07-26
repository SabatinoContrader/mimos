package com.mimosSpring.mimos.DAO;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mimosSpring.mimos.model.MisuraEntity;
import com.mimosSpring.mimos.model.UtenteEntity;

@Repository
@Transactional
public interface MisuraRepository extends CrudRepository<MisuraEntity, Integer> {
	
   
    List<MisuraEntity> findAllByUtente(UtenteEntity utente);

    @SuppressWarnings("unchecked")
    MisuraEntity save(MisuraEntity misuraEntity);


}
