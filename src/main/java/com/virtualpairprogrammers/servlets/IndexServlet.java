package com.virtualpairprogrammers.servlets;

import java.io.IOException;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.virtualpairprogrammers.converter.UtenteConverter;
import com.virtualpairprogrammers.dto.UtenteDTO;
import com.virtualpairprogrammers.model.Utente;
import com.virtualpairprogrammers.services.IndexService;

public class IndexServlet extends HttpServlet {

	private IndexService indexService;
	private Utente utente;
	private UtenteDTO utenteDTO;
	private UtenteConverter utenteConverter;
	private DateFormat formatter;

	public IndexServlet() {
		this.indexService = new IndexService();
		this.formatter = new SimpleDateFormat("yyyy-MM-dd");
		this.utenteConverter = new UtenteConverter();
	}

	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		session.setAttribute("utente", null);

		switch (request.getParameter("pulsante")) {
		case ("Login"):
			System.out.println("sto nel login");
			String nomeUtente = request.getParameter("username");
			String password = request.getParameter("password");
			if (this.indexService.login(nomeUtente, password)) {
				session.setAttribute("utente", nomeUtente);
				// response.sendRedirect("home.jsp");
				int role = this.indexService.getRole(nomeUtente);
				switch (role) {
				case (2):
					getServletContext().getRequestDispatcher("/homeDottore.jsp").forward(request, response);
					break;
				case (3):
					getServletContext().getRequestDispatcher("/homePaziente.jsp").forward(request, response);
					break;
				}
			} else {
				// response.sendRedirect("login.jsp");
				getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
			}
			break;
		case ("goRegister"):
			System.out.println("vado in register.jsp");
			getServletContext().getRequestDispatcher("/register.jsp").forward(request, response);
			break;
		case ("indietroPaziente"):
			getServletContext().getRequestDispatcher("/homePaziente.jsp").forward(request, response);
			break;
		case ("userRegister"):
			System.out.println("sto nel user register");
			utenteDTO = new UtenteDTO();
			utenteDTO.setCitta(request.getParameter("citta"));
			utenteDTO.setCodice_fiscale(request.getParameter("codice"));
			utenteDTO.setCognome(request.getParameter("cognome"));
			utenteDTO.setNome(request.getParameter("nome"));
			utenteDTO.setPassword(request.getParameter("password"));
			utenteDTO.setUsername(request.getParameter("username"));
			System.out.println(request.getParameter("data"));
			try {
				formatter.parse(request.getParameter("data"));
				utenteDTO.setData_nascita(Date.valueOf(request.getParameter("data")));
			} catch (Exception e) {
				System.out.println("huston abbiamo un problema");
				e.printStackTrace();
			}
			//t
			//utenteDTO = (UtenteDTO) request.getAttribute("utenteDTO");
			utente = utenteConverter.convertToEntity(utenteDTO);
			
			// 2 == paziente
			utente.setId_ruolo(2);
			this.indexService.register(utente);
			getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
			break;

		}
	}
}
