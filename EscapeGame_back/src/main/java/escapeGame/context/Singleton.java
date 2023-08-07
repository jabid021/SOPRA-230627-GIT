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


public class Singleton {
	
	private IDAOMateriel daoMateriel = new DAOMateriel();
	private IDAOCompte daoCompte = new DAOCompte();
	private IDAOParticipant daoParticipant = new DAOParticipant();
	private IDAOReservation daoReservation = new DAOReservation();
	private IDAOSalle daoSalle = new DAOSalle();
	
	
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

	public IDAOMateriel getDaoMateriel() {
		return daoMateriel;
	}

	public void setDaoMateriel(IDAOMateriel daoMateriel) {
		this.daoMateriel = daoMateriel;
	}

	public IDAOCompte getDaoCompte() {
		return daoCompte;
	}

	public void setDaoCompte(IDAOCompte daoCompte) {
		this.daoCompte = daoCompte;
	}

	public IDAOParticipant getDaoParticipant() {
		return daoParticipant;
	}

	public void setDaoParticipant(IDAOParticipant daoParticipant) {
		this.daoParticipant = daoParticipant;
	}

	public IDAOReservation getDaoReservation() {
		return daoReservation;
	}

	public void setDaoReservation(IDAOReservation daoReservation) {
		this.daoReservation = daoReservation;
	}

	public IDAOSalle getDaoSalle() {
		return daoSalle;
	}

	public void setDaoSalle(IDAOSalle daoSalle) {
		this.daoSalle = daoSalle;
	}

	
	

	
	

	

}
