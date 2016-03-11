package dao;

import meserreurs.MonException;
import java.util.*;

import metier.*;
import persistance.*;

public class Service {

	// Mise à jour des caractéristiques d'un adhérent
	// Le booleen indique s'il s'agit d'un nouvel adhérent, auquel cas on fait
	// une création

	public void insertAdherent(Adherent unAdherent) throws MonException {
		String mysql;

		DialogueBd unDialogueBd = DialogueBd.getInstance();
		try {
			mysql = "insert into adherent  (nom_adherent,prenom_adherent,ville_adherent)  " + "values ('"
					+ unAdherent.getNomAdherent();
			mysql += "'" + ",'" + unAdherent.getPrenomAdherent() + "','" + unAdherent.getVilleAdherent() + "')";

			unDialogueBd.insertionBD(mysql);
		} catch (MonException e) {
			throw e;
		}
	}

	// gestion des adherents
	// Consultation d'un adhérent par son numéro
	// Fabrique et renvoie un objet adhérent contenant le résultat de la requête
	// BDD
	public Adherent consulterAdherent(int numero) throws MonException {
		String mysql = "select * from adherent where numero_adherent=" + numero;
		List<Adherent> mesAdh = consulterListeAdherents(mysql);
		if (mesAdh.isEmpty())
			return null;
		else {
			return mesAdh.get(0);
		}
	}

	// Consultation des adhérents
	// Fabrique et renvoie une liste d'objets adhérent contenant le résultat de
	// la requête BDD
	public List<Adherent> consulterListeAdherents() throws MonException {
		String mysql = "select * from adherent";
		return consulterListeAdherents(mysql);
	}
	
	public List<Adherent> consulterListeAdherentsRecherche(String recherche) throws MonException {
		String mysql = "select * from adherent WHERE nom_adherent LIKE '%"+recherche+"%' OR prenom_adherent LIKE '%"+recherche+"%'";
		System.out.println(mysql);
		return consulterListeAdherents(mysql);
	}

	private List<Adherent> consulterListeAdherents(String mysql) throws MonException {
		List<Object> rs;
		List<Adherent> mesAdherents = new ArrayList<Adherent>();
		int index = 0;
		try {
			DialogueBd unDialogueBd = DialogueBd.getInstance();
			rs = DialogueBd.lecture(mysql);
			while (index < rs.size()) {
				// On crée un stage
				Adherent unA = new Adherent();
				// il faut redecouper la liste pour retrouver les lignes
				unA.setIdAdherent(Integer.parseInt(rs.get(index + 0).toString()));
				unA.setNomAdherent(rs.get(index + 1).toString());
				unA.setPrenomAdherent(rs.get(index + 2).toString());
				unA.setVilleAdherent(rs.get(index + 3).toString());
				// On incrémente tous les 3 champs
				index = index + 4;
				mesAdherents.add(unA);
			}

			return mesAdherents;
		} catch (Exception exc) {
			throw new MonException(exc.getMessage(), "systeme");
		}
	}
	
	public List<Oeuvrepret> consulterListeOeuvrePret() throws MonException {
		String mysql = "select * from oeuvrepret";
		return consulterListeOeuvrePret(mysql);
	}
	
	public List<Oeuvrepret> consulterListeOeuvrePretRecherche(String recherche) throws MonException {
		String mysql = "select * from oeuvrepret WHERE titre_oeuvrepret LIKE '%"+recherche+"%'";
		return consulterListeOeuvrePret(mysql);
	}
	
	private List<Oeuvrepret> consulterListeOeuvrePret(String mysql) throws MonException {
		List<Object> rs;
		List<Object> rp;
		List<Oeuvrepret> mesOeuvres = new ArrayList<Oeuvrepret>();
		int index = 0;
		int proprio = 0;
		try {
			DialogueBd unDialogueBd = DialogueBd.getInstance();
			rs = DialogueBd.lecture(mysql);
			String mysqlproprio = "select * from proprietaire WHERE id_proprietaire=";
			while (index < rs.size()) {
				// On crée un stage
				Oeuvrepret unA = new Oeuvrepret();
				// il faut redecouper la liste pour retrouver les lignes
				unA.setIdOeuvrepret(Integer.parseInt(rs.get(index + 0).toString()));
				unA.setTitreOeuvrepret(rs.get(index + 1).toString());
				rp = DialogueBd.lecture(mysqlproprio.concat(rs.get(index + 2).toString()));
				Proprietaire unAd = new Proprietaire();
				// il faut redecouper la liste pour retrouver les lignes
				unAd.setIdProprietaire(Integer.parseInt(rp.get(proprio + 0).toString()));
				unAd.setNomProprietaire(rp.get(proprio + 1).toString());
				unAd.setPrenomProprietaire(rp.get(proprio + 2).toString());
				unA.setProprietaire(unAd);
				// On incrémente tous les 3 champs
				index = index + 3;
				mesOeuvres.add(unA);
			}

			return mesOeuvres;
		} catch (Exception exc) {
			throw new MonException(exc.getMessage(), "systeme");
		}
	}
	
	public List<Oeuvrevente> consulterListeOeuvreVendre() throws MonException {
		String mysql = "select * from oeuvrevente";
		return consulterListeOeuvreVendre(mysql);
	}
	
	public List<Oeuvrevente> consulterListeOeuvreVendreRecherche(String recherche) throws MonException {
		String mysql = "select * from oeuvrevente WHERE titre_oeuvrevente LIKE '%"+recherche+"%'";
		return consulterListeOeuvreVendre(mysql);
	}
	
	public List<Oeuvrevente> consulterListeOeuvreReservable() throws MonException{
		String mysql = "select * from oeuvrevente WHERE etat_oeuvrevente ='L' ";
		return consulterListeOeuvreVendre(mysql);
	}
	
	private List<Oeuvrevente> consulterListeOeuvreVendre(String mysql) throws MonException {
		List<Object> rs;
		List<Object> rp;
		List<Oeuvrevente> mesOeuvres = new ArrayList<Oeuvrevente>();
		int index = 0;
		int proprio = 0;
		try {
			DialogueBd unDialogueBd = DialogueBd.getInstance();
			rs = DialogueBd.lecture(mysql);
			String mysqlproprio = "select * from proprietaire WHERE id_proprietaire=";
			while (index < rs.size()) {
				// On crée un stage
				Oeuvrevente unA = new Oeuvrevente();
				// il faut redecouper la liste pour retrouver les lignes
				unA.setIdOeuvrevente(Integer.parseInt(rs.get(index + 0).toString()));
				unA.setTitreOeuvrevente(rs.get(index + 1).toString());
				unA.setEtatOeuvrevente(rs.get(index + 2).toString());
				unA.setPrixOeuvrevente(Float.parseFloat(rs.get(index + 3).toString()));
				rp = DialogueBd.lecture(mysqlproprio.concat(rs.get(index + 4).toString()));
				Proprietaire unAd = new Proprietaire();
				// il faut redecouper la liste pour retrouver les lignes
				unAd.setIdProprietaire(Integer.parseInt(rp.get(proprio + 0).toString()));
				unAd.setNomProprietaire(rp.get(proprio + 1).toString());
				unAd.setPrenomProprietaire(rp.get(proprio + 2).toString());
				unA.setProprietaire(unAd);
				// On incrémente tous les 3 champs
				index = index + 5;
				mesOeuvres.add(unA);
			}

			return mesOeuvres;
		} catch (Exception exc) {
			throw new MonException(exc.getMessage(), "systeme");
		}
	}
	

}
