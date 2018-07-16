package com.virtualpairprogrammers.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.virtualpairprogrammers.converter.UtenteConverter;
import com.virtualpairprogrammers.dto.UtenteDTO;
import com.virtualpairprogrammers.model.Utente;
import com.virtualpairprogrammers.services.HomeService;

public class HomeServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private HomeService homeService;
	private Utente utente;
	private UtenteDTO utenteDTO;
	private UtenteConverter utenteConverter;

	public HomeServlet() {
		this.homeService = new HomeService();
		this.utente = new Utente();
		this.utenteDTO = new UtenteDTO();
		this.utenteConverter = new UtenteConverter();

	}

	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("utente");
		int role = (int) session.getAttribute("role");
		/*
		 * if (request == null) { // gestiamo l'eccezione e rimandiamo alla home.jsp }
		 */

		switch (request.getParameter("pulsante")) {
		case ("homeDottore"):
			// da qui posso creare una request con un messaggio all'interno
			// da implementare
			getServletContext().getRequestDispatcher("/homeDottore.jsp").forward(request, response);
			break;
		case ("homePaziente"):
			// da qui posso creare una request con un messaggio all'interno
			// da implementare
			getServletContext().getRequestDispatcher("/homePaziente.jsp").forward(request, response);
			break;
		case ("getAllMisurazioni"):
			this.homeService.getAllMisurazioni(username);
			getServletContext().getRequestDispatcher("/allMisura.jsp").forward(request, response);
			break;
		case ("insertMisurazione"):
			getServletContext().getRequestDispatcher("/insertMisurazione.jsp").forward(request, response);
			break;
		case ("ginsertMisurazione"):
			this.homeService.insertMisurazione(username);
			getServletContext().getRequestDispatcher("/homePaziente.jsp").forward(request, response);
			break;
		case ("insertCheckin"):

			break;
		case ("gomodificaDati"):
			utente = homeService.getSingleUser(username);
			utenteDTO = utenteConverter.convertToDTO(utente);
			request.setAttribute("utenteDTO", utenteDTO);
			getServletContext().getRequestDispatcher("/modificaDati.jsp").forward(request, response);

			break;
		case ("modificaDati"):
			utenteDTO = new UtenteDTO();
			utenteDTO.setCitta(request.getParameter("citta"));
			utenteDTO.setCodice_fiscale(request.getParameter("codice"));
			utenteDTO.setCognome(request.getParameter("cognome"));
			utenteDTO.setNome(request.getParameter("nome"));
			utente = utenteConverter.convertToEntity(utenteDTO);
			homeService.updateField(username, "citta", utente.getCitta());
			homeService.updateField(username, "codice_fiscale", utente.getCodice_fiscale());
			homeService.updateField(username, "cognome", utente.getCognome());
			homeService.updateField(username, "nome", utente.getNome());
			switch (role) {
			case (2):
				getServletContext().getRequestDispatcher("/homeDottore.jsp").forward(request, response);
				break;
			case (3):
				getServletContext().getRequestDispatcher("/homePaziente.jsp").forward(request, response);
				break;
			}

			break;
		case ("visualizzaDati"):
			utente = homeService.getSingleUser(username);
			utenteDTO = new UtenteDTO();
			/*
			 * utenteDTO.setCitta(this.utente.getCitta());
			 * utenteDTO.setCodice_fiscale(this.utente.getCodice_fiscale());
			 * utenteDTO.setCognome(this.utente.getCognome());
			 * utenteDTO.setNome(this.utente.getNome());
			 * utenteDTO.setPassword(this.utente.getPassword());
			 * utenteDTO.setUsername(this.utente.getUsername());
			 */
			utenteDTO = utenteConverter.convertToDTO(utente);
			request.setAttribute("utenteDTO", utenteDTO);
			getServletContext().getRequestDispatcher("/visualizzaDati.jsp").forward(request, response);
			break;
		case ("visualizzaSkills"):
			ArrayList<String> s = homeService.getDoctorSkills(username);
			request.setAttribute("skills", s);
			getServletContext().getRequestDispatcher("/visualizzaSkills.jsp").forward(request, response);
			break;
		case ("insertVisita"):
			this.homeService.insertMisurazione(username);
			getServletContext().getRequestDispatcher("/insertVisita.jsp").forward(request, response);
			break;
		case ("indietroPaziente"):
			getServletContext().getRequestDispatcher("/homePaziente.jsp").forward(request, response);
			break;
		case ("logout"):
			getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
			break;

		}
	}
}
