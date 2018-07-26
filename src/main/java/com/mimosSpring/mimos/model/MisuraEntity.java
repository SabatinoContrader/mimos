package com.mimosSpring.mimos.model;

import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.format.annotation.DateTimeFormat;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "misura")
public class MisuraEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4015534702432658029L;

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id_misura")
	private int idMisura;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_paziente")
    private UtenteEntity utente;
    
	@Column
    private float pressione;
    
	@Column
    private int battiti;
    
	@Column
    private float temperatura;
    
	@Column
    private float glicemia;
    
	@Temporal(TemporalType.TIMESTAMP)
	@Column(columnDefinition="timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP")
    private Date data;


}
