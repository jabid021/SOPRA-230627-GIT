package escapeGame.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import escapeGame.dao.IDAOSalle;
import escapeGame.model.Salle;
@Service
public class SalleService {
	@Autowired
	private IDAOSalle daoSalle;

	public void checkSalle(Salle salle) 
	{

	}

	public Salle create(Salle salle) {
		checkSalle(salle);
		return daoSalle.save(salle);
	}

	public Salle update(Salle salle) {
		checkSalle(salle);
		return daoSalle.save(salle);
	}


	public Salle getById(Integer id) {
		if (id == null) {
			throw new RuntimeException("id obligatoire");
		}
		Optional<Salle> opt = daoSalle.findById(id);
		if(opt.isEmpty()) 
		{
			throw new RuntimeException("id inconnu");
		}
		return opt.get();
	}


	public List<Salle> getAll() {
		return daoSalle.findAll();
	}


	public void delete(Integer id) {
		if (id == null) {
			throw new RuntimeException("id obligatoire");
		}
		Salle salle =getById(id);
		delete(salle);
	}	
	
	public void delete(Salle salle) {
		
		if (salle == null) {
			throw new RuntimeException("salle ne peut pas etre null");
		}
		daoSalle.delete(salle);
	}	
}
