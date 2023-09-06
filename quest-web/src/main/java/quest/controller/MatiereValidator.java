package quest.controller;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import quest.model.Matiere;

public class MatiereValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return Matiere.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Matiere matiere = (Matiere) target;
		
		if(!matiere.getLibelle().isBlank() && !matiere.getLibelle().matches("^[A-Z].*$")) {
			errors.rejectValue("libelle", "libelle.maj.error", "Le libellé doit commencé par une majuscule");
		}
		
	}

}
