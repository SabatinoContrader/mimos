package com.mimosSpring.mimos.model;

import java.io.Serializable;
import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "utente")
public class UtenteEntity implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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

}
