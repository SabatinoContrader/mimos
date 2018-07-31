package com.mimosSpring.mimos.DAO;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
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

	int deleteByIdSpecialita(int idSpecialita);

	int deleteByNomeSpecialita(String nomeSpecialita);

	SpecialitaEntity findByIdSpecialita(int idSpecialita);
    
    @Query("SELECT s.idSpecialita FROM SpecialitaEntity s where s.nomeSpecialita = :nomeSpecialita") 
    int findIdSpecialitaByNomeSpecialita(@Param("nomeSpecialita") String nomeSpecialita);

    @Query("SELECT s.descrizioneSpecialita FROM SpecialitaEntity s where s.idSpecialita = :idSpecialita") 
    String findDescrizioneSpecialitaByIdSpecialita(@Param("idSpecialita") int idSpecialita);

    @Query("SELECT s.nomeSpecialita FROM SpecialitaEntity s where s.idSpecialita = :idSpecialita") 
    String findNomeSpecialitaByIdSpecialita(@Param("idSpecialita") int idSpecialita);
    
    //List<SpecialitaEntity> findAllByIdUtente(int idUtente);
    
    //List<SpecialitaEntity> findAllByUsername(String username);
    
}
