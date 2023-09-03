package escapeGame.dao;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import escapeGame.model.GameMaster;
import escapeGame.model.Reservation;

public interface IDAOReservation extends JpaRepository<Reservation,Integer>{

	public List<Reservation> findByGameMasterAndDateReservationGreaterThan(GameMaster gameMaster,
			LocalDate date);
}
