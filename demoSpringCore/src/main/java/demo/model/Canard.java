package demo.model;

public class Canard {

	private String nom;


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

	@Override
	public String toString() {
		return "Canard [nom=" + nom + "]";
	}


}
