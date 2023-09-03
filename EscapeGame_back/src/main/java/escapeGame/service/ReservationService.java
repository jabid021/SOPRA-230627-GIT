package escapeGame.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import escapeGame.dao.IDAOReservation;
import escapeGame.model.Participant;
import escapeGame.model.Reservation;
@Service
public class ReservationService {
	@Autowired
	private IDAOReservation daoReservation;
	
	@Autowired
	private ParticipantService participantSrv;

	public void checkReservation(Reservation reservation) 
	{

	}

	public Reservation create(Reservation reservation) {
		checkReservation(reservation);
		for(Participant p  : reservation.getParticipants()) 
		{
			if (p.getId()==0) {p.setId(null);}
			participantSrv.create(p);
		}

		return daoReservation.save(reservation);
	}

	public Reservation update(Reservation reservation) {
		checkReservation(reservation);
		return daoReservation.save(reservation);
	}


	public Reservation getById(Integer id) {
		if (id == null) {
			throw new RuntimeException("id obligatoire");
		}
		Optional<Reservation> opt = daoReservation.findById(id);
		if(opt.isEmpty()) 
		{
			throw new RuntimeException("id inconnu");
		}
		return opt.get();
	}


	public List<Reservation> getAll() {
		return daoReservation.findAll();
	}

	public void delete(Integer id) {
		if (id == null) {
			throw new RuntimeException("id obligatoire");
		}
		Reservation reservation =getById(id);
		delete(reservation);
	}	
	
	public void delete(Reservation reservation) {
		
		if (reservation == null) {
			throw new RuntimeException("reservation ne peut pas etre null");
		}
		daoReservation.delete(reservation);
	}	
}
