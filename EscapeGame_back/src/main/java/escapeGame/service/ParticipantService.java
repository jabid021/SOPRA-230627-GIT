package escapeGame.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import escapeGame.dao.IDAOParticipant;
import escapeGame.model.Client;
import escapeGame.model.Participant;
@Service
public class ParticipantService {
	@Autowired
	private IDAOParticipant daoParticipant;

	public void checkParticipant(Participant participant) 
	{

	}

	public Participant create(Participant participant) {
		checkParticipant(participant);
		return daoParticipant.save(participant);
	}

	public Participant update(Participant participant) {
		checkParticipant(participant);
		return daoParticipant.save(participant);
	}


	public Participant getById(Integer id) {
		if (id == null) {
			throw new RuntimeException("id obligatoire");
		}
		Optional<Participant> opt = daoParticipant.findById(id);
		if(opt.isEmpty()) 
		{
			throw new RuntimeException("id inconnu");
		}
		return opt.get();
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
		Participant participant =getById(id);
		delete(participant);
	}	
	
	public void delete(Participant participant) {
		
		if (participant == null) {
			throw new RuntimeException("participant ne peut pas etre null");
		}
		daoParticipant.delete(participant);
	}	
}
