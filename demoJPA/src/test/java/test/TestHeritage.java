package test;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import demoHeritage.joined.Avion;
import demoHeritage.joined.Bateau;
import demoHeritage.joined.Vehicule;
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



		EntityManagerFactory emf = Persistence.createEntityManagerFactory("configJPA");
		EntityManager em = emf.createEntityManager();

		em.getTransaction().begin();
		//em.persist(canard1);
		//em.persist(chien1);
		//em.persist(chat1);

		//em.persist(avion);
		//em.persist(bateau);

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
		 

		em.close();

		emf.close();

	}
}
