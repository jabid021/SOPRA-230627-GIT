package eshop.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import eshop.model.Produit;

@Repository
@Transactional
public class DAOProduit implements IDAOProduit {

	@PersistenceContext
	private EntityManager em;

	@Override
	public Produit findById(Integer id) {
		return em.find(Produit.class, id);
	}

	@Override
	public List<Produit> findAll() {
		return em.createQuery("from Produit").getResultList();
	}

	@Override
	public Produit save(Produit p) {
		return em.merge(p);
	}

	@Override
	public void delete(Produit produit) {
		produit = em.merge(produit);
		em.remove(produit);
	}

}
