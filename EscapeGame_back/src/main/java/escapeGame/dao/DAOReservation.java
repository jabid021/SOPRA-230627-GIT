package escapeGame.dao;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import escapeGame.context.Singleton;
import escapeGame.model.GameMaster;
import escapeGame.model.Participant;
import escapeGame.model.Reservation;

public class DAOReservation implements IDAOReservation {



	@Override
	public Reservation findById(Integer id) {

			EntityManager em =  Singleton.getInstance().getEmf().createEntityManager();
				Reservation reservation =em.find(Reservation.class, id);	
			em.close();
			return reservation;
	}

	@Override
	public List<Reservation> findAll() {
		EntityManager em =  Singleton.getInstance().getEmf().createEntityManager();
			List<Reservation> reservations =em.createQuery("from Reservation").getResultList();	
		em.close();
		return reservations;
	}

	@Override
	public Reservation save(Reservation p) {
		
		EntityManager em  = Singleton.getInstance().getEmf().createEntityManager();
		
		em.getTransaction().begin();
		
			p = em.merge(p);
		
		em.getTransaction().commit();
		em.close();
		
		return p;
	}

	@Override
	public void delete(Reservation reservation) {
		EntityManager em  = Singleton.getInstance().getEmf().createEntityManager();
		em.getTransaction().begin();
			reservation=em.merge(reservation);
			em.remove(reservation);
		em.getTransaction().commit();
		em.close();
		
	}

	@Override
	public List<Reservation> findByGameMasterAndDateReservationGreaterThan(GameMaster gameMaster, LocalDate date) {
		EntityManager em =  Singleton.getInstance().getEmf().createEntityManager();
		
		Query query = em.createQuery("SELECT r from Reservation r where r.gameMaster = :gm and r.dateReservation> :date");
		query.setParameter("gm", gameMaster);
		query.setParameter("date", date);
		
		List<Reservation> reservations = query.getResultList();	
		
	em.close();
	return reservations;
	}

	

}
