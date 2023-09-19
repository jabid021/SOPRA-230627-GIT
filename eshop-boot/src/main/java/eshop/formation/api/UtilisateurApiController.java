package eshop.formation.api;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import eshop.formation.api.request.ConnexionRequest;
import eshop.formation.api.request.InscriptionRequest;
import eshop.formation.api.response.ConnexionResponse;
import eshop.formation.api.response.UtilisateurResponse;
import eshop.formation.config.IsAdmin;
import eshop.formation.config.jwt.JwtUtil;
import eshop.formation.exception.InscriptionNotValidException;
import eshop.formation.model.Roles;
import eshop.formation.model.Utilisateur;
import eshop.formation.repo.IUtilisateurRepository;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/utilisateur")
public class UtilisateurApiController {
	// DTO : Data Transform Object
	// Le principe, c'est de créer une instance spécialement dédiée pour le transfert d'information
	
	@Autowired
	private IUtilisateurRepository repoUtilisateur;
	
	@Autowired // Par défaut, ce manager n'existe pas dans le contexte, donc on le configure dans SecurityConfig
	private AuthenticationManager authenticationManager;
	
	@GetMapping
	@PreAuthorize("hasRole('ADMIN')")
	public List<UtilisateurResponse> findAll() {
		return this.repoUtilisateur.findAll()
			// Transforme la liste en Stream
			.stream()
			
			// Transformer chaque Utilisateur en UtilisateurResponse
			// > Donc on prend chaque Utilisateur, et on appelle la méthode convert de UtilisateurResponse, qui retourne un UtilisateurResponse
			// > Donc à l'issu, on se retrouve avec un Stream de UtilisateurResponse
			.map(UtilisateurResponse::convert)
			
			// Transforme le Stream en Liste
			.toList();
	}
	
	@GetMapping("/old")
	public List<UtilisateurResponse> findAllOld() {
		List<UtilisateurResponse> response = new ArrayList<>();
		List<Utilisateur> utilisateurs = this.repoUtilisateur.findAll();
		
		// Convertir les utilisateurs en UtilisateurResponse
		for (Utilisateur utilisateur : utilisateurs) {
//			UtilisateurResponse utilisateurResponse = new UtilisateurResponse();

//			utilisateurResponse.setId(utilisateur.getId());
//			utilisateurResponse.setUsername(utilisateur.getUsername());
			
			// Permer de recopier les infos communes de utilisateur vers utilisateurResponse
//			BeanUtils.copyProperties(utilisateur, utilisateurResponse);
			
//			response.add(utilisateurResponse);
			response.add(UtilisateurResponse.convert(utilisateur));
		}
		
		return response;
	}
	
	@PostMapping
//	@Secured("ROLE_GUEST")
	public UtilisateurResponse inscription(@Valid @RequestBody InscriptionRequest inscriptionRequest, BindingResult result) {
		if (result.hasErrors()) {
			throw new InscriptionNotValidException();
		}
		
		if (inscriptionRequest.getPassword().equals(inscriptionRequest.getPasswordVerif()) == false) {
			throw new InscriptionNotValidException();
		}
		
		Utilisateur utilisateur = new Utilisateur();
		
		BeanUtils.copyProperties(inscriptionRequest, utilisateur);
		
		utilisateur.getRoles().add(Roles.USER);
		
		this.repoUtilisateur.save(utilisateur);
		
		return UtilisateurResponse.convert(utilisateur);
	}
	
	@PostMapping("/connexion")
	public ConnexionResponse connexion(@RequestBody ConnexionRequest connexionRequest) {
		// On va demander à SPRING SECURITY de vérifier le username / password
		// On a besoin d'un AuthenticationManager
		// On utilisera la méthode authenticate, qui attend un Authentication
		// Et on utilisera le type UsernamePasswordAuthenticationToken pour donner le username & le password
		Authentication authentication =
				new UsernamePasswordAuthenticationToken(connexionRequest.getUsername(), connexionRequest.getPassword());
		
		// On demande à SPRING SECURITY de vérifier ces informations de connexion
		this.authenticationManager.authenticate(authentication);
		
		// Si on arrive ici, c'est que la connexion a fonctionné
		ConnexionResponse response = new ConnexionResponse();
		
		// On génère un jeton pour l'utilisateur connecté
		String token = JwtUtil.generate(authentication);
		
		response.setSuccess(true);
		response.setToken(token); // On donne le jeton en réponse
		
		return response;
	}
}
