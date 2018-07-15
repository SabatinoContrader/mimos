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
		utente = new Utente();
		utenteDTO = new UtenteDTO();
	}

	@Override
	public Utente convertToEntity(UtenteDTO dto) {

		//se il costruttore lo prevede possiamo mettere direttamente i dati nel cotruttore
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
		utenteDTO.setCitta(entity.getCitta());
		utenteDTO.setCodice_fiscale(entity.getCodice_fiscale());
		utenteDTO.setCognome(entity.getCognome());
		utenteDTO.setData_nascita(entity.getData_nascita());
		utenteDTO.setNome(entity.getNome());
		utenteDTO.setPassword(entity.getPassword());
		utenteDTO.setUsername(entity.getUsername());
		//metodi per il set da prendere dal dto come get
		return utenteDTO;
	}

}
