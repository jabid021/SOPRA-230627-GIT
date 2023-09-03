package escapeGame.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import escapeGame.model.Client;
import escapeGame.model.Participant;

public interface IDAOParticipant extends JpaRepository<Participant,Integer>{

	public List<Participant> findAllByClient(Client client);
}
