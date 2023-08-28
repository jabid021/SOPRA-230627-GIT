package test;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Adresse;
import model.Centre;
import model.Marque;
import model.Matiere;
import model.Ordinateur;
import model.Os;
import model.Personne;
import model.Session;

public class Test {

	public static void main(String[] args) {

		
		Matiere m1 = new Matiere("Java");
		Matiere m2 = new Matiere("SQL");
		Matiere m3 = new Matiere("Agile");
		
		Session s1 = new Session("JAVA-230327");
		Session s2 = new Session("JAVA-230627");
		Session s3 = new Session("JAVA-230927");
		
		Centre centre = new Centre("AJC");
		centre.getSessions().add(s1);
		centre.getSessions().add(s2);
		centre.getSessions().add(s3);
		
		
		
		Ordinateur o1 = new Ordinateur(Marque.Apple,Os.MacOs);
		Ordinateur o2 = new Ordinateur(Marque.Asus,Os.Linux);

		Adresse adresse1 = new Adresse ("6","Rue rougemont","Paris","75009");
		
		Personne p1 = new Personne("Abid","Jordan",LocalDate.parse("1993-05-01"),174,adresse1,o2,s1);

		Personne p2 = new Personne("Doe","John",LocalDate.parse("1960-01-01"),160,adresse1,o1,null);

		
		p1.getFormations().add(m1);
		p1.getFormations().add(m2);
		p1.getFormations().add(m3);
		
		//
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("configJPA");

		EntityManager em = emf.createEntityManager();

		//Ordinateur ordiBdd = em.find(Ordinateur.class,1);
		//Personne personneBdd = em.find(Personne.class, 2);

		
		//System.out.println(ordiBdd.getProprio().getNom());

		//System.out.println(personneBdd);
		
		
		em.getTransaction().begin();

		/*em.persist(o1);
		em.persist(o2);
		
		em.persist(p1);
		em.persist(p2);
		em.persist(m1);
		em.persist(m2);
		em.persist(m3);
		em.persist(s1);
		em.persist(s2);
		em.persist(s3);
		em.persist(centre);
		*/
		
		
		em.getTransaction().commit(); 



		em.close();
		emf.close();
		//

	}
}
