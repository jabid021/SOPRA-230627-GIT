package escapeGame.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import escapeGame.dao.DAOCompte;
import escapeGame.dao.DAOMateriel;
import escapeGame.dao.DAOParticipant;
import escapeGame.dao.DAOReservation;
import escapeGame.dao.DAOSalle;
import escapeGame.model.Adresse;
import escapeGame.model.Cadenas;
import escapeGame.model.Client;
import escapeGame.model.Coffre;
import escapeGame.model.Compte;
import escapeGame.model.Difficulte;
import escapeGame.model.Etat;
import escapeGame.model.GameMaster;
import escapeGame.model.Gerant;
import escapeGame.model.Materiel;
import escapeGame.model.Mecanisme;
import escapeGame.model.Participant;
import escapeGame.model.Reservation;
import escapeGame.model.Salle;

public class App {

	static DAOCompte daoCompte = new DAOCompte();
	static DAOReservation daoReservation = new DAOReservation();
	static DAOSalle daoSalle = new DAOSalle();
	static DAOParticipant daoParticipant = new DAOParticipant();
	static DAOMateriel daoMateriel = new DAOMateriel();

	static Compte connected;

	public static String saisieString(String msg) {
		Scanner monScanner = new Scanner(System.in);
		System.out.println(msg);
		String variable = monScanner.nextLine();
		return variable;
	}

	public static int saisieInt(String msg) {
		Scanner monScanner = new Scanner(System.in);
		System.out.println(msg);
		int variable = monScanner.nextInt();
		return variable;
	}

	public static double saisieDouble(String msg) {
		Scanner monScanner = new Scanner(System.in);
		System.out.println(msg);
		double variable = monScanner.nextDouble();
		return variable;
	}

	public static boolean saisieBoolean(String msg) {
		Scanner monScanner = new Scanner(System.in);
		System.out.println(msg);
		boolean variable = monScanner.nextBoolean();
		return variable;
	}

	public static void menuPrincipal() {
		System.out.println("Bienvenue sur l'app Escape Game");
		System.out.println("1 - Se connecter");
		System.out.println("2 - Inscription");
		System.out.println("3 - Stop");

		int choix = saisieInt("Choisir menu");
		switch (choix) {
		case 1:
			seConnecter();
			break;
		case 2:
			inscription();
			break;
		case 3:
			System.exit(0);
			break;
		}

		menuPrincipal();
	}

	public static void inscription() {

		System.out.println("Inscription d'un client");
		String login = saisieString("Saisir votre login");
		String password = saisieString("Saisir votre password");
		String nom = saisieString("Saisir votre nom");
		String prenom = saisieString("Saisir votre prenom");
		String tel = saisieString("Saisir votre tel");
		String mail = saisieString("Saisir votre mail");
		System.out.println("Saisie de l'adresse");
		String numero = saisieString("Saisir votre numero");
		String voie = saisieString("Saisir votre voie");
		String ville = saisieString("Saisir votre ville");
		String cp = saisieString("Saisir votre cp");

		Adresse adresse = new Adresse(numero, voie, ville, cp);
		Client client = new Client(login, password, nom, prenom, tel, mail, adresse);

		daoCompte.save(client);

	}

	public static void seConnecter() {
		System.out.println("\nEcran de connexion\n");
		String login = saisieString("Saisir votre login");
		String password = saisieString("Saisir votre password");

		connected = daoCompte.findByLoginAndPassword(login, password);

		if (connected instanceof Client) {
			menuClient();
		} else if (connected instanceof Gerant) {
			menuGerant();
		} else if (connected instanceof GameMaster) {
			menuGameMaster();
		} else {
			System.out.println("Identifiants invalides");
		}

	}

	public static void menuGerant() {
		System.out.println("\nMenu Gerant\n");
		System.out.println("1 - Gestion du Materiel");
		System.out.println("2 - Gestion des Salles");
		System.out.println("3 - Gestion des Comptes");
		System.out.println("4 - Gestion des Participants");
		System.out.println("5 - Gestion des Reservations");
		System.out.println("6 - Se deconnecter");

		int choix = saisieInt("Choisir un menu");

		switch (choix) {
		case 1:
			gestionMateriel();
			break;
		case 2:
			gestionSalle();
			break;
		case 3:
			gestionCompte();
			break;
		case 4:
			gestionParticipant();
			break;
		case 5:
			gestionReservation();
			break;
		case 6:
			menuPrincipal();
			break;
		}

		menuGerant();

	}

	public static void gestionMateriel() {
		System.out.println("Gestion du materiel :");
		System.out.println("1 - Afficher le materiel");
		System.out.println("2 - Ajouter du materiel");
		System.out.println("3 - Retour");

		int choix = saisieInt("Choisir menu");
		switch (choix) {
		case 1:
			afficherMateriel();
			break;
		case 2:
			ajouterMateriel();
			break;
		case 3:
			menuGerant();
			break;
		}

		gestionMateriel();
	}

	public static void afficherMateriel() {
		List<Materiel> materiels = daoMateriel.findAll();

		if (materiels.isEmpty()) {
			System.out.println("Pas de materiel");
		}
		for (Materiel m : materiels) {
			System.out.println(m);
		}

	}

