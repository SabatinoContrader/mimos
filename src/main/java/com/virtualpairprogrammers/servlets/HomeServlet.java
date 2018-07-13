package com.virtualpairprogrammers.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.virtualpairprogrammers.services.HomeService;
import com.virtualpairprogrammers.services.IndexService;

public class HomeServlet extends HttpServlet {

	private HomeService homeService;

	public HomeServlet() {
		this.homeService = new HomeService();
	}

	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		session.setAttribute("utente", null);

		if (request == null) {
			// gestiamo l'eccezione e rimandiamo alla home.jsp
		}

		switch (request.getParameter("pulsante")) {
		case ("getAllMisurazioni"):
			break;
		case ("insertMisurazione"):
			break;
		case ("insertCheckin"):
			break;
		case ("logout"):
			break;

		}
	}
}
