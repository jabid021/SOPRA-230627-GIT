package eshop.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import eshop.context.Singleton;
import eshop.model.Produit;

public class DAOProduit implements IDAOProduit {

	@Override
	public Produit findById(Integer id) {
		EntityManager em = null;
		EntityTransaction tx = null;
		Produit produit = null;
		try 
		{
			em =  Singleton.getInstance().getEmf().createEntityManager();

			produit=em.find(Produit.class, id);

		}catch(Exception e) 
		{
			e.printStackTrace();
		}
		finally 
		{
			if(em!=null) 
			{
				em.close();
			}
		}
		return produit;
	}

	@Override
	public List<Produit> findAll() {
		EntityManager em = null;
		EntityTransaction tx = null;
		List<Produit> produits=null;
		try 
		{
			em =  Singleton.getInstance().getEmf().createEntityManager();

			produits=em.createQuery("from Produit").getResultList();

		}catch(Exception e) 
		{
			e.printStackTrace();
		}
		finally 
		{
			if(em!=null) 
			{
				em.close();
			}
		}
		return produits;
	}

	@Override
	public Produit save(Produit p) {
		EntityManager em = null;
		EntityTransaction tx = null;

		try 
		{
			em =  Singleton.getInstance().getEmf().createEntityManager();
			tx=em.getTransaction();
			tx.begin();

			p = em.merge(p);

			tx.commit();

		}catch(Exception e) 
		{
			e.printStackTrace();
			if(tx!=null && tx.isActive()) 
			{
				tx.rollback();
			}
		}
		finally 
		{
			if(em!=null) 
			{
				em.close();
			}
		}
		return p;
	}

	@Override
	public void delete(Produit produit) {
		EntityManager em = null;
		EntityTransaction tx = null;

		try 
		{
			em =  Singleton.getInstance().getEmf().createEntityManager();
			tx=em.getTransaction();
			tx.begin();

			produit = em.merge(produit);
			em.remove(produit);

			tx.commit();

		}catch(Exception e) 
		{
			e.printStackTrace();
			if(tx!=null && tx.isActive()) 
			{
				tx.rollback();
			}
		}
		finally 
		{
			if(em!=null) 
			{
				em.close();
			}
		}
	}

}
