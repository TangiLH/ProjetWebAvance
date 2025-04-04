package servlets;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import dao.AbstractDAOFactory;
import dao.UtilisateurDAO;
import model.Utilisateur;
import utils.Password;

@WebServlet("/Connexion")
public class Connexion extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String CONF_DAO_FACTORY = "daofactory";
	public static final String ACCUEIL = "/Accueil";
	public static final String CREATION = "/WEB-INF/Connexion.jsp";
	public static final String AFFICHAGE = "/WEB-INF/afficherUtilisateur.jsp";
    public static final String CHAMP_PSEUDO = "userName";
    public static final String CHAMP_MDP="mdp";
    public static final String ATT_ERREURS  = "erreursUtilisateur";
    public static final String ATT_RESULTAT = "resultat";
    private UtilisateurDAO uDAO;
       
    
    public Connexion() {
        super();
       
    }

    public void init() throws ServletException {
        this.uDAO = ( (AbstractDAOFactory) getServletContext().getAttribute( CONF_DAO_FACTORY ) ).getUtilisateurDao();
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.getServletContext().getRequestDispatcher( CREATION ).forward( request, response );
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Map<String, String> erreurs = this.handleRequest(request);

		if (erreurs.isEmpty()) {
			response.sendRedirect(request.getContextPath() + ACCUEIL);
		} else {
		    this.getServletContext().getRequestDispatcher(CREATION).forward(request, response);
		}


	}
																
	@SuppressWarnings("deprecation")
	public Map<String, String> handleRequest(HttpServletRequest request) {
	    HttpSession session = request.getSession();
	    String pseudo = request.getParameter(CHAMP_PSEUDO);
	    String mdp = request.getParameter(CHAMP_MDP);

	    Map<String, String> erreurs = new HashMap<>();
	    request.setAttribute(ATT_ERREURS, erreurs); // utile pour afficher les erreurs dans la JSP

	    try {
	        Utilisateur utilisateur = this.uDAO.trouver(pseudo);

	        if (utilisateur != null) {
	            Password passwordHasher = new Password();
	            boolean passwordValide = passwordHasher.authenticate(mdp, utilisateur.getPassword());

	            if (passwordValide) {
	                session.setAttribute("utilisateur", utilisateur); // Connexion réussie
	            } else {
	                erreurs.put(CHAMP_MDP, "Mot de passe incorrect.");
	            }
	        } else {
	            erreurs.put(CHAMP_PSEUDO, "Utilisateur introuvable.");
	        }
	    } catch (Exception e) {
	        erreurs.put("exception", "Erreur inattendue : " + e.getMessage());
	    }
	    
	    System.out.println("Erreurs détectées : " + erreurs);
	    return erreurs;
	}

}
