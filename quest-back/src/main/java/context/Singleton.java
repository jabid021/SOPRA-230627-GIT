package context;

import dao.DAOFiliere;
import dao.DAOMatiere;
import dao.DAOOrdinateur;
import dao.DAOStagiaire;
import dao.IDAOFiliere;
import dao.IDAOMatiere;
import dao.IDAOOrdinateur;
import dao.IDAOStagiaire;
import service.FiliereService;
import service.MatiereService;
import service.OrdinateurService;
import service.StagiaireService;


public class Singleton {
	
	private IDAOMatiere daoMatiere = new DAOMatiere();
	private IDAOFiliere daoFiliere = new DAOFiliere();
	private IDAOOrdinateur daoOrdinateur = new DAOOrdinateur();
	private IDAOStagiaire daoStagiaire = new DAOStagiaire();
	
	private MatiereService matiereService = new MatiereService(daoMatiere);
	private FiliereService filiereService = new FiliereService(daoFiliere);
	private OrdinateurService ordinateurService = new OrdinateurService(daoOrdinateur);
	private StagiaireService stagiaireService = new StagiaireService(daoStagiaire);
	
	private static Singleton instance=null; 
	
	private Singleton() {}
	
	public static Singleton getInstance() 
	{
		if(instance==null) 
		{
			instance=new Singleton();
		}
		return instance;
	}

	

	public void setDaoMatiere(IDAOMatiere daoMatiere) {
		this.daoMatiere = daoMatiere;
	}



	public void setDaoFiliere(IDAOFiliere daoFiliere) {
		this.daoFiliere = daoFiliere;
	}


	public void setDaoOrdinateur(IDAOOrdinateur daoOrdinateur) {
		this.daoOrdinateur = daoOrdinateur;
	}



	public void setDaoStagiaire(IDAOStagiaire daoStagiaire) {
		this.daoStagiaire = daoStagiaire;
	}

	public MatiereService getMatiereService() {
		return matiereService;
	}

	public FiliereService getFiliereService() {
		return filiereService;
	}

	public OrdinateurService getOrdinateurService() {
		return ordinateurService;
	}

	public StagiaireService getStagiaireService() {
		return stagiaireService;
	}

	public void setMatiereService(MatiereService matiereService) {
		this.matiereService = matiereService;
	}

	public void setFiliereService(FiliereService filiereService) {
		this.filiereService = filiereService;
	}

	public void setOrdinateurService(OrdinateurService ordinateurService) {
		this.ordinateurService = ordinateurService;
	}

	public void setStagiaireService(StagiaireService stagiaireService) {
		this.stagiaireService = stagiaireService;
	}
	


}
