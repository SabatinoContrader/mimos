package com.virtualpairprogrammers.converter;

import java.util.Date;

import com.virtualpairprogrammers.dto.MisuraDTO;
import com.virtualpairprogrammers.model.Misura;


public class MisuraConverter implements Converter<Misura, MisuraDTO> {

	private Misura misura;
	private MisuraDTO misuraDTO;
	
	public MisuraConverter(Misura misura, MisuraDTO misuraDTO) {
		this.misura = misura;
		this.misuraDTO = misuraDTO;
	}
	
	public MisuraConverter() {
		/*
		 * si potrebbe avere un costruttore parametrizzato con uno string
		 * che mediante switch potrebbe modificare il tipo di output della conversione
		 * creando più o meno blank
		 */
	}

	@Override
	public Misura convertToEntity(MisuraDTO misuraDTO) {
		// TODO Auto-generated method stub
		System.out.println("Conversion 1");
		misura = new Misura();
		misura.setId_misura(misuraDTO.getId_misura());
		misura.setId_paziente(misuraDTO.getId_paziente());
		misura.setPressione(misuraDTO.getPressione());
		misura.setBattiti(misuraDTO.getBattiti());
		misura.setTemperatura(misuraDTO.getTemperatura());
		misura.setGlicemia(misuraDTO.getGlicemia());
		misura.setData(misuraDTO.getData());
		System.out.println("Conversion llega aqui");
		return misura;
	}

	@Override
	public MisuraDTO convertToDTO(Misura misura) {
		// TODO Auto-generated method stub
		misuraDTO = new MisuraDTO();
		misuraDTO.setId_misura(misura.getId_misura());
		misuraDTO.setId_paziente(misura.getId_paziente());
		misuraDTO.setPressione(misura.getPressione());
		misuraDTO.setBattiti(misura.getBattiti());
		misuraDTO.setTemperatura(misura.getTemperatura());
		misuraDTO.setGlicemia(misura.getGlicemia());
		misuraDTO.setData(misura.getData());
		return misuraDTO;

	}

}
