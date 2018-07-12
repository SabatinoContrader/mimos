package com.virtualpairprogrammsers.converter;

import com.virtualpairprogrammers.dto.UtenteDTO;
import com.virtualpairprogrammers.model.Utente;

public class UtenteConverter implements Converter<Utente, UtenteDTO> {

	private Utente user;
	private UtenteDTO userDTO;
	
	public UtenteConverter() {
		
	}

	@Override
	public Utente convertToEntity(UtenteDTO dto) {

		//se il costruttore lo prevede possiamo mettere direttamente i dati nel cotruttore
		user = new Utente();
		//metodi per il set da prendere dal dto come get
		return user;
	}

	@Override
	public UtenteDTO convertToDTO(Utente entity) {

		//se il costruttore lo prevede possiamo mettere direttamente i dati nel cotruttore
		userDTO = new UtenteDTO();
		//metodi per il set da prendere dal dto come get
		return userDTO;
	}

}
