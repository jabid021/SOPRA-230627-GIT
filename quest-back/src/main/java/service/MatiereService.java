package service;

import java.util.List;

import dao.IDAOMatiere;
import model.Matiere;

public class MatiereService {

	private IDAOMatiere daoMatiere;


	
	public MatiereService(IDAOMatiere daoMatiere) {
		this.daoMatiere = daoMatiere;
	}

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
		Matiere matiere = daoMatiere.findById(id);
		if(matiere==null) 
		{
			throw new RuntimeException("id inconnu");
		}
		return matiere;
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
