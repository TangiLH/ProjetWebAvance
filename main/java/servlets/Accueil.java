package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import dao.DAOFactory;

import dao.JoueurParticipePartieDAO;
import dao.PartieDAO;
import dao.UtilisateurDAO;


@WebServlet("/Accueil")
public class Accueil extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String ACCUEIL = "/Accueil";
	private DAOFactory daoFactory;
	private JoueurParticipePartieDAO jppDAO;
	private PartieDAO partieDAO;
	private UtilisateurDAO utilisateurDAO;
	

	public Accueil() {
		super();
		
		
		
		
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.daoFactory= DAOFactory.getInstance();
		this.jppDAO =  daoFactory.getJoueurParticipeDAO();
		this.partieDAO = daoFactory.getPartieDao();
		this.utilisateurDAO = daoFactory.getUtilisateurDao() ;
		List<Map<String, Object>> classement = jppDAO.getScores();

	    // Trier par ordre décroissant des scores
	    classement.sort((a, b) -> ((Integer) b.get("score")).compareTo((Integer) a.get("score")));

	    request.setAttribute("classement", classement);
		
		
		
	    response.sendRedirect(request.getContextPath() + ACCUEIL);
		
		
		
		
		
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
