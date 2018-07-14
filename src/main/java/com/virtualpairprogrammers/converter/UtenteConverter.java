package com.virtualpairprogrammers.converter;

import com.virtualpairprogrammers.dto.UtenteDTO;
import com.virtualpairprogrammers.model.Utente;

public class UtenteConverter implements Converter<Utente, UtenteDTO> {

	private Utente utente;
	private UtenteDTO utenteDTO;
	
	public UtenteConverter(Utente user, UtenteDTO pazienteDTO) {
		this.utente = user;
		this.utenteDTO = pazienteDTO;
	}
	
	public UtenteConverter() {
		/*
		 * si potrebbe avere un costruttore parametrizzato con uno string
		 * che mediante switch potrebbe modificare il tipo di output della conversione
		 * creando più o meno blank
		 */
	}

	@Override
	public Utente convertToEntity(UtenteDTO dto) {

		//se il costruttore lo prevede possiamo mettere direttamente i dati nel cotruttore
		utente = new Utente();
		utente.setCitta(dto.getCitta());
		utente.setCodice_fiscale(dto.getCodice_fiscale());
		utente.setCognome(dto.getCognome());
		utente.setData_nascita(dto.getData_nascita());
		utente.setNome(dto.getNome());
		utente.setPassword(dto.getPassword());
		utente.setUsername(dto.getUsername());
		
		//non ho nè l'id ruolo nè l'id nel db
		return utente;
	}

	@Override
	public UtenteDTO convertToDTO(Utente entity) {

		//se il costruttore lo prevede possiamo mettere direttamente i dati nel cotruttore
		utenteDTO = new UtenteDTO();
		utenteDTO.setCitta(utente.getCitta());
		utenteDTO.setCodice_fiscale(utente.getCodice_fiscale());
		utenteDTO.setCognome(utente.getCognome());
		utenteDTO.setData_nascita(utente.getData_nascita());
		utenteDTO.setNome(utente.getNome());
		utenteDTO.setPassword(utente.getPassword());
		utenteDTO.setUsername(utente.getUsername());
		//metodi per il set da prendere dal dto come get
		return utenteDTO;
	}

}
