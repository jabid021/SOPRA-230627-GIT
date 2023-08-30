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
	@Override
	public String toString() {
		return "Canard [nom=" + nom + "]";
	}


}
