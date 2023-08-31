package quest.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import quest.model.Matiere;

@Repository
@Transactional
public class DAOMatiere implements IDAOMatiere {
	@PersistenceContext
	private EntityManager em;

	@Override
	public Matiere findById(Integer id) {

		Matiere matiere =em.find(Matiere.class, id);	
		return matiere;
	}

	@Override
	public List<Matiere> findAll() {
		List<Matiere> matieres =em.createQuery("from Matiere").getResultList();	
		return matieres;
	}

	@Override
	public Matiere save(Matiere p) {
		p = em.merge(p);
		return p;
	}

	@Override
	public void delete(Matiere matiere) {
		matiere=em.merge(matiere);
		//matiere = em.find(Matiere.class,matiere.getId());
		em.remove(matiere);
	}



}
