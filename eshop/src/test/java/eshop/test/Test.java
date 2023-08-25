package eshop.test;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import eshop.model.Achat;
import eshop.model.Adresse;
import eshop.model.Client;
import eshop.model.Fournisseur;
import eshop.model.Produit;

public class Test {

	public static void main(String[] args) {
		
		Adresse a1 = new Adresse("6","rue rougemont","Paris","75009");
		
		Adresse a2 = new Adresse("1","rue rougemont","Paris","75009");
		
		
		
		Fournisseur f1 = new Fournisseur("Abid","Charly",a2,"AJC");
		
		Produit produit1 = new Produit("Formation SQL",850,f1);
		Produit produit2 = new Produit("Formation JPA", 1500,f1);
		
		
		Client c1 = new Client("Abid","Jordan",a1,LocalDate.parse("1993-05-01"),30);

	
		
		Client c2 = new Client("Doe","John",a1,LocalDate.parse("1960-01-01"),63);
		//
		
		Achat achat1 = new Achat(LocalDate.now(),2,c1,produit1);
		Achat achat2 = new Achat(LocalDate.now(),5,c1,produit2);
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("configJPA");

		EntityManager em = emf.createEntityManager();


		em.getTransaction().begin();

		em.persist(f1);
		em.persist(c1);
		em.persist(c2);
		em.persist(produit1);
		em.persist(produit2);
		em.persist(achat1);
		em.persist(achat2);

		em.getTransaction().commit();


		em.close();
		emf.close();
	}

}
