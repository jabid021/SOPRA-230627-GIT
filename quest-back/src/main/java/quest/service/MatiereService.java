package quest.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import quest.dao.IDAOMatiere;
import quest.model.Matiere;


@Service
public class MatiereService {
	@Autowired
	private IDAOMatiere daoMatiere;

	public void checkMatiere(Matiere matiere) 
	{

	}

	public Matiere create(Matiere matiere) {
		checkMatiere(matiere);
		return daoMatiere.save(matiere);
	}

	public Matiere update(Matiere matiere) {
		checkMatiere(matiere);
		return daoMatiere.save(matiere);
	}


	public Matiere getById(Integer id) {
		if (id == null) {
			throw new RuntimeException("id obligatoire");
		}
		Optional<Matiere> optMatiere = daoMatiere.findById(id);
		if(optMatiere.isEmpty()) 
		{
			throw new RuntimeException("id inconnu");
		}
		return optMatiere.get();
	}


	public List<Matiere> getAll() {
		return daoMatiere.findAll();
	}


	public void delete(Integer id) {
		if (id == null) {
			throw new RuntimeException("id obligatoire");
		}
		Matiere matiere =getById(id);
		delete(matiere);
	}	
	
	public void delete(Matiere matiere) {
		
		if (matiere == null) {
			throw new RuntimeException("matiere ne peut pas etre null");
		}
		daoMatiere.delete(matiere);
	}	
}
