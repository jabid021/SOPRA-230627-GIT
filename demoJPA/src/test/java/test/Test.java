package test;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import demoHeritage.single.Canard;
import demoHeritage.single.Chat;
import demoHeritage.single.Chien;
import model.Adresse;
import model.Marque;
import model.Ordinateur;
import model.Os;
import model.Personne;

public class Test {

	public static void main(String[] args) {

		Ordinateur o1 = new Ordinateur(Marque.Apple,Os.MacOs);
		Ordinateur o2 = new Ordinateur(Marque.Asus,Os.Linux);

		Adresse adresse1 = new Adresse ("6","Rue rougemont","Paris","75009");
		
		Personne p1 = new Personne("Abid","Jordan",LocalDate.parse("1993-05-01"),174,adresse1);

		Personne p2 = new Personne("Doe","John",LocalDate.parse("1960-01-01"),160,adresse1);

		Canard canard1 = new Canard("donald","red");
		Chien chien1 = new Chien("chien");
		Chat chat1 = new Chat("chat");

		//
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("configJPA");

		EntityManager em = emf.createEntityManager();


		em.getTransaction().begin();

		em.persist(p1);
		em.persist(p2);
		em.persist(o1);
		em.persist(o2);
		em.persist(chien1);
		em.persist(canard1);
		em.persist(chat1);
		em.getTransaction().commit();



		em.close();
		emf.close();
		//

	}
}
