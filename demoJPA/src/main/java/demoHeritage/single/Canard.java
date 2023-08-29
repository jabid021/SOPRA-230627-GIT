package demoHeritage.single;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@DiscriminatorValue("duck")
public class Canard extends Animal{

	@Column(name="color",length=10)
	private String couleur;
	
	public Canard() {}
	
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