	public static void ajouterMateriel() {
		System.out.println("Ajout d'un materiel :");
		String type = saisieString("Quel type de materiel ? (Cadenas / Coffre / Mecanisme)");
		String libelle = saisieString("Saisir le libelle");
		String etat = saisieString("Quel etat ? " + Arrays.toString(Etat.values()));
		Materiel materiel;
		if (type.equalsIgnoreCase("cadenas")) {
			String code = saisieString("Saisir code du cadenas");
			materiel = new Cadenas(libelle, null, Etat.valueOf(etat), code);
		} else if (type.equalsIgnoreCase("coffre")) {
			String code = saisieString("Saisir code du coffre");
			int attente = saisieInt("Temps d'attente avant le prochain code");
			materiel = new Coffre(libelle, null, Etat.valueOf(etat), code, attente);
		} else {
			boolean electrique = saisieBoolean("Ce mecanisme est electrique ? true/false");
			materiel = new Mecanisme(libelle, null, Etat.valueOf(etat), electrique);
		}

		afficherSalle();
		int choix = saisieInt("Saisir l'id de la salle  (0 pour null)");
		if (choix != 0) {
			Salle salle = daoSalle.findById(choix);
			materiel.setSalle(salle);
		}

		daoMateriel.save(materiel);

	}

	public static void gestionSalle() {
		System.out.println("Gestion des salles :");
		System.out.println("1 - Afficher les salles");
		System.out.println("2 - Ajouter une salle");
		System.out.println("3 - Retour");

		int choix = saisieInt("Choisir menu");
		switch (choix) {
		case 1:
			afficherSalle();
			break;
		case 2:
			ajouterSalle();
			break;
		case 3:
			menuGerant();
			break;
		}

		gestionSalle();

	}

	public static void afficherSalle() {
		List<Salle> salles = daoSalle.findAll();

		if (salles.isEmpty()) {
			System.out.println("Pas de salle");
		}
		for (Salle s : salles) {
			System.out.println(s);
		}
	}

	public static void ajouterSalle() {
		System.out.println("Ajout d'une salle :");

		int min = saisieInt("Nombre de joueur min");
		int max = saisieInt("Nombre de joueur max");
		String titre = saisieString("Saisir le titre");
		String description = saisieString("Saisir description");
		int duree = saisieInt("Saisir duree (en minute)");
		double prix = saisieDouble("Saisir prix par joueur");
		boolean accessibilite = saisieBoolean("Accessibilite ? true/false");
		String difficulte = saisieString("Quelle difficulte ?" + Arrays.toString(Difficulte.values()));

		Salle salle = new Salle(min, max, titre, description, duree, prix, accessibilite,
				Difficulte.valueOf(difficulte));

		daoSalle.save(salle);
	}

	public static void gestionCompte() {
		System.out.println("Gestion des comptes :");
		System.out.println("1 - Afficher les comptes");
		System.out.println("2 - Ajouter un compte");
		System.out.println("3 - Retour");

		int choix = saisieInt("Choisir menu");
		switch (choix) {
		case 1:
			afficherCompte();
			break;
		case 2:
			ajouterCompte();
			break;
		case 3:
			menuGerant();
			break;
		}

		gestionCompte();
	}

	public static void afficherCompte() {
		List<Compte> comptes = daoCompte.findAll();

		if (comptes.isEmpty()) {
			System.out.println("Pas de compte");
		}
		for (Compte c : comptes) {
			System.out.println(c);
		}
	}

	public static void ajouterCompte() {
		Compte compte;
		System.out.println("Ajout d'un compte :");
		String typePersonne = saisieString("Qui êtes-vous? Gerant/GameMaster/Client");
		String login = saisieString("Saisir votre login");
		String password = saisieString("Saisir votre password");
		String nom = saisieString("Saisir votre nom");
		String prenom = saisieString("Saisir votre prenom");

		if (typePersonne.equalsIgnoreCase("Client")) {
			String tel = saisieString("Saisir votre tel");
			String mail = saisieString("Saisir votre mail");
			System.out.println("Saisie de l'adresse");
			String numero = saisieString("Saisir votre numero");
			String voie = saisieString("Saisir votre voie");
			String ville = saisieString("Saisir votre ville");
			String cp = saisieString("Saisir votre cp");

			Adresse adresse = new Adresse(numero, voie, ville, cp);
			compte = new Client(login, password, nom, prenom, tel, mail, adresse);

		} else if (typePersonne.equalsIgnoreCase("Gerant")) {
			compte = new Gerant(login, password, nom, prenom);
		} else {
			compte = new GameMaster(login, password, nom, prenom);
		}

		daoCompte.save(compte);

	}

	public static void gestionParticipant() {
		System.out.println("Gestion du materiel :");
		System.out.println("1 - Afficher les participants");
		System.out.println("2 - Retour");

		int choix = saisieInt("Choisir menu");
		switch (choix) {
		case 1:
			afficherParticipant();
			break;
		case 2:
			menuGerant();
			break;
		}

		gestionParticipant();
	}

