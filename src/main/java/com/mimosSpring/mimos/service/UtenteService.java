package com.mimosSpring.mimos.service;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mimosSpring.mimos.DAO.SpecialitaRepository;
import com.mimosSpring.mimos.DAO.UtenteRepository;
import com.mimosSpring.mimos.model.SpecialitaEntity;
import com.mimosSpring.mimos.model.UtenteEntity;
import com.mimosSpring.mimos.util.HibernateUtil;
import java.util.List;
import java.util.Set;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

@Service
public class UtenteService {

	// l'estensione della libreria utils di H2 � presa da un altro progetto
	Session session = null;
	Transaction transaction = null;

	private UtenteRepository utenteRepository;
	private SpecialitaRepository specialitaRepository;

	@Autowired
	public UtenteService(UtenteRepository utenteRepository) {
		this.utenteRepository = utenteRepository;
		this.specialitaRepository = null;
	}
	

	public UtenteService(UtenteRepository utenteRepository, SpecialitaRepository specialitaRepository) {
		this.utenteRepository = utenteRepository;
		this.specialitaRepository = specialitaRepository;
		this.session = HibernateUtil.getSessionFactory().openSession();
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

	public long findIdRuoloByUsername(String username) {
		return this.utenteRepository.findIdRuoloByUsername(username);
	}

	public int findIdUtenteByUsername(String username) {
		return this.utenteRepository.findIdUtenteByUsername(username);
	}

	public List<UtenteEntity> findAll() {
		return this.utenteRepository.findAll();
	}
	
	// >>>>Salvatore
	public List<UtenteEntity> findByIdRuolo(int ruolo) {
		return this.utenteRepository.findByIdRuolo(ruolo);
	}
	// <<<<Salvatore
	

	public UtenteEntity findByIdUtente(int idUtente) {
		return this.utenteRepository.findByIdUtente(idUtente);
	}

	public UtenteEntity findByUsername(String username) {
		return this.utenteRepository.findByUsername(username);
	}

	public UtenteEntity findByUsernameAndPassword(String username, String password) {
		return this.utenteRepository.findByUsernameAndPassword(username, password);
	}

	public List<UtenteEntity> findByCitta(String citta) {
		return this.utenteRepository.findByCitta(citta);
	}

	public boolean addSpecialitaToDottore(int idSpecialita, int idUtente) {
		if (this.specialitaRepository != null) {
			try {
				transaction = session.beginTransaction();
				transaction.begin();
				UtenteEntity tUtente = (UtenteEntity) session.get(UtenteEntity.class, idUtente);
				SpecialitaEntity tSpecialita = (SpecialitaEntity) session.get(SpecialitaEntity.class, idSpecialita);
				tUtente.specialita.add(tSpecialita);
				session.save(tUtente);
				transaction.commit();
				return true;
			} catch (Exception e) {
				transaction.rollback();
				e.printStackTrace();
				return false;
			} finally {
				/*
				 * la finally viene eseguita a prescindere falla cattura dell'errore fa parte
				 * delle buone pratiche
				 */
				session.close();
			}
		}
		return false;
	}

	public boolean removeSpecialitaToDottore(int idSpecialita, int idUtente) {
		if (this.specialitaRepository != null) {
			try {
				transaction = session.beginTransaction();
				// il begin non so se � giusto
				transaction.begin();
				UtenteEntity tUtente = (UtenteEntity) session.get(UtenteEntity.class, idUtente);
				SpecialitaEntity tSpecialita = (SpecialitaEntity) session.get(SpecialitaEntity.class, idSpecialita);
				tUtente.specialita.remove(tSpecialita);
				session.save(tUtente);
				transaction.commit();
				return true;
			} catch (Exception e) {
				transaction.rollback();
				e.printStackTrace();
				return false;
			} finally {
				session.close();
			}
		}
		return false;
	}

	public Set<SpecialitaEntity> getDottoreWithSpecialitas(int idUtente) throws RuntimeException {
		/*
		 * try {
		 * HibernateUtil.getSessionFactory().getCurrentSession().beginTransaction();
		 * Deprecated dalla 5.2 in poi Criteria c =
		 * session.createCriteria(UtenteEntity.class) .addOrder(Order.asc("studentId"))
		 * .createCriteria("TClasses", Criteria.LEFT_JOIN)
		 * .addOrder(Order.asc("classId"))
		 * .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY); return c.list();
		 */
		/*
		 * // Get Criteria Builder CriteriaBuilder builder =
		 * session.getCriteriaBuilder();
		 * 
		 * // Create Criteria CriteriaQuery<UtenteEntity> criteria =
		 * builder.createQuery(UtenteEntity.class); Root<UtenteEntity> contactRoot =
		 * criteria.from(UtenteEntity.class); criteria.select(contactRoot);
		 * 
		 * // Use criteria to query with session to fetch all contacts
		 * List<SpecialitaEntity> contacts =
		 * session.createQuery(criteria).getResultList();
		 * 
		 * }catch(
		 * 
		 * RuntimeException e) { transaction.rollback(); e.printStackTrace(); throw e;
		 * }finally { session.close(); }
		 */
		/*
		 * try { transaction = session.beginTransaction(); CriteriaBuilder builder =
		 * session.getCriteriaBuilder(); // Using FROM and JOIN CriteriaQuery<Object[]>
		 * criteriaQuery = builder.createQuery(Object[].class); Root<UtenteEntity>
		 * utenteRoot = criteriaQuery.from(UtenteEntity.class); Root<SpecialitaEntity>
		 * specialitaRoot = criteriaQuery.from(SpecialitaEntity.class);
		 * criteriaQuery.multiselect(utenteRoot, specialitaRoot);
		 * criteriaQuery.where(builder.equal(utenteRoot.get("department"),
		 * specialitaRoot.get("id")));
		 * 
		 * Query<Object[]> query = session.createQuery(criteriaQuery); List<Object[]>
		 * list = query.getResultList(); for (Object[] objects : list) { UtenteEntity
		 * utente = (UtenteEntity) objects[0]; SpecialitaEntity specialita =
		 * (SpecialitaEntity) objects[1]; System.out.println("EMP NAME=" +
		 * utente.toString() + "\t DEPT NAME=" + specialita.toString()); }
		 * transaction.commit(); } catch (Exception e) { e.printStackTrace(); if
		 * (transaction != null) { transaction.rollback(); } } finally {
		 * session.close(); }
		 */
		
		//i tentativi di prima sono nell'uso di Criterion di Hibernate
		//qui sotto c'� invece l'uso delle librerie javax
		//usate per l'insert nella tabella derivata senza avere entit� @ManyToMany
		if (this.specialitaRepository != null) {
			try {
				transaction = session.beginTransaction();
				transaction.begin();
				UtenteEntity tUtente = (UtenteEntity) session.get(UtenteEntity.class, idUtente);
				Set<SpecialitaEntity> tmp = tUtente.specialita;
				session.save(tUtente);
				transaction.commit();
				return tmp;
			} catch (Exception e) {
				transaction.rollback();
				e.printStackTrace();
				return null;
			} finally {
				/*
				 * la finally viene eseguita a prescindere falla cattura dell'errore fa parte
				 * delle buone pratiche
				 */
				session.close();
			}
		}
		return null;
	}

}
