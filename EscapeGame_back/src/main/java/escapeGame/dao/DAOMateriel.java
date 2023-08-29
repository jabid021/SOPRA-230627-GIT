package escapeGame.dao;

import java.util.List;

import javax.persistence.EntityManager;

import escapeGame.context.Singleton;
import escapeGame.model.Materiel;

public class DAOMateriel implements IDAOMateriel {


	@Override
	public Materiel findById(Integer id) {

			EntityManager em =  Singleton.getInstance().getEmf().createEntityManager();
				Materiel materiel =em.find(Materiel.class, id);	
			em.close();
			return materiel;
	}

	@Override
	public List<Materiel> findAll() {
		EntityManager em =  Singleton.getInstance().getEmf().createEntityManager();
			List<Materiel> materiels =em.createQuery("from Materiel").getResultList();	
		em.close();
		return materiels;
	}

	@Override
	public Materiel save(Materiel p) {
		
		EntityManager em  = Singleton.getInstance().getEmf().createEntityManager();
		
		em.getTransaction().begin();
		
			p = em.merge(p);
		
		em.getTransaction().commit();
		em.close();
		
		return p;
	}

	@Override
	public void delete(Materiel materiel) {
		EntityManager em  = Singleton.getInstance().getEmf().createEntityManager();
		em.getTransaction().begin();
			materiel=em.merge(materiel);
			em.remove(materiel);
		em.getTransaction().commit();
		em.close();
		
	}

	

}
