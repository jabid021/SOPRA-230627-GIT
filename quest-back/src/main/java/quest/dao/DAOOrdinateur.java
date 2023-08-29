package quest.dao;

import java.util.List;

import javax.persistence.EntityManager;

import quest.context.Singleton;
import quest.model.Ordinateur;

public class DAOOrdinateur implements IDAOOrdinateur {


	@Override
	public Ordinateur findById(Integer id) {

			EntityManager em =  Singleton.getInstance().getEmf().createEntityManager();
				Ordinateur ordinateur =em.find(Ordinateur.class, id);	
			em.close();
			return ordinateur;
	}

	@Override
	public List<Ordinateur> findAll() {
		EntityManager em =  Singleton.getInstance().getEmf().createEntityManager();
			List<Ordinateur> ordinateurs =em.createQuery("from Ordinateur").getResultList();	
		em.close();
		return ordinateurs;
	}

	@Override
	public Ordinateur save(Ordinateur p) {
		
		EntityManager em  = Singleton.getInstance().getEmf().createEntityManager();
		
		em.getTransaction().begin();
		
			p = em.merge(p);
		
		em.getTransaction().commit();
		em.close();
		
		return p;
	}

	@Override
	public void delete(Ordinateur ordinateur) {
		EntityManager em  = Singleton.getInstance().getEmf().createEntityManager();
		em.getTransaction().begin();
			ordinateur=em.merge(ordinateur);
			em.remove(ordinateur);
		em.getTransaction().commit();
		em.close();
		
	}


	

}
