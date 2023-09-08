package eshop.formation;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import eshop.formation.model.Fournisseur;
import eshop.formation.model.Produit;
import eshop.formation.repo.IAdresseRepository;
import eshop.formation.repo.IClientRepository;
import eshop.formation.repo.ICommandeDetailRepository;
import eshop.formation.repo.ICommandeRepository;
import eshop.formation.repo.ICommentaireRepository;
import eshop.formation.repo.IFournisseurRepository;
import eshop.formation.repo.IProduitRepository;
import eshop.formation.repo.IReparateurRepository;
import eshop.formation.repo.IUtilisateurRepository;

@SpringBootTest
class EshopBootApplicationTests {
	
	@Autowired
	private IAdresseRepository adresseRepo;
	
	@Autowired
	private IClientRepository clientRepo;
	
	@Autowired
	private ICommandeRepository commandeRepo;
	
	@Autowired
	private ICommandeDetailRepository commandeDetailRepo;
	
	@Autowired
	private ICommentaireRepository commentaireRepo;
	
	@Autowired
	private IFournisseurRepository fournisseurRepo;
	
	@Autowired
	private IProduitRepository produitRepo;
	
	@Autowired
	private IReparateurRepository reparateurRepo;
	
	@Autowired
	private IUtilisateurRepository utilisateurRepo;

	@Test
	void contextLoads() {
		
		Produit iphone14 = new Produit("IPhone 14");

		iphone14.setPrixAchat(1000d);
		iphone14.setPrixVente(1250d);
		iphone14.setModele("XR");
		iphone14.setReference("IPHONE14XR");

		iphone14 = produitRepo.save(iphone14);
		
			
		Fournisseur amazon = new Fournisseur();
		amazon.setNom("AMAZON");
		amazon.setResponsable("BEZOS");
		
		amazon = fournisseurRepo.save(amazon); 
	}

}
