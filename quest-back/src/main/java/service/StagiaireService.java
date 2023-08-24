package service;

import java.util.List;

import dao.IDAOStagiaire;
import model.Stagiaire;

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
		return daoStagiaire.insert(stagiaire);
	}

	public Stagiaire update(Stagiaire stagiaire) {
		checkStagiaire(stagiaire);
		return daoStagiaire.update(stagiaire);
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
		daoStagiaire.delete(id);
	}	
}
