package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.DAOFactory;
import dao.UtilisateurDAO;
import forms.InscriptionForm;
import model.Utilisateur;
import utils.Password;

@WebServlet("/Inscription")
public class Inscription extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String ACCUEIL = "/Accueil";
	private static final String CHAMP_PSEUDO="pseudo";
	private static final String CHAMP_MDP="password";
	
	private InscriptionForm inscriptionForm;
	private DAOFactory daoFactory;
	private UtilisateurDAO utilisateurDAO;
    public Inscription() {
        super();
        
        
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getServletContext().getRequestDispatcher("/WEB-INF/Inscription.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.daoFactory= DAOFactory.getInstance();
        this.utilisateurDAO=daoFactory.getUtilisateurDao();
        this.inscriptionForm = new InscriptionForm(utilisateurDAO);
		HttpSession session = request.getSession();
		System.out.println(request.getParameter(CHAMP_PSEUDO));
		Utilisateur utilisateur=inscriptionForm.creerUtilisateur(request);
		
		if (utilisateur != null) {
	        session.setAttribute("utilisateur", utilisateur);
	    }
		response.sendRedirect(request.getContextPath() + ACCUEIL);
	}

}
