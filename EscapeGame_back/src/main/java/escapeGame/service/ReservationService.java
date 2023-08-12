package escapeGame.service;

import java.util.List;

import escapeGame.context.Singleton;
import escapeGame.dao.IDAOReservation;
import escapeGame.model.Participant;
import escapeGame.model.Reservation;

public class ReservationService {

	private IDAOReservation daoReservation;
	
	
	public ReservationService(IDAOReservation daoReservation) {
		this.daoReservation = daoReservation;
	}

	public void checkReservation(Reservation reservation) 
	{

	}

	public Reservation create(Reservation reservation) {
		checkReservation(reservation);
		for(Participant p  : reservation.getParticipants()) 
		{
			if (p.getId()==0) {p.setId(null);}
			Singleton.getInstance().getParticipantService().create(p);
		}

		return daoReservation.insert(reservation);
	}

	public Reservation update(Reservation reservation) {
		checkReservation(reservation);
		return daoReservation.update(reservation);
	}


	public Reservation getById(Integer id) {
		if (id == null) {
			throw new RuntimeException("id obligatoire");
		}
		Reservation reservation = daoReservation.findById(id);
		if(reservation==null) 
		{
			throw new RuntimeException("id inconnu");
		}
		return reservation;
	}


	public List<Reservation> getAll() {
		return daoReservation.findAll();
	}


	public void delete(Integer id) {
		if (id == null) {
			throw new RuntimeException("id obligatoire");
		}
		daoReservation.delete(id);
	}	
}
