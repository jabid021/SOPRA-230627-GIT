package quest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import quest.dao.IDAOFiliere;
import quest.model.Filiere;

@Service
public class FiliereService {

	@Autowired
	private IDAOFiliere daoFiliere;

	public void checkFiliere(Filiere filiere) 
	{

	}

	public Filiere create(Filiere filiere) {
		checkFiliere(filiere);
		return daoFiliere.save(filiere);
	}

	public Filiere update(Filiere filiere) {
		checkFiliere(filiere);
		return daoFiliere.save(filiere);
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
		Filiere filiere =getById(id);
		delete(filiere);
	}	
	
	public void delete(Filiere filiere) {
		
		if (filiere == null) {
			throw new RuntimeException("filiere ne peut pas etre null");
		}
		daoFiliere.delete(filiere);
	}	
	
	
}
