package com.mimosSpring.mimos.converter;

import com.mimosSpring.mimos.DTO.UtenteDTO;
import com.mimosSpring.mimos.model.UtenteEntity;

public class UtenteConverter implements Converter<UtenteEntity, UtenteDTO> {

	private UtenteEntity utente;
	private UtenteDTO utenteDTO;
	
	public UtenteConverter(UtenteEntity user, UtenteDTO pazienteDTO) {
		this.utente = user;
		this.utenteDTO = pazienteDTO;
	}
	
	public UtenteConverter() {
		/*
		 * si potrebbe avere un costruttore parametrizzato con uno string
		 * che mediante switch potrebbe modificare il tipo di output della conversione
		 * creando pi� o meno blank
		 */
		utente = new UtenteEntity();
		utenteDTO = new UtenteDTO();
	}

	@Override
	public UtenteEntity convertToEntity(UtenteDTO dto) {

		//se il costruttore lo prevede possiamo mettere direttamente i dati nel cotruttore
		utente.setCitta(dto.getCitta());
		utente.setCodiceFiscale(dto.getCodice_fiscale());
		utente.setCognome(dto.getCognome());
		utente.setDataNascita(dto.getData_nascita());
		utente.setNome(dto.getNome());
		utente.setPassword(dto.getPassword());
		utente.setUsername(dto.getUsername());
		
		//non ho n� l'id ruolo n� l'id nel db
		return utente;
	}

	@Override
	public UtenteDTO convertToDTO(UtenteEntity entity) {

		//se il costruttore lo prevede possiamo mettere direttamente i dati nel cotruttore
		utenteDTO.setCitta(entity.getCitta());
		utenteDTO.setCodice_fiscale(entity.getCodiceFiscale());
		utenteDTO.setCognome(entity.getCognome());
		utenteDTO.setData_nascita(entity.getDataNascita());
		utenteDTO.setNome(entity.getNome());
		utenteDTO.setPassword(entity.getPassword());
		utenteDTO.setUsername(entity.getUsername());
		//metodi per il set da prendere dal dto come get
		return utenteDTO;
	}

}
