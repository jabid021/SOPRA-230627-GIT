package service;

import java.util.List;

import dao.IDAOOrdinateur;
import dao.IDAOOrdinateur;
import model.Ordinateur;
import model.Ordinateur;

public class OrdinateurService {
	private IDAOOrdinateur daoOrdinateur;
	
	public OrdinateurService(IDAOOrdinateur daoOrdinateur) {
		this.daoOrdinateur = daoOrdinateur;
	}

	public void checkOrdinateur(Ordinateur ordinateur) 
	{
		if (ordinateur==null) 
		{
			throw new RuntimeException("le ordinateur ne peut pas etre null lors d'un insert / update ");
		}
		if (ordinateur.getMarque() == null || ordinateur.getMarque().isEmpty()) {
			throw new RuntimeException("marque obligatoire");
		}
		if (ordinateur.getRam() == 0) {
			throw new RuntimeException("ram obligatoire");
		}
		if (ordinateur.getStagiaire() == null) {
			throw new RuntimeException("stagiaire obligatoire");
		}
		
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

