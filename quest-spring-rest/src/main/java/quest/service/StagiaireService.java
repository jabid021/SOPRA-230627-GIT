package quest.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import quest.dao.IDAOStagiaire;
import quest.model.Stagiaire;


@Service
public class StagiaireService {
	@Autowired
	private IDAOStagiaire daoStagiaire;


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
		Optional<Stagiaire> opt = daoStagiaire.findById(id);
		if(opt.isEmpty()) 
		{
			throw new RuntimeException("id inconnu");
		}
		return opt.get();
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
