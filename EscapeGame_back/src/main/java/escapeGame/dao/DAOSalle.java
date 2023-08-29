package escapeGame.dao;

import java.util.List;

import javax.persistence.EntityManager;

import escapeGame.context.Singleton;
import escapeGame.model.Salle;

public class DAOSalle implements IDAOSalle{



	@Override
	public Salle findById(Integer id) {

			EntityManager em =  Singleton.getInstance().getEmf().createEntityManager();
				Salle salle =em.find(Salle.class, id);	
			em.close();
			return salle;
	}

	@Override
	public List<Salle> findAll() {
		EntityManager em =  Singleton.getInstance().getEmf().createEntityManager();
			List<Salle> salles =em.createQuery("from Salle").getResultList();	
		em.close();
		return salles;
	}

	@Override
	public Salle save(Salle p) {
		
		EntityManager em  = Singleton.getInstance().getEmf().createEntityManager();
		
		em.getTransaction().begin();
		
			p = em.merge(p);
		
		em.getTransaction().commit();
		em.close();
		
		return p;
	}

	@Override
	public void delete(Salle salle) {
		EntityManager em  = Singleton.getInstance().getEmf().createEntityManager();
		em.getTransaction().begin();
			salle=em.merge(salle);
			em.remove(salle);
		em.getTransaction().commit();
		em.close();
		
	}

	


}
