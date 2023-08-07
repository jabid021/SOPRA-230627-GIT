package escapeGame.dao;

import java.time.LocalDate;
import java.util.List;

import escapeGame.model.GameMaster;
import escapeGame.model.Reservation;

public interface IDAOReservation extends IDAO<Reservation,Integer>{

	public List<Reservation> findByGameMasterAndDateReservationGreaterThan(GameMaster gameMaster,
			LocalDate date);
}
