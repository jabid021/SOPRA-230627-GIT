package service;

import java.util.List;

import dao.IDAOOrdinateur;
import model.Ordinateur;

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
		return daoOrdinateur.insert(ordinateur);
	}

	public Ordinateur update(Ordinateur ordinateur) {
		checkOrdinateur(ordinateur);
		return daoOrdinateur.update(ordinateur);
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
		daoOrdinateur.delete(id);
	}	
}
