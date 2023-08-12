package escapeGame.service;

import java.util.List;

import escapeGame.context.Singleton;
import escapeGame.dao.IDAOCompte;
import escapeGame.model.Client;
import escapeGame.model.Compte;

public class CompteService {

	private IDAOCompte daoCompte;


	public CompteService(IDAOCompte daoCompte) {
		this.daoCompte = daoCompte;
	}

	public void checkCompte(Compte compte) 
	{
		if (compte==null) 
		{
			throw new RuntimeException("le compte ne peut pas etre null lors d'un insert / update ");
		}
		if (compte.getLogin() == null || compte.getLogin().isEmpty()) {
			throw new RuntimeException("login obligatoire");
		}
		if (compte.getPassword() == null || compte.getPassword().isEmpty()) {
			throw new RuntimeException("password obligatoire");
		}
		if (compte.getNom() == null || compte.getNom().isEmpty()) {
			throw new RuntimeException("nom obligatoire");
		}
		if (compte.getPrenom() == null || compte.getPrenom().isEmpty()) {
			throw new RuntimeException("prenom obligatoire");
		}

		if(compte instanceof Client) 
		{
			Client client = (Client) compte;
			if (client.getMail() == null || client.getMail().isEmpty()) {
				throw new RuntimeException("mail obligatoire");
			}
			if (client.getTel() == null || client.getTel().isEmpty()) {
				throw new RuntimeException("tel obligatoire");
			}
			if (client.getAdresse() == null ) {
				throw new RuntimeException("Adresse obligatoire");
			}
			if (client.getAdresse().getNumero() == null || client.getAdresse().getNumero().isEmpty()) {
				throw new RuntimeException("numero obligatoire");
			}
			if (client.getAdresse().getVoie() == null || client.getAdresse().getVoie().isEmpty()) {
				throw new RuntimeException("voie obligatoire");
			}
			if (client.getAdresse().getVille() == null || client.getAdresse().getVille().isEmpty()) {
				throw new RuntimeException("ville obligatoire");
			}
			if (client.getAdresse().getCp() == null || client.getAdresse().getCp().isEmpty()) {
				throw new RuntimeException("cp obligatoire");
			}	
		}
	}

	public Compte create(Compte compte) {
		checkCompte(compte);
		return daoCompte.insert(compte);
	}

	public Compte update(Compte compte) {
		checkCompte(compte);
		return daoCompte.update(compte);
	}


	public Compte getById(Integer id) {
		if (id == null) {
			throw new RuntimeException("id obligatoire");
		}
		Compte compte = daoCompte.findById(id);
		if(compte==null) 
		{
			throw new RuntimeException("id inconnu");
		}
		return compte;
	}


	public Compte getByLoginAndPassword(String login, String password) {
		if (login==null || login.isEmpty()) {
			throw new RuntimeException("login obligatoire");
		}
		if (password==null || password.isEmpty()) {
			throw new RuntimeException("password obligatoire");
		}
		Compte compte = daoCompte.findByLoginAndPassword(login, password);
		return compte;
	}
	
	
	
	public List<Compte> getAll() {
		return daoCompte.findAll();
	}


	public void delete(Integer id) {
		if (id == null) {
			throw new RuntimeException("id obligatoire");
		}
		daoCompte.delete(id);
	}	
}
