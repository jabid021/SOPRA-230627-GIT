package demo.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Canard {

	private String nom;
	
	@Autowired
	private Arme arme;

	public Canard() 
	{
		this.nom="test";
	}
	
	
	public Canard(String nom) 
	{
		this.nom=nom;
	}
	
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
	
	

	public Arme getArme() {
		return arme;
	}
	public void setArme(Arme arme) {
		this.arme = arme;
	}
	
	
	
	
	public void faireBlague() 
	{
		System.out.println("C'est toto qui...");
	}
	
	
	public int fonctionQuiRetourneUnAge() 
	{
		System.out.println("Fonction qui return 25");
		return 25;
	} 
	
	
	
	
	@Override
	public String toString() {
		return "Canard [nom=" + nom + "]";
	}


}
