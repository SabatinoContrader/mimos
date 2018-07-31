package com.mimosSpring.mimos.controller;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.Date;
import java.sql.*;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.mimosSpring.mimos.model.MisuraEntity;
import com.mimosSpring.mimos.model.UtenteEntity;
import com.mimosSpring.mimos.model.VisitaEntity;
import com.mimosSpring.mimos.service.MisuraService;
import com.mimosSpring.mimos.service.UtenteService;
import com.mimosSpring.mimos.service.VisitaService;



@Controller
@RequestMapping(value = "/paziente")
public class HomePazienteController {
	
	private static final Date NULL = null;
	@Autowired
	MisuraService misuraService;
	@Autowired
	UtenteService utenteService;
	@Autowired
	VisitaService visitaService;


    @RequestMapping(value = "/home", method = RequestMethod.GET)
	public String home(HttpServletRequest request, Model model) {
        List<MisuraEntity> misure = misuraService.findAllByUtente(utenteService.findByUsername((String) request.getSession().getAttribute("username")));
        model.addAttribute("misure", misure);
        return "homePaziente";
	}
    
    @RequestMapping(value = "/misura", method = RequestMethod.GET)
	public String misuraForm(HttpServletRequest request, Model model ) {
		return "insertMisura";
	}
    
    @RequestMapping(value = "/misura", method = RequestMethod.POST)
	public String addMisura(HttpServletRequest request, Model model ) {
    	MisuraEntity misura = new MisuraEntity();
    	misura.setPressione(Float.parseFloat(request.getParameter("pressione")));
    	misura.setGlicemia(Float.parseFloat(request.getParameter("glicemia")));
    	misura.setTemperatura(Float.parseFloat(request.getParameter("temperatura")));
    	misura.setBattiti(Integer.parseInt(request.getParameter("glicemia")));
    	misura.setUtente(utenteService.findByUsername((String) request.getSession().getAttribute("username")));
    	misura.setData(new Timestamp(System.currentTimeMillis()));
    	misuraService.save(misura);
		return "redirect:/paziente/home";
	}
	
    @RequestMapping(value = "/visita", method = RequestMethod.GET)
	public String mediciVisita(HttpServletRequest request, Model model) {
       List<UtenteEntity> dottori = utenteService.findByIdRuolo(2);
        model.addAttribute("dottori", dottori);
        return "mediciVisita";
	}
    
    @RequestMapping(value = "/visita", method = RequestMethod.POST)
	public String insertVisita(HttpServletRequest request, @RequestParam(name = "idDottoreView") int idDottore, Model model) {
    	UtenteEntity dottore = utenteService.findByIdUtente(idDottore);
        model.addAttribute("dottore", dottore);
        return "insertVisita";
	}
    
    @RequestMapping(value = "/aggiungi/visita", method = RequestMethod.POST)
	public String aggiungiVisita(HttpServletRequest request, 
			@RequestParam(name = "idDottoreView") int idDottore,
			@RequestParam(name = "dataVisita") Date dataVisita,
			@RequestParam(name = "descrizione") String descrizione,
			Model model) {
    		//System.out.println(dataVisita);
    		VisitaEntity visita = new VisitaEntity();
    		visita.setPaziente(utenteService.findByUsername((String) request.getSession().getAttribute("username")));
    		visita.setDottore(utenteService.findByIdUtente(idDottore));
    		visita.setStato(1);
    		visita.setDataVisita(new java.sql.Date(dataVisita.getTime()));
    		visita.setDescrizione(descrizione);
    		visita.setDiagnosi("");
    		visitaService.save(visita);
        	return "test";
	}

}
