package com.mimosSpring.mimos.converter;

import com.mimosSpring.mimos.DTO.SpecialitaDTO;
import com.mimosSpring.mimos.model.SpecialitaEntity;

public class SpecialitaConverter implements Converter<SpecialitaEntity, SpecialitaDTO> {

	SpecialitaEntity se;
	SpecialitaDTO sd;
	
	public SpecialitaConverter() {
		this.se = new SpecialitaEntity();
		this.sd = new SpecialitaDTO();
	}
	
	public SpecialitaConverter(SpecialitaEntity se, SpecialitaDTO sd) {
		this.se = se;
		this.sd = sd;
	}

	@Override
	public SpecialitaEntity convertToEntity(SpecialitaDTO dto) {

		se.setNomeSpecialita(dto.getNome());
		se.setDescrizioneSpecialita(dto.getDescrizione());
		return null;
	}

	@Override
	public SpecialitaDTO convertToDTO(SpecialitaEntity entity) {

		sd.setNome(entity.getNomeSpecialita());
		sd.setDescrizione(entity.getDescrizioneSpecialita());
		return null;
	}

}
