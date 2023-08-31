package quest.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import quest.model.Stagiaire;

@Repository
@Transactional
public class DAOStagiaire implements IDAOStagiaire {
	@PersistenceContext
	private EntityManager em;

	@Override
	public Stagiaire findById(Integer id) {
		Stagiaire stagiaire =em.find(Stagiaire.class, id);	
		return stagiaire;
	}

	@Override
	public List<Stagiaire> findAll() {
		List<Stagiaire> stagiaires =em.createQuery("from Stagiaire").getResultList();	
		return stagiaires;
	}

	@Override
	public Stagiaire save(Stagiaire p) {
		p = em.merge(p);
		return p;
	}

	@Override
	public void delete(Stagiaire stagiaire) {
		stagiaire=em.merge(stagiaire);
		em.remove(stagiaire);
	}

}
