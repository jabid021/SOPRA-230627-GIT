package hopital.context;

import java.util.LinkedList;

import hopital.dao.IDAOCompte;
import hopital.dao.IDAOPatient;
import hopital.dao.IDAOVisite;
import hopital.dao.jdbc.DAOCompteJDBC;
import hopital.dao.jdbc.DAOPatientJDBC;
import hopital.dao.jdbc.DAOVisiteJDBC;
import hopital.model.Patient;

public class Singleton {
	
	private IDAOCompte daoCompte = new DAOCompteJDBC();
	private IDAOPatient daoPatient = new DAOPatientJDBC();
	private IDAOVisite daoVisite = new DAOVisiteJDBC();
	
	private LinkedList<Patient> fileAttente = new LinkedList();
	
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
	
	
	
	
	public IDAOCompte getDaoCompte() {
		return daoCompte;
	}
	public IDAOPatient getDaoPatient() {
		return daoPatient;
	}
	public IDAOVisite getDaoVisite() {
		return daoVisite;
	}
	public void setDaoCompte(IDAOCompte daoCompte) {
		this.daoCompte = daoCompte;
	}
	public void setDaoPatient(IDAOPatient daoPatient) {
		this.daoPatient = daoPatient;
	}
	public void setDaoVisite(IDAOVisite daoVisite) {
		this.daoVisite = daoVisite;
	}

	public LinkedList<Patient> getFileAttente() {
		return fileAttente;
	}

	public void setFileAttente(LinkedList<Patient> fileAttente) {
		this.fileAttente = fileAttente;
	}
	
	
	

	

}
