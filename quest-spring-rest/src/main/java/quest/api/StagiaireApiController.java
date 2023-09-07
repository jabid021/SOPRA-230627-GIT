package quest.api;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import quest.dao.IDAOStagiaire;
import quest.model.Stagiaire;

@RestController
@RequestMapping("/stagiaire")
public class StagiaireApiController {

	private IDAOStagiaire daoStagiaire;

	public StagiaireApiController(IDAOStagiaire daoStagiaire) {
		super();
		this.daoStagiaire = daoStagiaire;
	}

	@GetMapping("")
	public List<Stagiaire> findAll() {
		return daoStagiaire.findAll();
	}

	@GetMapping("/{id}")
	public Stagiaire findById(@PathVariable int id) {
		return daoStagiaire.findById(id).get();
	}
	
	@GetMapping("/{id}/detail")
	public Stagiaire detailById(@PathVariable int id) {
		return daoStagiaire.findById(id).get();
	}

}
