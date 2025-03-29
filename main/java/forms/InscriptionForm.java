package forms;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import model.Utilisateur;
import utils.Password;
import dao.UtilisateurDAO;
import dao.DAOException;

//import eu.medsea.mimeutil.MimeUtil;

public final class InscriptionForm {
    private static final String CHAMP_PSEUDO       = "pseudo";
    private static final String CHAMP_MDP   = "password";
                    // 10ko

    private String              resultat;
    private Map<String, String> erreurs         = new HashMap<String, String>();
    private UtilisateurDAO           utilisateurDAO;
    private Password passwordHasher;
    public InscriptionForm( UtilisateurDAO utilisateurDAO ) {
        this.utilisateurDAO = utilisateurDAO;
        this.passwordHasher=new Password();
    }

    public Map<String, String> getErreurs() {
        return erreurs;
    }

    public String getResultat() {
        return resultat;
    }

    public Utilisateur creerUtilisateur( HttpServletRequest request ) {
        String pseudo = getValeurChamp( request, CHAMP_PSEUDO );
        String password = getValeurChamp( request, CHAMP_MDP );

        Utilisateur utilisateur = new Utilisateur();

        traiterPseudo( pseudo, utilisateur );
        traiterPassword( password, utilisateur );

        try {
            if ( erreurs.isEmpty() ) {
                utilisateurDAO.creer( utilisateur );
                resultat = "Succès de la création du utilisateur.";
            } else {
                resultat = "Échec de la création du utilisateur.";
            }
        } catch ( DAOException e ) {
            setErreur( "imprévu", "Erreur imprévue lors de la création." );
            resultat = "Échec de la création du utilisateur : une erreur imprévue est survenue, merci de réessayer dans quelques instants.";
            e.printStackTrace();
        }

        return utilisateur;
    }

    private void traiterPseudo( String pseudo, Utilisateur utilisateur ) {
        try {
            validationPseudo( pseudo );
        } catch ( FormValidationException e ) {
            setErreur( CHAMP_PSEUDO, e.getMessage() );
        }
        utilisateur.setPseudo( pseudo );
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

    private void validationPseudo( String pseudo ) throws FormValidationException {
        if ( pseudo != null ) {
            if ( pseudo.length() < 2 ) {
                throw new FormValidationException( "Le pseudo d'utilisateur doit contenir au moins 2 caractères." );
            }
        } else {
            throw new FormValidationException( "Merci d'entrer un pseudo d'utilisateur." );
        }
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

    

    
}