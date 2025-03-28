package dao;

import model.Partie;

public interface PartieDAO {
	void creer( Partie partie ) throws DAOException;

    Partie trouver( int id ) throws DAOException;
}
