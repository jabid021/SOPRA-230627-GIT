package escapeGame.service;

import java.util.List;

import escapeGame.context.Singleton;
import escapeGame.dao.IDAOSalle;
import escapeGame.model.Salle;

public class SalleService {

	private IDAOSalle daoSalle;

	public SalleService(IDAOSalle daoSalle) 
	{
		this.daoSalle=daoSalle;
	}
	
	
	public void checkSalle(Salle salle) 
	{

	}

	public Salle create(Salle salle) {
		checkSalle(salle);
		return daoSalle.insert(salle);
	}

	public Salle update(Salle salle) {
		checkSalle(salle);
		return daoSalle.update(salle);
	}


	public Salle getById(Integer id) {
		if (id == null) {
			throw new RuntimeException("id obligatoire");
		}
		Salle salle = daoSalle.findById(id);
		if(salle==null) 
		{
			throw new RuntimeException("id inconnu");
		}
		return salle;
	}


	public List<Salle> getAll() {
		return daoSalle.findAll();
	}


	public void delete(Integer id) {
		if (id == null) {
			throw new RuntimeException("id obligatoire");
		}
		daoSalle.delete(id);
	}	
}
