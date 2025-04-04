package forms;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import dao.DAOException;
import dao.UtilisateurDAO;
import model.Utilisateur;
import utils.Password;

public class PasswordChangeForm {
	
	private static final String CHAMP_MDP   = "password";
	private String              resultat;
    private Map<String, String> erreurs         = new HashMap<String, String>();
	private UtilisateurDAO utilisateurDAO;
	private Password passwordHasher;

	public PasswordChangeForm(UtilisateurDAO utilisateurDAO) {
		this.utilisateurDAO = utilisateurDAO;
        this.passwordHasher=new Password();
	}
	
	public String getResultat() {
        return resultat;
    }
	
	private void traiterPassword( String password, Utilisateur utilisateur ) {
        try {
            validationPassword( password );
            password=passwordHasher.hash(password);
            
        } catch ( FormValidationException e ) {
            setErreur( CHAMP_MDP, e.getMessage() );
        }
        utilisateur.setPassword( password );
    }
	
	private void validationPassword( String password ) throws FormValidationException {
        if ( password != null && password.length() < 2 ) {
            throw new FormValidationException( "Le prépseudo d'utilisateur doit contenir au moins 2 caractères." );
        }
    }
	
	 /*
     * Ajoute un message correspondant au champ spécifié à la map des erreurs.
     */
    private void setErreur( String champ, String message ) {
        erreurs.put( champ, message );
    }

    /*
     * Méthode utilitaire qui retourne null si un champ est vide, et son contenu
     * sinon.
     */
    private static String getValeurChamp( HttpServletRequest request, String champ ) {
        String valeur = request.getParameter( champ );
        if ( valeur == null || valeur.trim().length() == 0 ) {
            return null;
        } else {
            return valeur;
        }
    }

	public void changerMDP(HttpServletRequest request) {
        String password = getValeurChamp( request, CHAMP_MDP );
        
        Utilisateur utilisateur = (Utilisateur) request.getSession().getAttribute("utilisateur");
        traiterPassword(password,utilisateur);

        try {
            if ( erreurs.isEmpty() ) {
                utilisateurDAO.changePassword( utilisateur );
                resultat = "Succès du changement de mot de passe.";
            } else {
                resultat = "Échec du changement de mot de passe";
            }
        } catch ( DAOException e ) {
            setErreur( "imprévu", "Erreur imprévue lors du changement de mot de passe" );
            resultat = "Échec du changement de mot de passe : une erreur imprévue est survenue, merci de réessayer dans quelques instants.";
            e.printStackTrace();
        }
		
	}

	public void addMoney(HttpServletRequest request) {
		//System.out.println("adding money");
		String montant = getValeurChamp(request,"montant");
		Utilisateur utilisateur = (Utilisateur) request.getSession().getAttribute("utilisateur");

        try {
            if ( erreurs.isEmpty() ) {
                utilisateurDAO.addMoney( utilisateur ,montant);
                utilisateur.setMoney(Integer.valueOf(montant));
                request.getSession().setAttribute("utilisateur", utilisateur);
                resultat = "Succès de l'ajout d'argent";
            } else {
                resultat = "Échec de l'ajout d'argent";
            }
        } catch ( DAOException e ) {
            setErreur( "imprévu", "Erreur imprévue lors de l'ajout d'argent" );
            resultat = "Échec de l'ajout d'argent: une erreur imprévue est survenue, merci de réessayer dans quelques instants.";
            e.printStackTrace();
        }
        
       
		
	}
	
}
