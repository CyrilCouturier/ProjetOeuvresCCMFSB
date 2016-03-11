package persistance;

import java.sql.*;
import java.util.*;
import meserreurs.*;

public class DialogueBd {

	private static DialogueBd instance = null;

	public static DialogueBd getInstance() {
		if (instance == null) {
			instance = new DialogueBd();
		}
		return instance;
	}

	private DialogueBd() {
		super();
	}

	public void insertionBD(String mysql) throws MonException {
		Connection cnx = null;
		try {
			cnx = Connexion.getInstance().getConnexion();
			Statement unstatement = cnx.createStatement();
			unstatement.execute(mysql);
			// on ferme la connexion
			cnx.close();
		} catch (SQLException e)

		{
			System.out.println("Erreur :" + e.getMessage());
			System.out.println(mysql);
			new MonException(e.getMessage());
		}

		catch (Exception e) {
			System.out.println(e.getMessage());
			throw new MonException(e.getMessage());
		}
	}

	public static List<Object> lecture(String req) throws MonException {
		Connection cnx = null;
		Statement stmt;
		ResultSet rs;
		List<Object> mesRes = new ArrayList<Object>();
		int i;
		int nbCols;
		try {

			cnx = Connexion.getInstance().getConnexion();
			stmt = cnx.createStatement();
			stmt.executeQuery("SET NAMES UTF8");
			// Execution de la requete
			rs = stmt.executeQuery(req);
			// on retrouve le nombre de colonnes de la requête
			ResultSetMetaData rsmd = rs.getMetaData();
			nbCols = rsmd.getColumnCount();
			i = 1;
			// on balaie toutes les lignes
			while (rs.next()) {

				// On balaie les colonnes
				i = 1;
				while (i <= nbCols) {
					mesRes.add(rs.getObject(i));
					i++;
				}
			}
			cnx.close();
			// Retourner la table
			return (mesRes);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new MonException(e.getMessage());
		} catch (Exception e) {
			System.out.println(e.getMessage());
			throw new MonException(e.getMessage());
		} finally {
			// S'il y a eu un problème, la connexion
			// peut être encore ouverte, dans ce cas
			// il faut la fermer.

			if (cnx != null)
				try {
					cnx.close();
				} catch (SQLException e) {
				}
		}
	}

	public void execute(String mysql) throws MonException {
		Connection cnx = null;
		try {
			cnx = Connexion.getInstance().getConnexion();
			Statement unstatement = cnx.createStatement();
			unstatement.execute(mysql);
			System.out.println(mysql);
			// on ferme la connexion
			cnx.close();
		} catch (SQLException e) {
			throw new MonException(e.getMessage());
		} catch (Exception e) {
			System.out.println(e.getMessage());
			throw new MonException(e.getMessage());
		}
	}

}
