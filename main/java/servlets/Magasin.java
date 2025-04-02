package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DAOFactory;
import dao.ItemDAO;
import dao.JoueurPossedeItemDAO;
import dao.UtilisateurDAO;
import model.Utilisateur;

/**
 * Servlet implementation class Magasin
 */
@WebServlet("/Magasin")
public class Magasin extends HttpServlet {
	private static final long serialVersionUID = 1L;


	private DAOFactory daoFactory;
	private ItemDAO itemDAO;
	private JoueurPossedeItemDAO jpiDAO;
	

	public Magasin() {
		super();
		this.daoFactory= DAOFactory.getInstance();
		this.itemDAO = daoFactory.getItemDao();
		this.jpiDAO = daoFactory.getJoueurPossedeItemDAO();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Récupérer l'utilisateur de la session
		Utilisateur utilisateur = (Utilisateur) request.getSession().getAttribute("utilisateur");

		if (utilisateur != null) {

			// Récupérer les items et les ajouter à l'attribut request
			request.setAttribute("items", itemDAO.listerItems());

			//Récupérer les items de l'utilisateur connecté
			request.setAttribute("gotItems", jpiDAO.listerItemsJoueur(utilisateur));

			// Passer à la page du magasin
			this.getServletContext().getRequestDispatcher("/WEB-INF/Magasin.jsp").forward(request, response);
		} else {
			// Si l'utilisateur n'est pas connecté, rediriger vers la page d'inscription ou d'accueil
			response.sendRedirect(request.getContextPath() + "/Inscription");
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
