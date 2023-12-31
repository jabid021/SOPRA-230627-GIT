package quest.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import quest.dao.IDAOOrdinateur;
import quest.model.Ordinateur;


@Service
public class OrdinateurService {
	@Autowired
	private IDAOOrdinateur daoOrdinateur;


	
	
	public void checkOrdinateur(Ordinateur ordinateur) 
	{

	}

	public Ordinateur create(Ordinateur ordinateur) {
		checkOrdinateur(ordinateur);
		return daoOrdinateur.save(ordinateur);
	}

	public Ordinateur update(Ordinateur ordinateur) {
		checkOrdinateur(ordinateur);
		return daoOrdinateur.save(ordinateur);
	}


	public Ordinateur getById(Integer id) {
		if (id == null) {
			throw new RuntimeException("id obligatoire");
		}
		Optional<Ordinateur> opt = daoOrdinateur.findById(id);
		if(opt.isEmpty()) 
		{
			throw new RuntimeException("id inconnu");
		}
		return opt.get();
	}


	public List<Ordinateur> getAll() {
		return daoOrdinateur.findAll();
	}


	public void delete(Integer id) {
		if (id == null) {
			throw new RuntimeException("id obligatoire");
		}
		Ordinateur ordinateur =getById(id);
		delete(ordinateur);
	}	
	
	public void delete(Ordinateur ordinateur) {
		
		if (ordinateur == null) {
			throw new RuntimeException("ordinateur ne peut pas etre null");
		}
		daoOrdinateur.delete(ordinateur);
	}	
}
