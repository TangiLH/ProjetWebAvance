package dao;

import model.Utilisateur;

public interface UtilisateurDAO {
	void creer( Utilisateur utilisateur ) throws DAOException;

    Utilisateur trouver( String email ) throws DAOException;
}
