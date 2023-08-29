package quest.service;

import java.util.List;

import quest.dao.IDAOOrdinateur;
import quest.model.Ordinateur;

public class OrdinateurService {

	private IDAOOrdinateur daoOrdinateur;


	
	public OrdinateurService(IDAOOrdinateur daoOrdinateur) {
		this.daoOrdinateur = daoOrdinateur;
	}

	public void checkOrdinateur(Ordinateur ordinateur) 
	{

	}

	public Ordinateur create(Ordinateur ordinateur) {
		checkOrdinateur(ordinateur);
		return daoOrdinateur.save(ordinateur);
	}

	public Ordinateur update(Ordinateur ordinateur) {
		checkOrdinateur(ordinateur);
		return daoOrdinateur.save(ordinateur);
	}


	public Ordinateur getById(Integer id) {
		if (id == null) {
			throw new RuntimeException("id obligatoire");
		}
		Ordinateur ordinateur = daoOrdinateur.findById(id);
		if(ordinateur==null) 
		{
			throw new RuntimeException("id inconnu");
		}
		return ordinateur;
	}


	public List<Ordinateur> getAll() {
		return daoOrdinateur.findAll();
	}


	public void delete(Integer id) {
		if (id == null) {
			throw new RuntimeException("id obligatoire");
		}
		Ordinateur ordinateur =getById(id);
		delete(ordinateur);
	}	
	
	public void delete(Ordinateur ordinateur) {
		
		if (ordinateur == null) {
			throw new RuntimeException("ordinateur ne peut pas etre null");
		}
		daoOrdinateur.delete(ordinateur);
	}	
}
