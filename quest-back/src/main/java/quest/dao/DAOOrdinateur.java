package quest.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import quest.model.Ordinateur;

@Repository
@Transactional
public class DAOOrdinateur implements IDAOOrdinateur {
	@PersistenceContext
	private EntityManager em;

	@Override
	public Ordinateur findById(Integer id) {

		Ordinateur ordinateur =em.find(Ordinateur.class, id);	
			return ordinateur;
	}

	@Override
	public List<Ordinateur> findAll() {
		List<Ordinateur> ordinateurs =em.createQuery("from Ordinateur").getResultList();	
		return ordinateurs;
	}

	@Override
	public Ordinateur save(Ordinateur p) {
		
		p = em.merge(p);
		return p;
	}

	@Override
	public void delete(Ordinateur ordinateur) {
		ordinateur=em.merge(ordinateur);
			em.remove(ordinateur);
	}


	

}
