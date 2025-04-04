package servlets;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.AbstractDAOFactory;
import dao.JoueurParticipePartieDAO;
import dao.PartieDAO;
import dao.UtilisateurDAO;

@SuppressWarnings("unused")
@WebServlet("/Accueil")
public class Accueil extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String CONF_DAO_FACTORY = "daofactory";
	private JoueurParticipePartieDAO jppDAO;
	private PartieDAO partieDAO;
	private UtilisateurDAO utilisateurDAO;

	public Accueil() {
		super();
	}

	public void init() throws ServletException {
		this.utilisateurDAO = ( (AbstractDAOFactory) getServletContext().getAttribute( CONF_DAO_FACTORY ) ).getUtilisateurDao();
		this.jppDAO = ( (AbstractDAOFactory) getServletContext().getAttribute( CONF_DAO_FACTORY ) ).getJoueurParticipeDAO();
		this.partieDAO = ( (AbstractDAOFactory) getServletContext().getAttribute( CONF_DAO_FACTORY ) ).getPartieDao();
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getSession();

		List<Map<String, Object>> classement = jppDAO.getScores();

		// Trier par ordre décroissant des scores
		classement.sort((a, b) -> ((Integer) b.get("score")).compareTo((Integer) a.get("score")));

		request.setAttribute("classement", classement);

		this.getServletContext().getRequestDispatcher("/WEB-INF/Accueil.jsp").forward(request, response);






	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
