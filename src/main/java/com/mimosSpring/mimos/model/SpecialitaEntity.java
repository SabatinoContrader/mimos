package com.mimosSpring.mimos.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "specialita")
public class SpecialitaEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4983918190881661426L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_specialita", unique=true, nullable=false)
	private int idSpecialita;

	@Column(name = "nome_specialita")
	private String nomeSpecialita;

	@Column(name = "descrizione_specialita")
	private String descrizioneSpecialita;
	
	
    @ManyToMany(mappedBy = "specialita",
    		fetch=FetchType.LAZY,
    		cascade = CascadeType.ALL)
    private Set<UtenteEntity> utente = new HashSet<UtenteEntity>();
	
}
