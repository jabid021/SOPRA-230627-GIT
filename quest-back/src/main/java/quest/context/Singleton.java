package quest.context;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import quest.dao.DAOFiliere;
import quest.dao.DAOMatiere;
import quest.dao.DAOOrdinateur;
import quest.dao.DAOStagiaire;
import quest.dao.IDAOFiliere;
import quest.dao.IDAOMatiere;
import quest.dao.IDAOOrdinateur;
import quest.dao.IDAOStagiaire;
import quest.service.FiliereService;
import quest.service.MatiereService;
import quest.service.OrdinateurService;
import quest.service.StagiaireService;


public class Singleton {
	
	private IDAOMatiere daoMatiere = new DAOMatiere();
	private IDAOFiliere daoFiliere = new DAOFiliere();
	private IDAOOrdinateur daoOrdinateur = new DAOOrdinateur();
	private IDAOStagiaire daoStagiaire = new DAOStagiaire();
	
	
	private MatiereService matiereService = new MatiereService(daoMatiere);
	private FiliereService filiereService = new FiliereService(daoFiliere);
	private StagiaireService stagiaireService = new StagiaireService(daoStagiaire);
	private OrdinateurService ordinateurService = new OrdinateurService(daoOrdinateur);
	
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("configJPA");

	
	
	
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

	public EntityManagerFactory getEmf() {
		return emf;
	}

	
}
