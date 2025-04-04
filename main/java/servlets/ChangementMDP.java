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
import forms.PasswordChangeForm;
import model.Utilisateur;

/**
 * Servlet implementation class ChangementMDP
 */
@WebServlet("/ChangementMDP")
public class ChangementMDP extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String CONF_DAO_FACTORY = "daofactory";
	public static final String ACCUEIL = "/Accueil";
	public static final String COMPTE = "/Compte";
	private UtilisateurDAO utilisateurDAO;
	private PasswordChangeForm passwordChangeForm;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangementMDP() {
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
		request.getSession();
		response.sendRedirect(request.getContextPath() + ACCUEIL);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Utilisateur utilisateur = (Utilisateur) request.getSession().getAttribute("utilisateur");
		this.passwordChangeForm = new PasswordChangeForm(utilisateurDAO);
		HttpSession session = request.getSession();
		passwordChangeForm.changerMDP(request);
		
		response.sendRedirect(request.getContextPath() + COMPTE);
	}

}
