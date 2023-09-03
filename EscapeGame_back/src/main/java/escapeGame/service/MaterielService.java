package escapeGame.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import escapeGame.dao.IDAOMateriel;
import escapeGame.model.Materiel;
@Service
public class MaterielService {
	@Autowired
	private IDAOMateriel daoMateriel;

	public void checkMateriel(Materiel materiel) 
	{

	}

	public Materiel create(Materiel materiel) {
		checkMateriel(materiel);
		return daoMateriel.save(materiel);
	}

	public Materiel update(Materiel materiel) {
		checkMateriel(materiel);
		return daoMateriel.save(materiel);
	}


	public Materiel getById(Integer id) {
		if (id == null) {
			throw new RuntimeException("id obligatoire");
		}
		Optional<Materiel> opt = daoMateriel.findById(id);
		if(opt.isEmpty()) 
		{
			throw new RuntimeException("id inconnu");
		}
		return opt.get();
	}


	public List<Materiel> getAll() {
		return daoMateriel.findAll();
	}


	public void delete(Integer id) {
		if (id == null) {
			throw new RuntimeException("id obligatoire");
		}
		Materiel materiel =getById(id);
		delete(materiel);
	}	
	
	public void delete(Materiel materiel) {
		
		if (materiel == null) {
			throw new RuntimeException("materiel ne peut pas etre null");
		}
		daoMateriel.delete(materiel);
	}	
}
