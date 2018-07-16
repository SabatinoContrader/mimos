package com.virtualpairprogrammers.servlets;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.virtualpairprogrammers.converter.MisuraConverter;
import com.virtualpairprogrammers.dto.MisuraDTO;
import com.virtualpairprogrammers.dao.MisuraDAO;
import com.virtualpairprogrammers.model.Misura;
import com.virtualpairprogrammers.services.IndexService;
import com.virtualpairprogrammers.services.MisuraService;


/**
 * Servlet implementation class MisuraServlet
 */
public class MisuraServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IndexService indexService = new IndexService();
	private MisuraService misuraService = new MisuraService();
	private Misura misura = new Misura();
	private MisuraDTO misuraDTO;
	private MisuraConverter misuraConverter = new MisuraConverter();	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MisuraServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		switch (request.getParameter("pulsante")) {
		case ("getAllMisura"):
		System.out.println(this.indexService.getIdByNick((String)session.getAttribute("utente")));
		System.out.println("ritorna l'id");
		List<MisuraDTO> misureDTO = new ArrayList<>();
		List<Misura> misure =  new ArrayList<>();
		misure = this.misuraService.getAllMisura(this.indexService.getIdByNick((String)session.getAttribute("utente")));
		misure.forEach( misura -> misureDTO.add(this.misuraConverter.convertToDTO(misura)));
		//misureDTO.forEach( misuraDTO -> System.out.println(misuraDTO.getGlicemia()));
		request.setAttribute("misureDTO", misureDTO);
		getServletContext().getRequestDispatcher("/allMisura.jsp").forward(request, response);
		break;
		case ("insertMisura"):
		//System.out.println(this.indexService.getIdByNick((String)session.getAttribute("utente")));
		System.out.println("ritorna l'id");
		misuraDTO = new MisuraDTO();
		misuraDTO.setId_paziente(this.indexService.getIdByNick((String)session.getAttribute("utente")));
		misuraDTO.setPressione(Float.parseFloat(request.getParameter("pressione")));
		misuraDTO.setBattiti(Integer.parseInt(request.getParameter("battiti")));
		misuraDTO.setTemperatura(Float.parseFloat(request.getParameter("temperatura")));
		misuraDTO.setGlicemia(Float.parseFloat(request.getParameter("glicemia")));
		System.out.println("Creado objeto con exito");
		misura = this.misuraConverter.convertToEntity(misuraDTO);
		System.out.println("Conversion hecha con exito");
		this.misuraService.insertMisura(misura);
		getServletContext().getRequestDispatcher("/homePaziente.jsp").forward(request, response);
		break;
		}
		
		
	
		
	}
}
