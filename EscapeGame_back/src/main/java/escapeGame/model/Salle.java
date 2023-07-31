package escapeGame.model;

import java.util.ArrayList;
import java.util.List;

public class Salle {
	
	private Integer id;
	private int min; 
	private int max;
	private String titre;
	private String description;
	private int duree;
	private double prix;
	private boolean accessibilite;
	private Difficulte difficulte;
	private List<Caracteristique> caracteristiques = new ArrayList();
	
	public Salle(Integer id,int min, int max, String titre, String description, int duree, double prix, boolean accessible,
			Difficulte difficulte) {
		this.id=id;
		this.min = min;
		this.max = max;
		this.titre = titre;
		this.description = description;
		this.duree = duree;
		this.prix = prix;
		this.accessibilite = accessible;
		this.difficulte = difficulte;
	
		
	}
	
	public Salle(int min, int max, String titre, String description, int duree, double prix, boolean accessible,
			Difficulte difficulte) {
		this.min = min;
		this.max = max;
		this.titre = titre;
		this.description = description;
		this.duree = duree;
		this.prix = prix;
		this.accessibilite = accessible;
		this.difficulte = difficulte;
	}
	public int getMin() {
		return min;
	}
	public int getMax() {
		return max;
	}
	public String getTitre() {
		return titre;
	}
	public String getDescription() {
		return description;
	}
	public int getDuree() {
		return duree;
	}
	public double getPrix() {
		return prix;
	}
	public boolean isAccessibilite() {
		return accessibilite;
	}
	public Difficulte getDifficulte() {
		return difficulte;
	}
	
	public List<Caracteristique> getCaracteristiques() {
		return caracteristiques;
	}
	public void setMin(int min) {
		this.min = min;
	}
	public void setMax(int max) {
		this.max = max;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public void setDuree(int duree) {
		this.duree = duree;
	}
	public void setPrix(double prix) {
		this.prix = prix;
	}
	public void setAccessibilite(boolean accessible) {
		this.accessibilite = accessible;
	}
	public void setDifficulte(Difficulte difficulte) {
		this.difficulte = difficulte;
	}
	
	public void setCaracteristiques(List<Caracteristique> caracteristiques) {
		this.caracteristiques = caracteristiques;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Salle [id=" + id + ", min=" + min + ", max=" + max + ", titre=" + titre + ", duree=" + duree + ", prix=" + prix + ", accessibilite=" + accessibilite + ", difficulte="
				+ difficulte + ", caracteristiques=" + caracteristiques + "]";
	}

	
	
	
	
	
	
	

}
