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
	@Column(name = "id_specialita")
	private int idSpecialita;

	@Column
	private String nome;

	@Column
	private String descrizione;

    @ManyToMany(mappedBy = "specialita")
    private Set<UtenteEntity> utente = new HashSet<>();

}
