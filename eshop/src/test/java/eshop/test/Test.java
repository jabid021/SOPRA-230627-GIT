package eshop.test;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import eshop.context.Singleton;
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
		
		
		
		System.out.println(Singleton.getInstance().getDaoProduit().findAll());
		
	/*	EntityManagerFactory emf = Persistence.createEntityManagerFactory("configJPA");

		EntityManager em = emf.createEntityManager();


		em.getTransaction().begin();

		em.persist(f1);
		Client copie = em.merge(c1);
		System.out.println(c1);
		System.out.println(copie);
		achat1.setClient(copie);
		em.persist(produit1);
		em.persist(achat1);
		
		/*em.persist(f1);
		em.persist(c1);
		em.persist(c2);
		em.persist(produit1);
		em.persist(produit2);
		em.persist(achat1);
		em.persist(achat2);
		
		
		 
		em.getTransaction().commit();
		


		em.close();
	
		emf.close();
	
	*/
	
		//em.persist(objet) => impossible de persist un element avec un id / 	l'objet persist EST Managed
		//em.find(Personne.class,1) => retourne null, ou la personne avec l'id 1 (Managed)
		//em.createQuery(from Personne) => retourne un tableau vide / toutes les personnes (Managed)
		//em.merge(f1) => merge d'un objet sans id / null / id qui n'existe pas => insert, si id existant => update  ////  l'objet f1 n'est PAS MANAGED, l'objet retourné par merge EST MANAGED
		//remove(f1) => f1 doit etre MANAGED avant le remove
	
		
		
		Singleton.getInstance().getEmf().close();
	}

}
