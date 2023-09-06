package quest.api;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import quest.dao.IDAOMatiere;
import quest.model.Matiere;

@RestController
@RequestMapping("/matiere")
public class MatiereApiController {

	private IDAOMatiere daoMatiere;

	public MatiereApiController(IDAOMatiere daoMatiere) {
		super();
		this.daoMatiere = daoMatiere;
	}

	@GetMapping("")
	public List<Matiere> findAll() {
		return daoMatiere.findAll();
	}

	@GetMapping("/{id}")
	public Matiere findById(@PathVariable int id) {
		return daoMatiere.findById(id).get();
	}

}
