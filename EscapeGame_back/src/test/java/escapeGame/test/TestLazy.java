package escapeGame.test;

import java.util.List;

import javax.persistence.EntityManager;

import escapeGame.context.Singleton;
import escapeGame.model.Client;

public class TestLazy {


	//Acces aux reservations APRES le em.close() ❌
	//Impossibe de faire des filtres sur les reservation ❌
	public static List<Client> showLazy() {
		List<Client> clients;
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();

		clients=em.createQuery("from Client").getResultList();

		em.close();

		return clients;
	}

	//Acces aux reservations APRES le em.close() ❌
	//Possibe de faire des filtres sur les reservation ✔
	//Les client ayant plusieurs reservations ce jour la, sortent avec des doublons (une ligne pour chaque resa) ❌
	public static List<Client> showFilter() {
		List<Client> clients;
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();

		clients=em.createQuery("SELECT c from Client c join c.reservations r where r.dateReservation='2023-08-24' ").getResultList();

		em.close();

		return clients;
	}


	//Acces aux reservations APRES le em.close() ❌
	//Possibe de faire des filtres sur les reservation ✔
	//Les client ayant plusieurs reservations ce jour la, n'ont plus de doublons ✔
	public static List<Client> showFilterNoDoublons() {
		List<Client> clients;
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();

		clients=em.createQuery("SELECT distinct c from Client c join c.reservations r where r.dateReservation='2023-08-24' ").getResultList();

		em.close();

		return clients;
	}

	//Acces aux reservations APRES le em.close() ❌
	//join ne retourne QUE les clients ayant des Reservations ❌
	//Possibe de faire des filtres sur les reservation ✔
	//Les client ayant plusieurs reservations ce jour la, n'ont plus de doublons ✔
	public static List<Client> showWithReservation() {
		List<Client> clients;
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();

		clients=em.createQuery("SELECT distinct c from Client c join c.reservations r ").getResultList();

		em.close();

		return clients;
	}


	//Acces aux reservations APRES le em.close()❌
	//left join  retourne TOUS les clients même ceux n'ayant pas de Reservations  ✔ 
	//Possibe de faire des filtres sur les reservation ✔
	//Les client ayant plusieurs reservations ce jour la, n'ont plus de doublons ✔
	public static List<Client> showWithLEFTReservation() {
		List<Client> clients;
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();

		clients=em.createQuery("SELECT distinct c from Client c left join c.reservations r ").getResultList();

		em.close();

		return clients;
	}

	//Acces aux reservations APRES le em.close() ✔
	//join ne retourne QUE les clients ayant des Reservations ❌
	//Possibe de faire des filtres sur les reservation ✔
	//Les client ayant plusieurs reservations ,n'ont plus de doublons ✔
	public static List<Client> showWithReservationAfterClose() {
		List<Client> clients;
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();

		clients=em.createQuery("SELECT distinct c from Client c join fetch c.reservations r ").getResultList();

		em.close();

		return clients;
	}

	//Acces aux reservations APRES le em.close() ✔
	//left join  retourne TOUS les clients même ceux n'ayant pas de Reservations  ✔ 
	//Possibe de faire des filtres sur les reservation ✔
	//Les client ayant plusieurs reservations ,n'ont plus de doublons ✔
	public static List<Client> showWithLeftReservationAfterClose() {
		List<Client> clients;
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();

		clients=em.createQuery("SELECT distinct c from Client c left join fetch c.reservations r ").getResultList();

		em.close();

		return clients;
	}

	
	
	public static List<Client> showWithParticipant() {
		List<Client> clients;
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();

		clients=em.createQuery("SELECT distinct c from Client c left join fetch c.participants p ").getResultList();

		em.close();

		return clients;
	}
	
	public static List<Client> showWithParticipantAndReservationNotWorking() {
		List<Client> clients;
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();

		clients=em.createQuery("SELECT distinct c from Client c left join fetch c.participants p  left join fetch c.reservations r ").getResultList();

		em.close();

		return clients;
	}

	
	public static List<Client> showWithParticipantAndReservationWorking() {
		List<Client> clients;
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();

		clients=em.createQuery("SELECT distinct c from Client c left join fetch c.participants p ").getResultList();
		
		clients=em.createQuery("SELECT distinct c from Client c left join fetch c.reservations r ").getResultList();


		em.close();

		return clients;
	}

	
	
	public static void demoJPQL() {
		List<Client> clients;
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();

		List<Integer>  nb =em.createQuery("SELECT COUNT(c) from Client c group by c.prenom").getResultList();
		System.out.println(nb);
		em.close();

	
	}
	
	
	public static void main(String[] args) {

		demoJPQL();

		List<Client> clients = showWithParticipantAndReservationWorking();

		for(Client c : clients) 
		{
			System.out.println(c);
			//System.out.println("Nombre de reservation : "+c.getReservations().size());
			//System.out.println("Nombre de participants deja inscrits : "+c.getParticipants().size());
		}


		Singleton.getInstance().getEmf().close();
	}


}
