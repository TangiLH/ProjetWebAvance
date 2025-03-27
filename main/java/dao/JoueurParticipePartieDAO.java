package dao;

import java.util.ArrayList;

import model.Partie;

public interface JoueurParticipePartieDAO {
	public ArrayList<Partie> listerPartiesJoueur(int idJoueur);
}
