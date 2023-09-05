package quest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import quest.dao.IDAOMatiere;
import quest.model.Matiere;

@Controller
public class MatiereController {
	
	@Autowired
	private IDAOMatiere daoMatiere;
	
	@GetMapping("/matiere/list") // ETAPE 1 : Réception de la Request
	public String list(Model model) {
		
		// ETAPE 2 : Récupération des données
		List<Matiere> matieres = daoMatiere.findAll();
		
		// ETAPE 3 : Renseigner le Model
		model.addAttribute("mesMatieres", matieres);
		
		return "matiere/list"; // ETAPE 4 : Appel de la View
	}

}
