package test;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import demoHeritage.joined.Avion;
import demoHeritage.joined.Bateau;
import demoHeritage.joined.Vehicule;
import demoHeritage.map.Laptop;
import demoHeritage.map.Materiel;
import demoHeritage.map.Telephone;
import demoHeritage.perclass.Humain;
import demoHeritage.perclass.Nain;
import demoHeritage.perclass.Orc;
import demoHeritage.perclass.Race;
import demoHeritage.single.Animal;
import demoHeritage.single.Canard;
import demoHeritage.single.Chat;
import demoHeritage.single.Chien;

public class TestHeritage {


	public static void main(String[] args) {

		Canard canard1 = new Canard("donald","red");
		Chien chien1 = new Chien("chien");
		Chat chat1 = new Chat("chat");

		Bateau bateau = new Bateau(0);
		Avion avion = new Avion(2,250);

		Orc orc = new Orc("Zog Zog");
		Humain humain = new Humain("Humain lambda","Herboriste");
		Nain nain = new Nain("c'est un nain",5000);

		Laptop laptop = new Laptop("Asus", true);
		Telephone tel = new Telephone("Apple","Iphone 15");
		
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("configJPA");
		EntityManager em = emf.createEntityManager();

		em.getTransaction().begin();
		em.persist(canard1);
		em.persist(chien1);
		em.persist(chat1);

		em.persist(avion);
		em.persist(bateau);
		
		em.persist(orc);
		em.persist(humain);
		em.persist(nain);

		em.persist(laptop);
		em.persist(tel);
		
		em.getTransaction().commit();
		em.close();

		em = emf.createEntityManager();


		List<Animal> animaux = em.createQuery("FROM Animal").getResultList();

		for(Animal a : animaux) 
		{
			System.out.println(a);
		}
		 
		
		
		List<Vehicule> garage = em.createQuery("FROM Vehicule").getResultList();

		for(Vehicule v : garage) 
		{
			System.out.println(v);
		}
		 

		
		
		List<Race> races = em.createQuery("FROM Race").getResultList();

		for(Race r : races) 
		{
			System.out.println(r);
		}
		 

		/*List<Materiel> stock = em.createQuery("FROM Materiel").getResultList();

		for(Materiel s : stock) 
		{
			System.out.println(s);
		}*/
		 
		//em.find(Laptop.class, 1);
		
		//System.out.println(em.find(Animal.class,2));
		
		//System.out.println(em.find(Bateau.class,2));
		em.close();

		emf.close();

	}
}
