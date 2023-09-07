package quest.api;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import quest.dao.IDAOOrdinateur;
import quest.model.Ordinateur;

@RestController
@RequestMapping("/ordinateur")
public class OrdinateurApiController {

	private IDAOOrdinateur daoOrdinateur;

	public OrdinateurApiController(IDAOOrdinateur daoOrdinateur) {
		super();
		this.daoOrdinateur = daoOrdinateur;
	}

	@GetMapping("")
	public List<Ordinateur> findAll() {
		return daoOrdinateur.findAll();
	}

	@GetMapping("/{id}")
	public Ordinateur findById(@PathVariable int id) {
		return daoOrdinateur.findById(id).get();
	}

}
