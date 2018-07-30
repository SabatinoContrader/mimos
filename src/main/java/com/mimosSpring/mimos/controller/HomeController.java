package com.mimosSpring.mimos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.mimosSpring.mimos.DTO.UtenteDTO;
import com.mimosSpring.mimos.converter.UtenteConverter;
import com.mimosSpring.mimos.model.UtenteEntity;
import com.mimosSpring.mimos.service.UtenteService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import java.sql.Date;
import java.util.*;

@Controller
@RequestMapping(value = "/home", method = RequestMethod.POST)
public class HomeController {

	private UtenteService utenteService;
	private UtenteConverter utenteConverter;

	@Autowired
	public HomeController(UtenteService utenteService) {
		this.utenteService = utenteService;
		this.utenteConverter = new UtenteConverter();
	}

	@RequestMapping(value = "/Paziente", method = RequestMethod.GET)
	public String homePaziente(Map<String, Object> model) {
		return "homePaziente";
	}

	@RequestMapping(value = "/Admin", method = RequestMethod.POST)
	public String homeAdmin(Map<String, Object> model) {
		List<UtenteEntity> utEntities = utenteService.findAll();
		model.put("listaUtenti", utEntities);
		return "homeAdmin";
	}

	@RequestMapping(value = "/Dottore", method = RequestMethod.GET)
	public String homeDottore(Map<String, Object> model) {
		return "homeDottore";
	}

	@RequestMapping(value = "/Farmacista", method = RequestMethod.POST)
	public String homeFarmacista(Map<String, Object> model) {
		return "homeFarmacista";
	}

	@RequestMapping(value = "/registerAdmin", method = RequestMethod.POST)
	public String register(@RequestParam(name = "username", required = true) String username,
			@RequestParam(name = "password", required = true) String password,
			@RequestParam(name = "nome", required = true) String nome,
			@RequestParam(name = "cognome", required = true) String cognome,
			@RequestParam(name = "codiceFiscale", required = true) String codiceFiscale,
			@RequestParam(name = "citta", required = true) String citta,
			@RequestParam(name = "dataNascita", required = true) Date dataNascita,
			@RequestParam(name = "idRuolo", required = true) int idRuolo, HttpServletRequest request,
			Map<String, Object> model) {
		UtenteEntity nuovoUtente = new UtenteEntity();
		nuovoUtente.setPassword(password);
		nuovoUtente.setUsername(username);
		nuovoUtente.setCitta(citta);
		nuovoUtente.setCodiceFiscale(codiceFiscale);
		nuovoUtente.setCognome(cognome);
		nuovoUtente.setDataNascita(dataNascita);
		nuovoUtente.setIdRuolo(idRuolo);
		nuovoUtente.setNome(nome);
		utenteService.save(nuovoUtente);
		List<UtenteEntity> utEntities = utenteService.findAll();
		model.put("listaUtenti", utEntities);
		return "homeAdmin";
	}

	@RequestMapping(value = "/modificaUtente", method = RequestMethod.POST)
	public String modificaUtente(@RequestParam(name = "id_utente", required = true) int idUtente,
			HttpServletRequest request, Map<String, Object> model) {
		UtenteEntity ue = utenteService.findByIdUtente(idUtente);
		UtenteDTO ud = new UtenteDTO();
		ud = utenteConverter.convertToDTO(ue);
		String udId = UUID.randomUUID().toString();
		String ueId = UUID.randomUUID().toString();
		// effetto uno storage dell'oggeto nella session
		HttpSession session = request.getSession(true);
		session.setAttribute(udId, ud);
		session.setAttribute(ueId, ue);
		// ma nella request gli passo la stringa di riferimento
		model.put("udId", udId);
		model.put("utenteModifica", ud);
		System.out.println("vado in modificDati");
		return "modificaDati";
	}

	@RequestMapping(value = "/modificaUtenteComplete", method = RequestMethod.POST)
	public String modificaUtenteComplete(@RequestParam(name = "udId", required = true) String udId,
			@RequestParam(name = "idRuolo", required = true) int idRuolo,
			@RequestParam(name = "nome", required = true) String nome,
			@RequestParam(name = "username", required = true) String username,
			@RequestParam(name = "password", required = true) String password,
			@RequestParam(name = "cognome", required = true) String cognome,
			@RequestParam(name = "codiceFiscale", required = true) String codiceFiscale,
			@RequestParam(name = "citta", required = true) String citta,
			@RequestParam(name = "dataNascita", required = true) Date dataNascita, HttpServletRequest request,
			Map<String, Object> model) {
		UtenteDTO utenteModifica = (UtenteDTO) request.getSession().getAttribute(udId);
		request.getSession().removeAttribute(udId);
		utenteModifica.setCitta(citta);
		utenteModifica.setCodice_fiscale(codiceFiscale);
		utenteModifica.setCognome(cognome);
		utenteModifica.setData_nascita(dataNascita);
		utenteModifica.setPassword(password);
		utenteModifica.setUsername(username);
		utenteModifica.setNome(nome);
		utenteModifica.setId_ruolo(idRuolo);
		UtenteEntity utenteCompelto = utenteConverter.convertToEntity(utenteModifica);
		utenteCompelto.setIdUtente(utenteService.findIdUtenteByUsername(username));
		System.out.println(utenteCompelto);
		utenteService.save(utenteCompelto);
		List<UtenteEntity> utEntities = utenteService.findAll();
		model.put("listaUtenti", utEntities);
		return "homeAdmin";
	}

	@RequestMapping(value = "/deleteUtente", method = RequestMethod.POST)
	public String deleteUtente(@RequestParam(name = "udId", required = true) String udId, HttpServletRequest request,
			Map<String, Object> model) {
		UtenteDTO utenteModifica = (UtenteDTO) request.getSession().getAttribute(udId);
		request.getSession().removeAttribute(udId);
		int i = utenteService.deleteByUsername(utenteModifica.getUsername());
		List<UtenteEntity> utEntities = utenteService.findAll();
		model.put("listaUtenti", utEntities);
		return "homeAdmin";
	}
}
