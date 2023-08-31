package quest.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import quest.model.Filiere;

@Repository
@Transactional
public class DAOFiliere implements IDAOFiliere {
	
	@PersistenceContext
	private EntityManager em;

	@Override
	public Filiere findById(Integer id) {

			Filiere filiere =em.find(Filiere.class, id);	
			return filiere;
	}

	@Override
	public List<Filiere> findAll() {
		List<Filiere> filieres =em.createQuery("from Filiere").getResultList();	
		return filieres;
	}

	@Override
	public Filiere save(Filiere p) {
		p = em.merge(p);
		return p;
	}

	@Override
	public void delete(Filiere filiere) {
		filiere=em.merge(filiere);
		em.remove(filiere);
	}

	

}
