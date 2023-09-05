package quest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import quest.dao.IDAOMatiere;
import quest.model.Matiere;

@Controller
@RequestMapping("/matiere")
public class MatiereController {

	@Autowired
	private IDAOMatiere daoMatiere;

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
		
		return "matiere/form";
	}

	@GetMapping("/edit")
	public String edit(@RequestParam Integer id, Model model) {
		Matiere matiere = daoMatiere.findById(id).get();

		model.addAttribute("maMatiere", matiere);

		return "matiere/form";
	}

	@PostMapping("/save")
	public String save(@RequestParam(required = false) Integer id, @RequestParam int version, @RequestParam String libelle,
			@RequestParam int quest) {
		
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
	public String saveBis(@ModelAttribute("maMatiere") Matiere matiere) {
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
