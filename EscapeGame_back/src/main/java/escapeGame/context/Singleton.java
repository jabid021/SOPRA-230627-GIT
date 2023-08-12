package escapeGame.context;

import escapeGame.dao.DAOCompte;
import escapeGame.dao.DAOMateriel;
import escapeGame.dao.DAOParticipant;
import escapeGame.dao.DAOReservation;
import escapeGame.dao.DAOSalle;
import escapeGame.dao.IDAOCompte;
import escapeGame.dao.IDAOMateriel;
import escapeGame.dao.IDAOParticipant;
import escapeGame.dao.IDAOReservation;
import escapeGame.dao.IDAOSalle;
import escapeGame.service.CompteService;
import escapeGame.service.MaterielService;
import escapeGame.service.ParticipantService;
import escapeGame.service.ReservationService;
import escapeGame.service.SalleService;


public class Singleton {
	
	private IDAOMateriel daoMateriel = new DAOMateriel();
	private IDAOCompte daoCompte = new DAOCompte();
	private IDAOParticipant daoParticipant = new DAOParticipant();
	private IDAOReservation daoReservation = new DAOReservation();
	private IDAOSalle daoSalle = new DAOSalle();
	private MaterielService materielService = new MaterielService(daoMateriel);
	private CompteService compteService = new CompteService(daoCompte);
	private ParticipantService participantService = new ParticipantService(daoParticipant);
	private ReservationService reservationService = new ReservationService(daoReservation);
	
	private SalleService salleService = new SalleService(daoSalle);
	
	
	
	private static Singleton instance=null; 
	
	private Singleton() {}
	
	public static Singleton getInstance() 
	{
		if(instance==null) 
		{
			instance=new Singleton();
		}
		return instance;
	}

	
	public MaterielService getMaterielService() {
		return materielService;
	}

	public CompteService getCompteService() {
		return compteService;
	}

	public ParticipantService getParticipantService() {
		return participantService;
	}

	public ReservationService getReservationService() {
		return reservationService;
	}

	public SalleService getSalleService() {
		return salleService;
	}

	
	

	
	

	

}
