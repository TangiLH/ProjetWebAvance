package dao;

import model.Utilisateur;

public interface UtilisateurDAO {
	void creer( Utilisateur utilisateur ) throws DAOException;

    Utilisateur trouver( String username ) throws DAOException;
}
