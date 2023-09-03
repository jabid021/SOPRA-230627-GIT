package escapeGame.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import escapeGame.dao.IDAOCompte;
import escapeGame.exception.CompteException;
import escapeGame.model.Client;
import escapeGame.model.Compte;
import escapeGame.model.GameMaster;

@Service
public class CompteService {

	@Autowired
	private IDAOCompte daoCompte;

	public void checkCompte(Compte compte) 
	{
		if (compte==null) 
		{
			throw new CompteException("le compte ne peut pas etre null lors d'un insert / update ");
		}
		if (compte.getLogin() == null || compte.getLogin().isEmpty()) {
			throw new CompteException("login obligatoire");
		}
		if (compte.getPassword() == null || compte.getPassword().isEmpty()) {
			throw new CompteException("password obligatoire");
		}
		if (compte.getNom() == null || compte.getNom().isEmpty()) {
			throw new CompteException("nom obligatoire");
		}
		if (compte.getPrenom() == null || compte.getPrenom().isEmpty()) {
			throw new CompteException("prenom obligatoire");
		}

		if(compte instanceof Client) 
		{
			Client client = (Client) compte;
			if (client.getMail() == null || client.getMail().isEmpty()) {
				throw new CompteException("mail obligatoire");
			}
			if (client.getTel() == null || client.getTel().isEmpty()) {
				throw new CompteException("tel obligatoire");
			}
			if (client.getAdresse() == null ) {
				throw new CompteException("Adresse obligatoire");
			}
			if (client.getAdresse().getNumero() == null || client.getAdresse().getNumero().isEmpty()) {
				throw new CompteException("numero obligatoire");
			}
			if (client.getAdresse().getVoie() == null || client.getAdresse().getVoie().isEmpty()) {
				throw new CompteException("voie obligatoire");
			}
			if (client.getAdresse().getVille() == null || client.getAdresse().getVille().isEmpty()) {
				throw new CompteException("ville obligatoire");
			}
			if (client.getAdresse().getCp() == null || client.getAdresse().getCp().isEmpty()) {
				throw new CompteException("cp obligatoire");
			}	
		}
	}

	public Compte create(Compte compte) {
		checkCompte(compte);
		return daoCompte.save(compte);
	}

	public Compte update(Compte compte) {
		checkCompte(compte);
		return daoCompte.save(compte);
	}


	public Compte getById(Integer id) {
		if (id == null) {
			throw new CompteException("id obligatoire");
		}
		Optional<Compte> opt = daoCompte.findById(id);
		if(opt.isEmpty()) 
		{
			throw new CompteException("id inconnu");
		}
		return opt.get();
	}


	public Compte getByLoginAndPassword(String login, String password) {
		if (login==null || login.isEmpty()) {
			throw new CompteException("login obligatoire");
		}
		if (password==null || password.isEmpty()) {
			throw new CompteException("password obligatoire");
		}
		Compte compte = daoCompte.findByLoginAndPassword(login, password);
		return compte;
	}
	
	public List<GameMaster> getAllGameMaster() {
		return daoCompte.findAllGameMaster();
	}
	
	public List<Compte> getAll() {
		return daoCompte.findAll();
	}


	public void delete(Integer id) {
		if (id == null) {
			throw new RuntimeException("id obligatoire");
		}
		Compte compte =getById(id);
		delete(compte);
	}	
	
	public void delete(Compte compte) {
		
		if (compte == null) {
			throw new RuntimeException("compte ne peut pas etre null");
		}
		daoCompte.delete(compte);
	}	
}
