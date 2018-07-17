package com.mimosSpring.mimos.model;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "dottore_specialita")
@IdClass(com.mimosSpring.mimos.model.DottoreEntity.Dottore_SpecialitaPK.class)
public class DottoreEntity implements Serializable {

	/*
	 * la classe non afferisce ad una tabella nel db secondo l'er questo modello
	 * corrisponde alla tabella derivata dottore_specialita le chiamate manipolano
	 * la 1-N N-1
	 * 
	 * with IdClass
	 * select d.idUtente from DottoreEntity d
	 */

	/**
	 * 
	 */
	private static final long serialVersionUID = 2719525480730622346L;

    @Id
    @Column(name="id_utente")
	private int idUtente;
    @Id
    @Column(name="id_specialita")
	private int idSpecialita;

    @ManyToOne
    @JoinColumn(name = "id_utente")
    private Set<UtenteEntity> utenteEntitySet;

    @ManyToOne
    @JoinColumn(name = "id_specialita")
    private Set<SpecialitaEntity> specialitaEntitySet;

	public class Dottore_SpecialitaPK implements Serializable {

		/**
		 * 
		 */
		private static final long serialVersionUID = 8126823474238843366L;

	    @Column(name="id_utente")
		protected int idUtente;
	    @Column(name="id_specialita")
		protected int idSpecialita;

		public Dottore_SpecialitaPK(int idUtente, int idSpecialita) {
			this.idUtente = idUtente;
			this.idSpecialita = idSpecialita;
		}
	}
}
