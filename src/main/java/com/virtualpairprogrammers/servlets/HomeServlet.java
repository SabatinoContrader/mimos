package com.virtualpairprogrammers.servlets;

import java.io.IOException;

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

		if (request == null) {
			// gestiamo l'eccezione e rimandiamo alla home.jsp
		}

		switch (request.getParameter("pulsante")) {
		case ("getAllMisurazioni"):

			this.homeService.getAllMisurazioni(username);
			getServletContext().getRequestDispatcher("/viewMisurazioni.jsp").forward(request, response);
			break;
		case ("goInsertMisurazione"):

			getServletContext().getRequestDispatcher("/insertMisurazione.jsp").forward(request, response);
			break;

		case ("insertMisurazione"):

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
			getServletContext().getRequestDispatcher("/homePaziente.jsp").forward(request, response);

			break;
		case ("logout"):
			getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
			break;

		}
	}
}
