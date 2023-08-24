package service;

import java.util.List;

import dao.IDAOFiliere;
import model.Filiere;

public class FiliereService {

	private IDAOFiliere daoFiliere;


	
	public FiliereService(IDAOFiliere daoFiliere) {
		this.daoFiliere = daoFiliere;
	}

	public void checkFiliere(Filiere filiere) 
	{

	}

	public Filiere create(Filiere filiere) {
		checkFiliere(filiere);
		return daoFiliere.insert(filiere);
	}

	public Filiere update(Filiere filiere) {
		checkFiliere(filiere);
		return daoFiliere.update(filiere);
	}


	public Filiere getById(Integer id) {
		if (id == null) {
			throw new RuntimeException("id obligatoire");
		}
		Filiere filiere = daoFiliere.findById(id);
		if(filiere==null) 
		{
			throw new RuntimeException("id inconnu");
		}
		return filiere;
	}


	public List<Filiere> getAll() {
		return daoFiliere.findAll();
	}


	public void delete(Integer id) {
		if (id == null) {
			throw new RuntimeException("id obligatoire");
		}
		daoFiliere.delete(id);
	}	
}