package dao;

import java.util.ArrayList;

import model.Partie;
import model.Utilisateur;

public interface JoueurParticipePartieDAO {
	public ArrayList<Partie> listerPartiesJoueur(Utilisateur joueur);
	public ArrayList<Utilisateur> listerJoueursPartie(Partie partie);
	void creer(Utilisateur joueur, Partie partie) throws DAOException;
}
