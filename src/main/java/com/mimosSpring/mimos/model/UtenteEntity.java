package com.mimosSpring.mimos.model;

import java.io.Serializable;
import java.sql.Date;
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
@Table(name = "utente")
public class UtenteEntity implements Serializable {


    /**
	 * 
	 */
	private static final long serialVersionUID = 5844994165384360679L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_utente")
	private int idUtente;
    
    @Column
	private int idRuolo;
    
    @Column
	private String nome;
    
    @Column
	private String cognome;
    
    @Column
	private String codiceFiscale;
    
    @Column
	private Date dataNascita;
    
    @Column
	private String username;
    
    @Column
	private String password;
    
    @Column
	private String citta;

    @ManyToMany(cascade = { CascadeType.ALL }, fetch=FetchType.EAGER)
    @JoinTable(
        name = "dottore_specialita", 
        joinColumns = { @JoinColumn(name = "id_utente") }, 
        inverseJoinColumns = { @JoinColumn(name = "id_specialita") }
    )
    private Set<SpecialitaEntity> specialita = new HashSet<SpecialitaEntity>();

}
