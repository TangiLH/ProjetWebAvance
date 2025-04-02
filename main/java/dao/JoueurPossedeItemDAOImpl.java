package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.Item;
import model.Utilisateur;

public class JoueurPossedeItemDAOImpl implements JoueurPossedeItemDAO {

	private DAOFactory daoFactory;
	private static final String SQL_SELECT_PAR_PSEUDO = "SELECT id, nom, prix FROM Item WHERE nom = ?";
	private static final String SQL_INSERT = "INSERT INTO JoueurPossedeItem (id_joueur, id_item) VALUES (?, ?)";
	private static final String SQL_LIST_ALL="SELECT id,nom,prix FROM Item ORDER BY Prix DESC;";
	private static final String SQL_SELECT_ITEMS_JOUEUR = 
		    "SELECT i.id, i.nom, i.prix FROM Item i " +
		    "JOIN JoueurPossedeItem jpi ON i.id = jpi.id_item " +
		    "WHERE jpi.id_joueur = ?";

	JoueurPossedeItemDAOImpl(DAOFactory daoFactory){
		this.daoFactory=daoFactory;
	}

	@Override
	public void creer(Utilisateur joueur,Item item) throws DAOException {
		Connection connexion = null;
		PreparedStatement preparedStatement = null;
		ResultSet valeursAutoGenerees = null;

		try {
			/* Récupération d'une connexion depuis la Factory */
			connexion = daoFactory.getConnection();
			preparedStatement = initialisationRequetePreparee( connexion, SQL_INSERT, true, joueur.getId(),item.getId() );
			int statut = preparedStatement.executeUpdate();
			/* Analyse du statut retourné par la requête d'insertion */
			if ( statut == 0 ) {
				throw new DAOException( "Échec de la participation du joueur à la item, aucune ligne ajoutée dans la table." );
			}
			/* Récupération de l'id auto-généré par la requête d'insertion */
			valeursAutoGenerees = preparedStatement.getGeneratedKeys();
			if ( valeursAutoGenerees.next() ) {
				/* Puis initialisation de la propriété id du bean Item avec sa valeur */
			} else {
				throw new DAOException( "Échec, aucun ID auto-généré retourné." );
			}
		} catch ( SQLException e ) {
			throw new DAOException( e );
		} finally {
			fermeturesSilencieuses( valeursAutoGenerees, preparedStatement, connexion );
		}

	}

	
	@Override
	public ArrayList<Item> listerItemsJoueur(Utilisateur joueur){
		ArrayList<Item>listItems=new ArrayList<>();
		Connection connexion = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			/* Récupération d'une connexion depuis la Factory */
			connexion = daoFactory.getConnection();
			preparedStatement = initialisationRequetePreparee(connexion, SQL_SELECT_ITEMS_JOUEUR, false, joueur.getId());
			resultSet = preparedStatement.executeQuery();
			/* Parcours de la ligne de données de l'éventuel ResulSet retourné */
			while ( resultSet.next() ) {
				listItems.add(mapItem( resultSet ));
			}
		} catch ( SQLException e ) {
			throw new DAOException( e );
		} finally {
			fermeturesSilencieuses( resultSet, preparedStatement, connexion );
		}
		
		return listItems;
	}
	
	@Override
	public ArrayList<Utilisateur> listerJoueursItem(Item item){
		ArrayList<Utilisateur>listUtilisateur=new ArrayList<>();
		Connection connexion = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			/* Récupération d'une connexion depuis la Factory */
			connexion = daoFactory.getConnection();
			preparedStatement = initialisationRequetePreparee( connexion, SQL_LIST_ALL, false );
			resultSet = preparedStatement.executeQuery();
			/* Parcours de la ligne de données de l'éventuel ResulSet retourné */
			while ( resultSet.next() ) {
				listUtilisateur.add(mapUtilisateur( resultSet ));
			}
		} catch ( SQLException e ) {
			throw new DAOException( e );
		} finally {
			fermeturesSilencieuses( resultSet, preparedStatement, connexion );
		}
		
		return listUtilisateur;
	}

	/*
	 * Initialise la requête préparée basée sur la connexion passée en argument,
	 * avec la requête SQL et les objets donnés.
	 */
	public static PreparedStatement initialisationRequetePreparee( Connection connexion, String sql, boolean returnGeneratedKeys, Object... objets ) throws SQLException {
		PreparedStatement preparedStatement = connexion.prepareStatement( sql, returnGeneratedKeys ? Statement.RETURN_GENERATED_KEYS : Statement.NO_GENERATED_KEYS );
		for ( int i = 0; i < objets.length; i++ ) {
			preparedStatement.setObject( i + 1, objets[i] );
		}
		return preparedStatement;
	}

	/*
	 * Simple méthode utilitaire permettant de faire la correspondance (le
	 * mapping) entre une ligne issue de la table des items (un
	 * ResultSet) et un bean Item.
	 */
	private static Item mapItem( ResultSet resultSet ) throws SQLException {
		Item item = new Item();
		item.setId( resultSet.getInt( "id" ) );
		item.setNom(resultSet.getString("nom"));
		item.setPrix( Integer.valueOf(resultSet.getString( "prix" )) );
		return item;
	}
	
	/*
	 * Simple méthode utilitaire permettant de faire la correspondance (le
	 * mapping) entre une ligne issue de la table des items (un
	 * ResultSet) et un bean Item.
	 */
	private static Utilisateur mapUtilisateur( ResultSet resultSet ) throws SQLException {
		Utilisateur utilisateur = new Utilisateur();
		utilisateur.setId( resultSet.getInt( "id" ) );
		utilisateur.setPseudo( (resultSet.getString( "username" )) );
		utilisateur.setPassword(resultSet.getString("password"));
		return utilisateur;
	}

	/* Fermeture silencieuse du resultset */
	public static void fermetureSilencieuse( ResultSet resultSet ) {
		if ( resultSet != null ) {
			try {
				resultSet.close();
			} catch ( SQLException e ) {
				System.out.println( "Échec de la fermeture du ResultSet : " + e.getMessage() );
			}
		}
	}

	/* Fermeture silencieuse du statement */
	public static void fermetureSilencieuse( Statement statement ) {
		if ( statement != null ) {
			try {
				statement.close();
			} catch ( SQLException e ) {
				System.out.println( "Échec de la fermeture du Statement : " + e.getMessage() );
			}
		}
	}

	/* Fermeture silencieuse de la connexion */
	public static void fermetureSilencieuse( Connection connexion ) {
		if ( connexion != null ) {
			try {
				connexion.close();
			} catch ( SQLException e ) {
				System.out.println( "Échec de la fermeture de la connexion : " + e.getMessage() );
			}
		}
	}

	/* Fermetures silencieuses du statement et de la connexion */
	public static void fermeturesSilencieuses( Statement statement, Connection connexion ) {
		fermetureSilencieuse( statement );
		fermetureSilencieuse( connexion );
	}

	/* Fermetures silencieuses du resultset, du statement et de la connexion */
	public static void fermeturesSilencieuses( ResultSet resultSet, Statement statement, Connection connexion ) {
		fermetureSilencieuse( resultSet );
		fermetureSilencieuse( statement );
		fermetureSilencieuse( connexion );
	}


}
