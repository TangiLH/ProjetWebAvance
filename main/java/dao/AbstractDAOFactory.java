package dao;


public abstract class AbstractDAOFactory {


	public abstract UtilisateurDAO getUtilisateurDao();

	public abstract PartieDAO getPartieDao();

	public abstract ItemDAO getItemDao();

	public abstract JoueurPossedeItemDAO getJoueurPossedeItemDAO();

	public abstract JoueurParticipePartieDAO getJoueurParticipeDAO();
}
