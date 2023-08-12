package escapeGame.service;

import java.util.List;

import escapeGame.context.Singleton;
import escapeGame.dao.IDAOMateriel;
import escapeGame.model.Materiel;

public class MaterielService {

	private IDAOMateriel daoMateriel;


	
	public MaterielService(IDAOMateriel daoMateriel) {
		this.daoMateriel = daoMateriel;
	}

	public void checkMateriel(Materiel materiel) 
	{

	}

	public Materiel create(Materiel materiel) {
		checkMateriel(materiel);
		return daoMateriel.insert(materiel);
	}

	public Materiel update(Materiel materiel) {
		checkMateriel(materiel);
		return daoMateriel.update(materiel);
	}


	public Materiel getById(Integer id) {
		if (id == null) {
			throw new RuntimeException("id obligatoire");
		}
		Materiel materiel = daoMateriel.findById(id);
		if(materiel==null) 
		{
			throw new RuntimeException("id inconnu");
		}
		return materiel;
	}


	public List<Materiel> getAll() {
		return daoMateriel.findAll();
	}


	public void delete(Integer id) {
		if (id == null) {
			throw new RuntimeException("id obligatoire");
		}
		daoMateriel.delete(id);
	}	
}
