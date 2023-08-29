package quest.dao;

import java.util.List;

import javax.persistence.EntityManager;

import quest.context.Singleton;
import quest.model.Matiere;

public class DAOMatiere implements IDAOMatiere {


	@Override
	public Matiere findById(Integer id) {

			EntityManager em =  Singleton.getInstance().getEmf().createEntityManager();
				Matiere matiere =em.find(Matiere.class, id);	
			em.close();
			return matiere;
	}

	@Override
	public List<Matiere> findAll() {
		EntityManager em =  Singleton.getInstance().getEmf().createEntityManager();
			List<Matiere> matieres =em.createQuery("from Matiere").getResultList();	
		em.close();
		return matieres;
	}

	@Override
	public Matiere save(Matiere p) {
		
		EntityManager em  = Singleton.getInstance().getEmf().createEntityManager();
		
		em.getTransaction().begin();
		
			p = em.merge(p);
		
		em.getTransaction().commit();
		em.close();
		
		return p;
	}

	@Override
	public void delete(Matiere matiere) {
		EntityManager em  = Singleton.getInstance().getEmf().createEntityManager();
		em.getTransaction().begin();
			matiere=em.merge(matiere);
			em.remove(matiere);
		em.getTransaction().commit();
		em.close();
		
	}

	

}
