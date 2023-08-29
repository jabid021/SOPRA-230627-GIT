package escapeGame.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import escapeGame.context.Singleton;
import escapeGame.model.Client;
import escapeGame.model.Participant;

public class DAOParticipant implements IDAOParticipant {



	@Override
	public Participant findById(Integer id) {

			EntityManager em =  Singleton.getInstance().getEmf().createEntityManager();
				Participant participant =em.find(Participant.class, id);	
			em.close();
			return participant;
	}

	@Override
	public List<Participant> findAll() {
		EntityManager em =  Singleton.getInstance().getEmf().createEntityManager();
			List<Participant> participants =em.createQuery("from Participant").getResultList();	
		em.close();
		return participants;
	}

	@Override
	public Participant save(Participant p) {
		
		EntityManager em  = Singleton.getInstance().getEmf().createEntityManager();
		
		em.getTransaction().begin();
		
			p = em.merge(p);
		
		em.getTransaction().commit();
		em.close();
		
		return p;
	}

	@Override
	public void delete(Participant participant) {
		EntityManager em  = Singleton.getInstance().getEmf().createEntityManager();
		em.getTransaction().begin();
			participant=em.merge(participant);
			em.remove(participant);
		em.getTransaction().commit();
		em.close();
		
	}

	@Override
	public List<Participant> findAllByClient(Client client) {
		EntityManager em =  Singleton.getInstance().getEmf().createEntityManager();
	
		Query query = em.createQuery("SELECT p from Participant p where p.client = :client ");
		query.setParameter("client", client);
		
		List<Participant> participants = query.getResultList();	
		
	em.close();
	return participants;
	}

	



	public List<Participant> findAllByClientPrenomContient(String prenom) {
		EntityManager em =  Singleton.getInstance().getEmf().createEntityManager();
	
		Query query = em.createQuery("SELECT p from Participant p where p.client.prenom like :prenom ");
		query.setParameter("prenom", "%"+prenom+"%");
		
		List<Participant> participants = query.getResultList();	
		
	em.close();
	return participants;
	}

}
