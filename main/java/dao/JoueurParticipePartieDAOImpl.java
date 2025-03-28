package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.Item;
import model.Partie;
import model.Utilisateur;

public class JoueurParticipePartieDAOImpl implements JoueurParticipePartieDAO {

	private DAOFactory daoFactory;
	private static final String SQL_SELECT_PAR_PSEUDO = "SELECT id, name, prix FROM Item WHERE nom = ?";
	private static final String SQL_INSERT = "INSERT INTO JoueurParticipePartie (id_joueur, id_partie) VALUES (?, ?)";
	private static final String SQL_LIST_ALL="SELECT id,name,prix FROM Item ORDER BY Prix DESC;";

	JoueurParticipePartieDAOImpl(DAOFactory daoFactory){
		this.daoFactory=daoFactory;
	}

	@Override
	public void creer(Utilisateur joueur,Partie partie) throws DAOException {
		Connection connexion = null;
		PreparedStatement preparedStatement = null;
		ResultSet valeursAutoGenerees = null;

		try {
			/* Récupération d'une connexion depuis la Factory */
			connexion = daoFactory.getConnection();
			preparedStatement = initialisationRequetePreparee( connexion, SQL_INSERT, true, joueur.getId(),partie.getId() );
			int statut = preparedStatement.executeUpdate();
			/* Analyse du statut retourné par la requête d'insertion */
			if ( statut == 0 ) {
				throw new DAOException( "Échec de la participation du joueur à la partie, aucune ligne ajoutée dans la table." );
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
	public ArrayList<Partie> listerPartiesJoueur(Utilisateur joueur){
		ArrayList<Partie>listParties=new ArrayList<>();
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
				listParties.add(mapPartie( resultSet ));
			}
		} catch ( SQLException e ) {
			throw new DAOException( e );
		} finally {
			fermeturesSilencieuses( resultSet, preparedStatement, connexion );
		}
		
		return listParties;
	}
	
	@Override
	public ArrayList<Utilisateur> listerJoueursPartie(Partie partie){
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
	private static Partie mapPartie( ResultSet resultSet ) throws SQLException {
		Partie partie = new Partie();
		partie.setId( resultSet.getInt( "id" ) );
		partie.setDate( (resultSet.getString( "datePartie" )) );
		return partie;
	}
	
	/*
	 * Simple méthode utilitaire permettant de faire la correspondance (le
	 * mapping) entre une ligne issue de la table des items (un
	 * ResultSet) et un bean Item.
	 */
	private static Utilisateur mapUtilisateur( ResultSet resultSet ) throws SQLException {
		Utilisateur utilisateur = new Utilisateur();
		utilisateur.setId( resultSet.getInt( "id" ) );
		utilisateur.setUsername( (resultSet.getString( "username" )) );
		utilisateur.setMotdepasse(resultSet.getString("password"));
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
