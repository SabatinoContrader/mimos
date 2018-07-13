package com.virtualpairprogrammers.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.virtualpairprogrammers.services.IndexService;

public class IndexServlet extends HttpServlet {

	private IndexService indexService;

	public IndexServlet() {
		this.indexService = new IndexService();
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
				getServletContext().getRequestDispatcher("/home.jsp").forward(request, response);
			} else {
				// response.sendRedirect("login.jsp");
				getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
			}
			break;
		case ("goRegister"):
			System.out.println("vado in register.jsp");
			getServletContext().getRequestDispatcher("/register.jsp").forward(request, response);
			break;
		case ("userRegister"):
			System.out.println("sto nel user register");
			//this.indexService.register(utente);
			getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
			break;

		}
	}
}
