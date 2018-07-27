package com.mimosSpring.mimos.DAO;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mimosSpring.mimos.model.UtenteEntity;
import com.mimosSpring.mimos.model.VisitaEntity;

@Repository
@Transactional
public interface VisitaRepository extends CrudRepository<VisitaEntity, Integer> {
	
   
    List<VisitaEntity> findAllByPaziente(UtenteEntity paziente);
    List<VisitaEntity> findAllByPazienteAndStato(UtenteEntity paziente, int stato);
    List<VisitaEntity> findAllByDottore(UtenteEntity dottore);
    List<VisitaEntity> findAllByDottoreAndStato(UtenteEntity dottore, int stato);

    @SuppressWarnings("unchecked")
    VisitaEntity save(VisitaEntity visitaEntity);

    void delete(VisitaEntity visitaEntity);

}
