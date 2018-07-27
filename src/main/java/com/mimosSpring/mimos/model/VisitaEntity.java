package com.mimosSpring.mimos.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "visita")
public class VisitaEntity {
	   
	   @Id
	   @GeneratedValue(strategy= GenerationType.IDENTITY)
	   @Column(name="id_misura")
	   private int id_visita;
	   
	   @ManyToOne(fetch = FetchType.LAZY)
	   @JoinColumn(name = "id_paziente")
	   private UtenteEntity paziente;
	   
	   @ManyToOne(fetch = FetchType.LAZY)
	   @JoinColumn(name = "id_dottore")
	   private UtenteEntity dottore;
	
	 
	   @Column(name="data_visita")
	   private Date dataVisita;
	   
	   @Column
	   private int stato;
	   
	   @Column
	   private String descrizione;
	   
	   @Column
	   private String diagnosi;
	
}
