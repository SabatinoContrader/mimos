package com.mimosSpring.mimos.model;



import java.sql.Time;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "orario")
public class OrarioEntity {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id_orario")
	private int idOrario;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_dottore")
	private UtenteEntity dottore;
	
	@Column
	private int giorno;
	
	@Column(name="ora_inizio")
	private Time oraInizio;

	@Column(name="ora_fine")
	private Time oraFine;
	
	@Column(name="max_visita")
	private int maxVisita;
}
