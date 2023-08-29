package quest.service;

import java.util.List;

import quest.dao.IDAOStagiaire;
import quest.model.Stagiaire;

public class StagiaireService {

	private IDAOStagiaire daoStagiaire;


	
	public StagiaireService(IDAOStagiaire daoStagiaire) {
		this.daoStagiaire = daoStagiaire;
	}

	public void checkStagiaire(Stagiaire stagiaire) 
	{

	}

	public Stagiaire create(Stagiaire stagiaire) {
		checkStagiaire(stagiaire);
		return daoStagiaire.save(stagiaire);
	}

	public Stagiaire update(Stagiaire stagiaire) {
		checkStagiaire(stagiaire);
		return daoStagiaire.save(stagiaire);
	}


	public Stagiaire getById(Integer id) {
		if (id == null) {
			throw new RuntimeException("id obligatoire");
		}
		Stagiaire stagiaire = daoStagiaire.findById(id);
		if(stagiaire==null) 
		{
			throw new RuntimeException("id inconnu");
		}
		return stagiaire;
	}


	public List<Stagiaire> getAll() {
		return daoStagiaire.findAll();
	}


	public void delete(Integer id) {
		if (id == null) {
			throw new RuntimeException("id obligatoire");
		}
		Stagiaire stagiaire =getById(id);
		delete(stagiaire);
	}	
	
	public void delete(Stagiaire stagiaire) {
		
		if (stagiaire == null) {
			throw new RuntimeException("stagiaire ne peut pas etre null");
		}
		daoStagiaire.delete(stagiaire);
	}	
}
