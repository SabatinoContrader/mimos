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
    @Column(name="id_utente", unique=true, nullable=false)
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

    
    /*
     * direi che è dall'utente che va fatto il cascade perché
     * al dottore posso aggiungere specialita
     * quindi persist per la persistenza del dato
     * e dato che il servizio di popolamento sarà solo in utente
     * allora facciamo un bel merging
     */
    @ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE },
    		fetch=FetchType.LAZY)
    @JoinTable(
        name = "dottore_specialita", 
        joinColumns = { @JoinColumn(name = "id_utente") }, 
        inverseJoinColumns = { @JoinColumn(name = "id_specialita") }
    )
    
    /*
     * Set fa parte anche delle librerie di hibernate
     * Ora uso le utils ma non so se va bene
     */
    
    public Set<SpecialitaEntity> specialita = new HashSet<SpecialitaEntity>();

}
