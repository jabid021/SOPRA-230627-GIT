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

import quest.dao.IDAOFiliere;
import quest.model.Filiere;

@Controller
@RequestMapping("/filiere")
public class FiliereController {

	@Autowired
	private IDAOFiliere daoFiliere;

	@GetMapping({ "", "/list" }) // ETAPE 1 : Réception de la Request
	public String list(Model model) {

		// ETAPE 2 : Récupération des données
		List<Filiere> filieres = daoFiliere.findAll();

		// ETAPE 3 : Renseigner le Model
		model.addAttribute("filieres", filieres);

		return "filiere/list"; // ETAPE 4 : Appel de la View
	}

	@GetMapping("/add")
	public String add(Model model) {
		model.addAttribute("filiere", new Filiere());
		
		return "filiere/form";
	}

	@GetMapping("/edit")
	public String edit(@RequestParam Integer id, Model model) {
		Filiere filiere = daoFiliere.findById(id).get();

		model.addAttribute("filiere", filiere);

		return "filiere/form";
	}

	@PostMapping("/saveBis")
	public String saveBis(@ModelAttribute("filiere") Filiere filiere) {
		daoFiliere.save(filiere);

		return "redirect:/filiere";

	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable Integer id) {
		daoFiliere.deleteById(id);
		
		return "redirect:/filiere";
	}

	@GetMapping("/cancel")
	public String cancel() {
		return "forward:/filiere/list";
	}

}
