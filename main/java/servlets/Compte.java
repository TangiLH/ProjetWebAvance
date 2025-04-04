package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AbstractDAOFactory;
import dao.UtilisateurDAO;
import model.Utilisateur;

/**
 * Servlet implementation class Compte
 */
@WebServlet("/Compte")
public class Compte extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String CONF_DAO_FACTORY = "daofactory";
	private UtilisateurDAO utilisateurDAO;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Compte() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public void init() throws ServletException {
        this.utilisateurDAO = ( (AbstractDAOFactory) getServletContext().getAttribute( CONF_DAO_FACTORY ) ).getUtilisateurDao();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Récupérer l'utilisateur de la session
				Utilisateur utilisateur = (Utilisateur) request.getSession().getAttribute("utilisateur");

				if (utilisateur != null) {


					// Passer à la page du magasin
					this.getServletContext().getRequestDispatcher("/WEB-INF/Compte.jsp").forward(request, response);
				} else {
					// Si l'utilisateur n'est pas connecté, rediriger vers la page d'inscription ou d'accueil
					response.sendRedirect(request.getContextPath() + "/Inscription");
				}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
