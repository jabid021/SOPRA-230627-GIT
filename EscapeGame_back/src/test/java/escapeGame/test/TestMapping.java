package escapeGame.test;

import java.time.LocalDate;
import java.util.List;

import escapeGame.context.Singleton;
import escapeGame.dao.DAOReservation;
import escapeGame.model.Client;
import escapeGame.model.GameMaster;
import escapeGame.model.Participant;
import escapeGame.model.Reservation;

public class TestMapping {

	public static void main(String[] args) {
	
		
		for(Participant p : Singleton.getInstance().getParticipantService().getAll())
		{
		System.out.println(p);	
		}
		
		System.out.println("--------------");
		Client client = (Client) Singleton.getInstance().getCompteService().getById(3);
		
		for(Participant p : Singleton.getInstance().getParticipantService().getAllByClient(client))
		{
		System.out.println(p);	
		}
		
		/*DAOParticipant daop = new DAOParticipant();
		for(Participant p : daop.findAllByClientPrenomContient("ordsffd"))
		{
		System.out.println(p);	
		}*/
		
		GameMaster gm = (GameMaster) Singleton.getInstance().getCompteService().getById(2);
		
		
		DAOReservation daoR = new DAOReservation();
		List<Reservation> resa = daoR.findByGameMasterAndDateReservationGreaterThan(gm, LocalDate.parse("2023-01-01"));
		
		System.out.println(resa.size());
	}

}
