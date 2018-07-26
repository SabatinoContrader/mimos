package com.mimosSpring.mimos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.mimosSpring.mimos.model.MisuraEntity;
import com.mimosSpring.mimos.model.UtenteEntity;
import com.mimosSpring.mimos.service.MisuraService;
import com.mimosSpring.mimos.service.UtenteService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.*;


@Controller
public class LoginController {

	private UtenteService utenteService;
	private MisuraService misuraService;
	
    @Autowired
    public LoginController(UtenteService utenteService, MisuraService misuraService) {
    	this.utenteService = utenteService;
    	this.misuraService = misuraService;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index() {
        return "index";
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(HttpServletRequest request) {
        HttpSession session = request.getSession(true);
        session.invalidate();
        return "homeDottore";
    }

    @RequestMapping(value = "/homePaziente", method = RequestMethod.GET)
    public String home(Map<String, Object> model) {
        return "homePaziente";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@RequestParam(name = "username", required = true) String username,
                        @RequestParam(name = "password", required = true) String password,
                        HttpServletRequest request,
                        Map<String, Object> model) {
        UtenteEntity retrived = utenteService.findByUsernameAndPassword(username, password);
        System.out.println(retrived==null);
        System.out.println(username + " " + password);
    	String returnString = "";
        if (retrived != null) {
            int role = (int) utenteService.findIdRuoloByUsername(username);
            System.out.println(role);
            switch (role) {
            case (0):
            	List<UtenteEntity> utEntities = utenteService.findAll();
                model.put("listaUtenti", utEntities);
            	returnString = "homeAdmin";
            	break;
            case (1):

            	break;
            case (3):
  
                HttpSession session = request.getSession(true);
                session.setAttribute("username", username);
                session.setAttribute("utente", retrived);
        		return "redirect:/paziente/home";
            	//  <<<Salvatore
            case (4):
            	break;
            }
            model.put("utente", retrived);
            HttpSession session = request.getSession(true);
            session.setAttribute("username", username);
            session.setAttribute("utente", retrived);
        } else {
        	returnString = "index";
        }
        return returnString;
    }
    /*
    public HashMap colorPanel(List<AutoEntity> autoEntitySet)
    {
        HashMap color = new HashMap();
        for (AutoEntity autoEntity:autoEntitySet) {
            List<DatiEntity> listaDati = autoEntity.getDatiEntitySet();
            DatiEntity dato = listaDati.get(listaDati.size()-1);
            Scanner scanner = new Scanner(autoEntity.getRevisione()).useDelimiter("/");
            int gg_revisione = scanner.nextInt();
            int mm_revisione = scanner.nextInt();
            int aa_revisione = scanner.nextInt();
            scanner = new Scanner(autoEntity.getTagliandoData()).useDelimiter("/");
            int gg_tagliando = scanner.nextInt();
            int mm_tagliando = scanner.nextInt();
            int aa_tagliando = scanner.nextInt();
            scanner = new Scanner(dato.getData()).useDelimiter("/");
            int gg_dato = scanner.nextInt();
            int mm_dato = scanner.nextInt();
            int aa_dato = scanner.nextInt();
            int revisione = gg_revisione + mm_revisione * 365 / 12 + aa_revisione * 365;
            int tagliando = gg_tagliando + mm_tagliando * 365 / 12 + aa_tagliando * 365;
            int data = gg_dato + mm_dato * 365 / 12 + aa_dato * 365;

            int km = dato.getKm() - autoEntity.getTagliandoKm();

            if (data - revisione > 365 + 365 / 12 * 11) {
                color.put(autoEntity.getCodDispositivo(), "yellow");
            }
            else if (((data - tagliando) > 365 + 365 / 12 * 11) || km > 14500) {
                color.put(autoEntity.getCodDispositivo(), "yellow");
            }
            else {
                color.put(autoEntity.getCodDispositivo(), "primary");
            }
            for (DatiEntity datiEntity:autoEntity.getDatiEntitySet()) {
                if(datiEntity.getCodErrore() != null && datiEntity.isStato() == false)
                    color.put(autoEntity.getCodDispositivo(), "red");
            }

        }
        return color;
	}
     */
}
