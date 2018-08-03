package com.mimosSpring.mimos.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mimosSpring.mimos.DTO.UtenteDTO;
import com.mimosSpring.mimos.converter.UtenteConverter;
import com.mimosSpring.mimos.model.SpecialitaEntity;
import com.mimosSpring.mimos.model.UtenteEntity;
import com.mimosSpring.mimos.service.MisuraService;
import com.mimosSpring.mimos.service.SpecialitaService;
import com.mimosSpring.mimos.service.UtenteService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.*;
import java.sql.Date;


@CrossOrigin(value = "*")
@RestController
@RequestMapping("/login")
public class IndexControllerApi {

	private UtenteService utenteService;
	private UtenteConverter utenteConverter;
	private MisuraService misuraService;
	private SpecialitaService specialitaService;

	@Autowired
	public IndexControllerApi(UtenteService utenteService, SpecialitaService specialitaService) {
		this.utenteService = utenteService;
		this.specialitaService = specialitaService;
    	this.misuraService = misuraService;
		this.utenteConverter = new UtenteConverter();
	}
	
	//si usa al posto request mapping method ecc 
    @PostMapping
	public UtenteDTO login(@RequestParam("username") String username, @RequestParam("password") String password) {
    	UtenteEntity utenteEntity = this.utenteService.findByUsernameAndPassword(username, password);
    	UtenteConverter converter = new UtenteConverter();
    	if( (utenteEntity.getUsername().length()>0)) {
    		return converter.convertToDTO(utenteEntity);
    	}
        else {
        	return null;
        }
	}
    
//    @PostMapping
//	public UtenteDTO login(@RequestBody UtenteDTO utenteDTO) {
//    	UtenteEntity utenteEntity = this.utenteService.findByUsernameAndPassword(utenteDTO.getUsername(), utenteDTO.getPassword());
//    	UtenteConverter converter = new UtenteConverter();
//    	if( (utenteEntity.getUsername().length()>0)) {
//    		return converter.convertToDTO(utenteEntity);
//    	}
//        else {
//        	return null;
//        }
//	}
    
    @PostMapping(value = "/registerIndex")
	public UtenteDTO registerIndex(@RequestBody UtenteDTO utenteDTO) {
    	UtenteConverter converter = new UtenteConverter();
    	utenteService.save(converter.convertToEntity(utenteDTO));
		return utenteDTO;
	}
}
