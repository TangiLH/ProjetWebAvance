package dao;

import model.Utilisateur;

public interface UtilisateurDAO {
	void creer( Utilisateur utilisateur ) throws DAOException;

    Utilisateur trouver( String username ) throws DAOException;

	void update(Utilisateur utilisateur) throws DAOException;

	Utilisateur findByID(int id) throws DAOException;
	
	void changePassword(Utilisateur utilisateur);
	
	void addMoney(Utilisateur utilisateur,String montant);
}
