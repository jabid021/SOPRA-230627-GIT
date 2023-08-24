package eshop.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import eshop.model.Personne;
import eshop.model.Produit;

public class Test {

	public static void main(String[] args) {
		Personne p1 = new Personne("Abid","Jordan");

		Personne p2 = new Personne("Doe","John");
		
		Produit produit1 = new Produit("Formation SQL",850);
		Produit produit2 = new Produit("Formation JPA", 1500);
		//
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("configJPA");

		EntityManager em = emf.createEntityManager();


		em.getTransaction().begin();

		em.persist(p1);
		em.persist(p2);
		em.persist(produit1);
		em.persist(produit2);

		em.getTransaction().commit();


		em.close();
		emf.close();
	}

}
