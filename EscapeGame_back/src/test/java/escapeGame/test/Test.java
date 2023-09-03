package escapeGame.test;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import escapeGame.model.Adresse;
import escapeGame.model.Cadenas;
import escapeGame.model.Client;
import escapeGame.model.Coffre;
import escapeGame.model.Difficulte;
import escapeGame.model.Etat;
import escapeGame.model.GameMaster;
import escapeGame.model.Gerant;
import escapeGame.model.Mecanisme;
import escapeGame.model.Participant;
import escapeGame.model.Reservation;
import escapeGame.model.Salle;

public class Test {

	public void run(String ...args) {

	
		/// ----------------Groupe 1 ----------------//
		//login/password => admin / admin
		  Gerant gerant=new Gerant("Gerant","Gerant","Ger","Ant");
	        System.out.println(gerant);
	        GameMaster gm1=new GameMaster("GameMaster1", "GameMaster1", "Game", "Master1");
	        System.out.println(gm1);
	        GameMaster gm2=new GameMaster("GameMaster2", "GameMaster2", "Game", "Master2");
	        System.out.println(gm2);
	        Adresse adresse1=new Adresse("1","Rue de la cave","Bourg-la-Reine","66666");
	        Adresse adresse2=new Adresse("2","Rue du bar","Hebecrevon","55555");
	        Client client1=new Client("Client1","Client1","Cli","Ent1","0653265894","Cli.Ent1@gmail.com",adresse1);
	        System.out.println(client1);
	        Client client2=new Client("Client2","Client2","Cli","Ent2","0254879832","Cli.Ent2@gmail.com",adresse2);
	        System.out.println(client2);
	        
		
	      /// ----------------Groupe 3 ----------------//

	        String description1 = "Le métro est en approche."
	                + "Les phares émergent tout juste de l’obscurité quand tout à coup, "
	                + "le métro s’immobilise en pleine voie ! "
	                + "Cela semble bien plus inquiétant qu’un simple arrêt "
	                + "pour régulation du trafic et le métro ne semble pas"
	                + " prêt à repartir…";
	      
	        Salle salle1 = new Salle(3,5,"Metro Parisien", description1, 60, 20.50, true, Difficulte.Intermediaire);

	        String description2 = "Porte 4 de votre aéroport, "
	                + "votre avion est à l’heure. "
	                + "Billet en main, vous êtes prêt à embarquer "
	                + "mais un peu nerveux… Rassurez-vous, "
	                + "il ne s’agit que d’un vol d’une heure. "
	                + "L’embarquement est annoncé, vous allez "
	                + "enfin pouvoir vous installer.";
	        Salle salle2  = new Salle(4,7,"Avion", description2, 27 , 100, false, Difficulte.Debutant);
		
		//Tout le materiel dans la salle1
	        Cadenas code1 = new Cadenas ("cadena1",salle1, Etat.Neuf, "5839");
	        Cadenas code2 = new Cadenas ("cadena2",null, Etat.Standard, "6398");
	        Cadenas code3 = new Cadenas("cryptex",salle1, Etat.Standard, "AZERTY");
	        Coffre coffre1 = new Coffre("Coffre1",salle2, Etat.Standard, "1234",3);
	        Mecanisme kitUV = new Mecanisme ("KitUv",salle1, Etat.Neuf, false);
	        Mecanisme cryptex = new Mecanisme ("Meca1",salle2, Etat.Neuf, true);
		
		
		/// ----------------Groupe 2 ----------------//
		
		LocalDate ld  = LocalDate.parse("2023-07-10");   
        LocalTime lt = LocalTime.parse("16:00");
      
        Participant participant1 = new Participant("Gonzales","Victor",client1);
        Participant participant2 = new Participant("Diane","Reja",client1);
        Participant participant3 = new Participant("Sébastien","Nin",client1);
        Participant participant4 = new Participant("Baptiste","Guineheux",client1);
        Participant participant5 = new Participant("Jordan","Abid",client1);
        
        List<Participant> participants1 = new ArrayList();
        Collections.addAll(participants1, participant1,participant2,participant5);
        
        List<Participant> participants2 = new ArrayList();
        Collections.addAll(participants2, participant3,participant4,participant5);
        
        Reservation reservation1 = new Reservation(LocalDate.parse("2023-07-21"), LocalTime.parse("16:00"), 60, "groupe 1", 61.50, client1, salle1,gm1);

        Reservation reservation2 = new Reservation(LocalDate.now(), LocalTime.parse("14:30"), 30, "groupe 2", 81,client1, salle2, null);
    
        
        

	}

}
