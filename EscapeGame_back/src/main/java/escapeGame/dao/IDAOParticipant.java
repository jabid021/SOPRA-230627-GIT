package escapeGame.dao;

import java.util.List;

import escapeGame.model.Client;
import escapeGame.model.Participant;

public interface IDAOParticipant extends IDAO<Participant,Integer>{

	public List<Participant> findAllByClient(Client client);
}
