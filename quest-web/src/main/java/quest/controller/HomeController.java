package quest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

	@RequestMapping(path = "/home", method = RequestMethod.GET)
	public String home(Model model, @RequestParam String nom) {

		model.addAttribute("utilisateur", nom);

		return "home";
	}

	@GetMapping("/homeBis/{nom}|{prenom}")
	public String homeBis(Model model, @PathVariable("nom") String monNom, @PathVariable String prenom) {

		model.addAttribute("utilisateur", monNom + " " + prenom);

		return "home";
	}

}
