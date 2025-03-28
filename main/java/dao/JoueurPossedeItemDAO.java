package dao;

import java.util.ArrayList;

import model.Item;
import model.Utilisateur;

public interface JoueurPossedeItemDAO {
	public ArrayList<Item> listerItemsJoueur(Utilisateur joueur)throws DAOException;
	public ArrayList<Utilisateur> listerJoueursItem(Item item)throws DAOException;
	void creer(Utilisateur joueur, Item item) throws DAOException;
}
