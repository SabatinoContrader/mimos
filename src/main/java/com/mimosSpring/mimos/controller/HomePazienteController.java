package com.mimosSpring.mimos.controller;

import java.sql.Timestamp;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mimosSpring.mimos.model.MisuraEntity;
import com.mimosSpring.mimos.service.MisuraService;
import com.mimosSpring.mimos.service.UtenteService;



@Controller
@RequestMapping(value = "/paziente")
public class HomePazienteController {
	
	@Autowired
	MisuraService misuraService;
	@Autowired
	UtenteService utenteService;


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
        /*List<MisuraEntity> misure = misuraService.findAllByUtente(utenteService.findByUsername((String) request.getSession().getAttribute("username")));
        model.addAttribute("misure", misure);*/
        return "mediciVisita";
	}

}
