package model;

import javax.persistence.Entity;

@Entity
public class Canard extends Animal{

	private String couleur;
	
	public Canard() {
		super();
	}
	public Canard(String nom, String couleur) {
		super(nom);
		this.couleur=couleur;
	}


	public String getCouleur() {
		return couleur;
	}


	public void setCouleur(String couleur) {
		this.couleur = couleur;
	}


	@Override
	public String toString() {
		return "Canard [id=" + id + ", nom=" + nom + ", couleur=" + couleur + "]";
	}
	
	

	
	
}
