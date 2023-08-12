package escapeGame.service;

import java.util.List;

import escapeGame.dao.IDAOParticipant;
import escapeGame.model.Client;
import escapeGame.model.Participant;

public class ParticipantService {

	private IDAOParticipant daoParticipant;

	
	public ParticipantService(IDAOParticipant daoParticipant) {
		this.daoParticipant = daoParticipant;
	}

	public void checkParticipant(Participant participant) 
	{

	}

	public Participant create(Participant participant) {
		checkParticipant(participant);
		return daoParticipant.insert(participant);
	}

	public Participant update(Participant participant) {
		checkParticipant(participant);
		return daoParticipant.update(participant);
	}


	public Participant getById(Integer id) {
		if (id == null) {
			throw new RuntimeException("id obligatoire");
		}
		Participant participant = daoParticipant.findById(id);
		if(participant==null) 
		{
			throw new RuntimeException("id inconnu");
		}
		return participant;
	}
	
	public List<Participant> getAllByClient(Client client) {
		if (client == null) {
			throw new RuntimeException("client ne peut pas etre null");
		}
		if (client.getId() == null) {
			throw new RuntimeException("l'id client ne peut pas etre null");
		}
		List<Participant> participants = daoParticipant.findAllByClient(client);
		
		return participants;
	}


	public List<Participant> getAll() {
		return daoParticipant.findAll();
	}


	public void delete(Integer id) {
		if (id == null) {
			throw new RuntimeException("id obligatoire");
		}
		daoParticipant.delete(id);
	}	
}