	public static void afficherParticipant() {
		List<Participant> participants = daoParticipant.findAll();

		if (participants.isEmpty()) {
			System.out.println("Pas de participant");
		}
		for (Participant p : participants) {
			System.out.println(p);
		}

	}

	public static void gestionReservation() {
		System.out.println("Gestion des reservations :");
		System.out.println("1 - Afficher les reservations");
		System.out.println("2 - Affecter un game master");
		System.out.println("3 - Retour");

		int choix = saisieInt("Choisir menu");
		switch (choix) {
		case 1:
			afficherReservation();
			break;
		case 2:
			affecterGameMaster();
			break;
		case 3:
			menuGerant();
			break;
		}

		gestionReservation();
	}

	public static void afficherReservation() {
		List<Reservation> reservations = daoReservation.findAll();

		if (reservations.isEmpty()) {
			System.out.println("Pas de reservation");
		}
		for (Reservation r : reservations) {
			System.out.println(r);
		}

	}

	public static void afficherGameMaster() {
		List<GameMaster> gameMasters = daoCompte.findAllGameMaster();

		if (gameMasters.isEmpty()) {
			System.out.println("Pas de game master");
		}
		for (GameMaster g : gameMasters) {
			System.out.println(g);
		}

	}

	public static void affecterGameMaster() {
		afficherReservation();
		int choix = saisieInt("Saisir l'id de la reservation");
		Reservation reservation = daoReservation.findById(choix);
		afficherGameMaster();
		choix = saisieInt("Saisir l'id du game master (0 pour null)");
		if (choix != 0) {
			GameMaster gm = (GameMaster) daoCompte.findById(choix);
			reservation.setGameMaster(gm);
		} else {
			reservation.setGameMaster(null);
		}
		daoReservation.save(reservation);

	}

	public static void menuGameMaster() {
		System.out.println("\nMenu Game Master\n");
		System.out.println("1 - Afficher mon planning");
		System.out.println("2 - Se deconnecter");

		int choix = saisieInt("Choisir un menu");

		switch (choix) {
		case 1:
			afficherPlanning();
			break;
		case 2:
			menuPrincipal();
			break;
		}

		menuGameMaster();

	}

	public static void afficherPlanning() {
		List<Reservation> reservations = daoReservation
				.findByGameMasterAndDateReservationGreaterThan((GameMaster) connected, LocalDate.now());

		System.out.println("Voici votre planning");
		if (reservations.isEmpty()) {
			System.out.println("Vacances!");
		} else {
			System.out.println("Vous avez " + reservations.size() + " reservation(s)");
			for (Reservation r : reservations) {
				System.out.println(r.toString());
			}
		}
	}

	public static void menuClient() {
		System.out.println("\nMenu Client\n");
		System.out.println("1 - Faire une reservation");
		System.out.println("2 - Afficher mes participants");
		System.out.println("3 - Supprimer un de mes participants");
		System.out.println("4 - Se deconnecter");

		int choix = saisieInt("Choisir un menu");

		switch (choix) {
		case 1:
			reserverSalle();
			break;
		case 2:
			afficherMesParticipants();
			break;

		case 3:
			supprimerMesParticipants();
			break;
		case 4:
			menuPrincipal();
			break;
		}

		menuClient();
	}

	public static void afficherMesParticipants() {
		Client client = (Client) connected;
		List<Participant> participants = daoParticipant.findAllByClient(client);

		if (participants.isEmpty()) {
			System.out.println("Vous n'avez pas encore créé de participant");
		}
		for (Participant p : participants) {
			System.out.println(p);
		}
	}

	
	
	public static void supprimerMesParticipants() {
		afficherMesParticipants();
		int id = saisieInt("Saisir l'id du participant à supprimer");
		daoParticipant.delete(null);
	}

	
	public static void reserverSalle() {
		Client client = (Client) connected;
		List<Participant> inscriptions = new ArrayList();
		

		afficherSalle();
		int choix = saisieInt("Choisir une salle");
		Salle salle = daoSalle.findById(choix);
		String equipe = saisieString("Saisir le nom de l'equipe");

		afficherMesParticipants();
	
		boolean restart;
		do {
			boolean participantExistant = saisieBoolean("Utiliser un ancien participant ? true / false");
			if (participantExistant) {
				choix = saisieInt("Saisir l'id du participant");
				Participant p = daoParticipant.findById(choix);
				inscriptions.add(p);
			} else {
				String nom = saisieString("Saisir le nom du participant");
				String prenom = saisieString("Saisir le prenom du participant");
				Participant p = new Participant(nom, prenom, client);
				daoParticipant.save(p);
				inscriptions.add(p);
			}

			restart = saisieBoolean("Ajouter un autre participant ? true / false");
		} while (restart);

		double prix = salle.getPrix() * inscriptions.size();
		Reservation r = new Reservation(LocalDate.now(), LocalTime.now(), null, equipe, prix, client, salle, null);
		r.setParticipants(inscriptions);
		daoReservation.save(r);
	}

	public static void main(String[] args) {

		menuPrincipal();
	}

}
