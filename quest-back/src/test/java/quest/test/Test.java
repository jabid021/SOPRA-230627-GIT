package quest.test;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import quest.dao.IDAOFiliere;
import quest.dao.IDAOMatiere;
import quest.model.Filiere;
import quest.model.Matiere;
import quest.service.MatiereService;

public class Test {

	@Autowired
	MatiereService matiereSrv;
	
	@Autowired
	IDAOMatiere daoMatiere;
	
	@Autowired
	IDAOFiliere daoFiliere;
	public void run(String ...args) {
		
		
		//System.out.println(matiereSrv.getAll());
		//System.out.println(daoMatiere.findByLibelleContaining("l"));
		//System.out.println(daoMatiere.matiereTitreLike("l"));
		
		//Avant Spring DATA-JPA, em.find d'un element inexistant => null, existant => object
		
		////Avant Spring DATA-JPA, em.createQuery().getSingleResult => soit l'objet trouvé, soit exxception
		//Avec Spring DATA-JPA, Query Single => object / null
		//Filiere f = daoFiliere.findById(1);
		//System.out.println(f);
		
		System.out.println(daoMatiere.findById(1));
		System.out.println(daoMatiere.findById(18));
		
		Optional<Matiere> opt = daoMatiere.findById(1);
	
		Matiere m = opt.get();
		System.out.println(m);
		
		
		
	}
}
