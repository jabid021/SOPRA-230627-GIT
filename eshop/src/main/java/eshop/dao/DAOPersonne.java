package eshop.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import eshop.model.Personne;

@Repository
@Transactional
public class DAOPersonne implements IDAOPersonne{

	@PersistenceContext
	private EntityManager em;

	@Override
	public Personne findById(Integer id) {
		return em.find(Personne.class, id);	
	}

	@Override
	public List<Personne> findAll() {
		return em.createQuery("from Personne").getResultList();
	}

	@Override
	public Personne save(Personne p) {
		return em.merge(p);
	}

	@Override
	public void delete(Personne personne) {
		personne=em.merge(personne);
		em.remove(personne);
	}

}
