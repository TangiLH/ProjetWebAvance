package dao;

import model.Item;

public interface ItemDAO {
	void creer( Item item ) throws DAOException;

    Item trouver( String name ) throws DAOException;

}
