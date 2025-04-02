package servlets;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.DAOFactory;
import dao.ItemDAO;
import dao.UtilisateurDAO;
import model.Item;
import model.Utilisateur;

@WebServlet("/ConfirmationAchat")
public class ConfirmationAchat extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private DAOFactory daoFactory;
    private ItemDAO itemDAO;   
    private UtilisateurDAO userDAO;

    public ConfirmationAchat() {
        super();
        this.daoFactory = DAOFactory.getInstance();
        this.itemDAO = daoFactory.getItemDao();
        this.userDAO = daoFactory.getUtilisateurDao();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String itemName = request.getParameter("itemName");

        Utilisateur utilisateur = (Utilisateur) session.getAttribute("utilisateur");

        if (utilisateur != null) {
            Item item = itemDAO.trouver(itemName);
            session.setAttribute("item", item);

            if (item != null) {
                if (utilisateur.getMoney() >= item.getPrix()) {
                    // Déduire le prix de l'item du solde de l'utilisateur
                    utilisateur.setMoney(utilisateur.getMoney() - item.getPrix());

                    // Mettre à jour l'utilisateur en base de données
                    userDAO.update(utilisateur);

                    // Mettre à jour la session avec les nouvelles informations
                    session.setAttribute("utilisateur", utilisateur);
                    
                    // Ajouter un message de succès
                    request.setAttribute("message", "Merci pour votre achat !");
                    request.setAttribute("achatReussi", true);
                } else {
                    // Fond insuffisant
                    request.setAttribute("message", "Fonds insuffisants pour cet achat.");
                    request.setAttribute("achatReussi", false);
                }
            } else {
                request.setAttribute("message", "L'article demandé n'existe pas.");
                request.setAttribute("achatReussi", false);
            }

            request.setAttribute("user", userDAO.trouver(utilisateur.getPseudo()));

            RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/Confirmation.jsp");
            dispatcher.forward(request, response);
        } else {
            response.sendRedirect(request.getContextPath() + "/Inscription");
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
