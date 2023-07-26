package hopital.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import hopital.context.Singleton;
import hopital.dao.IDAOCompte;
import hopital.dao.IDAOPatient;
import hopital.dao.IDAOVisite;
import hopital.model.Compte;
import hopital.model.Medecin;
import hopital.model.Patient;
import hopital.model.Secretaire;
import hopital.model.Visite;

public class App {

	
	static IDAOCompte daoCompte = Singleton.getInstance().getDaoCompte();
	static IDAOPatient daoPatient = Singleton.getInstance().getDaoPatient();
	static IDAOVisite daoVisite = Singleton.getInstance().getDaoVisite();
	
	
	static Compte connected;
	static boolean isPause = false;

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



	public static void menuPrincipal() {
		System.out.println("App Hopital\n");
		System.out.println("1 - Se connecter");
		System.out.println("2 - Stop");
		int choix = saisieInt("Choisir menu");

		switch(choix) 
		{
		case 1 : seConnecter();break;
		case 2 : System.exit(0);
		}
		menuPrincipal();
	}

	public static void seConnecter() {
		String login = saisieString("Saisir votre login");
		String password = saisieString("Saisir votre password");
		connected=daoCompte.findByLoginAndPassword(login, password);
		if(connected instanceof Medecin) 
		{
			int salle = saisieInt("Quelle salle ?");
			((Medecin) connected).setSalle(salle);
			menuMedecin();
		}
		else if(connected instanceof Secretaire) 
		{
			if(isPause) 
			{
				menuSecretairePause();
			}
			else 
			{
				menuSecretaire();
			}
		}
		else 
		{
			System.out.println("Identifiants invalides");
		}

	}

	public static void menuSecretaire() {
		System.out.println("\nMenu Secretaire\n");
		System.out.println("1 - Inscription patient");
		System.out.println("2 - Afficher l'etat de la file d'attente");
		System.out.println("3 - Afficher toutes les visites d'un patient");
		System.out.println("4 - Partir en pause");
		System.out.println("5 - Se deconnecter");

		int choix = saisieInt("Choisir un menu");
		switch(choix) 
		{
		case 1 : inscription();break;
		case 2 : afficherFileAttente();break;
		case 3 : afficherVisitesPatient();break;
		case 4 : partirEnPause();break;
		case 5 : connected=null;menuPrincipal();

		}
		menuSecretaire();
	}

	public static void partirEnPause() {
		File f = new File("fileAttente.txt");
		
		try {
		FileOutputStream fos = new FileOutputStream(f);
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		
		oos.writeObject(Singleton.getInstance().getFileAttente());
		Singleton.getInstance().getFileAttente().clear();
		isPause=true;
		
		oos.close();
		fos.close();
		}
		catch(Exception e) 
		{
			e.printStackTrace();
		}
		
		menuSecretairePause();
	}

	public static void afficherVisitesPatient() {
		Integer id = saisieInt("Saisir l'id du patient");
		Patient patient = daoPatient.findById(id);
		if(patient !=null) 
		{
			List<Visite> visites = daoVisite.findAllByPatient(patient);
			if(visites.isEmpty()) 
			{
				System.out.println("Le patient "+id+" n'a pas de visite");
			}
			for(Visite visite : visites) 
			{
				System.out.println(visite);
			}
		}
		else 
		{
			System.out.println("Le patient "+id+" n'existe pas");
		}

	}

	public static void afficherFileAttente() {
		if(Singleton.getInstance().getFileAttente().isEmpty()) 
		{
			System.out.println("Aucun patient dans la file d'attente");
		}
		for(Patient patient : Singleton.getInstance().getFileAttente()) 
		{
			System.out.println(patient);
		}
	}

	public static void inscription() {
		Integer id = saisieInt("Saisir l'id du patient");
		Patient patient = daoPatient.findById(id);
		if(patient ==null) 
		{
			System.out.println("Inscription d'un nouveau patient :");
			String prenom = saisieString("Saisir prenom");
			String nom = saisieString("Saisir nom");
			patient = new Patient(id,prenom,nom);
			daoPatient.insert(patient);
		}
		Singleton.getInstance().getFileAttente().add(patient);
		System.out.println("Patient ajouté dans la file");

	}

	public static void menuSecretairePause() {
		System.out.println("\nMenu Secretaire PAUSE\n");
		System.out.println("1 - Retour de pause");
		System.out.println("2 - Se deconnecter");

		int choix = saisieInt("Choisir un menu");
		switch(choix) 
		{
		case 1 : retourPause();break;
		case 2 : connected=null;menuPrincipal();

		}
		menuSecretairePause();

	}

	public static void retourPause() {
		File f = new File("fileAttente.txt");
		
		try {
		FileInputStream fis = new FileInputStream(f);
		ObjectInputStream ois = new ObjectInputStream(fis);
		
		
		Singleton.getInstance().setFileAttente((LinkedList<Patient>) ois.readObject());
		isPause=false;
		
		ois.close();
		fis.close();
		}
		catch(Exception e) 
		{
			e.printStackTrace();
		}
		
		menuSecretaire();
	}

	public static void menuMedecin() {
		System.out.println("\nMenu Medecin\n");
		System.out.println("1 - Recevoir patient");
		System.out.println("2 - Afficher l'etat de la file d'attente");
		System.out.println("3 - Sauvegarder mes visites");
		System.out.println("4 - Se deconnecter");

		int choix = saisieInt("Choisir un menu");
		switch(choix) 
		{
		case 1 : recevoirPatient();break;
		case 2 : afficherFileAttenteMedecin();break;
		case 3 : sauvegarderVisites();break;
		case 4 : connected=null;menuPrincipal();

		}
		menuMedecin();
	}

	public static void afficherFileAttenteMedecin() {
		if(Singleton.getInstance().getFileAttente().isEmpty()) 
		{
			System.out.println("Aucun patient dans la file d'attente");
		}
		else 
		{
			for(Patient patient : Singleton.getInstance().getFileAttente()) 
			{
				System.out.println(patient);
			}
			System.out.println("Prochain patient : "+Singleton.getInstance().getFileAttente().peek());
		}
	}

	public static void recevoirPatient() {
		Medecin medecin = (Medecin) connected;
		if(Singleton.getInstance().getFileAttente().isEmpty()) 
		{
			System.out.println("Aucun patient dans la file d'attente");
		}
		else 
		{
			Patient patient = Singleton.getInstance().getFileAttente().poll();
			System.out.println("Creation d'une visite pour le patient : "+patient);
			Visite visite = new Visite(medecin,patient);
			medecin.getConsultations().add(visite);
			
			if(medecin.getConsultations().size()>=3) 
			{
				System.out.println("------------Sauvegarde automatique des visites------------");
				sauvegarderVisites();
			}
		}
		

	}

	public static void sauvegarderVisites() {
		Medecin medecin = (Medecin) connected;
		if(medecin.getConsultations().isEmpty()) 
		{
			System.out.println("Aucune visite à sauvegarder");
		}
		else 
		{
			for(Visite visite : medecin.getConsultations()) 
			{
				daoVisite.insert(visite);
				System.out.println(visite);
			}
			medecin.getConsultations().clear();
		}

	}

	public static void main(String[] args) {
		menuPrincipal();

	}
}
