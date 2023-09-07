package quest.api;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.util.ReflectionUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.fasterxml.jackson.annotation.JsonView;

import jakarta.validation.Valid;
import quest.dao.IDAOMatiere;
import quest.model.Matiere;
import quest.model.Views;

@RestController
@RequestMapping("/matiere")
public class MatiereApiController {

	private IDAOMatiere daoMatiere;

	public MatiereApiController(IDAOMatiere daoMatiere) {
		super();
		this.daoMatiere = daoMatiere;
	}

	@GetMapping("")
	@JsonView(Views.Matiere.class)
	public List<Matiere> findAll() {
		return daoMatiere.findAll();
	}

	@GetMapping("/{id}")
	@JsonView(Views.MatiereWithFiliere.class)
	public Matiere findById(@PathVariable int id) {
		return daoMatiere.findById(id).get();
	}

	@PostMapping("")
	@JsonView(Views.Matiere.class)
	public Matiere create(@Valid @RequestBody Matiere matiere, BindingResult result) {
		if (result.hasErrors()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Matière invalide");
		}

		matiere = daoMatiere.save(matiere);

		return matiere;
	}

	@PutMapping("/{id}")
	@JsonView(Views.Matiere.class)
	public Matiere update(@RequestBody Matiere matiere, @PathVariable int id) {
		matiere = daoMatiere.save(matiere);

		return matiere;
	}

	@PatchMapping("/{id}")
	@JsonView(Views.Matiere.class)
	public Matiere partialEdit(@RequestBody Map<String, Object> fields, @PathVariable int id) {
		Matiere matiere = this.daoMatiere.findById(id).get();
		
		fields.forEach((key, value) -> {
			Field field = ReflectionUtils.findField(Matiere.class, key);
			ReflectionUtils.makeAccessible(field);
			ReflectionUtils.setField(field, matiere, value);
		});
		
		Matiere matiereReturn = daoMatiere.save(matiere);
		
		return matiereReturn;
	}

	@DeleteMapping("/{id}")
	public void remove(@PathVariable int id) {
		if(!daoMatiere.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
		
		daoMatiere.deleteById(id);
	}
}
