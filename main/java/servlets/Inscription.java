package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import dao.AbstractDAOFactory;
import dao.UtilisateurDAO;
import forms.InscriptionForm;
import model.Utilisateur;

@WebServlet("/Inscription")
public class Inscription extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String CONF_DAO_FACTORY = "daofactory";
	public static final String ACCUEIL = "/Accueil";
	private InscriptionForm inscriptionForm;
	private UtilisateurDAO utilisateurDAO;
	
	public void init() throws ServletException {
        this.utilisateurDAO = ( (AbstractDAOFactory) getServletContext().getAttribute( CONF_DAO_FACTORY ) ).getUtilisateurDao();
    }

    public Inscription() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getServletContext().getRequestDispatcher("/WEB-INF/Inscription.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.inscriptionForm = new InscriptionForm(utilisateurDAO);
		HttpSession session = request.getSession();
		Utilisateur utilisateur=inscriptionForm.creerUtilisateur(request);
		
		if (utilisateur != null) {
	        session.setAttribute("utilisateur", utilisateur);
	    }
		response.sendRedirect(request.getContextPath() + ACCUEIL);
	}

}
