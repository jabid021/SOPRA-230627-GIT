package escapeGame.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import escapeGame.context.Singleton;
import escapeGame.model.Compte;
import escapeGame.model.GameMaster;

public class DAOCompte implements IDAOCompte {

	@Override
	public Compte findById(Integer id) {

			EntityManager em =  Singleton.getInstance().getEmf().createEntityManager();
				Compte compte =em.find(Compte.class, id);	
			em.close();
			return compte;
	}

	@Override
	public List<Compte> findAll() {
		EntityManager em =  Singleton.getInstance().getEmf().createEntityManager();
			List<Compte> comptes =em.createQuery("from Compte").getResultList();	
		em.close();
		return comptes;
	}

	@Override
	public Compte save(Compte p) {
		
		EntityManager em  = Singleton.getInstance().getEmf().createEntityManager();
		
		em.getTransaction().begin();
		
			p = em.merge(p);
		
		em.getTransaction().commit();
		em.close();
		
		return p;
	}

	@Override
	public void delete(Compte compte) {
		EntityManager em  = Singleton.getInstance().getEmf().createEntityManager();
		em.getTransaction().begin();
			compte=em.merge(compte);
			em.remove(compte);
		em.getTransaction().commit();
		em.close();
		
	}

	@Override
	public Compte findByLoginAndPassword(String login, String password) {
		EntityManager em =  Singleton.getInstance().getEmf().createEntityManager();
		Compte compte = null;
		
		//Query query = em.createQuery("SELECT  c from Compte c where c.login=?1 and c.password=?2");
		//query.setParameter(1, login);
		//query.setParameter(2, password);
		
		Query query = em.createQuery("SELECT  c from Compte c where c.login=:login and c.password=:password");
		query.setParameter("login", login);
		query.setParameter("password", password);
		try {
			compte = (Compte) query.getSingleResult();
		}
		catch(Exception e) {}
		
		//em.createQuery("SELECT  c from Compte c where c.login=:login and c.password=:password").setParameter("login", login).setParameter("password", password).getSingleResult();	
		
		em.close();
		return compte;
	}

	@Override
	public List<GameMaster> findAllGameMaster() {
		EntityManager em =  Singleton.getInstance().getEmf().createEntityManager();
		List<GameMaster> comptes =em.createQuery("from GameMaster").getResultList();
	em.close();
	return comptes;
	}

	

}
