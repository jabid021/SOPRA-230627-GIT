package eshop.formation.api;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import eshop.formation.api.request.FournisseurRequest;
import eshop.formation.api.response.FournisseurDetailResponse;
import eshop.formation.exception.FournisseurNotFoundException;
import eshop.formation.exception.FournisseurNotValidException;
import eshop.formation.model.Fournisseur;
import eshop.formation.repo.IFournisseurRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/fournisseur")
public class FournisseurApiController {
	@Autowired
	private IFournisseurRepository repoFournisseur;

	@GetMapping
	@JsonView(Views.Fournisseur.class)
	public List<Fournisseur> findAll() {
		return this.repoFournisseur.findAll();
	}

	@GetMapping("/{id}")
	@Transactional // Important pour garder l'EntityManager pour récupérer getProduits()
	public FournisseurDetailResponse findById(@PathVariable Long id) {
		Fournisseur fournisseur = this.repoFournisseur.findById(id).orElseThrow(FournisseurNotFoundException::new);
		FournisseurDetailResponse response = new FournisseurDetailResponse();

		BeanUtils.copyProperties(fournisseur, response);

		response.setNbProduits(fournisseur.getProduits().size());

		return response;
	}

	@PostMapping
	@JsonView(Views.Fournisseur.class)
	public Fournisseur add(@Valid @RequestBody FournisseurRequest fournisseurRequest, BindingResult result) {
		if (result.hasErrors()) {
			throw new FournisseurNotValidException();
		}

		Fournisseur fournisseur = new Fournisseur();

		BeanUtils.copyProperties(fournisseurRequest, fournisseur);

		return this.repoFournisseur.save(fournisseur);
	}

	@PutMapping("/{id}")
	@JsonView(Views.Fournisseur.class)
	public Fournisseur edit(@PathVariable Long id, @Valid @RequestBody FournisseurRequest fournisseurRequest,
			BindingResult result) {
		if (result.hasErrors()) {
			throw new FournisseurNotValidException();
		}

		Fournisseur fournisseur = this.repoFournisseur.findById(id).orElseThrow(FournisseurNotFoundException::new);

		BeanUtils.copyProperties(fournisseurRequest, fournisseur);

		return this.repoFournisseur.save(fournisseur);
	}

	@DeleteMapping("/{id}")
	public void deleteById(@PathVariable Long id) {
		this.repoFournisseur.deleteById(id);
	}
}
