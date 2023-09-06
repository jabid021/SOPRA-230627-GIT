package quest.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.server.ResponseStatusException;

import jakarta.validation.Valid;
import quest.dao.IDAOFiliere;
import quest.dao.IDAOMatiere;
import quest.model.Filiere;
import quest.model.Matiere;

@Controller
@RequestMapping("/matiere")
public class MatiereController {

	private IDAOMatiere daoMatiere;

	private IDAOFiliere daoFiliere;
	
	
	public MatiereController(IDAOMatiere daoMatiere, IDAOFiliere daoFiliere) {
		super();
		this.daoMatiere = daoMatiere;
		this.daoFiliere = daoFiliere;
	}

	@GetMapping({ "", "/list" }) // ETAPE 1 : Réception de la Request
	public String list(Model model) {

		// ETAPE 2 : Récupération des données
		List<Matiere> matieres = daoMatiere.findAll();

		// ETAPE 3 : Renseigner le Model
		model.addAttribute("mesMatieres", matieres);

		return "matiere/list"; // ETAPE 4 : Appel de la View
	}

	@GetMapping("/add")
	public String add(Model model) {
		model.addAttribute("maMatiere", new Matiere());
		model.addAttribute("filieres", daoFiliere.findAll());
		
		return "matiere/form";
	}

	@GetMapping("/edit")
	public String edit(@RequestParam Integer id, Model model) {
		if(!daoMatiere.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "ID Matière non trouvé");
//			throw new QuestWebException();
		}
		
		Matiere matiere = daoMatiere.findById(id).get();

		model.addAttribute("maMatiere", matiere);
		model.addAttribute("filieres", daoFiliere.findAll());

		return "matiere/form";
	}

	@PostMapping("/save")
	public String save(@RequestParam(required = false) Integer id, @RequestParam int version,
			@RequestParam String libelle, @RequestParam int quest) {

		Matiere matiere = new Matiere();
		matiere.setId(id);
		matiere.setVersion(version);
		matiere.setLibelle(libelle);
		matiere.setQuest(quest);

//		Matiere matiere = null;
//		
//		if(id != null && daoMatiere.existsById(id)) {
//			matiere = daoMatiere.findById(id).get();
//		} else {
//			matiere = new Matiere();
//		}
//		
//		matiere.setLibelle(libelle);
//		matiere.setQuest(quest);

		daoMatiere.save(matiere);

		return "redirect:/matiere";
	}

	@PostMapping("/saveBis")
	public String saveBis(@ModelAttribute("maMatiere") @Valid Matiere matiere, BindingResult result, @RequestParam(required = false) Integer idFiliere) {
		new MatiereValidator().validate(matiere, result);
		
		if(result.hasErrors()) {
			return "matiere/form";
		}
		
		if(idFiliere != null) {
			Filiere filiere = new Filiere();
			filiere.setId(idFiliere);
			matiere.setFiliere(filiere);
		}
		
		daoMatiere.save(matiere);

		return "redirect:/matiere";

	}

	@GetMapping("/delete/{id}")
	public String delete(@PathVariable Integer id) {
		daoMatiere.deleteById(id);

		return "redirect:/matiere";
	}

	@GetMapping("/cancel")
	public String cancel() {
		return "forward:/matiere/list";
	}

}
